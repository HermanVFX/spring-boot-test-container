package com.hermanvfx.springboottestcontainer.service;

import com.hermanvfx.springboottestcontainer.entity.Account;
import com.hermanvfx.springboottestcontainer.entity.User;

public interface AccountService {
    Account createNewAccount(User user);
}
