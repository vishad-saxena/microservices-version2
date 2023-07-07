package com.ratingservice.controllers;

import com.ratingservice.entities.Rating;
import com.ratingservice.services.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    Logger logger = LoggerFactory.getLogger(RatingController.class);
    @Autowired
    RatingService ratingService;
//    getAllRatings
    @GetMapping
    public ResponseEntity<List<Rating>>getAllRatings(){
        logger.info("getting all ratings");
        List<Rating> ratings=ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

//    getRating by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId){
        logger.info("getting all ratings by usr id {}",userId);
        List<Rating> rating=ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(rating);
    }
//    getRating by Hotel Id
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<Rating> getRatingByHotelId(@PathVariable String hotelId){
        logger.info("getting all ratings by hotel id {}",hotelId);
        Rating rating=ratingService.getRatingsByHotelId(hotelId);
        return ResponseEntity.ok(rating);
    }
//    save rating
    @PostMapping
    public Rating saveRating(@RequestBody Rating rating){
        return ratingService.saveRatings(rating);
    }
}
