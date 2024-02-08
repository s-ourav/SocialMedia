package com.example.demo.Service;

import com.example.demo.Models.User;
import com.example.demo.Repo.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRep userRep;

    public String addUser(String name,int age){

        User user=new User();
        user.setName(name);
        user.setAge(age);
        userRep.save(user);
        return "User created";
    }
}
