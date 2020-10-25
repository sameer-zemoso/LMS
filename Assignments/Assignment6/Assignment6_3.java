package Assignments.Assignment6;

class data {
    data(String args) {
        System.out.println(args);
    }
}
public class Assignment6_3 {
    public static void main(String[] args) {
        data ar[] = new data[3];
        ar[0] = new data("hi");
        ar[1] = new data("hello");
        ar[2] = new data("how are you?");
    }
}
