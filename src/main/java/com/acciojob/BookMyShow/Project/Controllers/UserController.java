package com.acciojob.BookMyShow.Project.Controllers;

import com.acciojob.BookMyShow.Project.Requests.AddUserRequest;
import com.acciojob.BookMyShow.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public String addUser(@RequestBody AddUserRequest userRequest){
        return userService.addUser(userRequest);
    }
}
