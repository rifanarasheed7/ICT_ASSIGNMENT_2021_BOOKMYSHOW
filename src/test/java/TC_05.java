import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class TC_05 extends BasePage {


    public TC_05(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void Scenario5() throws IOException {
        try {
            citySelected("Goa");
            click(By.cssSelector(".ddCzTB"));
            List<String> host = Arrays.asList("Online Streaming", "Performances", "Experiences", "Expositions", "Parties", "Sports", "Conferences");
            List<WebElement> hostsList = driver.findElements(By.xpath("//div[@class='__txt']"));
            int j = 0;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");
            for (int i = 1; i <= hostsList.size(); i++) {
                String hostItemsName = getText(By.xpath("(//div[@class='__txt'])[position()=" + i + "]"));
                if (host.contains(hostItemsName)) {
                    System.out.println(hostItemsName);
                    Reports.extentTest.log(Status.PASS,"List of Host verified as "+hostItemsName, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("")).build());

                    j++;

                }
            }
            if (j == 7) {
                System.out.println("Correct number of list ");
                Reports.extentTest.log(Status.PASS,"Correct number of List");


            } else {
                System.out.println("Incorrect number of list ");
                Reports.extentTest.log(Status.PASS,"InCorrect number of List");

            }
            takeScreenshot("5-1");
        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
//            takeScreenshot();
        }
    }
}