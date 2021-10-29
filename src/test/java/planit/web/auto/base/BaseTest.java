package planit.web.auto.base;

import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import planit.web.auto.config.WebDriverManager;
import planit.web.auto.contstants.Constant;
import planit.web.auto.entities.TestDetails;
import planit.web.auto.utils.BasePageListener;
import planit.web.auto.utils.Log;
import planit.web.auto.utils.Utility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BaseTest {


    @BeforeMethod
    public void initialize (Method method) throws IOException {
        TestDetails.setTestCaseName(method.getName());
        Log.info(this, "Test Case Name: " + TestDetails.getTestCaseName());
        Log.info(this, "Initializing Browser");
        WebDriverManager.initializeBrowser();
        BasePageListener.goToURL(Utility.getProperty("url"));
    }


    @AfterMethod
    public void tearDown () {
        //if (result.getStatus() == ITestResult.FAILURE) {
        Utility.screenShot(TestDetails.getTestCaseName());
        //}
        WebDriverManager.closeBrowser();
        Log.info(this, "Successfully close browser");
    }

    @AfterTest
    public void closingDriver () {
        WebDriverManager.closeDriver();
        Log.info(this, "Successfully close driver");
    }
}
