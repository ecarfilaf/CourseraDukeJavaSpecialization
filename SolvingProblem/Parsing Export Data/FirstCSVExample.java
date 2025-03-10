
/**
 * Write a description of FirstCSVExample here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser){
            System.out.print(record.get("Country") + " ");
            System.out.print(record.get("Exports") + " ");
            System.out.println(record.get("Value (dollars)"));
        }
    }
    public String countryInfo (CSVParser parser, String country){
        String resp = "NOT FOUND";
        
        for (CSVRecord record : parser){
            if (record.get("Country").equals(country)){
                resp = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
                break;
            }
        }
        return resp;
    }
    public void test_countryInfo(String country){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, country));
    }
}
