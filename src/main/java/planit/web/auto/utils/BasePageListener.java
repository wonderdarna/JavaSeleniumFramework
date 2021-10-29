package planit.web.auto.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import planit.web.auto.config.DriverUtil;

import java.util.List;

public class BasePageListener {
    private static WebDriverWait wait;


    public static void goToURL (String url) {
        DriverUtil.getDriver().get(url);
    }

    public static WebElement findElement(String xpath) {
        return findElement(xpath, 5l);
    }

    public static WebElement findElement(String xpath, Long waitTime) {
        wait = new WebDriverWait(DriverUtil.getDriver(), waitTime);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Actions.scrollToElement(element);
        return element;
    }

    public static WebElement findElement (By by, Long waitTime) {
        wait = new WebDriverWait(DriverUtil.getDriver(), waitTime);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Actions.scrollToElement(element);
        return element;
    }

    public static WebElement findElement(By by) {
        return findElement(by, 5L);
    }

    public static boolean checkIfElementIsDisplaying (String xpath) {
       return checkIfElementIsDisplaying(xpath, 5l);
    }

    public static boolean checkIfElementIsDisplaying (String xpath, Long waitTime) {
        try {
            findElement(xpath, waitTime);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkIfElementIsDisplaying (By by, Long waitTime) {
        try {
            findElement(by, waitTime);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkIfElementIsDisplaying (By by) {
        return checkIfElementIsDisplaying(by, 5l);
    }

    public static List<WebElement> findElements (By by) {
        return checkIfElementIsDisplaying(by, 5l) ? DriverUtil.getDriver().findElements(by) : null;
    }
}
