package com.trevor.mexicodiveapp.presentation.api;

import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.service.DiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user/logbook/dives")
public class DiveController {

    @Resource
    private DiveService diveService;

    @Autowired
    public DiveController(DiveService diveService) {
        this.diveService = diveService;
    }

    @GetMapping
    public List<Dive> getAllDives() {
        return diveService.getAllDives();
    }

    @GetMapping("/location/{location}")
    public List<Dive> getDiveByLocation(@PathVariable String location) {
        return diveService.getDiveByLocation(location);
    }

    @GetMapping("/date/{date}")
    public List<Dive> getDiveByDate(@PathVariable String date) {
        return diveService.getDiveByDate(LocalDate.parse(date));
    }

    @GetMapping("/id/{id}")
    public Dive getDiveById(@PathVariable Integer id) {
        return diveService.getDiveById(id);
    }

    @PostMapping
    public Dive save(@RequestBody Dive dive) {
        return diveService.save(dive);
    }

    @PutMapping("/{id}")
    public Dive updateDiveById(@PathVariable int id, @RequestBody Dive dive) {
        return diveService.updateDiveById(id, dive);
    }

    @DeleteMapping("/{id}")
    public Dive deleteDive(@PathVariable int id) {
        return diveService.delete(id);
    }

}
