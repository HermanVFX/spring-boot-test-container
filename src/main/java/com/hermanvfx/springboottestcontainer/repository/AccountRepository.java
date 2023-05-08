package com.hermanvfx.springboottestcontainer.repository;

import com.hermanvfx.springboottestcontainer.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Long> {

    List<Account> findAllByUserIdIn(Collection<Long> usersId);

    List<Account> findAllByIdIn(Collection<Long> accountsId);
}
