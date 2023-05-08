package com.hermanvfx.springboottestcontainer.repository;

import com.hermanvfx.springboottestcontainer.entity.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone,Long> {

    List<Phone> findAllByUserIdIn(Collection<Long> usersId);

    List<Phone> findAllByIdIn(Collection<Long> accountsId);
}
