package com.trevor.mexicodiveapp.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//todo: find better name - homeController
@Controller
public class HomeController {
    //todo implement logout
    @GetMapping({"/", "/home"})
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/contact")
    public ModelAndView contact() {
        return new ModelAndView("contact");
    }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }
}
