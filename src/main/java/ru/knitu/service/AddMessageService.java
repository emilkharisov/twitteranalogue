package ru.knitu.service;

import ru.knitu.model.User;

public interface AddMessageService {
     boolean addMessgae(String text1, User user,String filename);
}
