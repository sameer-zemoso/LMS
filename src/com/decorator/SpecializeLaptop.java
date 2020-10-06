package com.decorator;

public class SpecializeLaptop {
    public static void main(String[] args) {
        Laptop type1 = new Dell();
        System.out.println("Name: "+type1.getDescription()+" Cost: "+type1.getCost());

        type1 = new Ram(type1);
        System.out.println("Description: "+type1.getDescription()+" Total Cost: "+type1.getCost());

        type1 = new GraphicCard(type1);
        System.out.println("Description: "+type1.getDescription()+" Total Cost: "+type1.getCost());
    }
}
