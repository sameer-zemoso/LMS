package Assignments.Assignment7.factorymethod_3;

public class Factory {
    public Cycle cycle(String cycle) {
        if (cycle.equals("UniCycle")) {
            return new UniCycle();
        }
        if (cycle.equals("BiCycle")) {
            return new BiCycle();
        }
        if (cycle.equals("TriCycle")) {
            return new TriCycle();
        }
        return null;
    }
    public static void main(String[] args) {
        Factory factory = new Factory();
        Cycle cycle = factory.cycle("UniCycle");
        cycle.printDescription();
    }
}
