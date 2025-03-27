
/**
 * Write a description of Tester here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/17
 */
import java.util.*;
import edu.duke.*;

public class Tester {
	public void testLogEntry() {
		LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
		System.out.println(le);
		LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
		System.out.println(le2);
	}

	public void testLogAnalyzer() {
		// complete method
		LogAnalyzer la = new LogAnalyzer();
		String file = "weblog2_log";
		la.readFile(file);
		//la.printAll();
		int uniqueIPs = la.countUniqueIPs();
		System.out.println("Total Unique Ips : "+uniqueIPs);

		la.printAllHigherThanNum(302);

		System.out.println("uniqueIPVisitsOnDay ");
		ArrayList<String> arr = la.uniqueIPVisitsOnDay("Mar 17");
		System.out.println(arr);

		System.out.println("weblog2_log");
		int count = la.countUniqueIPsInRange(200,299);
		System.out.println("Total Unique Ips in Range 200 : "+count);

	}
}
