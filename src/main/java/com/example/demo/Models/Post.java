package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String content;
    private String time;
    private int likes;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    List<Notification> notificationList=new ArrayList<>();

}
