package planit.web.auto.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import planit.web.auto.config.DriverUtil;
import planit.web.auto.entities.TestDetails;
import planit.web.auto.utils.BasePageListener;
import planit.web.auto.utils.Log;
import planit.web.auto.utils.Utility;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {


    @BeforeMethod
    public void initialize (Method method) throws IOException {
        TestDetails.setTestCaseName(method.getName());
        Log.info(this, "Test Case Name: " + TestDetails.getTestCaseName());
        Log.info(this, "Initializing Browser");
        DriverUtil.initializeBrowser();
        BasePageListener.goToURL(Utility.getProperty("url"));
    }


    @AfterMethod
    public void tearDown () {
        //if (result.getStatus() == ITestResult.FAILURE) {
        Utility.screenShot(TestDetails.getTestCaseName());
        //}
        DriverUtil.closeBrowser();
        Log.info(this, "Successfully close browser");
    }

    @AfterTest
    public void closingDriver () {
        DriverUtil.closeDriver();
        Log.info(this, "Successfully close driver");
    }
}
