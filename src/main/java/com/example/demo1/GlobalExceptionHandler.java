package com.example.demo1;

import com.example.demo1.entity.AuthException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常
     * @param request the http request
     * @param e the exception
     * @return the results
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AuthException exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        AuthException authException = new AuthException();
        authException.setErrorReason(e.getMessage());
        authException.setErrorCode("400");
        return authException;
    }

}
