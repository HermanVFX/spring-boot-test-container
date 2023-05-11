package com.hermanvfx.springboottestcontainer.repository;

import com.hermanvfx.springboottestcontainer.SpringBootTestContainerApplication;
import com.hermanvfx.springboottestcontainer.entity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Random;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = SpringBootTestContainerApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    User getRandomUserEntity() {
        var random = new Random();
        var user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(5));
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        user.setBirthDate(OffsetDateTime.of(
                random.nextInt(1900, 100),
                random.nextInt(1, 12),
                random.nextInt(1, 29),
                random.nextInt(0, 23),
                random.nextInt(0, 59),
                random.nextInt(0, 59),
                random.nextInt(0, 1000),
                java.time.ZoneOffset.UTC
                ));
        return user;
    }

    @Test
    public void save_user_good_params() {
        var testUser = userRepository.save(getRandomUserEntity());
        var bdUser = userRepository.findById(testUser.getId()).orElseThrow();
        System.out.println(testUser);
        System.out.println(bdUser);
    }
}
