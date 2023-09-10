package com.example.demo.advice;

import com.example.demo.exception.InvalidCredentials;
import com.example.demo.exception.UnauthorizedUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler() {
        return new ResponseEntity<>("User name or password is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser e, HttpServletRequest request) {
        System.out.println(e);
        String name = request.getParameter("user");
        return new ResponseEntity<>("Unknown user " + name, HttpStatus.UNAUTHORIZED);
    }
}
