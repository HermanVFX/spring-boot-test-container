package com.hermanvfx.springboottestcontainer.service;

import com.hermanvfx.springboottestcontainer.entity.Email;
import com.hermanvfx.springboottestcontainer.entity.User;

public interface EmailService {
    Email saveNewEmail(String email, User user);
}
