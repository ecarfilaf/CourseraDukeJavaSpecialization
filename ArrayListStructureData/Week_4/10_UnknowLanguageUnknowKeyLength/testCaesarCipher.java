
/**
 * Write a description of testCaesarCipher here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/22
 */
import java.util.*;
import edu.duke.*;

public class testCaesarCipher {
	public static void main(String[] args) {
		System.out.println(".()");
	}

	public void testCaesarCipher() {
		FileResource fr = new FileResource();
		CaesarCipher cc = new CaesarCipher(10);
		for (String line : fr.lines()) {
			String enc = cc.encrypt(line);
			System.out.println("Line : " + line);
			System.out.println(" enc : " + enc);
		}
	}
}
