package com.trevor.mexicodiveapp.presentation.web;

import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.service.DiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class AddDiveController {

    @Resource
    private DiveService diveService;

    @Autowired
    public AddDiveController(DiveService diveService) {
        this.diveService = diveService;
    }

    @GetMapping("/add")
    public String addDive(Model model) {
        model.addAttribute("dive", new Dive());
        return "addDive";
    }

    @PostMapping("/add")
    public String diveSubmit(@ModelAttribute("dive") Dive dive) {
        diveService.save(dive);
        return "redirect:/dives";
    }

}