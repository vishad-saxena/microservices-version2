package com.microservices.hotel.hotelservice.repositories;

import com.microservices.hotel.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {

}
