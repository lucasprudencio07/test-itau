package selenium.base;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium.pages.PageHome;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private static WebDriver chromeDriver;
    protected PageHome home;

    @BeforeAll
    public static void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lucas\\Documents\\Drivers\\chromedriver83.exe");

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        chromeDriver.manage().window().maximize();
    }


    @BeforeEach
    public void loadInitialScreen() {

        chromeDriver.get("https://www.icarros.com.br/principal/index.jsp");
        home = new PageHome(chromeDriver);
    }


    @AfterAll
    public static void tearDown() {

        chromeDriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        chromeDriver.quit();
    }

}
