package com.microservices.userservice.Controllers;

import com.microservices.userservice.entities.User;
import com.microservices.userservice.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return ResponseEntity.ok(list);
    }

    int retryCount=1;
    @GetMapping("/{id}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
//    @RateLimiter(name = "ratingHotelLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        logger.info("retry count: {}",retryCount);
        retryCount++;
        User user1 = userService.getUserById(id);
        return ResponseEntity.ok(user1);
    }

    //    creating fallback method for rating hotel fallback
    public ResponseEntity<User> ratingHotelFallback(String id,Exception exception) {
        logger.error("fall back method called for getUserByID with ex {}",exception.getMessage());
        User user1 = User.builder()
                .userId("1234")
                .name("dummy")
                .email("dummy@gmail.com")
                .about("this is a dummy feedback from handler method").build();
        return ResponseEntity.ok(user1);
    }


}
