package com.decorator;

abstract class Laptop {
    String description = "Unknown";
    public String getDescription() {
        return description;
    }
    public abstract int getCost();
}
