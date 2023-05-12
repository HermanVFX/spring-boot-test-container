package com.hermanvfx.springboottestcontainer.service;

import com.hermanvfx.springboottestcontainer.dto.RegistrationUserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDtoPage;
import com.hermanvfx.springboottestcontainer.dto.UserFullDtoPage;
import org.springframework.data.domain.Pageable;

import java.time.OffsetDateTime;

public interface UserService {
    UserDto userRegistration(RegistrationUserDto user);
    UserDtoPage findLikeName(String name, Pageable pageable);
    UserDtoPage findBetweenDateOfBirth(OffsetDateTime dateStart, OffsetDateTime dateEnd, Pageable pageable);
    UserDtoPage findLikeEmail(String email, Pageable pageable);
    UserDtoPage findLikePhone(String phone, Pageable pageable);
    UserDtoPage findByBalance(String filter, Pageable pageable);
    UserFullDtoPage findAllWithPhoneAndEmail(Pageable pageable);
}
