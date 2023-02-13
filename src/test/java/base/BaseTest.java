package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private Properties prop;
    private WebDriver driver;
    protected HomePage homePage;

    public BaseTest() {
        try {
            prop = new Properties();

            FileInputStream file = new FileInputStream("src/main/java/config/config.properties");
            prop.load(file);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    protected void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

        if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    @BeforeClass
    public void setUp() {
        initialization();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
