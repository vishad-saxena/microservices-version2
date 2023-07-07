package com.microservices.userservice;

import com.microservices.userservice.entities.Hotel;
import com.microservices.userservice.entities.Rating;
import com.microservices.userservice.externalservices.HotelService;
import com.microservices.userservice.externalservices.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserserviceApplicationTests {

	@Autowired
	RatingService ratingService;
	@Autowired
	HotelService hotelService;

	@Test
	void contextLoads() {
	}

//	@Test
//	void createRating(){
//		Rating rating =Rating.builder().rating(3).hotelId("").userId("").feedback("this is a rating using feign").build();
//		ratingService.addRating(rating);
//		System.out.println("rating is created");
//	}

//	@Test
//	void createHotel(){
//		Hotel hotel=Hotel.builder().name("cafe hours").location("janakpuri").about("best coffe in town").build();
//		ResponseEntity<Hotel> entity=hotelService.createHotel(hotel);
//		System.out.println(entity.getBody());
//		System.out.println(entity.getStatusCode());
//	}
}
