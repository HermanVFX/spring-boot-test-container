package com.hermanvfx.springboottestcontainer.repository;

import com.hermanvfx.springboottestcontainer.entity.User;
import com.hermanvfx.springboottestcontainer.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Long> {

    Page<User> findAllByAccountIdIn(Collection<Long> accountIds, Pageable pageable);

    @Query(
            value = "SELECT u.name, u.birth_date as birthDate, pd.phone, ed.email FROM usr u" +
                    "   join phone_data pd on u.id = pd.user_id" +
                    "   join email_data ed on u.id = ed.user_id" +
                    "   order by u.created_at desc",
            nativeQuery = true
    )
    Page<UserInfo> findAllUsers(Pageable pageable);

    @Query(
            value = "SELECT * FROM usr u where u.name like :name order by u.created_at desc",
            nativeQuery = true
    )
    Page<User> findUserLikeName(@Param("name") String name, Pageable pageable);

    @Query(
            value = "SELECT * FROM usr u" +
                    "    where u.birth_date between :dateStart and :dateEnd" +
                    "    order by u.birth_date desc",
            nativeQuery = true
    )
    Page<User> findUserBetweenDateOfBirth(
            @Param("dateStart") OffsetDateTime dateStart,
            @Param("dateEnd") OffsetDateTime dateEnd,
            Pageable pageable);

    @Query(
            value = "SELECT u.* FROM email_data ed" +
                    "    join usr u on u.id = ed.user_id" +
                    "    where ed.email like :email",
            nativeQuery = true
    )
    Page<User> findUserLikeEmail(@Param("email") String email, Pageable pageable);

    @Query(
            value = "SELECT u.* FROM phone_data pd" +
                    "    join usr u on u.id = pd.user_id" +
                    "    where pd.phone like :phone",
            nativeQuery = true
    )
    Page<User> findUserLikePhone(@Param("phone") String phone, Pageable pageable);

    @Query(
            value = "SELECT u.* FROM account a" +
                    "    join usr u on u.id = a.user_id" +
                    "    order by a.balance",
            nativeQuery = true
    )
    Page<User> findUserGrowBalance(Pageable pageable);

    @Query(
            value = "SELECT u.* FROM account a" +
                    "    join usr u on u.id = a.user_id" +
                    "    order by a.balance desc",
            nativeQuery = true
    )
    Page<User> findUserLowBalance(Pageable pageable);
}
