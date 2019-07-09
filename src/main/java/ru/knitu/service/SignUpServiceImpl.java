package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.knitu.form.UserForm;
import ru.knitu.model.Role;
import ru.knitu.model.State;
import ru.knitu.model.User;
import ru.knitu.repository.UserRepository;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                    .firstname(userForm.getFirstName())
                    .lastname(userForm.getLastName())
                    .login(userForm.getLogin())
                    .hashpassword(hashPassword)
                    .telephone(userForm.getTelephone())
                    .role(Role.USER)
                    .state(State.ACTIVE)
                .build();
        userRepository.save(user);
        return true;
    }
}
