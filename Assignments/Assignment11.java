package Assignments;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Assignment11 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("myFile.txt");
        BufferedReader br = new BufferedReader(fr);
        String text = br.readLine();
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            ch = Character.toLowerCase(ch);
                if (!hm.containsKey(ch)) {
                    hm.put(ch,1);
                }
                else {
                    int value = hm.get(ch);
                    hm.put(ch,value+1);
                }
        }
        FileWriter fileWriter = new FileWriter("output.txt");
        String str = "";
        for (Map.Entry entry : hm.entrySet()) {
            String string = entry.getKey().toString() + " : " + entry.getValue().toString();
            str = str + string + "\n";
            //System.out.println(str);
        }
        fileWriter.write(str);
        fileWriter.close();
        br.close();
    }
}
