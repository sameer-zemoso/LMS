package Assignments.Assignment7.Assignment7_2;

public class Bicycle extends Cycle {
    public String toString() {
        return "Bicycle";
    }

    public int wheels() {
        return 2;
    }

    public void balance() {
        System.out.println("Balancing on " + this);
    }
}
