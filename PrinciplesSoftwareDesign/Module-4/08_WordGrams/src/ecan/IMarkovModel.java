package ecan;
/**
 * Write a description of interface IMarkovModel here.
 *
 * @author Esteban Carfilaf 
 * @version 1.001.01 2025/04/28
 */
public interface IMarkovModel {

	public void setTraining(String text);

	public void setRandom(int seed);

	public String getRandomText(int numChars);

}
