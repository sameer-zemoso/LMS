package com.factory;

public class LaptopService {
    public static void main(String[] args) {

        LaptopFactory factoryobject = new LaptopFactory();
        Laptop laptop = factoryobject.getBrand("Dell");
        laptop.getDescription();
    }
}
