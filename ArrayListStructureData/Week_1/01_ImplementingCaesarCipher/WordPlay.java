


/**
 * Write a description of WordPlay here.
 * 
 * @author Esteban Carfilaf 
 * @version 1.001.01 2025/03/10
 */
public class WordPlay {
	public boolean isVowel(char ch) {
		String vowels = "aeiou";
		char lowerCh = Character.toLowerCase(ch);
		return vowels.indexOf(lowerCh) != -1;
	}
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	public void testIsVowel() {
		System.out.println(isVowel('F'));
		System.out.println(isVowel('a'));
	}
	public String replaceVowels(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		for (int i = 0; i < sb.length(); i++) {
			if (isVowel(sb.charAt(i))) {
				sb.setCharAt(i, ch);
			}
		}
		return sb.toString();
	}
	public String replaceVowels2(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		for (int i = 0; i < sb.length(); i++) {
			if (isVowel(sb.charAt(i))) {
				//sb.setCharAt(i, ch);
				if(sb.charAt(i) == ch) {
					if (i % 2 == 0) {
						sb.setCharAt(i, '*');
					} else {
						sb.setCharAt(i, '+');
					}
				}
			}
		}
		return sb.toString();
	}
	public void testReplaceVowels() {
		System.out.println(replaceVowels("Hello World", '*'));
	}
	public void testReplaceVowels2() {
		System.out.println(replaceVowels2("dna ctgaaactga", 'a'));
		System.out.println(replaceVowels2("Mary Bella Abracadabra", 'a'));
	}
}
