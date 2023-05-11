package com.hermanvfx.springboottestcontainer.service.impl;

import com.hermanvfx.springboottestcontainer.dto.RegistrationUserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDtoPage;
import com.hermanvfx.springboottestcontainer.entity.Account;
import com.hermanvfx.springboottestcontainer.entity.Email;
import com.hermanvfx.springboottestcontainer.entity.Phone;
import com.hermanvfx.springboottestcontainer.entity.User;
import com.hermanvfx.springboottestcontainer.entity.mapper.EmailMapper;
import com.hermanvfx.springboottestcontainer.entity.mapper.PhoneMapper;
import com.hermanvfx.springboottestcontainer.entity.mapper.UserMapper;
import com.hermanvfx.springboottestcontainer.repository.AccountRepository;
import com.hermanvfx.springboottestcontainer.repository.EmailRepository;
import com.hermanvfx.springboottestcontainer.repository.PhoneRepository;
import com.hermanvfx.springboottestcontainer.repository.UserRepository;
import com.hermanvfx.springboottestcontainer.service.AccountService;
import com.hermanvfx.springboottestcontainer.service.EmailService;
import com.hermanvfx.springboottestcontainer.service.PhoneService;
import com.hermanvfx.springboottestcontainer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PhoneService phoneService;
    private final EmailService emailService;
    private final AccountService accountService;

    private final UserMapper userMapper;
    private final PhoneMapper phoneMapper;
    private final EmailMapper emailMapper;

    @Override
    @Transactional
    public UserDto userRegistration(RegistrationUserDto user) {
        var newUser = new User();
        newUser.setName(user.getName());
        newUser.setBirthDate(user.getBirthDate());
        newUser.setPassword(user.getPassword());
        newUser.setCreatedAt(Calendar.getInstance(Locale.CANADA));
        var userFromDb = userRepository.save(newUser);
        log.info("User was added [name : {} , birthDate : {}]",
                userFromDb.getName(),
                userFromDb.getBirthDate());

        List<Phone> phones = phoneMapper.listShortPhoneDtoToListPhone(user.getPhone());
        phones.forEach(phone -> {
            phoneService.saveNewPhone(phone.getPhone(), userFromDb);
        });
        List<Email> emails = emailMapper.listShortEmailDtoToListEmail(user.getEmail());
        emails.forEach(email -> {
            emailService.saveNewEmail(email.getEmail(), userFromDb);
        });

        var accountFromDb = accountService.createNewAccount(userFromDb);
        userFromDb.setAccount(accountFromDb);
        var userFromDbWithAccount = userRepository.save(userFromDb);
        log.info("Insert in User Account with balance : {}", accountFromDb.getBalance());
        return userMapper.userToUserDto(userFromDbWithAccount);
    }

    @Override
    public UserDtoPage findLikeName(String name, Pageable pageable) {
        var users = userRepository.findUserLikeName(name+'%', pageable);
        return pageToDto(users, pageable);
    }

    @Override
    public UserDtoPage findBetweenDateOfBirth(OffsetDateTime dateStart, OffsetDateTime dateEnd, Pageable pageable) {
        var users = userRepository.findUserBetweenDateOfBirth(dateStart, dateEnd, pageable);
        return pageToDto(users, pageable);
    }

    @Override
    public UserDtoPage findLikeEmail(String email, Pageable pageable) {
        var users = userRepository.findUserLikeEmail(email+'%', pageable);
        return pageToDto(users, pageable);
    }

    @Override
    public UserDtoPage findLikePhone(String phone, Pageable pageable) {
        var users = userRepository.findUserLikePhone(phone+'%', pageable);
        return pageToDto(users, pageable);
    }

    @Override
    public UserDtoPage findByBalance(String filter, Pageable pageable) {
        Page<User> users;
        if (filter.equals("low")) {
            users = userRepository.findUserLowBalance(pageable);
        } else if (filter.equals("Grow")) {
            users = userRepository.findUserLowBalance(pageable);
        } else {
            throw new IllegalStateException("Incorrect filter");
        }
        return pageToDto(users, pageable);
    }

    private UserDtoPage pageToDto(Page<User> users, Pageable pageable) {
        var content = userMapper.userListToUserDtoList(users.getContent());
        UserDtoPage userDtoPage = new UserDtoPage();
        userDtoPage.setContent(content);
        userDtoPage.setTotalPage(users.getTotalPages());
        userDtoPage.setCurrentPage(pageable.getPageNumber());
        return userDtoPage;
    }
}
