package com.hermanvfx.springboottestcontainer.service.impl;

import com.hermanvfx.springboottestcontainer.dto.RegistrationUserDto;
import com.hermanvfx.springboottestcontainer.dto.UserDto;
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
import com.hermanvfx.springboottestcontainer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;
    private final EmailRepository emailRepository;
    private final AccountRepository accountRepository;

    private final UserMapper userMapper;
    private final PhoneMapper phoneMapper;
    private final EmailMapper emailMapper;

    @Override
    public UserDto userRegistration(RegistrationUserDto user) {
        var newUser = new User();
        newUser.setName(user.getName());
        newUser.setBirthDate(user.getBirthDate());
        newUser.setPassword(user.getPassword());

        var userFromDb = userRepository.save(newUser);
        log.info("User was added [name : {} , birthDate : {}]",
                userFromDb.getName(),
                userFromDb.getBirthDate());

        List<Phone> phones = phoneMapper.listShortPhoneDtoToListPhone(user.getPhone());
        phones.forEach(phone -> {
            phone.setUser(newUser);
            var phoneFromDb = phoneRepository.save(phone);
            log.info("Phone : {}, for user : {} was added", phoneFromDb.getPhone(), phoneFromDb.getUser().getName());
        });
        List<Email> emails = emailMapper.listShortEmailDtoToListEmail(user.getEmail());
        emails.forEach(email -> {
            email.setUser(newUser);
            var emailFromDb = emailRepository.save(email);
            log.info("Email : {}, for user : {} was added",  emailFromDb.getEmail(), emailFromDb.getUser().getName());
        });

        var account = new Account();
        account.setUser(userFromDb);
        var accountFromDb = accountRepository.save(account);
        log.info("Account for user : {} was added", accountFromDb.getUser().getName());

        return userMapper.userToUserDto(userFromDb);
    }
}
