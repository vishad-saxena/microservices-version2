package com.microservices.hotel.hotelservice.services.impl;

import com.microservices.hotel.hotelservice.entities.Hotel;
import com.microservices.hotel.hotelservice.exceptions.ResourceNotFoundException;
import com.microservices.hotel.hotelservice.repositories.HotelRepository;
import com.microservices.hotel.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        String hotelId= UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel with given id not found !!"));
    }
}
