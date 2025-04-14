
/**
 * Write a description of PhraseFilter here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/28
 */

public class PhraseFilter implements Filter {

	private String strType;
	private String strPhrase;
	private String strFilter;

	public PhraseFilter(String type, String phrase, String sName) {
		strType = type;
		strPhrase = phrase;
		strFilter = sName;
	}

	public boolean satisfies(QuakeEntry qe) {
		return strType.equals("start") && qe.getInfo().startsWith(strPhrase) ? true
				: strType.equals("end") && qe.getInfo().endsWith(strPhrase) ? true
						: strType.equals("any") && qe.getInfo().indexOf(strPhrase) != -1 ? true
								: false;
	}

	public String getName() {
		return strFilter;
	}

}
