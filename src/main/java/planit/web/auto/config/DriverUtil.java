package planit.web.auto.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {
    private static WebDriver driver;

    public static WebDriver getDriver () {
        return driver;
    }

    public static void initializeBrowser() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static JavascriptExecutor getJsExecutor () {
        return (JavascriptExecutor) driver;
    }

    public static void closeBrowser () {
        if (driver != null)
            driver.close();
    }


    public static void closeDriver () {
        if (driver != null)
            driver.quit();
    }
}
