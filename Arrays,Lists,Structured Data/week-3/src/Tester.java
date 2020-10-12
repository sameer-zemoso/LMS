import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        String filename = "weblog2-short_log";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(filename);
        logAnalyzer.printAll();
    }
    public void testUniqIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are "+uniqueIPs+" unique IPs");
    }
    public void testPrintAllHigherThanNum() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        la.printAllHigherThanNum(400);
    }
    public void testCountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        int count2 = la.countUniqueIPsInRange(200,299);
        System.out.println("Unique IPs with status code in range 200,299\n"+count2);
    }
    public void testCountVisitsPerIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        for (String key : counts.keySet()) {
            System.out.println(key+" has "+counts.get(key)+" visits.");
        }
    }

    public static void main(String[] args) {
        Tester t = new Tester();
        //t.testUniqIP();
        //t.testPrintAllHigherThanNum();
        //t.testCountVisitsPerIP();
        t.testCountUniqueIPsInRange();
    }
}