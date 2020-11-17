import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class Temperature {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        //FileResource fr = new FileResource("nc_weather/2014");
        CSVRecord coldestRecord = null;
        for(CSVRecord record : parser) {
            if(coldestRecord == null) {
                coldestRecord = record;
            }
            else {
                double currentTemperature = Double.parseDouble(record.get("TemperatureF"));
                double coldestTemperature = Double.parseDouble(coldestRecord.get("TemperatureF"));
                if(currentTemperature < coldestTemperature) {
                    if (currentTemperature != -9999) {
                        coldestRecord = record;
                    }
                }
            }
        }
        return coldestRecord;
    }
    public String fileWithColdestTemperature() {
        String filename = null;
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestRecord= null;
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = coldestHourInFile(fr.getCSVParser());
            if(coldestRecord == null) {
                coldestRecord = currentRecord;
                filename = f.getName();
            }
            else {
                double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestRecord.get("TemperatureF"));
                if(currentTemp < coldestTemp) {
                    coldestRecord = currentRecord;
                    filename = f.getName();
                }
            }
        }
        return filename;
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidrecord = null;
        for(CSVRecord record : parser) {
            if(lowestHumidrecord == null) {
                lowestHumidrecord = record;
            }
            else {
                double currentHumidity = Double.parseDouble(record.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestHumidrecord.get("Humidity"));
                if( currentHumidity < lowestHumidity) {
                    //lowestHumidity = currentHumidity;
                    lowestHumidrecord = record;
                }
            }
        }
        return lowestHumidrecord;
    }
    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidityRecord = null;
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = lowestHumidityInFile(fr.getCSVParser());
            if(lowestHumidityRecord == null) {
                lowestHumidityRecord = currentRecord;
            } else {
                double currentHum = Double.parseDouble(currentRecord.get("Humidity"));
                double lowestHum = Double.parseDouble(lowestHumidityRecord.get("Humidity"));
                if(currentHum < lowestHum) {
                    lowestHumidityRecord = currentRecord;
                }
            }
        }
        return lowestHumidityRecord;
    }
    public double averageTemperatureInFile(CSVParser parser) {
        //CSVRecord csvRecord = null;
        double sum=0;
        int count=0;
        for(CSVRecord record : parser) {
            if(record == null) {
                return 0.0;
            }
            else {
                double currentTemp = Double.parseDouble(record.get("TemperatureF"));
                sum = sum + currentTemp;
                count++;
            }
        }
        double average = sum/count;
        return average;
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double sum = 0.0;
        int count = 0;
        for (CSVRecord record : parser) {
            double humidity = Double.parseDouble(record.get("Humidity"));
            if(humidity > (double)value) {
                double currentTemp = Double.parseDouble(record.get("TemperatureF"));
                sum = sum + currentTemp;
                count++;
            }
        }
        double average = sum/count;
        return average;
    }
    public void testColdestHourInFile() {
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-01-01.csv");
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestRecord = coldestHourInFile(parser);
        System.out.println("Coldest Hour: "+coldestRecord.get("TemperatureF")+", Time: "+coldestRecord.get("TimeEST"));
    }
    public void testfileWithColdestTemperature() {
        String coldFileName = fileWithColdestTemperature();
        System.out.println("File with coldest temperature: "+coldFileName);
    }
    public void testlowestHumidityinFile() {
        //FileResource fr = new FileResource("nc_weather/2014/weather-2014-01-01.csv");
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidRecord = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity: "+lowestHumidRecord.get("Humidity"));
    }
    public void testlowestHumidityInManyFiles() {
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity of all files: "+lowest.get("Humidity"));
    }
    public void testaverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemperature = averageTemperatureInFile(parser);
        System.out.println("Average Temperature: "+averageTemperature);
    }
    public void testaverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser,35);
        System.out.println("Average Temperature With High-Humidity: "+average);
    }
    public static void main(String[] args) {
        Temperature temperature = new Temperature();
        //temperature.testColdestHourInFile();
        //temperature.testfileWithColdestTemperature();
        //temperature.testlowestHumidityinFile();
        //temperature.testlowestHumidityInManyFiles();
        //temperature.testaverageTemperatureInFile();
        temperature.testaverageTemperatureWithHighHumidityInFile();
    }
}

