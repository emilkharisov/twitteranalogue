package ru.knitu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.User;

import java.util.List;
import java.util.Optional;

public  interface UserRepository extends JpaRepository<User, Integer> {
List<User> findAllByFirstname(String firstname);
Optional<User> findUserByLogin(String  login);

}
