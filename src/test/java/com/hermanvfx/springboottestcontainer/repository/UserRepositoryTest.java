package com.hermanvfx.springboottestcontainer.repository;

import com.hermanvfx.springboottestcontainer.SpringBootTestContainerApplication;
import com.hermanvfx.springboottestcontainer.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = SpringBootTestContainerApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void When_FindUserLikeName_Expect_EmptyList() {
//        List<User> list = userRepository.
    }
}
