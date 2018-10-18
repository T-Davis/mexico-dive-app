package com.trevor.mexicodiveapp.data;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryDivesRepository {

//  List<Dive> secondList;
//  private List<Dive> diveList;

//  public InMemoryDivesRepository() {
//      this.diveList = new ArrayList<>();
//  }

//  @Override
//  public List<Dive> getAllDives() {
//      return diveList;
//  }

//  @Override
//  public List<Dive> getDiveByLocation(String location) {
//      return getByLocation(location);
//  }

//  @Override
//  public List<Dive> getDiveByDate(LocalDate date) {
//      return getByDate(date);

//  }

//  @Override
//  public Dive save(Dive dive) {
//      diveList.add(dive);
//      return diveList.get(diveList.indexOf(dive));
//  }

//  @Override
//  public Dive updateDiveById(int id, Dive dive) {
//      Dive storedDive = getById(id);
//      storedDive.setId(dive.getId());
//      storedDive.setDurationInMinutes(dive.getDurationInMinutes());
//      storedDive.setWaterConditions(dive.getWaterConditions());
//      storedDive.setSafetyStop(dive.getSafetyStop());
//      storedDive.setMaxDepthInMeters(dive.getMaxDepthInMeters());
//      storedDive.setLocation(dive.getLocation());
//      storedDive.setDate(dive.getDate());
//      return storedDive;
//  }


//  @Override
//  public Dive delete(int id) {
//      Dive dive = getById(id);
//      diveList.remove(dive);
//      return dive;
//  }

//  private Dive getById(int id) {
//      for (Dive diveInList : diveList) {
//          if (diveInList.getId() == id) {
//              return diveInList;
//          }
//      }
//      return null;
//  }

//  private List<Dive> getByLocation(String location) {
//      for (Dive diveInList : diveList) {
//          if (diveInList.getLocation().equals(location)) {
//              secondList.add(diveInList);
//          }
//      }
//      return secondList;
//  }

//  private List<Dive> getByDate(LocalDate date) {
//      for (Dive diveInList : diveList) {
//          if (diveInList.getDate().isEqual(date)) {
//              secondList.add(diveInList);
//          }
//      }
//      return secondList;
//  }
}
