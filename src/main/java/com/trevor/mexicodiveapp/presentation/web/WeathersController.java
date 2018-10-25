package com.trevor.mexicodiveapp.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class WeathersController {

    @GetMapping("/weather")
    public String weather(Model model) {
        model.addAttribute("date", LocalDate.now());
        return "weather";
    }
}
