package com.trevor.mexicodiveapp.logic.repository;

import com.trevor.mexicodiveapp.logic.model.Dive;

import java.time.LocalDate;
import java.util.List;

public interface DiveRepository {

    List<Dive> getAllDives();

    List<Dive> getDiveByLocation(String location);

    List<Dive> getDiveByDate(LocalDate date);

    Dive getDiveById(int id);

    Dive save(Dive dive);

    Dive updateDiveById(int id, Dive dive);

    Dive delete(int id);


}
