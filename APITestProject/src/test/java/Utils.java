import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;

public class Utils {
    public static int getLinesNumberFromFile(File file){
        int lineNumber= 0;
        try {
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    lineNumber++;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lineNumber;
    }

    public static String getAPIFromCSVFile1(int index){
        String api= "";
        try {
            int i= 0;
            FileReader fileReader1 = new FileReader(System.getProperty("user.dir")+"/userRecordsFile1.csv");
            CSVReader csvReader1 = new CSVReader(fileReader1);
            String[] nextRecord1;
            while ((nextRecord1 = csvReader1.readNext()) != null) {
                for (String cell : nextRecord1) {
                    i++;
                    if (i== index){
                        api= cell;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return api;
    }

    public static String getAPIFromCSVFile2(int index){
        String api= "";
        try {
            int i= 0;
            FileReader fileReader2 = new FileReader(System.getProperty("user.dir")+"/userRecordsFile2.csv");
            CSVReader csvReader2 = new CSVReader(fileReader2);
            String[] nextRecord2;
            while ((nextRecord2 = csvReader2.readNext()) != null) {
                for (String cell : nextRecord2) {
                    i++;
                    if (i== index){
                        api= cell;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return api;
    }

}
