package com.example.termproject;

import java.io.Serializable;

public class Riskclass implements Serializable {
    private String gender;
    private int riskassessment;
    public Riskclass(String gender, int riskassessment) {
        this.gender = gender;
        this.riskassessment = riskassessment;

    }

    public int getRiskassessment() {
        return this.riskassessment;
    }

    public String getGender() {
        return this.gender;
    }

}
