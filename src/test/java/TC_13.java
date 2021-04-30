import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TC_13 extends BasePage {

    public TC_13(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //    public void CitySelect(String cityName){}
    public void VerifyCity(String cityName) throws IOException {
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://in.bookmyshow.com/");
            locateElement(By.cssSelector(".sc-fihHvN")).sendKeys(cityName + Keys.ENTER);
            String cityShowing = getText(By.xpath("//span[@class='sc-RcBXQ dTleyQ ellipsis']"));
            if (cityName.equals(cityShowing)) {
                System.out.println("City selected is correct : " + cityName);
                Reports.extentTest.log(Status.PASS, "City name showing is correct", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("City name is Correct")).build());

            } else {
                System.out.println("City showing is incorrect : " + cityName);
                Reports.extentTest.log(Status.FAIL, "City name showing is correct", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("City  name is incorrect")).build());
            }
            takeScreenshot("13-1");
        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            System.out.println(e);
        }
    }
}