import java.util.*;
import edu.duke.*;
//import org.apache.*;

public class LogAnalyzer
{
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for(String line : fr.lines()) {
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }
    }

    public int countUniqueIPs() {
        HashMap<String, Integer> uniqueIPs = countVisitsPerIP();
        return uniqueIPs.size();
    }
    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for(LogEntry le : records) {
            String ipAddress = le.getIpAddress();
            if(!counts.containsKey(ipAddress)) {
                counts.put(ipAddress, 1);
            } else {
                counts.put(ipAddress, counts.get(ipAddress) + 1);
            }
        }
        return counts;
    }
    public int countUniqueIPsInRange(int low, int high) {
        int count = 0;
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry le : records) {
            int code = le.getStatusCode();
            String ipAddr = le.getIpAddress();
            if((code >= low && code <= high) && !uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
    public void printAllHigherThanNum(int num) {
        for(LogEntry le : records) {
            int code = le.getStatusCode();
            if(code > num) {
                System.out.println(le);
            }
        }
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> IPs) {
        int mostVisit = 0;
        for(String key : IPs.keySet()) {
            int count = IPs.get(key);
            if(count > mostVisit) {
                mostVisit = count;
            }
        }
        return mostVisit;
    }
}