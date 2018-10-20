package com.trevor.mexicodiveapp.presentation.web;

import com.trevor.mexicodiveapp.logic.service.DiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class DivesController {

    @Resource
    private DiveService diveService;

    @Autowired
    public DivesController(DiveService diveService) {
        this.diveService = diveService;
    }

    @GetMapping("/dives")
    public String dives(Model model) {
//        model.addAttribute("classActiveSettings","active");
        model.addAttribute("dives", diveService.getAllDives());
        return "dives";
    }

}
