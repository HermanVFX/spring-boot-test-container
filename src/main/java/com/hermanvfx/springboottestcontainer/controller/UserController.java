package com.hermanvfx.springboottestcontainer.controller;

import com.hermanvfx.springboottestcontainer.dto.RegistrationUserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDto;
import com.hermanvfx.springboottestcontainer.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> registrationNewUser(RegistrationUserDto registrationUserDto) {
        return new ResponseEntity<>(userService.userRegistration(registrationUserDto), HttpStatus.CREATED);
    }
}
