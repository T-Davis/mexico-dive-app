package com.trevor.mexicodiveapp.presentation.web;

import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.service.DiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/dives")
public class DivesController {

    @Resource
    private DiveService diveService;

    @Autowired
    public DivesController(DiveService diveService) {
        this.diveService = diveService;
    }

    @GetMapping
    public String dives(Model model) {
        model.addAttribute("dives", diveService.getAllDives());
        return "dives";
    }

    @GetMapping("/{id}")
    public String deleteDive(Model model) {
        model.addAttribute("dive", new Dive());
        return "redirect:/dives";
    }

    @DeleteMapping("/{id}")
    public String deleteDive(@ModelAttribute("id") int id) {
        diveService.delete(id);
        return "redirect:/dives";
    }
}