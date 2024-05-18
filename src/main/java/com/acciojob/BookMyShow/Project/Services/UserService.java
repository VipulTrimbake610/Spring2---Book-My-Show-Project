package com.acciojob.BookMyShow.Project.Services;

import com.acciojob.BookMyShow.Project.Repository.UserRepository;
import com.acciojob.BookMyShow.Project.Requests.AddUserRequest;
import com.acciojob.BookMyShow.Project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(AddUserRequest userRequest){
        User user = User.builder()
                .age(userRequest.getAge())
                .name(userRequest.getName())
                .mobileNo(userRequest.getMobileNo())
                .build();

        user = userRepository.save(user);
        return "User has been saved to the Db with userId "+user.getUserId();
    }
}
