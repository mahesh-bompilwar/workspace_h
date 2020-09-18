package com.techdenovo.aaps.signup.service.impl;

import com.techdenovo.aaps.signup.UserRepository;
import com.techdenovo.aaps.signup.io.entity.UserEntity;
import com.techdenovo.aaps.signup.service.UserService;
import com.techdenovo.aaps.signup.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserID");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, userDto);
        return userDto;
    }
}
