public class Part2 {

    public int howMany(String stringa, String stringb) {
        int count = 0;
        int index = stringb.indexOf(stringa);
        while(index >= 0) {
            index = stringb.indexOf(stringa, index + stringa.length());
            count++;
        }
        return count;
    }

    public void testHowMany() {
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
    }

    public static void main(String[] args) {
        Part2 obj = new Part2();
        obj.testHowMany();
    }
}