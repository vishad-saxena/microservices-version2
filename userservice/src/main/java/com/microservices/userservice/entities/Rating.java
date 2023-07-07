package com.microservices.userservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    public String ratingId;
    public String hotelId;
    public String userId;
    public int rating;
    public String feedback;
    public Hotel hotel;
}
