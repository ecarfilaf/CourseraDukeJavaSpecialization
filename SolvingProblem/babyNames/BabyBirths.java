
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)){
            System.out.println("Name "+rec.get(0) +
                                ", Gender "+rec.get(1)+
                                ", Num Born "+rec.get(2));
        }
    }
    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if(rec.get(1).equals("M")){
                totalBoys += numBorn;
            }else{
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = "+totalBirths);
        System.out.println("total girls = "+totalGirls);
        System.out.println("total boys = "+totalBoys);
    }
    public void testTotalBirths(){
        FileResource fr = new FileResource("us_babynames_test/example-small.csv");
        totalBirths(fr);
    }
    public void getRank (int year, String name, String gender){
        FileResource fr = new FileResource();
        int resp = -1;
        
        //if (fr.filename().contains(year)){
            for(CSVRecord rec : fr.getCSVParser(false)){
                if (rec.get(0).equals(name)){
                    if (rec.get(1).equals(gender)){
                        int numBorn = Integer.parseInt(rec.get(2));
                        resp = numBorn;
                    }
                }
            }
        //}
        System.out.println("getRank = "+resp);
    }
}
