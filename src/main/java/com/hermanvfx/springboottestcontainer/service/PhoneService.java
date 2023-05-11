package com.hermanvfx.springboottestcontainer.service;

import com.hermanvfx.springboottestcontainer.entity.Phone;
import com.hermanvfx.springboottestcontainer.entity.User;

public interface PhoneService {
    Phone saveNewPhone(String phone, User  user);
}
