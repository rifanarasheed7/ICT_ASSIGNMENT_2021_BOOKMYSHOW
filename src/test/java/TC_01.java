import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TC_01 extends BasePage {
    public TC_01(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //FilmSelectionPositiveScenario
    public void scenario1(String film) throws IOException {
        try {
            citySelected("Goa");
            click(By.id("4"));
            locateElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(film);
            waits(By.xpath("//li"));
            click(By.xpath("//li"));
            String NameMovie = getText(By.xpath("//h1[@class='styles__EventHeading-qswwm9-6 mptsd']"));
            if (NameMovie.contains(film)) {
                System.out.println("Movie searched is found: " + film);
                Reports.extentTest.log(Status.INFO, "Film search successfull");
                takeScreenshot("MovieSearchDone");

            } else {
                System.out.println("Incorrect Movie searched: " + film);
                Reports.extentTest.log(Status.INFO, "Film not found");
                takeScreenshot(" MovieSearchFail");
            }
            Assert.assertEquals(film, getText(By.xpath("//h1[@class='styles__EventHeading-qswwm9-6 mptsd']")));

        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            System.out.println(e);
        }
    }
}



