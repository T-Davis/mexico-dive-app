package com.trevor.mexicodiveapp.logic.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Dive {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String location;
    private double durationInMinutes;
    private double maxDepthInMeters;
    private String waterConditions;
    private boolean safetyStop;

    public Dive() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getMaxDepthInMeters() {
        return maxDepthInMeters;
    }

    public void setMaxDepthInMeters(double maxDepthInMeters) {
        this.maxDepthInMeters = maxDepthInMeters;
    }

    public String getWaterConditions() {
        return waterConditions;
    }

    public void setWaterConditions(String waterConditions) {
        this.waterConditions = waterConditions;
    }

    public boolean getSafetyStop() {
        return safetyStop;
    }

    public void setSafetyStop(boolean safetyStop) {
        this.safetyStop = safetyStop;
    }
}
