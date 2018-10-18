package com.trevor.mexicodiveapp.logic.model;

public class Statistics {
    private Double result;
    private String information;

    public Statistics(Double result, String information) {
        this.result = result;
        this.information = information;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }


}
