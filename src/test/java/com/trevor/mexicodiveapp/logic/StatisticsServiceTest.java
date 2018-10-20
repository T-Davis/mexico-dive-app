package com.trevor.mexicodiveapp.logic;

import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.service.DiveService;
import com.trevor.mexicodiveapp.logic.service.StatisticsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class StatisticsServiceTest {
    private List<Dive> diveList;
    private StatisticsService statisticsService;
    private DiveService diveServiceMock;

    @Before
    public void setUp() {
        diveList = new ArrayList<>();

        Dive dive1 = new Dive();
        dive1.setDurationInMinutes(60);
        dive1.setMaxDepthInMeters(18);
        diveList.add(dive1);

        Dive dive2 = new Dive();
        dive2.setDurationInMinutes(40);
        dive2.setMaxDepthInMeters(30);
        diveList.add(dive2);

        diveServiceMock = Mockito.mock(DiveService.class);
        statisticsService = new StatisticsService(diveServiceMock);
    }

    @Test
    public void whenGettingTotalNumberOfDives_shouldReturnTotalNumberOfDives() {
        when(diveServiceMock.getAllDives()).thenReturn(diveList);

        double totalNumberOfDives = statisticsService.getTotalNumberOfDives();

        assertThat(totalNumberOfDives).isEqualTo(2);
    }

    @Test
    public void whenGettingTotalTimeInWater_shouldReturnTotalTimeInWater() {
        when(diveServiceMock.getAllDives()).thenReturn(diveList);

        double totalTimeInWaterInMinutes = statisticsService.getTotalTimeInWaterInMinutes();

        assertThat(totalTimeInWaterInMinutes).isEqualTo(100);
    }

    @Test
    public void whenGettingMaxDepth_shouldReturnMaxDepth() {
        when(diveServiceMock.getAllDives()).thenReturn(diveList);

        double maxDepthInMetersForAllDives = statisticsService.getMaxDepthInMetersForAllDives(diveList);

        assertThat(maxDepthInMetersForAllDives).isEqualTo(30);
    }


    @Test
    public void whenGettingMinDepth_shouldReturnMinDepth() {
        when(diveServiceMock.getAllDives()).thenReturn(diveList);

        double minDepthInMetersForAllDives = statisticsService.getMinDepthInMetersForAllDives(diveList);

        assertThat(minDepthInMetersForAllDives).isEqualTo(18);
    }


    @Test
    public void whenGettingAverageDepth_shouldReturnAverageDepth() {
        when(diveServiceMock.getAllDives()).thenReturn(diveList);

        double averageDepthInMetersForAllDives = statisticsService.getAverageDepthInMetersForAllDives(diveList);

        assertThat(averageDepthInMetersForAllDives).isEqualTo(24);
    }

}