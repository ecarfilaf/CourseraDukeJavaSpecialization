import java.util.*;
import edu.duke.*;

/**
 * Class created as an Assignment 1 requirement.
 * 
 * @author (Abraham Ferrero)
 * @version (28/Nov/2017)
 */
public class Tester {
	// This method has been made for testing the getFollows method in the MarkovOne
	// class:
	public static void testGetFollows() {
		MarkovOne one = new MarkovOne();
		one.setTraining("this is a test yes this is a test.");
		String key = "t";
		System.out.println(one.getFollows(key));
	}

	public static void testGetFollowsWithFile() {
		MarkovOne one = new MarkovOne();
		FileResource f = new FileResource("../data/confucius.txt");
		one.setTraining(f.asString());
		String key = "he";
		System.out.println(one.getFollows(key).size());
		// "You should get 11548." ----> Correct.
	}

	public static void main(String[] args) {
		testGetFollows();
		System.out.println("------------------------------------------------");
		testGetFollowsWithFile();
	}
}