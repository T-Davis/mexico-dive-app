package com.trevor.mexicodiveapp.logic.service;

import com.trevor.mexicodiveapp.logic.model.Dive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    private DivesService divesService;

    @Autowired
    public StatisticsService(DivesService divesService) {
        this.divesService = divesService;
    }

    public double getTotalNumberOfDives() {
        return divesService.getAllDives().size();
    }

    public double getTotalTimeInWaterInMinutes() {
        List<Dive> allDives = divesService.getAllDives();
        double totalTimeInWater = 0;
        for (Dive dive : allDives) {
            totalTimeInWater += dive.getDurationInMinutes();
        }
        return totalTimeInWater;

    }

    public double getMaxDepthInMetersForAllDives(List<Dive> allDives) {
        double maxDepth = 0;
        for (Dive dive : allDives) {
            if (maxDepth < dive.getMaxDepthInMeters()) {
                maxDepth = dive.getMaxDepthInMeters();
            }
        }
        return maxDepth;
    }

    public double getMinDepthInMetersForAllDives(List<Dive> allDives) {
        Dive dive1 = allDives.get(0);
        double minDepth = dive1.getMaxDepthInMeters();
        for (Dive dive : allDives) {
            if (minDepth > dive.getMaxDepthInMeters()) {
                minDepth = dive.getMaxDepthInMeters();
            }
        }
        return minDepth;
    }

    public double getAverageDepthInMetersForAllDives(List<Dive> allDives) {
        double sumOfAllDepths = 0;
        for (Dive dive : allDives) {
            sumOfAllDepths += dive.getMaxDepthInMeters();
        }
        double numberOfDives = getTotalNumberOfDives();
        return sumOfAllDepths / numberOfDives;
    }

}
