import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TC_10 extends BasePage {
    public TC_10(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void scenario10(String offerName2) throws IOException {
        try {
            citySelected("Goa");
            click(By.cssSelector("div.wrapper-main._touch:nth-child(2) div.super-container div.styles__DiscoveryContainerWrapper-b1h692-2.jcIRgl header.sc-kaNhvL.ktcVLV:nth-child(2) div.sc-iBEsjs.jBWmGA div.sc-jXQZqI.iuZyni div.sc-kasBVs.gbkTzy div.sc-hgHYgh.gqxEJg div.sc-jtggT.eoYVls div.sc-bmyXtO.jLbuuP > a.sc-ebFjAB.ipkDbl:nth-child(3)"));
            locateElement(By.xpath("//input[@id='ajax-typeahead']")).sendKeys("Kotak Mahindra Offer");
//            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");
            String offerResult = getText(By.xpath("//div[contains(text(),'No matching results')]"));
            if (offerResult.contains(offerName2)) {
                System.out.println("Offer is not present");

            } else {
                System.out.println("offer available");
            }
            takeScreenshot("10-1");


        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            System.out.println(e);
            takeScreenshot("10-2");
        }


    }

}


