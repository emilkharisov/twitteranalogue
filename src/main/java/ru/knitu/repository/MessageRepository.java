package ru.knitu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Message;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}
