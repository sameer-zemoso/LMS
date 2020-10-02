package com.zemoso;

public class AllRounder extends TeamMember implements IBattingStatistics, IBowlingStatistics, IFieldPosition {
    private double Average,Rate, economy;
    private String Role;
    private String Position;

    public AllRounder(String Name, String Designation) {
        super(Name, Designation);
    }

    public void setPlayerRole() {
        this.Role = "All-Rounder";
    }

    @Override
    public void setAverage(double average) {
        this.Average = average;
    }

    @Override
    public void setStrikeRate(double rate) {
        this.Rate = rate;
    }

    @Override
    public void setEconomy(double economy) {
        this.economy = economy;
    }

    @Override
    public void setFieldPosition(String position) {
        this.Position = position;
    }

    @Override
    public String getFieldPosition() {
        return this.Position;
    }
    public void getAllRoundDetails() {
        System.out.println("Player Role: "+Role);
        System.out.println("Average: "+Average);
        System.out.println("StrikeRate: "+Rate);
        System.out.println("Economy: "+economy+"\n");
    }
}
