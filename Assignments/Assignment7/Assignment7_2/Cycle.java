package Assignments.Assignment7.Assignment7_2;

public class Cycle {
    public void ride(Cycle cycle) {
        System.out.println("I am riding a " + cycle);
        System.out.println("The number of wheels it has is " + cycle.wheels());
    }
    public int wheels() {
        return 0;
    }
    public void balance(){
        System.out.println("Balance of base class Cycle");
    }
}
