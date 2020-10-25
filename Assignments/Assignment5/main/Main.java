package Assignments.Assignment5.main;

import Assignments.Assignment5.Data;
import Assignments.Assignment5.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        data.print();

        Singleton obj = Singleton.function("Hello World!");
        obj.print();
        //obj.print() method will print null
        //because the non-static members i.e string
        //cannot be referenced in static method "function().
        //So the initialization was not done
        //in function() method of Singleton class

    }
}
