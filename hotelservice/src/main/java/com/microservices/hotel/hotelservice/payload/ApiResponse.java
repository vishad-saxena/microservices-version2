package com.microservices.hotel.hotelservice.payload;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse {
    public String message;
    public boolean status;
    public HttpStatus httpStatus;

}
