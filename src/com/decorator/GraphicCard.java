package com.decorator;

public class GraphicCard extends ExtraFeatures {
    Laptop laptop;
    public GraphicCard(Laptop laptop) {
        this.laptop = laptop;
    }
    @Override
    public String getDescription() {
        return laptop.getDescription() + ", An extra Graphic card has Added";
    }
    @Override
    public int getCost() {
        return 25 + laptop.getCost();
    }
}
