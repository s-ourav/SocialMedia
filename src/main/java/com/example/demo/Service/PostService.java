package com.example.demo.Service;

import com.example.demo.Models.Notification;
import com.example.demo.Models.Post;
import com.example.demo.Models.User;
import com.example.demo.Repo.NotiRep;
import com.example.demo.Repo.PostRepo;
import com.example.demo.Repo.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    UserRep userRep;
    @Autowired
    PostRepo postRepo;

    @Autowired
    NotiRep notiRep;
    public String addPost(int userId,String content,String time){
        if(!userRep.existsById(userId)){
            return "user doesn't exist";
        }

        User user=userRep.findById(userId).get();
        Post post= Post.builder()
                .user(user)
                .content(content)
                .time(time)
                .build();

        user.getPostList().add(post);
        userRep.save(user);
        return "Post saved";
    }

    public String likePost (int postId){
        if(! postRepo.existsById(postId)){
            return "Invalid postID";
        }

        Post post = postRepo.findById(postId).get(); // find user and post
        User user=post.getUser();

        Post post1=null;
        for(Post p: user.getPostList()){ // find the post in the user's postList
                if(p.getPostId()==postId){
                    p.setLikes(p.getLikes()+1); //set likes+1
                    Notification notification= Notification.builder() //create a notification
                            .post(p)
                            .time(p.getTime())
                            .user(p.getUser())
                            .build();
                    p.getNotificationList().add(notification); //add noti to posts's notiList
                    post1=p;
                }
        }


        postRepo.save(post1);
        userRep.save(user);


        return "Post Liked";
    }
}
