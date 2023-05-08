package com.hermanvfx.springboottestcontainer.repository;

import com.hermanvfx.springboottestcontainer.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByAccountIdIn(Collection<Long> accountIds);

    @EntityGraph(value = "UserPhoneEmailGraph", type = EntityGraph.EntityGraphType.FETCH)
    List<User> findAllWithPhoneAndEmail();
}
