package com.example.demo.Repo;

import com.example.demo.Models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotiRep extends JpaRepository<Notification,Integer> {
}
