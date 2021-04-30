import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TC_09 extends BasePage {
    public TC_09(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void Scenario9(String offerName) throws IOException {
        try {
            citySelected("Goa");
            click(By.cssSelector("div.wrapper-main._touch:nth-child(2) div.super-container div.styles__DiscoveryContainerWrapper-b1h692-2.jcIRgl header.sc-kaNhvL.ktcVLV:nth-child(2) div.sc-iBEsjs.jBWmGA div.sc-jXQZqI.iuZyni div.sc-kasBVs.gbkTzy div.sc-hgHYgh.gqxEJg div.sc-jtggT.eoYVls div.sc-bmyXtO.jLbuuP > a.sc-ebFjAB.ipkDbl:nth-child(3)"));
            locateElement(By.xpath("//input[@id='ajax-typeahead']")).sendKeys( "ICICI Bank Credit Card 25%"+ Keys.ENTER);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");
            String offerImage = getText(By.xpath("//h4[contains(text(),'ICICI Bank Credit Card 25% Discount Offer')]"));
            if (offerImage.contains(offerName)) {
                System.out.println("Offer is present");
                Reports.extentTest.log(Status.INFO, "Offer search successfull");
            } else {
                System.out.println("offer not available");
                Reports.extentTest.log(Status.INFO, "Offer search unsuccessfull");
            }
            takeScreenshot("9-1");


        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            System.out.println(e);
        }


    }

}
