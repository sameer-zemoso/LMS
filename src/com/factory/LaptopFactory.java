package com.factory;

public class LaptopFactory {
    public Laptop getBrand(String brand) {
        if(brand.equals("Dell")) {
            return  new Dell();
        }
        else if(brand.equals("Lenovo")) {
            return  new Lenovo();
        }
        else if(brand.equals("Hp")) {
            return  new Hp();
        }
        else if(brand == null || brand.isEmpty()) {
            return null;
        }
        return  null;
    }
}
