package com.hermanvfx.springboottestcontainer.service.impl;

import com.hermanvfx.springboottestcontainer.dto.ShortPhoneDto;
import com.hermanvfx.springboottestcontainer.entity.Phone;
import com.hermanvfx.springboottestcontainer.entity.User;
import com.hermanvfx.springboottestcontainer.entity.mapper.PhoneMapper;
import com.hermanvfx.springboottestcontainer.repository.PhoneRepository;
import com.hermanvfx.springboottestcontainer.service.PhoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    @Transactional
    public Phone saveNewPhone(String phone, User user) {
        var newPhone = new Phone();
        newPhone.setUser(user);
        newPhone.setUserId(user.getId());
        newPhone.setPhone(phone);
        var phoneFromDb = phoneRepository.save(newPhone);
        log.info("Phone : {}, for user : {} was added", phoneFromDb.getPhone(), phoneFromDb.getUser().getName());
        return phoneFromDb;
    }
}
