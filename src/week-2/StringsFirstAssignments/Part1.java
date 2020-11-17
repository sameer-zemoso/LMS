import edu.duke.*;

public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1) {
            return "";
        }
        if ((stopIndex-(startIndex+3)) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex+3);
        }
        return result;
    }
    public void testSimpleGene() {

        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA is  " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

        dna = "AATAGCTAGGGTAATATGGT";
        System.out.println("DNA is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

        dna = "AATGCTAGGGTAGATATGGT";
        System.out.println("DNA is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

        dna = "AACTGCTAGGGTACATATGGT";
        System.out.println("DNA is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }

    public static void main(String[] args) {
        Part1 obj = new Part1();
        obj.testSimpleGene();
    }
}
