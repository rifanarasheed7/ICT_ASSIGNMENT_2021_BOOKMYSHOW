import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_12 extends BasePage {
    public TC_12(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void Scenario12() throws IOException {
        try {
            citySelected("Goa");
            List<String> Menuchecklist = Arrays.asList("Movies", "Stream", "Events", "Plays", "Sports", "Activities", "Fanhood", "Buzz");
            List<WebElement> Menu = driver.findElements(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"));
            int list = 0;
            for (int i = 1; i <= Menu.size(); i++) {
                String menuBarItem = getText(By.xpath("(//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1])[position()=" + i + "]"));
                if (Menuchecklist.contains(menuBarItem)) {
                    System.out.println(menuBarItem);
                    list++;
                }
            }
            if (list == 8) {
                System.out.println("All the listed items are present in Menu Bar");
                Reports.extentTest.log(Status.PASS, "Items are available");
                takeScreenshot("12-1");

            } else {
                System.out.println("Items are missing in the Menu Bar");
                Reports.extentTest.log(Status.FAIL, "Items are not available");
                takeScreenshot("12-2");
            }

        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            System.out.println(e);
            takeScreenshot("12-2");
        }
    }


}

