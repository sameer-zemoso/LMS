package Assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("ping");
        arrayList.add("-c");
        arrayList.add("1");
        while(true) {
            System.out.println("Enter only ip address: //enter \"stop\" to exit");
            String inputIP = sc.next();
            if (inputIP.equals("stop")) {
                break;
            }
            arrayList.add(inputIP);
            ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
            Process process = processBuilder.start();

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader Error = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String s = null;
            while ((s = input.readLine()) != null) {
                s = input.readLine();
                System.out.println(s);
                int time = s.indexOf("time=");
                if (s.contains("time")) {
                    System.out.println("time taken to ping: " + s.substring(time + 5, s.length()));
                }
            }
            while ((s = Error.readLine()) != null) {
                System.out.println("error: "+s);
            }
        }
    }
}
