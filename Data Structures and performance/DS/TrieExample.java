package DS;

import java.util.*;

class Trie{
    Trie alphabets[]=new Trie[26];
    int count;
    Trie() {
        this.count=0;
        for(int i=0;i<26;i++){
            this.alphabets[i]=null;
        }
    }
}

public class TrieExample {
    static void insert(Trie root, String words){
        //Trie t=root;
        for(int i=0;i<words.length();i++){
            int index = words.charAt(i)-'a';
            if(root.alphabets[index] == null) {
                root.alphabets[index] = new Trie();
            }
            root = root.alphabets[index];
            root.count++;
        }
        //root=t
    }
    static int getCount(Trie root,String q) {
        for(int i=0;i<q.length();i++){
            int index = q.charAt(i)-'a';
            if(root.alphabets[index]==null)
                return 0;
            root = root.alphabets[index];
        }
        return root.count;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of contacts you want to add: ");
        int n = sc.nextInt();
        sc.nextLine();
        Trie root=new Trie();
        System.out.println("Add "+n+" contacts using keyword add at the beginning");
        while(n-- > 0){
            String query = sc.next();
            String word = sc.next();
            if(query.equals("add")) {
                insert(root,word);
            }
        }
        System.out.println("Get contacts starting with: //Enter \"stop\" to exit");
        while(true) {
            String word = sc.next();
            if (word.equals("stop")) {
                break;
            }
            else {
                System.out.println(getCount(root, word));
            }
        }
    }
}
//contacts....search count of contacts starts with