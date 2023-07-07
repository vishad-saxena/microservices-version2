package com.ratingservice.services.impl;

import com.ratingservice.entities.Rating;
import com.ratingservice.repository.RatingRepository;
import com.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    //    get ratings by userId
    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.getRatingsByUserId(userId);
    }

    //    get ratings by hotelId

    @Override
    public Rating getRatingsByHotelId(String hotelId) {
        return ratingRepository.getRatingsByHotelId(hotelId);
    }

    //    get all ratings
    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }


    //    SAve ratings
    @Override
    public Rating saveRatings(Rating rating) {
        return ratingRepository.save(rating);
    }
}
