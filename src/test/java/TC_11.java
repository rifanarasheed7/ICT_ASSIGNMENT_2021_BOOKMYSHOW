import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_11 extends BasePage {
    public TC_11(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //success
    public void Scenario11() throws IOException {
        try {
            citySelected("Goa");
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            String footerCheck = "The content and images used on this site are copyright protected and copyrights vests with the respective owners. The usage of the content and images on this website is intended to promote the works and no endorsement of the artist shall be implied. Unauthorized use is prohibited and punishable by law.";
            String copyright = (getText(By.xpath("//div[@class='sc-bMVAic bOhLXm']")).replace("Copyright 2021 © Bigtree Entertainment Pvt. Ltd. All Rights Reserved.", "")).replace("\n", "");
            if (footerCheck.contains(copyright)) {
                System.out.println("Footer Correct");
            } else {
                System.out.println("Incorrect footer element");
            }
            takeScreenshot("11-1");


        } catch (Exception e) {
            Reports.extentTest.log(Status.INFO, e);
            System.out.println(e);
            takeScreenshot("11-2");
        }
    }
}

