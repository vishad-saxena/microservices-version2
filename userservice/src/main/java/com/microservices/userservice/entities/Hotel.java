package com.microservices.userservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hotel implements Serializable {
    public String hotelId;
    public String name;
    public String location;
    public String about;
}
