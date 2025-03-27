
/**
 * Write a description of testVigenereBreaker here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/22
 */
import java.util.*;
import edu.duke.*;

public class testVigenereBreaker {
	public static void main(String[] args) {
		System.out.println(".()");
	}

	public void testVigenereBreaker(){
		System.out.println("test-VigenereBreaker");
		VigenereBreaker vb = new VigenereBreaker();
		
		System.out.println(vb.sliceString("abcdefghijklm", 0, 3));
		// System.out.println(vb.sliceString("abcdefghijklm", 1, 3));
		// System.out.println(vb.sliceString("abcdefghijklm", 2, 3));
		// System.out.println(vb.sliceString("abcdefghijklm", 0, 4));
		// System.out.println(vb.sliceString("abcdefghijklm", 1, 4));
		// System.out.println(vb.sliceString("abcdefghijklm", 2, 4));
		// System.out.println(vb.sliceString("abcdefghijklm", 3, 4));

		System.out.println("test-tryKeyLength");
		FileResource fr = new FileResource();
		int[] key = {5, 11, 20, 19, 4};

		String file = fr.toString();
		key = vb.tryKeyLength(file, 4, 'e');
		//System.out.println(key);

		// for(String line: fr.lines()){
		// 	//System.out.println(line);
		// 	System.out.println(vb.tryKeyLength(line, 5, 'e'));
		// }

		System.out.println("test-breakVigenere");
		vb.breakVigenere();
	}
}
