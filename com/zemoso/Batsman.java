package com.zemoso;

public class Batsman extends TeamMember implements IBattingStatistics,IFieldPosition {
    private double Average,Rate;
    private String Role;
    private String Position;
    public Batsman(String Name, String Designation) {
        super(Name,Designation);
    }
    public void setPlayerRole() {
        this.Role = "Batsman";
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
    public void setFieldPosition(String position) {
        this.Position = position;
    }
    @Override
    public String getFieldPosition() {
        return this.Position;
    }
    public void getBatsmanDetails() {
        System.out.println("Player Role: "+Role);
        System.out.println("Average: "+Average);
        System.out.println("StrikeRate: "+Rate+"\n");
    }
}
