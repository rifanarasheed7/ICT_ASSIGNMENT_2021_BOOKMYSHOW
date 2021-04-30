import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_07 extends BasePage {
    public TC_07(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void Scenario07() throws IOException {
        try {
            citySelected("Goa");
            click(By.cssSelector(".ddCzTB"));
            click(By.cssSelector(".\\__card-color:nth-child(5) > .\\__txt"));
            List<String> reportItems = Arrays.asList("In depth reports", "Access registration data", "behavioural insights");
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/s/list-your-show/");
            int j = 0;
            for (int i = 1; i <= 4; i++) {
                String reports = getText(By.xpath("//*[@id='Reports']/div/div[2]/div[2]/div[" + i + "]/div[2]"));
                if (reportItems.contains(reports)) {
                    System.out.println(reports);
                    j++;
                    Reports.extentTest.log(Status.INFO, reports);
                }
            }
            if (j == 3) {
                System.out.println("Correct");
                Reports.extentTest.log(Status.PASS, "Items are present");
            } else {
                System.out.println("Incorrect");
                Reports.extentTest.log(Status.FAIL, "Items missing");
            }
            takeScreenshot("7-1");
        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            takeScreenshot("7-2");
        }


    }
}





