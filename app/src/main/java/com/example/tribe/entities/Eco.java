package com.example.tribe.entities;

import java.util.Date;

public class Eco {

    private String name;
    private String describe;
    private int flagRes;
    private String problem;
    private String solution;
    private String recommendation;

    public Eco(String name, String describe, int flagRes, String problem, String solution, String recommendation) {
        this.name = name;
        this.describe = describe;
        this.flagRes = flagRes;
        this.problem = problem;
        this.solution = solution;
        this.recommendation = recommendation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getFlagRes() {
        return flagRes;
    }

    public void setFlagRes(int flagRes) {
        this.flagRes = flagRes;
    }

    public String getProblem() { return problem; }

    public void setProblem(String problem) { this.problem = problem; }

    public String getSolution() { return solution; }

    public void setSolution(String solution) { this.solution = solution; }

    public String getRecommendation() { return recommendation; }

    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }
}
