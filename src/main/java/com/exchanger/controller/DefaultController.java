package com.exchanger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String mainPage(){
        return "Simply empty page:)";
    }

    @GetMapping("/table")
    public String tablePage(){
        return "Page with table of currencies:)";
    }
}
