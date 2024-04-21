package ru.example.bank.controller;

import feign.FeignException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        return "Ошибка получения данных от внутреннего сервиса: " + e.getMessage();
    }

}
