package com.techdenovo.aaps.signup.service;

import com.techdenovo.aaps.signup.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
}
