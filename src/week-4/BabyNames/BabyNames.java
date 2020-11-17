import edu.duke.*;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyNames {
    public void totalBirths(FileResource fr) {
        int girlsCount = 0;
        int boysCount = 0;
        int total = 0;
        for(CSVRecord record : fr.getCSVParser(false)) {
            String gender = record.get(1);
            int births = Integer.parseInt(record.get(2));
            if(gender.equals("F")) {
                girlsCount ++;
            }
            else {
                boysCount ++;
            }
            total++;
        }
        System.out.println("Total Girls: "+girlsCount);
        System.out.println("Total Boys: "+boysCount);
        System.out.println("Overall total Births: "+total);
    }
    public int getRank(int year, String name, String gender) {
        String filename = "yob" + year +".csv";
        FileResource fr = new FileResource("src/data/"+filename);
        int rank = 0;
        for(CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(1).equals(gender)) {
                rank++;
                if(record.get(0).equals(name)){
                    return rank;
                }
            }
        }
        return -1;
    }
    public String getName(int year, int rank, String gender) {
        String filename = "yob" + year +".csv";
        FileResource fr = new FileResource("src/data/"+filename);
        String name = "NO NAME";
        int currentRank = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                currentRank++;
                if(currentRank == rank) {
                    name = record.get(0);
                }
            }
        }
        return name;
    }
    public String whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year,name,gender);
        String nameInNewYear = getName(newYear,rank,gender);
        return nameInNewYear;
    }
    public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        //FileResource fr = new FileResource();
        int highestRank = 0;
        int year = -1;
        int tempYear = 0;
        //int currRank = 0;
        for (File f : dr.selectedFiles()) {
            String filename = f.getName();
            System.out.println("File Name: "+filename);
            String getYear = filename.substring(filename.indexOf("yob") + 3, filename.indexOf(".csv"));
            tempYear = Integer.parseInt(getYear);
            int currentRank = getRank(tempYear, name, gender);
            if((currentRank != -1) && (highestRank == 0 || currentRank < highestRank)) {
                highestRank = currentRank;
                year = tempYear;
            }
        }
        return year;
    }
    public double getAverageRank(String name, String gender) {
        double average = 0.0;
        double sum = 0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            String filename = f.getName();
            String getYear = filename.substring(filename.indexOf("yob") + 3, filename.indexOf(".csv"));
            int year = Integer.parseInt(getYear);
            int rank = getRank(year, name, gender);
            sum = sum + rank;
            count++;
        }
        average = sum/count;
        return average;
    }
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        String filename = "data/yob" + year + ".csv";
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser(false);
        int totalBirths = 0;
        int count = 0;
        int boysCount = 0;
        int rank = getRank(year, name, gender);
        for (CSVRecord record : parser) {
            int numBorn = Integer.parseInt(record.get(2));
            if (record.get(1).equals("M") && gender.equals("M")) {
                boysCount++;
                if (boysCount < rank) {
                    totalBirths += numBorn;
                }
            } else if (record.get(1).equals("F") && gender.equals("F")) {
                count++;
                if (count < rank) {
                    totalBirths += numBorn;
                }
            }
        }
        return totalBirths;
    }
    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    public void testgetRank() {
        System.out.println(getRank(2010, "Jacob", "M"));
    }
    public void testgetName() {
        System.out.println(getName(2010, 100, "M"));
    }
    public void testWhatIsNameInYear() {
        whatIsNameInYear("Noah", 1888, 2012, "M");
    }
    public void testYearOfHighestRank() { System.out.println(yearOfHighestRank("Jennifer", "F")); }
    public void testGetAverageRank() {
        System.out.println(getAverageRank("Jacob", "M"));
    }
    public void testGetTotalBirthsRankedHigher() {
        System.out.println(getTotalBirthsRankedHigher(1990, "Emily", "F"));
    }

    public static void main(String[] args) {
        BabyNames obj = new BabyNames();
        //obj.testTotalBirths();
        //obj.testgetRank();
        //obj.testgetName();
        //obj.testWhatIsNameInYear();
        //obj.testGetTotalBirthsRankedHigher();
        //obj.testYearOfHighestRank(); //select from 1990
        //obj.testGetAverageRank();
    }
}
