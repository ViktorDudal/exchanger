package com.exchanger.controller;

import com.exchanger.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class DefaultController {

    private final CurrencyService currencyService;

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/table")
    public ModelAndView tablePage(){
        ModelAndView modelAndView = new ModelAndView("table");
        modelAndView.addObject("currencies", currencyService.getAllCurrencies());
        return modelAndView;
    }
}
