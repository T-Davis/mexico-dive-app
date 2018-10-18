package com.trevor.mexicodiveapp.presentation;


import com.trevor.mexicodiveapp.logic.model.Statistics;
import com.trevor.mexicodiveapp.logic.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/statistics")
public class StatisticsController {

    @Resource
    private StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


    @GetMapping("/dives")
    public Statistics getTotalNumberOfDives() {
        return new Statistics(statisticsService.getTotalNumberOfDives(), "Total Number Of Dives");
    }

    @GetMapping("/duration/total")
    public Statistics getTotalTimeInWaterInMinutes() {
        return new Statistics(statisticsService.getTotalTimeInWaterInMinutes(), "Total Number of Minutes in the Water");
    }

//    @GetMapping("/depth/max")
//    public Statistics getMaxDepthInMetersForAllDives() {
//        return new Statistics(statisticsService.getMaxDepthInMetersForAllDives(statisticsService.getDiveList()), "Max Depth In Meters");
//
//    }
//
//    @GetMapping("/depth/min")
//    public Statistics getMinDepthInMetersForAllDives() {
//        return new Statistics(statisticsService.getMinDepthInMetersForAllDives(statisticsService.getDiveList()), "Min Depth In Meters");
//
//    }
//
//    @GetMapping("/depth/average")
//    public Statistics getAverageDepthInMetersForAllDives() {
//        return new Statistics(statisticsService.getAverageDepthInMetersForAllDives(statisticsService.getDiveList()), "Average Depth in Meters");
//
//    }
}
