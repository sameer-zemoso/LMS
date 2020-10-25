package Assignments;

import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count[] = new int[26];
        int counter = 0;
        boolean flag = false;
        //String str = sc.nextLine();
        String str = "The quick brown fox jumps over the lazy dog";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z' && count[ch - 'a'] == 0) {
                count[ch - 'a']++;
                counter++;
            }
            else if(ch >= 'A' && ch <= 'Z' && count[ch - 'A'] == 0 ) {
                count[ch - 'A']++;
                counter++;
            }
            if (counter == 26) {
                flag = true;
                System.out.println("All alphabets are present");
                break;
            }
        }
        if (!flag) {
            System.out.println("All alphabets are not present");
        }
    }
}
