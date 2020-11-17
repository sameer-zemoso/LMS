import java.util.*;
import java.lang.*;

public class WordPlay {
    public boolean isVowel(char ch) {
        String vowels = "aeiouAEIOU";
        for(int i = 0; i < vowels.length(); i++) {
            if(vowels.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i = 0; i < newPhrase.length(); i++) {
            if(isVowel(newPhrase.charAt(i))) {
                newPhrase.setCharAt(i, ch);
            }
        }
        return newPhrase.toString();
    }

    public String emphasize(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i = 0; i < newPhrase.length(); i++) {
            char currChar = newPhrase.charAt(i);
            if(i%2 != 0 && Character.toLowerCase(currChar) == Character.toLowerCase(ch)) {
                newPhrase.setCharAt(i, '+');
            } else if(i%2 == 0 && Character.toLowerCase(currChar) == Character.toLowerCase(ch)) {
                newPhrase.setCharAt(i, '*');
            }
        }
        return newPhrase.toString();
    }

    public void testIsVowel() {
        System.out.println(isVowel('a'));
        System.out.println(isVowel('F'));
    }

    public void testReplaceVowels() {
        System.out.println(replaceVowels("Hello World", '*'));
    }

    public void testEmphasize() {
        System.out.println(emphasize("dna ctgaaactga", 'a')); //dn* ctg+*+ctg+
        System.out.println(emphasize("Mary Bella Abracadabra", 'a')); //M+ry Bell+ +br*c*d*br+
        System.out.println(emphasize("AbraCAdaBRaSisBumbA", 'A')); //*br+C+d+BR*SisBumb*
    }

    public static void main(String[] args) {
        WordPlay p = new WordPlay();
        p.testEmphasize();
    }
}
