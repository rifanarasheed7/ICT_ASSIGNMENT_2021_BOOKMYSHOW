import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {

    public static WebDriver openBrowser(String Browser, String Url) throws Exception {
        String baseDirectory = System.getProperty("user.dir");
        if (Browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", baseDirectory + "/src/main/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            //ToDo parameterise browser and url
            driver.get(Url);
            return driver;
        } else if (Browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("Webdriver.gecko.driver", "/src/main/resources/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(Url);
            return driver;
        }
        return null;
    }

    public static void closeBrowser (WebDriver driver){
        driver.close();

    }
}
