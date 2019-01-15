import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class AasaanJobsAPITest {
    int rowsLengthFromFile1, rowsLengthFromFile2;

    @Test

    public void isRowsFromGivenFileIsEqual(){
        File file1= new File(System.getProperty("user.dir") + "/userRecordsFile1.csv");
        File file2= new File(System.getProperty("user.dir") + "/userRecordsFile2.csv");
        rowsLengthFromFile1= Utils.getLinesNumberFromFile(file1);
        rowsLengthFromFile2= Utils.getLinesNumberFromFile(file2);
        Assert.assertEquals(rowsLengthFromFile1, rowsLengthFromFile2);
    }

    @Test(dependsOnMethods = "isRowsFromGivenFileIsEqual")

    public void checkAPI(){
        for (int i= 1; i<= rowsLengthFromFile1; i++){

            Response response1= given()
                    .log()
                    .all()
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7")
                    .header("authority", "reqres.in")
                    .header("scheme", "https")
                    .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3668.0 Safari/537.36")
                    .get(Utils.getAPIFromCSVFile1(i));
            Assert.assertEquals(response1.getStatusCode(), 200);
            System.out.println(response1.body().asString());

            Response response2= given()
                    .log()
                    .all()
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7")
                    .header("authority", "reqres.in")
                    .header("scheme", "https")
                    .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3668.0 Safari/537.36")
                    .get(Utils.getAPIFromCSVFile2(i));
            Assert.assertEquals(response2.getStatusCode(), 200);
            System.out.println(response2.body().asString());
        }
    }


}
