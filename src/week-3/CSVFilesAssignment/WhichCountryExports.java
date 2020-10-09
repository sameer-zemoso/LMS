import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountryExports {

    public void tester() {
        FileResource fr = new FileResource("exports/exports_small.csv");
        CSVParser parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "cocoa"));
        //System.out.println(countryInfo(parser,"United States"));
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"gold"));

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","zinc");
    }

    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record : parser) {
            String countries = record.get("Country");
            if(countries.contains(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                return country + ": " + exports + ": " + value;
            }
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record : parser) {
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for(CSVRecord record : parser) {
            String export = record.get("Exports");
            if(export.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if(value.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + value);
            }
        }
    }

    public static void main(String[] args) {
        WhichCountryExports obj = new WhichCountryExports();
        obj.tester();
    }
}