package Assignments.Assignment6;

import java.util.Arrays;

public class VampireNumbers {
    static boolean isVampire(long x, long y) {
        vampire = x * y;
        if (vampire % 9 == (x + y) % 9) {
            String sVampire = Long.toString(vampire);
            String sX = Long.toString(x);
            String sY = Long.toString(y);

            if ((sX.endsWith("0") && sY.endsWith("0")) == false) {

                char[] charsVampire = sVampire.toCharArray();
                Arrays.sort(charsVampire);

                char[] factors = (sX + sY).toCharArray();
                Arrays.sort(factors);

                if (Arrays.equals(charsVampire, factors)) {
                    return true;
                }
            }
        }
        return false;
    }
    static long vampire;
    public static void main(String[] args) {
        int startX = 10, range = 1000;
        int c = 0;
        boolean flag = false;
        for (int x = startX; x < range; x++) {

            String sX = Integer.toString(x);
            int max = (int) Math.min(range, Math.pow(10, sX.length()));

            for (long y = x; y < max; y++) {
                if (isVampire(x,y)) {
                    c++;
                    System.out.println(c+ ". " + x + " * " + y + " = " + vampire);
                    if (c == 100) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("The above are first 100 vampire numbers");
                break;
            }
        }
    }
}