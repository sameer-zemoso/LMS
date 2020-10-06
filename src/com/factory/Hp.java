package com.factory;

public class Hp implements  Laptop{
    @Override
    public void getDescription() {
        System.out.println("This is Hp Laptop");
    }
}
