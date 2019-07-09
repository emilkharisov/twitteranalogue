package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.model.Message;
import ru.knitu.model.User;
import ru.knitu.repository.MessageRepository;


@Service
public class AddMessageServiceImpl implements AddMessageService {
    @Autowired
    MessageRepository messageRepository;
    @Override
    public boolean addMessgae(String text1, User user, String filename1) {
        Message message =
                Message.builder()
                            .author(user)
                            .text(text1)
                            .filename(filename1)
                        .build();
        messageRepository.save(message);
        return true;
    }

}
