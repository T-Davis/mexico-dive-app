package com.trevor.mexicodiveapp.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String about(Model model) {
//        model.addAttribute("classActiveSettings","active");
        return "contact";
    }
}
