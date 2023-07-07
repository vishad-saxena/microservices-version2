package com.microservices.hotel.hotelservice.services;

import com.microservices.hotel.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel saveHotel(Hotel hotel);
    public List<Hotel> getAllHotels();
    public Hotel getHotelById(String hotelId);
}
