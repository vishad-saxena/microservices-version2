package com.microservices.hotel.hotelservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class HotelStaffController {

    @GetMapping
    public ResponseEntity<List<String>> getStaff(){
        List<String> list=Arrays.asList("RAM","SHYAM","SITA","KRISHNA");
        return ResponseEntity.ok(list);
    }
}
