package com.zemoso;

public class TeamMember extends Team implements IPlayer {
    private String TeamName,Name, Designation;
    private String BattingStyle;
    private String BowlingStyle;

    public TeamMember(String Name, String Designation) {
        this.Name = Name;
        this.Designation = Designation;
    }

    @Override
    public void setTeamName(String Name) {
        this.TeamName = Name;
    }

    @Override
    public void setPlayerStyle(String BattingStyle, String BowlingStyle) {
        this.BattingStyle = BattingStyle;
        this.BowlingStyle = BowlingStyle;
    }

    @Override
    public void setPlayerRole() {
        System.out.println("Player Role: Team Member");
    }

    public void isWicketKeeper(boolean choice) {
        System.out.println("is WicketKeeper: "+choice);
    }

    public String getName() {
        return Name;
    }

    @Override
    public void getPlayerDetails() {
        System.out.println("Team Name: "+TeamName);
        System.out.println("PlayerName: "+Name);
        System.out.println("Designation: "+Designation);
        System.out.println("Batting Style: "+BattingStyle);
        System.out.println("Bowling Style: "+BowlingStyle);
    }
}
