package com.microservices.userservice.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.userservice.entities.Hotel;
import com.microservices.userservice.entities.Rating;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.exceptions.ResourceNotFoundException;
import com.microservices.userservice.repositories.UserRepository;
import com.microservices.userservice.externalservices.HotelService;
import com.microservices.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper mapper;

    @Autowired
    HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user= repository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User not found on server for user id "+ userId));
        Rating[] ratingsOfUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
//        Rating[] ratingsOfUser=restTemplate.getForObject("http://localhost:8083/ratings/users/"+userId, Rating[].class);
        List<Rating>ratings=Arrays.stream(ratingsOfUser).collect(Collectors.toList());

        List<Rating>ratingsList=ratings.stream().map((rating)->{
//            ResponseEntity<Hotel> response=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
           Hotel hotel= hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingsList);
        return user;
    }
}
