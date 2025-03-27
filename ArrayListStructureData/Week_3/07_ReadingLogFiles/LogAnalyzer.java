
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/17
 */
import java.text.SimpleDateFormat;
import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
	private ArrayList<LogEntry> records;

	public LogAnalyzer() {
		// complete constructor
		records = new ArrayList<LogEntry>();
	}

	public void readFile(String filename) {
		// complete method
		FileResource fr = new FileResource(filename);
		for (String line : fr.lines()) {
			// System.out.println(line);
			LogEntry log = WebLogParser.parseEntry(line);
			records.add(log);
		}
	}

	public int countUniqueIPs() {
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for (LogEntry le : records) {
			if (!uniqueIPs.contains(le.getIpAddress())) {
				uniqueIPs.add(le.getIpAddress());
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
		for (LogEntry le : records) {
			if (le.getStatusCode() > num) {
				System.out.println(le);
			}
		}
	}

	public ArrayList<String> uniqueIPVisitsOnDay(String date) {
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		// System.out.println(date);
		for (LogEntry le : records) {
			String str = le.getAccessTime().toString();
			if (str.contains(date)) {
				if (!uniqueIPs.contains(le.getIpAddress())) {
					uniqueIPs.add(le.getIpAddress());
				}
			}
		}
		return uniqueIPs;
	}

	public int countUniqueIPsInRange(int low, int high) {
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for (LogEntry le : records) {
			if (le.getStatusCode() >= low && le.getStatusCode() <= high && !uniqueIPs.contains(le.getIpAddress())) {
				uniqueIPs.add(le.getIpAddress());
			}
		}
		return uniqueIPs.size();
	}

	public HashMap<String, Integer> countVisiterPerIp() {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		for (LogEntry le : records) {
			String ip = le.getIpAddress();
			if (!counts.containsKey(ip)) {
				counts.put(ip, 1);
			} else {
				counts.put(ip, counts.get(ip) + 1);
			}
		}
		return counts;
	}

	public int mostNumberVisitsByIP(HashMap<String, Integer> counts) {
		int mostVisited = 0;

		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			if (entry.getValue() > mostVisited) {
				mostVisited = entry.getValue();
			}
		}

		return mostVisited;
	}

	public HashMap<String, Integer> iPsMostVisits(HashMap<String, Integer> counts) {
		HashMap<String, Integer> ipMostVisited = new HashMap<String, Integer>();
		int maxNumber = mostNumberVisitsByIP(counts);

		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == maxNumber) {
				ipMostVisited.put(entry.getKey(), maxNumber);
			}
		}
		return ipMostVisited;
	}

	static String toProperCase(String s) {
		return s.substring(0, 1).toUpperCase() +
				s.substring(1).toLowerCase();
	}

	public HashMap<String, ArrayList<String>> iPsForDays() {
		HashMap<String, ArrayList<String>> resp = new HashMap<String, ArrayList<String>>();
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog2_log");

		for (LogEntry le : la.records) {
			String month = toProperCase(new SimpleDateFormat("MMMM").format(le.getAccessTime())).substring(0, 3);
			String day = new SimpleDateFormat("dd").format(le.getAccessTime());
			String date = month + " " + day;
			
			if (!resp.containsKey(date)) {
				ArrayList<String> al = new ArrayList<String>();
				al.add(le.getIpAddress());
				resp.put(date, al);
			} else {
				ArrayList<String> al = resp.get(date);
				al.add(le.getIpAddress());
				resp.put(date, al);
			}
			//System.out.println(le);
		}
		return resp;
	}
	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> iPsForDays){
		String resp = "";
		int maxVisit = -1;
		HashMap<String, Integer> counts = new HashMap<String, Integer>();

		for(String key : iPsForDays.keySet()){
			if (!counts.containsKey(key)){
				ArrayList<String> al = iPsForDays.get(key);
				counts.put(key, al.size());
				if(al.size()>maxVisit){
					maxVisit = al.size();
					resp = key;
				}
			}
		}
		System.out.println(counts);

		return resp;
	}

	public HashMap<String,Integer> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> counts, String date){
		HashMap<String,Integer> resp = new HashMap<String,Integer>();
		for(String key : counts.keySet()){
			
			if(key == date){
				ArrayList al = counts.get(key);
				for(int i = 0; i < al.size(); i++){
					String str = al.get(i).toString();
					if (!resp.containsKey(str)){
						resp.put(str, 1);
					}else{
						resp.put(str,resp.get(str)+1);
					}
				}
			}
		}
		return resp;
	}
}
