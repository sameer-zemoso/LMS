package com.decorator;

public class Ram extends ExtraFeatures {
    Laptop laptop;
    public Ram(Laptop laptop){
        this.laptop = laptop;
    }
    @Override
    public String getDescription() {
        return laptop.getDescription() + ", An extra ram has added";
    }
    @Override
    public int getCost() {
        return 50 + laptop.getCost();
    }
}