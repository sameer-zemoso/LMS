package com.zemoso;

public class Spinner extends Bowler {

    public Spinner(String Name, String Designation) {
        super(Name, Designation);
    }

    public void bowlsGoogly() {
        System.out.println("This player can spin Googly");
    }

    public void bowlsCarrom() {
        System.out.println("This player can bowl Carrom ball");
    }
}
