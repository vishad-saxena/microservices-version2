package com.ratingservice.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user_ratings")
public class Rating {
    @Id
    public String ratingId;
    public String hotelId;
    public String userId;
    public int rating;
    public String feedback;
}
