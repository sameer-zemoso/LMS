package Assignments;

public class Assignment8 {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
//
//            String string = "hello";
//            char ch = string.charAt(10);
//
//            int n = 5/0;
//
//            int num = Integer.parseInt("Hello");

        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("This is finally block");
        }
    }
}
