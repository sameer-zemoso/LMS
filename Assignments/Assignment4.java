package Assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment4 {

    final static String format = "dd-MM-yyyy";

    public void formDate(String signUpDate, String today) {
        String anniversaryDate = signUpDate.substring(0, 6) + today.substring(6);
        System.out.println("Anniversary date: "+anniversaryDate);

        LocalDate newAD = LocalDate.parse(anniversaryDate, DateTimeFormatter.ofPattern(format));
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern(format));

        String startDate = newAD.minusDays(30).format(DateTimeFormatter.ofPattern(format));
        String endDate = newAD.plusDays(30).format(DateTimeFormatter.ofPattern(format));

        String signUpYear = signUpDate.substring(6, 10);
        String currYear = today.substring(6, 10);

        if (Integer.parseInt(signUpYear) >= Integer.parseInt(currYear)) {
            System.out.println("No range");
        }
        else {
            System.out.print(startDate);
            System.out.print(" ");
            if (todayDate.compareTo(newAD.plusDays(30)) >= 0) {
                System.out.println(endDate);
            }
            else {
                System.out.println(today);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Assignment4 obj = new Assignment4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            System.out.print("\n");
            String[] strings = string.split(" ");
            obj.formDate(strings[0], strings[1]);
        }
    }
}