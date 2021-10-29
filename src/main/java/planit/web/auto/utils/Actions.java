package planit.web.auto.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import planit.web.auto.config.WebDriverManager;

public class Actions {

    public static void scrollToElement(WebElement element) {
        WebDriverManager.getJsExecutor().executeScript("arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"});", element);
    }

    public static void  click (String xpath, String nameOfObject) {
        click(By.xpath(xpath), nameOfObject);
    }

    public static void click (By by, String nameOfObject) {
        BasePageListener.findElement(by).click();
        Log.info(Actions.class, "Successfully clicked: " + nameOfObject);
    }

    public static void enter (String xpath, String nameOfObject ,String keyToEnter) {
        enter(By.xpath(xpath), nameOfObject ,keyToEnter);
    }

    public static void enter (By by, String nameOfObject ,String keyToEnter) {
        BasePageListener.findElement(by).sendKeys(keyToEnter);
        Log.info(Actions.class, "Successfully entered [ " + keyToEnter + "] on " + nameOfObject);
    }
}
