package com.ratingservice.services;

import com.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getRatingByUserId(String userId);

    List<Rating> getAllRatings();

    Rating getRatingsByHotelId(String hotelId);

    Rating saveRatings(Rating rating);
}
