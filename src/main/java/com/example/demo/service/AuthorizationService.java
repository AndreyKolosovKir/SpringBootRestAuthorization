package com.example.demo.service;

import com.example.demo.exception.Authorities;
import com.example.demo.exception.InvalidCredentials;
import com.example.demo.exception.UnauthorizedUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            //TODO Вам нужно написать обработчики ошибок, которые выкидывает сервис AuthorizationService:

            //TODO 1) на InvalidCredentials он должен отсылать обратно клиенту HTTP-статус с кодом 400
            // и телом в виде сообщения из exception;
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            //TODO 2) на UnauthorizedUser он должен отсылать обратно клиенту HTTP-статус с кодом 401
            // телом в виде сообщения из exception и писать в консоль сообщение из exception.
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
