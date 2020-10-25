package Assignments.Assignment6;

public class Assignment6_2 {
    Assignment6_2() {
        new Assignment6_2("hello");
    }

    Assignment6_2(String str) {
        System.out.println("Moved to Parameterized Constructor: " + str);
    }

    public static void main(String[] args) {
        Assignment6_2 obj = new Assignment6_2();
    }
}
