import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_06 extends BasePage {

    public TC_06(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void Scenario6() throws IOException {
        try {
            citySelected("Goa");
            click(By.cssSelector(".ddCzTB"));
            List<String> servicesNeeded = Arrays.asList("Online Sales & Marketing", "Pricing", "Food & beverages, stalls and the works!", "On ground support & gate entry management", "Reports & business insights", "POS, RFID, Turnstiles & more...");
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/s/list-your-show/");
            List<WebElement> services = driver.findElements(By.xpath("//div[@class='__txt']"));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4500)");
            int j = 0;
            for (int i = 1; i <= services.size(); i++) {
                String servicesItems = getText(By.xpath("(//div[@class='__txt'])[position()=" + i + "]"));
                if (servicesNeeded.contains(servicesItems)) {
                    System.out.println(servicesItems);
                    Reports.extentTest.log(Status.INFO, servicesItems);
                    j++;
                }
            }
            if (j == 6) {
                System.out.println("Correct number of service items");
                Reports.extentTest.log(Status.PASS, "Correct number of service items");

            } else {
                System.out.println("Incorrect number of service items");
                Reports.extentTest.log(Status.FAIL, "Incorrect number of service items");

            }
            takeScreenshot("6-1");

        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            System.out.println(e);
        }
    }

}
