import edu.duke.*;
import java.util.Arrays;

public class WordLengths {

    void countWordLengths(FileResource resource, int[] counts) {
        for(String word : resource.words()) {
            if(!Character.isLetter(word.charAt(0))) {
                word = word.substring(1, word.length());
            }
            if( word.length()!=0 && !Character.isLetter(word.charAt(word.length() - 1))) {
                word = word.substring(0, word.length() - 1);
            }
            int length = word.length();
            counts[length] += 1;
        }
        System.out.println(Arrays.toString(counts));
        System.out.println("index of largest element: " + indexOfMax(counts));
    }

    int indexOfMax(int[] values) {
        int index = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] > values[index]) {
                index = i;
            }
        }
        return index;
    }

    int countWords(FileResource fr) {
        int longest = 0;
        for(String word : fr.words()) {
            if(word.length() > longest) {
                longest = word.length();
            }
        }
        return longest + 1;
    }

    void testCountWordLengths() {
        //String[] sample = {"romeo.txt"};
        //String[] sample = {"errors.txt"};
//        String[] sample = new String[3];
//        for(int i = 0; i < sample.length; i++) {
            FileResource fr = new FileResource();
            String words = fr.asString();
            System.out.println(countWords(fr));
            int[] counts = new int[countWords(fr)];
            //System.out.println("done with " + sample[i]);
            //System.out.println(counts.length);
            countWordLengths(fr, counts);
        //}
    }

    public static void main(String[] args) {
        WordLengths obj = new WordLengths();
        obj.testCountWordLengths();
    }
}