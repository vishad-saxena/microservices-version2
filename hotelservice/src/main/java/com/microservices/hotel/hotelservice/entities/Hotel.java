package com.microservices.hotel.hotelservice.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @Column(name = "ID")
    public String hotelId;
    @Column(name = "NAME")
    public String name;
    @Column(name = "LOCATION")
    public String location;
    @Column(name = "ABOUT")
    public String about;
}
