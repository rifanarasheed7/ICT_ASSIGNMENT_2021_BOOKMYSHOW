import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;


public class BookMyShow {

    private WebDriver driver;

    @Parameters({"Chromebrowser", "Url"})
    @BeforeMethod
    public void openBrowser(String browser, String Url) throws Exception {
        driver = Browser.openBrowser(browser, Url);
    }

    @Test(priority = 0)
    //scenario_01-PositiveFilmSearch
    public void testCase01_filmSearch1() throws IOException {
        Reports.createTest("TestScenario_01_FilmSearchPositiveScenario");
        TC_01 tc01 = new TC_01(driver);
        tc01.scenario1("Fantasy Island");
    }

    @Test(priority = 1)
    //scenario_02-NegativeFilmSearch
    public void testCase02_filmSearch2() {
        Reports.createTest("TestScenario_02_FilmSearchNegativeScenario");
        TC_02 tc02 = new TC_02(driver);
        tc02.Scenario2("1234564");
    }

    @Test(priority = 2)
    //scenario_05-List Your Show-What can you Host
    public void testCase05_hostCheck() throws IOException {
        Reports.createTest("TestScenario_05_HostOptionsCheck");
        TC_05 tc05 = new TC_05(driver);
        tc05.Scenario5();

    }

    @Test(priority = 3)
    //scenario_06-List Your Show-What are the services we offer?
    public void testCase06_servicesCheck() throws IOException {
        Reports.createTest("TestScenario_06_ServiceOfferCheck");
        TC_06 tc06 = new TC_06(driver);
        tc06.Scenario6();

    }


    @Test(priority = 4)
    //scenario_07-List Your Show-Reports & Business insights details
    public void testCase07_reportsCheck() throws IOException {
        Reports.createTest("TestScenario_07_ReportOptionsCheck");
        TC_07 tc07 = new TC_07(driver);
        tc07.Scenario07();
    }

    @Test(priority = 5)
    //scenario_09-Search Offers-Positive scenario
    public void testCase09_SearchOffers() throws IOException {
        Reports.createTest("TestScenario_09_OfferCheck1");
        TC_09 tc09 = new TC_09(driver);
        tc09.Scenario9(" ");
    }

    @Test(priority = 6)
    //scenario_10-Search Offers-Negative scenario
    public void testCase10_searchOffers2() throws IOException {
        Reports.createTest("TestScenario_10_OfferCheck2");
        TC_10 tc10 = new TC_10(driver);
        tc10.scenario10(" ");
    }

    @Test(priority = 7)
    //scenario_11-Footer Text Validation
    public void testCase11_footerCheck() throws IOException {
        Reports.createTest("TestScenario_11_FooterTextCheck");
        TC_11 tc11 = new TC_11(driver);
        tc11.Scenario11();
    }

    @Test(priority = 8)
    //scenario_12-Validate Menu
    public void testCase12_MenuCheck() throws IOException {
        Reports.createTest("TestScenario_12_MenuOptionsCheck");
        TC_12 tc12 = new TC_12(driver);
        tc12.Scenario12();
    }


    @Parameters({"City"})
    @Test(priority = 9)
    //scenario_13-CitySelection
    public void testCase13_ChooseCity(@Optional("Alappuzha") String city) throws IOException {
        Reports.createTest("TestScenario_13_citySelectionCheck");
        TC_13 tc13 = new TC_13(driver);
        tc13.VerifyCity(city);
    }


    @AfterMethod
    public void closeBrowser() {
        Browser.closeBrowser(driver);
    }
}
