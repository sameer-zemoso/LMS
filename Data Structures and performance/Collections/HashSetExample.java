package Collections;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Books> hashSet = new HashSet<Books>();
        ArrayList<Books> ar = new ArrayList<Books>();
        Books b1=new Books(101,"Gang of Four","4-authors","BPB",8);
        Books b2=new Books(102,"Clean Code","Bob Martin","Mc Graw Hill",4);
        Books b3=new Books(103,"Organic Chemistry","O.P.Tendon","GRB",1);

        hashSet.add(b1);
        hashSet.add(b2);
        hashSet.add(b3);

        for(Books b: hashSet){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}
