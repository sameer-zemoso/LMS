package com.zemoso;

public class Pacer implements  IPaceAbility {

    @Override
    public void canYorker() {
        System.out.println("This bowler can bowl Yorker");
    }

    @Override
    public void canBounce() {
        System.out.println("This bowler can bowl tough Bouncers");
    }
}
