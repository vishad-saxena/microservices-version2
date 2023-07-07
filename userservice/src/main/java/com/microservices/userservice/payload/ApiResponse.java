package com.microservices.userservice.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    public String message;
    public boolean success;
    public HttpStatus status;
}
