
/**
 * Write a description of CountTester here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/17
 */
import java.util.*;
import edu.duke.*;

public class CountTester {

	public void testCounts(){
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog2_log");
		HashMap<String,Integer> counts = la.countVisiterPerIp();
		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			System.out.println("IP = " + entry.getKey() + ", Count = " + entry.getValue());
		}
		//System.out.println(counts);
	}

	public  void testMostNumberVisitsByIP(){
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog2_log");
		//la.printAll();
		int count = la.mostNumberVisitsByIP(la.countVisiterPerIp());
		System.out.println("Count = " + count);
		HashMap<String , Integer> ipMostVisited = new HashMap<String , Integer>();
		ipMostVisited = la.iPsMostVisits(la.countVisiterPerIp());
		for (Map.Entry<String, Integer> entry : ipMostVisited.entrySet()) {
			System.out.println("IP = " + entry.getKey() + ", Count = " + entry.getValue());
		}
	}

	public void testipPsForDays(){
		LogAnalyzer la = new LogAnalyzer();
		HashMap<String, ArrayList<String>> ipList = new HashMap<String, ArrayList<String>>();
		ipList = la.iPsForDays();
		
		for(String key : ipList.keySet()){
			ArrayList<String> ls = ipList.get(key);
			System.out.println(key + "; " + ls);
		}

		String dayWithMostVsits = la.dayWithMostIPVisits(ipList);
		System.out.println("Max. Visit = "+dayWithMostVsits);

		HashMap<String, Integer> ipMostVisitDate = new HashMap<String, Integer>();
		ipMostVisitDate = la.iPsWithMostVisitsOnDay(ipList,"Sep 30");
		System.out.println(ipMostVisitDate);
	}
}