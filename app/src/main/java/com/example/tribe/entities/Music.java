package com.example.tribe.entities;

public class Music {

    private int flagRes;
    private String executor;
    private String name;

    public Music(int flagRes, String executor, String name) {
        this.flagRes = flagRes;
        this.executor = executor;
        this.name = name;
    }

    public int getFlagRes() { return flagRes; }

    public void setFlagRes(int flagRes) { this.flagRes = flagRes; }

    public String getExecutor() { return executor; }

    public void setExecutor(String executor) { this.executor = executor; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
