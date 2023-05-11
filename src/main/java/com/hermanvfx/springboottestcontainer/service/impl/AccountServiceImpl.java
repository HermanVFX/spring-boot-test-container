package com.hermanvfx.springboottestcontainer.service.impl;

import com.hermanvfx.springboottestcontainer.entity.Account;
import com.hermanvfx.springboottestcontainer.entity.User;
import com.hermanvfx.springboottestcontainer.repository.AccountRepository;
import com.hermanvfx.springboottestcontainer.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public Account createNewAccount(User user) {
        var account = new Account();
        account.setUser(user);
        account.setCreatedAt(Calendar.getInstance(Locale.CANADA));
        var accountFromDb = accountRepository.save(account);
        log.info("Account for user : {} was added", accountFromDb.getUser().getName());
        return accountFromDb;
    }
}
