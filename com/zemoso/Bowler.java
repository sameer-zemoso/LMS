package com.zemoso;

public class Bowler extends TeamMember implements IBowlingStatistics,IFieldPosition {
    private double economy;
    private String Role,Position;
    public Bowler(String Name, String Designation) {
        super(Name,Designation);
    }
    public void setPlayerRole() {
        this.Role = "Bowler";
    }
    public void setEconomy(double economy) {
        this.economy = economy;
    }
    @Override
    public void setFieldPosition(String position) {
        this.Position = position;
    }
    public void isPacer() {
        IPaceAbility ability = new Pacer();
        ability.canBounce();
        ability.canYorker();
    }
    public void getBowlerDetails() {
        System.out.println("Player Role: "+Role);
        System.out.println("Economy: "+economy+"\n");
    }
    @Override
    public String getFieldPosition() {
        return this.Position;
    }
}
