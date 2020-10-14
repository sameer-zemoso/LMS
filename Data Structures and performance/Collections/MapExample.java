package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
//    public static void main(String[] args) {
//        HashMap<Integer,Books> hashMap = new HashMap<Integer, Books>();
//
//        Books b1=new Books(101,"Gang of Four","4-authors","BPB",8);
//        Books b2=new Books(103,"Clean Code","Bob Martin","Mc Graw Hill",4);
//        Books b3=new Books(102,"Organic Chemistry","O.P.Tendon","GRB",1);
//
//        hashMap.put(1,b1);
//        hashMap.put(2,b2);
//        hashMap.put(3,b3);
//
//        for(Map.Entry<Integer, Books> entry : hashMap.entrySet()){
//            int key=entry.getKey();
//            Books b=entry.getValue();
//            System.out.println(key+" Details:");
//            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
//        }
//    }
        public static void main(String[] args) {
            testMaps(new HashMap<String,Integer>());
            testMaps(new TreeMap<String,Integer>());
            testMaps(new LinkedHashMap<String,Integer>());
        }

        static void testMaps(Map<String,Integer> map) {
            System.out.println(map.getClass().getName());

            map.put("Zero",  0);
            map.put("One",   1);
            map.put("Two",   2);
            map.put("Three", 3);
            map.put("Four",  4);

            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }
}
