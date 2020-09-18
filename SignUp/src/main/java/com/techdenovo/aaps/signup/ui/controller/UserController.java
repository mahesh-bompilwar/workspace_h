package com.techdenovo.aaps.signup.ui.controller;

import com.techdenovo.aaps.signup.service.UserService;
import com.techdenovo.aaps.signup.shared.dto.UserDto;
import com.techdenovo.aaps.signup.ui.model.request.UserDetailsRequestModel;
import com.techdenovo.aaps.signup.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUser(){
        return "get User Details";
    }

    @PostMapping("/createUser")
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails ){

        UserRest userRest = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser, userRest);

        return userRest;
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        return "get User Details";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "get User Details";
    }
}
