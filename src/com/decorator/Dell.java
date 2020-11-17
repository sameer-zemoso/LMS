package com.decorator;

public class Dell extends Laptop {
    public Dell() {
        description = "Dell";
    }
    @Override
    public int getCost() {
        return 100;
    }
}
