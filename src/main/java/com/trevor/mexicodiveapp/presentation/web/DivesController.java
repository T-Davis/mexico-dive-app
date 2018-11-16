package com.trevor.mexicodiveapp.presentation.web;

import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.service.DiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    //todo: refactor names of methods - save, getById, etc, through all layers
    @GetMapping
    public ModelAndView dives(Model model) {
        model.addAttribute("dives", diveService.getAllDives());
        return new ModelAndView("dives");
    }

    @GetMapping("/search")
    public ModelAndView search() {
        return new ModelAndView("searchDives");
    }

    @GetMapping("/add")
    public ModelAndView addDive(Model model) {
        //todo: test if this is necessary
        model.addAttribute("dive", new Dive());
        return new ModelAndView("addDive");
    }

    @PostMapping("/add")
    public ModelAndView diveSubmit(@ModelAttribute("dive") Dive dive) {
        diveService.save(dive);
        return new ModelAndView("redirect:/dives");
    }

    @GetMapping("/{id}")
    public ModelAndView deleteDive(Model model) {
        model.addAttribute("dive", new Dive());
        return new ModelAndView("redirect:/dives");
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteDive(@PathVariable("id") String id) {
        diveService.delete(Integer.valueOf(id));
        return new ModelAndView("redirect:/dives");
    }
}
