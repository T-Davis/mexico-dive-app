package com.trevor.mexicodiveapp.logic;

import com.trevor.mexicodiveapp.data.MySqlDiveRepository;
import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.service.DiveService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DiveServiceTest {
    private final static String LOCATION = "Bull shark dive";
    private final static LocalDate DATE = LocalDate.of(2014, Month.JANUARY, 1);
    private DiveService diveService;
    private MySqlDiveRepository mySqlDiveRepositoryMock;
    private Dive dive1;
    private Dive dive2;
    private Dive diveFromRepository;
    private List<Dive> diveList;
    private int dive2Id = 2;
    private int dive3Id = 3;

    @Before
    public void setUp() {
        diveList = new ArrayList<>();
        mySqlDiveRepositoryMock = Mockito.mock(MySqlDiveRepository.class);
        diveService = new DiveService(mySqlDiveRepositoryMock);

        dive1 = new Dive();
        dive1.setLocation("Bull shark dive");
        dive1.setDate(DATE);
        diveList.add(dive1);

        dive2 = new Dive();
        dive2.setId(dive2Id);

        diveFromRepository = new Dive();
        diveFromRepository.setId(dive3Id);
    }

    @Test
    public void whenGettingAllDives_shouldReturnAllDives() {
        when(mySqlDiveRepositoryMock.getAllDives()).thenReturn(Arrays.asList(dive1, dive2));

        List<Dive> allDives = diveService.getAllDives();

        assertThat(allDives).hasSize(2);
        assertThat(allDives).contains(dive1, dive2);
    }

    @Test
    public void whenGettingDiveByLocation_shouldReturnListOfDivesByLocation() {
        when(mySqlDiveRepositoryMock.getDiveByLocation(LOCATION)).thenReturn(diveList);

        List<Dive> diveListByLocation = diveService.getDiveByLocation(LOCATION);

        assertThat(diveListByLocation).extracting(dive -> dive.getLocation()).containsOnly(LOCATION);
    }

    @Test
    public void whenGettingDiveByDate_shouldReturnDiveListForThatDate() {
        when(mySqlDiveRepositoryMock.getDiveByDate(DATE)).thenReturn(diveList);

        List<Dive> diveListByDate = diveService.getDiveByDate(DATE);


        assertThat(diveListByDate).extracting("date").containsOnly(DATE);
    }

    @Test
    public void whenGettingDiveById_shouldReturnDiveById() {
        when(mySqlDiveRepositoryMock.getDiveById(dive2Id)).thenReturn(dive2);
        Dive diveById = diveService.getDiveById(dive2Id);

        assertThat(diveById).extracting("id").containsOnly(dive2Id);
    }

    @Test
    public void whenSavingADive_shouldSaveADive() {
        when(mySqlDiveRepositoryMock.save(dive1)).thenReturn(diveFromRepository);

        Dive savedDive = diveService.save(dive1);

        verify(mySqlDiveRepositoryMock).save(dive1);
        assertThat(savedDive).isEqualTo(diveFromRepository);
    }

    @Test
    public void whenUpdatingDiveById_shouldUpdateDiveById() {
        when(mySqlDiveRepositoryMock.updateDiveById(dive2Id, dive2)).thenReturn(diveFromRepository);

        Dive updatedDive = diveService.updateDiveById(dive2Id, dive2);

        assertThat(updatedDive).isEqualTo(diveFromRepository);
        verify(mySqlDiveRepositoryMock).updateDiveById(dive2Id, dive2);
    }

    @Test
    public void whenDeletingDiveById_shouldDeleteDiveById() {
        when(mySqlDiveRepositoryMock.delete(dive3Id)).thenReturn(diveFromRepository);

        Dive deletedDive = diveService.delete(dive3Id);

        assertThat(deletedDive).isEqualTo(diveFromRepository);
        assertThat(deletedDive.getId()).isEqualTo(dive3Id);
        verify(mySqlDiveRepositoryMock).delete(dive3Id);
    }
}