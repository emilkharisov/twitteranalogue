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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import ru.knitu.form.UserForm;
import ru.knitu.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "ru.knitu")
public class SignUpServiceTest {

    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    UserRepository userRepository;
    @Autowired
    SignUpServiceImpl signUpService;

    UserForm userForm = new UserForm();
    @Before
    public void setUp(){
        String test = "test";
        userForm.setLogin(test);
        userForm.setPassword(test);
        userForm.setTelephone(test);
        userForm.setFirstName(test);
        userForm.setLastName(test);
    }
    @Test
    public void signUp() {
        boolean isUserSigned = signUpService.signUp(userForm);
        Assert.assertTrue(isUserSigned);
    }
    @Configuration
    @Import(SignUpServiceImpl.class)
    static class Config {
    }
}