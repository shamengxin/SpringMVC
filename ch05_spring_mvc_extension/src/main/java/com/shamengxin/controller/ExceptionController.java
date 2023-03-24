package com.shamengxin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public String HandleException(Model model,Throwable ex){
        model.addAttribute("ex",ex);
        return "error";
    }

}
