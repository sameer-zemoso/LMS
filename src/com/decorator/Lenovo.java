package com.decorator;

public class Lenovo extends Laptop {
    public Lenovo() {
        description = "Lenovo";
    }
    @Override
    public int getCost() {
        return 200;
    }
}
