package Assignments.singleton;

public class Singleton {
    String str;
    public static Singleton function(String string) {
        //str = string;
        return new Singleton();
    }
    public void print() {
        System.out.println(str);
    }
}
