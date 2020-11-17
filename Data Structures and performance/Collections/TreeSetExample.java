package Collections;

import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        TreeSet<Books> treeSet = new TreeSet<Books>();

        Books b1=new Books(101,"Gang of Four","4-authors","BPB",8);
        Books b2=new Books(102,"Clean Code","Bob Martin","Mc Graw Hill",4);
        Books b3=new Books(103,"Organic Chemistry","O.P.Tendon","GRB",1);

        treeSet.add(b1);
        treeSet.add(b2);
        treeSet.add(b3);

        for(Books b: treeSet){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }

}
