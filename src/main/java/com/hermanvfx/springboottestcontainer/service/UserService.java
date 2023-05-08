package com.hermanvfx.springboottestcontainer.service;

import com.hermanvfx.springboottestcontainer.dto.RegistrationUserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDto;

public interface UserService {
    UserDto userRegistration(RegistrationUserDto user);
}
