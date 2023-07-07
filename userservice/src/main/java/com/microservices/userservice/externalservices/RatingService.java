package com.microservices.userservice.externalservices;

import com.microservices.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("RATING-SERVICE")
public interface RatingService {

//    GET

//    PUT

//    POST
    @PostMapping("/ratings")
    Rating addRating(Rating rating);
}
