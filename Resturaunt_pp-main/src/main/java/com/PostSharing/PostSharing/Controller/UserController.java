package com.PostSharing.PostSharing.Controller;

import com.PostSharing.PostSharing.Modle.User;
import com.PostSharing.PostSharing.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public String loginfun(@RequestBody String data) throws JsonProcessingException {
        User user = new ObjectMapper().readValue(data,User.class);
        return userService.loginuser(user);
    }

    @PostMapping("/user/signin")
    public String siginfun(@RequestBody String data) throws JsonProcessingException {
        User user = new ObjectMapper().readValue(data,User.class);
        return userService.signupuser(user);
    }



}
