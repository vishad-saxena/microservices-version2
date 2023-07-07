package com.microservices.userservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "micro_users")
@Builder
public class User {

    @Id
    @Column(name = "ID")
    public String userId;
    @Column(name = "NAME",length = 20)
    public String name;
    @Column(name = "EMAIL")
    public String email;
    @Column(name = "ABOUT")
    public String about;

    @Transient
    public List<Rating> ratings=new ArrayList<>();
}
