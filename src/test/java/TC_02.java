import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC_02 extends BasePage {
    public TC_02(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void Scenario2(String invalidFilm) {
        try {
            citySelected("Goa");
            click(By.id("4"));
            locateElement(By.cssSelector(".sc-fihHvN")).sendKeys(invalidFilm);
//            click(By.xpath("//li"));
            if (getText(By.xpath("//span[contains(text(),'No Results found')]")).contains("No Results found")) {
                System.out.println("Provide valid film name");
                Reports.extentTest.log(Status.PASS, "No results found for invalid film search");

                takeScreenshot("2-1");
            } else {
                System.out.println("Film found");
                Reports.extentTest.log(Status.FAIL, "Film found for invalid data");
                takeScreenshot("2-2");
            }

        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            System.out.println(e);
        }
    }
}
