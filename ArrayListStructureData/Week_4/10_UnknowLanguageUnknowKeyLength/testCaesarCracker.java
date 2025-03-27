
/**
 * Write a description of testCaesarCracker here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/22
 */
import java.util.*;
import edu.duke.*;

public class testCaesarCracker {
	public static void main(String[] args) {
		System.out.println(".()");
	}

	public void testCaesarCracker(){
		FileResource fr = new FileResource();
		
		CaesarCracker cc = new CaesarCracker();
		for (String line : fr.lines()) {

			String decrypt = cc.decrypt(line);
			System.out.println("Line : " + line);
			System.out.println(" dec : " + decrypt);
		}
	}
}
