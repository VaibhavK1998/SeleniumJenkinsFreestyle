package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass2 {


    @BeforeSuite
    public void beforeClass(){
        DeleteAllureReport.deleteAllureReports();
    }

    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    public WebDriver driver;

    @Parameters("browserName")
    @BeforeMethod
    public WebDriver initialize(String driverName) {
            if (driverName.equals("chrome")||driverName.equals("CH")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (driverName.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (driverName.equals("FF")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            tdriver.set(driver);
            return getDriver();
        }


        public static synchronized WebDriver getDriver() {
            return tdriver.get();
        }
    }

