package com.trevor.mexicodiveapp.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchDivesController {

    @GetMapping("/search")
    public String search(Model model) {
        return "searchDives";
    }

}
