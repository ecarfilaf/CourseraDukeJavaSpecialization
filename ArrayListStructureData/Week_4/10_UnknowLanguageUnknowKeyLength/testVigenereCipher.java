
/**
 * Write a description of testVigenereCipher here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/22
 */
import java.util.*;
import edu.duke.*;

public class testVigenereCipher {
	public static void main(String[] args) {
		System.out.println(".()");
	}

	public void testVigenereCipherEncrypt() {
		System.out.println("testVigenereCipherEncrypt");
		int[] keys = { 17, 14, 12, 4 };
		VigenereCipher vc = new VigenereCipher(keys);
		FileResource fr = new FileResource();

		for (String line : fr.lines()) {

			String decrypt = vc.encrypt(line);
			System.out.println("Line : " + line);
			System.out.println(" enc : " + decrypt);
		}
	}
	public void testVigenereCipherDecrypt() {
		System.out.println("testVigenereCipherDecrypt");
		int[] keys = { 17, 14, 12, 4 };
		VigenereCipher vc = new VigenereCipher(keys);
		FileResource fr = new FileResource();

		for (String line : fr.lines()) {

			String decrypt = vc.decrypt(line);
			System.out.println("Line : " + line);
			System.out.println(" dec : " + decrypt);
		}
	}
}
