package com.zemoso;

import java.util.*;

public class TeamZeMoSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String FieldPosition = "";
        FieldPositions obj = new FieldPositions();

        TeamMember player6 = new Batsman("Kohli","ASE");
        player6.setPlayerRole();
        player6.setPlayerStyle("Right-handed", null);
        player6.setTeamName("ZeMoSo Blinders");
        player6.getPlayerDetails();

        System.out.println("");

        Batsman player1 = new Batsman("Virat","intern");
        player1.setPlayerRole();
        player1.setPlayerStyle("right handed", null);
        player1.setAverage(50.43);
        player1.setStrikeRate(151.65);
        player1.setTeamName("ZeMoSo Blinders");
        player1.isWicketKeeper(true);
        System.out.println("Set field position for "+player1.getName());
        FieldPosition = sc.nextLine();
        player1.setFieldPosition(FieldPosition);
        player1.getPlayerDetails();
        obj.getFieldPosition(player1);
        player1.getBatsmanDetails();


        Bowler player2 = new Bowler("Arshil","intern");
        player2.setPlayerRole();
        player2.setPlayerStyle("right handed", "left-arm medium fast");
        player2.setTeamName("ZeMoSo Blinders");
        player2.setEconomy(5.20);
        player2.isPacer();
        player2.getPlayerDetails();
        player2.getBowlerDetails();
        System.out.println();

        Spinner player3 = new Spinner("Fareed","ASE");
        player3.setPlayerRole();
        player3.setPlayerStyle("left handed", "right-arm Offbreak");
        player3.setEconomy(7.89);
        player3.setTeamName("ZeMoSo Blinders");
        player3.getPlayerDetails();
        player3.bowlsCarrom();
        player3.getBowlerDetails();

        AllRounder player4 = new AllRounder("Sameer","intern");
        player4.setPlayerRole();
        player4.setPlayerStyle("right-hand bat","right-arm fast");
        player4.setTeamName("ZeMoSo Blinders");
        player4.setAverage(45);
        player4.setStrikeRate(128.4);
        player4.setEconomy(5.72);
        System.out.println("Set field position for "+player4.getName());
        FieldPosition = sc.nextLine();
        player4.setFieldPosition(FieldPosition);
        obj.getFieldPosition(player4);
        player4.getPlayerDetails();
        player4.getAllRoundDetails();

        obj.getFieldPosition(player1);
        obj.getFieldPosition(player4);
    }
}
