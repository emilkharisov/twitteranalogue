package ru.knitu.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.knitu.model.Message;
import ru.knitu.model.Role;
import ru.knitu.model.State;
import ru.knitu.model.User;
import ru.knitu.repository.MessageRepository;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "ru.knitu")

public class AddMessageServiceImplTest {

    @MockBean
    MessageRepository messageRepository;

    @Autowired
    AddMessageServiceImpl addMessageService;

    User user = new User();
    String text1="test";
    String filename="test";

    @Before
    public void setUp(){
        String test ="test";
        user.setLogin(test);
        user.setFirstname(test);
        user.setLastname(test);
        user.setHashpassword(test);
        user.setId(1);
        user.setRole(Role.USER);
        user.setState(State.ACTIVE);
        user.setTelephone(test);
    }

    @Test
    public void addMessgae() {
        boolean isAdded = addMessageService.addMessgae(text1,user,filename);
        Assert.assertTrue(isAdded);

    }
    @Configuration
    @Import(AddMessageServiceImpl.class)
    static class Config{
    }
}