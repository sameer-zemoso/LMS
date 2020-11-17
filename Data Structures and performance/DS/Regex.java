package DS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
//        String pattern = "^Q[^u]\\d+\\.";
//        String input = "QA777. is the next flight. It is on time.";
//
//        Pattern p = Pattern.compile(pattern);
//        Matcher matcher = p.matcher(input);
//
//        boolean found = matcher.lookingAt();
//
//        System.out.println("'" + pattern + "'" +
//                        (found ? " matches '" : " doesn't match '") + input + "'");


//        String pattern = ".*Q[^u]\\d+\\..*";
//        String line = "Order QT300. Now!";
//        if (line.matches(pattern)) {
//            System.out.println(line + " matches \"" + pattern + "\"");
//        } else {
//            System.out.println("NO MATCH");
//        }
        String patt = "\\bfavor\\b";

        // A test input.
        String input = "Do me a favor? Fetch my favorite.";
        System.out.println("Input: " + input);

        // Run it from a RE instance and see that it works
        Pattern r = Pattern.compile(patt);
        Matcher m = r.matcher(input);
        System.out.println("ReplaceAll: " + m.replaceAll("favour"));

        // Show the appendReplacement method
        m.reset();
        StringBuffer sb = new StringBuffer();
        System.out.print("Append methods: ");
        while (m.find()) {
            // Copy to before first match,
            // plus the word "favor"
            m.appendReplacement(sb, "favour");
        }
        m.appendTail(sb);        // copy remainder
        System.out.println(sb.toString());
    }
}
