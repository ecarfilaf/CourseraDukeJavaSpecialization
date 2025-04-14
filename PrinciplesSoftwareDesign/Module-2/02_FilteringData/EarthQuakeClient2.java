import java.util.*;

public class EarthQuakeClient2 {
	public EarthQuakeClient2() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) {
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		for (QuakeEntry qe : quakeData) {
			if (f.satisfies(qe)) {
				answer.add(qe);
			}
		}

		return answer;
	}

	public void quakesWithFilter(double minMagnitude, double maxMagnitude, double minDepth, double maxDepth) {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		String source = "../data/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");

		// Filter minMag = new MinMagFilter(minMagnitude);
		// ArrayList<QuakeEntry> res1 = filter(list, minMag);

		Filter magFilter = new MagnitudeFilter(minMagnitude,maxMagnitude,"");
		ArrayList<QuakeEntry> res1 = filter(list, magFilter);

		Filter depthFilter = new DepthFilter(minDepth, maxDepth, "");
		ArrayList<QuakeEntry> res2 = filter(res1, depthFilter);

		for (QuakeEntry qe : res2) {
			System.out.println(qe);
		}
		System.out.println("Found " + res2.size() + " quakes");
	}

	public void quakesWithFilterTwo(double meters, Location location, String phrase, String type) {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		String source = "../data/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");

		Filter disFilter = new DistanceFilter(location,meters,"");
		ArrayList<QuakeEntry> res1 = filter(list, disFilter);

		Filter phraseFilter = new PhraseFilter(type,phrase,"");
		ArrayList<QuakeEntry> res2 = filter(res1, phraseFilter);

		for (QuakeEntry qe : res2) {
			System.out.println(qe);
		}
		System.out.println("Found " + res2.size() + " quakes");
	}

	public void createCSV() {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source = "../data/nov20quakedata.atom";
		String source = "../data/nov20quakedatasmall.atom";
		// String source =
		// "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		dumpCSV(list);
		System.out.println("# quakes read: " + list.size());
	}

	public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for (QuakeEntry qe : list) {
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
					qe.getLocation().getLatitude(),
					qe.getLocation().getLongitude(),
					qe.getMagnitude(),
					qe.getInfo());
		}
	}

	public void testQuakesWithFilter() {
		System.out.println("quakesWithFilter");
		quakesWithFilter(4.0, 5.0, -35000.0, -12000.0);

		System.out.println("quakesWithFilterTwo");
		Location loc = new Location(35.42, 139.43);
		quakesWithFilterTwo(10000000, loc, "Japan", "end");
	}

	public void testMatchAllFilter(){
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "../data/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");

		MatchAllFilter maf = new MatchAllFilter();
		Filter magfilter = new MagnitudeFilter(0, 2.0, "");
		maf.addFilter(magfilter);
		Filter depFilter = new DepthFilter(-100000.0, -10000.0, "");
		maf.addFilter(depFilter);
		Filter phraFilter = new PhraseFilter("any","a","");
		maf.addFilter(phraFilter);

		ArrayList<QuakeEntry> res = filter(list, maf);
		for (QuakeEntry qe : res) {
			//System.out.println(qe);
		}
		System.out.println("Found " + res.size() + " quakes");
	}
	
	public void testMatchAllFilter2(){
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "../data/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");

		MatchAllFilter maf = new MatchAllFilter();
		Filter magfilter = new MagnitudeFilter(0, 3.0, "");
		maf.addFilter(magfilter);
		Location loc = new Location(36.1314, -95.9372);
		Filter depFilter = new DistanceFilter(loc, 10000000, "");
		maf.addFilter(depFilter);
		Filter phraFilter = new PhraseFilter("any","Ca","");
		maf.addFilter(phraFilter);

		ArrayList<QuakeEntry> res = filter(list, maf);
		for (QuakeEntry qe : res) {
			System.out.println(qe);
		}
		System.out.println("Found " + res.size() + " quakes");
		System.out.println("Filters used are: " + maf.getName());

	}
}
