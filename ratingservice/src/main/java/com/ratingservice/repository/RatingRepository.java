package com.ratingservice.repository;

import com.ratingservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {
    public Rating getRatingsByHotelId(String hotelId);
    public List<Rating> getRatingsByUserId(String userId);

}
