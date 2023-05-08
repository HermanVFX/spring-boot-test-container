package com.hermanvfx.springboottestcontainer.repository;

import com.hermanvfx.springboottestcontainer.entity.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface EmailRepository extends CrudRepository<Email,Long> {

    List<Email> findAllByUserIdIn(Collection<Long> usersId);

    List<Email> findAllByIdIn(Collection<Long> accountsId);
}
