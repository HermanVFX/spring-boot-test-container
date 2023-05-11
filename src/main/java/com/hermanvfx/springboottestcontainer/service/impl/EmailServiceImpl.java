package com.hermanvfx.springboottestcontainer.service.impl;

import com.hermanvfx.springboottestcontainer.entity.Email;
import com.hermanvfx.springboottestcontainer.entity.Phone;
import com.hermanvfx.springboottestcontainer.entity.User;
import com.hermanvfx.springboottestcontainer.repository.EmailRepository;
import com.hermanvfx.springboottestcontainer.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    @Override
    @Transactional
    public Email saveNewEmail(String email, User user) {
        var newEmail = new Email();
        newEmail.setUser(user);
        newEmail.setUserId(user.getId());
        newEmail.setEmail(email);
        var emailFromDb = emailRepository.save(newEmail);
        log.info("Email : {}, for user : {} was added", emailFromDb.getEmail(), emailFromDb.getUser().getName());
        return emailFromDb;
    }
}
