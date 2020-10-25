package Assignments.Assignment7.Assignment7_2;

public class CycleExample {
    public static void main(String[] args) {
//        Cycle cycle = new Cycle();
//        UniCycle uniCycle = new UniCycle();
//        Tricycle tricycle = new Tricycle();
//        Bicycle bicycle = new Bicycle();
//
//        cycle.ride(uniCycle);
//        cycle.ride(tricycle);
//        cycle.ride(bicycle);
//
//        uniCycle.balance();

        Cycle ar[] = new Cycle[3];
        ar[0] =  new UniCycle();
        ar[1] = new Bicycle();
        ar[2] = new Tricycle();

        ar[0].balance();
        ar[1].balance();
        ar[2].balance();
    }
}
