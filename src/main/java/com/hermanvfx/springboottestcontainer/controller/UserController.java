package com.hermanvfx.springboottestcontainer.controller;

import com.hermanvfx.springboottestcontainer.dto.RegistrationUserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDtoPage;
import com.hermanvfx.springboottestcontainer.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> registrationNewUser(RegistrationUserDto registrationUserDto) {
        return new ResponseEntity<>(userService.userRegistration(registrationUserDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDtoPage> usersByBalance(String filter, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(userService.findByBalance(filter, pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDtoPage> usersByDate(
            OffsetDateTime dateStart,
            OffsetDateTime dateEnd,
            Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(userService.findBetweenDateOfBirth(dateStart, dateEnd, pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDtoPage> usersByEmail(String filter, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(userService.findLikeEmail(filter, pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDtoPage> usersByName(String filter, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(userService.findLikeName(filter, pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDtoPage> usersByPhone(String filter, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(userService.findLikePhone(filter, pageable), HttpStatus.OK);
    }
}
