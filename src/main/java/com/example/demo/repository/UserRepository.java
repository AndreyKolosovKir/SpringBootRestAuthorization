package com.example.demo.repository;

import com.example.demo.exception.Authorities;
import com.example.demo.persons.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    User userDefault = new User("admin", "!QAZ2wsx"); //для простого добавления юзера, с которым идет сравнение
    List<Authorities> allAuthoritiesList;

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals(userDefault.getUser()) && password.equals(userDefault.getPassword())) {
            Authorities[] allAuthorities = Authorities.values();
            return allAuthoritiesList = new ArrayList<>(List.of(allAuthorities));
        }
        return allAuthoritiesList;
    }
}
