package Assignments;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment1 {
    public static void displayFiles(File[] files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
    public void search(String path, String regex) {
        File directory = new File(path);
        if (directory.listFiles() == null) {
            return;
        }
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                search(file.getAbsolutePath(),regex);
            }
            else {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(file.getName());
                if(matcher.find()) {
                    System.out.println("Matched fileName: "+file.getName());
                    System.out.println("path: "+file.getAbsolutePath());
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File directory = new File("/home");

        File[] files = directory.listFiles();
        System.out.println("All files and directories:");
        displayFiles(files);
        while (true) {
            System.out.println("Enter a regex: //enter \"stop\" to exit");
            String regex = sc.next();
            if (regex.equals("stop")) {
                break;
            }
            Assignment1 obj = new Assignment1();
            obj.search("/home",regex);
        }
    }
}
