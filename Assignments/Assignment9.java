package Assignments;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment9 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String regex = "^[A-Z].*\\.$";
        System.out.println("Enter a sentence");
        String sentence = sc.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        if(matcher.matches()) {
            System.out.println("Matched");
        }
    }
}
