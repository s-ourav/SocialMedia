package com.example.demo.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;
    private String name;
    private int age;

    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)
    List<Post> postList=new ArrayList<>();

    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)
    List<Notification> notificationList=new ArrayList<>();

}
