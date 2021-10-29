package planit.web.auto.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import planit.web.auto.config.WebDriverManager;

import java.io.*;
import java.util.Properties;

public class Utility {


    public static String getProperty (String key) throws IOException {
        Properties prop = new Properties();
        String fileDir = "src/main/resources/properties/application.properties";
        File file = new File(fileDir);
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        String value = prop.getProperty(key);
        return value;
    }

    public static void screenShot(String name) {
        String path = "src/test/resources/reports/" + name + ".png";
        TakesScreenshot screenshot = ((TakesScreenshot) WebDriverManager.getDriver());
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        Log.info(Utility.class, "Saving screenshot to: " + path);
        File destfile = new File(path);
        try {
            FileUtils.copyFile(file, destfile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
