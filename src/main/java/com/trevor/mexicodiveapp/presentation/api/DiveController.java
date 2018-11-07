package com.trevor.mexicodiveapp.presentation.api;

import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.model.security.ApiToken;
import com.trevor.mexicodiveapp.logic.service.DiveService;
import com.trevor.mexicodiveapp.logic.service.security.ApiTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user/logbook/dives")
public class DiveController {

    private DiveService diveService;
    private ApiTokenService tokenService;

    @Autowired
    public DiveController(DiveService diveService, ApiTokenService tokenService) {
        this.diveService = diveService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public List<Dive> getAllDives(@RequestParam ApiToken apiToken) {
        tokenService.validateToken(apiToken);//todo token must be taken from parameters
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

    @GetMapping("/{id}")
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
