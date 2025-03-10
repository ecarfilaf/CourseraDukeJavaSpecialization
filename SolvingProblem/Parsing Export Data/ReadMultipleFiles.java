
/**
 * Write a description of ReadMultipleFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class ReadMultipleFiles {
    public void readDirectory(){
        Double coldestTemp = 99999.0;
        Double lowestHumidity = 99999.0;
        Double temp = 0.0;
        Double humidity = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            //System.out.println("Filename " + f);
            for (CSVRecord record : parser){
                temp = Double.valueOf(record.get("TemperatureF"));
                try{
                    humidity = Double.valueOf(record.get("Humidity"));
                }
                catch (Exception ex){
                    humidity = 99.0;
                }
                if (temp < coldestTemp){
                    coldestTemp = temp;
                    System.out.println("Coldest Temperature " + coldestTemp);
                    System.out.println("Coldest Temperature Date " + record.get("DateUTC"));
                }
                if (humidity < lowestHumidity){
                    lowestHumidity = humidity;
                    System.out.println("Lowest Humidity " + lowestHumidity);
                    System.out.println("Lowest Humidity Date " + record.get("DateUTC"));
                }
            }
        }
        System.out.println("Coldest Temperature " + coldestTemp);
        System.out.println("Lowest Humidity " + lowestHumidity);
    }
}
