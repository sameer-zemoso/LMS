public class Part3 {
    public boolean twoOccurences(String stringa, String stringb){
        int subStringIndex = stringb.indexOf(stringa);
        int count = 0;
        while(subStringIndex >= 0) {
            count++;
            subStringIndex = stringb.indexOf(stringa, subStringIndex + 1);
        }
        if (count >= 2) {
            return true;
        }
        return false;
    }

    public String lastPart(String stringa, String stringb){
        int subStringIndex = stringb.indexOf(stringa);
        String lastPartString = stringb;
        if(subStringIndex >= 0){
            lastPartString = stringb.substring(subStringIndex + stringa.length());
        }
        return lastPartString;
    }

    public void testTwoOccurences(){
        String stringa = "by";
        String stringb = "A story by Abby Long";
        boolean hasTwoOccurences = twoOccurences(stringa, stringb);
        System.out.println(hasTwoOccurences);

        stringa = "ba";
        stringb = "Breaking Bad";
        hasTwoOccurences = twoOccurences(stringa, stringb);
        System.out.println(hasTwoOccurences);

        stringa = "or";
        stringb = "A short story by Abby Long";
        hasTwoOccurences = twoOccurences(stringa, stringb);
        System.out.println(hasTwoOccurences);
    }

    public void testLastPart() {
        String stringa = "an";
        String stringb = "banana";
        System.out.println("Initial full string: " + stringb);
        System.out.println("stringa is: " + stringa);
        String lastPartString = lastPart(stringa, stringb);
        System.out.println("lastPart String: " + lastPartString);

        stringa = "hello";
        stringb = "world";
        System.out.println("Initial full string: " + stringb);
        System.out.println("stringa is: " + stringa);
        lastPartString = lastPart(stringa, stringb);
        System.out.println("lastPart String: " + lastPartString);

        stringa = "an";
        stringb = "Anabella";
        System.out.println("Initial full string: " + stringb);
        System.out.println("stringa is: " + stringa);
        lastPartString = lastPart(stringa, stringb);
        System.out.println("lastPart String: " + lastPartString);
    }

    public static void main(String[] args) {
        Part3 obj = new Part3();
        obj.testTwoOccurences();
        obj.testLastPart();
    }
}
