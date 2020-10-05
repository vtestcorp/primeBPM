package listeners;

import base.baseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import helperMethods.screenshots;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/**
 * Created by manisha.jadhav on 12-02-2020.
 * In listeners
 */
public class RetryAnalyser implements IRetryAnalyzer {

    private int attemptCount = 0;
    private int retryLimit = 0;
    private String testName;
    public ExtentTest test1;

    /***
     *
     * This method decides how many times a test needs to be rerun.
     * TestNg will call this method every time a test fails. So we
     * can put some code in here to decide when to rerun the test.
     *
     * Note: This method will return true if a tests needs to be retried
     * and false if not.
     *
     */

    public boolean retry(ITestResult result) {
        String URL;

        System.out.println("retry failed test");
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((baseClass) currentClass).getDriver();
        //To Ignore Re-running Specified Tests
        this.testName = result.getMethod().getMethodName();
        for (int i = 0; i < retryLimit; i++) {
            int j = i++;
            try {
                ((baseClass) currentClass).test.createNode("Retry Analyser ", "Retrying the test cases" + j + "time").log(Status.FAIL, MarkupHelper.createLabel("Test cases retried" + j + "times ", ExtentColor.ORANGE)).addScreenCaptureFromPath(screenshots.retryTakeScreenshot(webDriver, this.testName));
            } catch (Exception e) {

            }
            if (attemptCount < retryLimit) {
                //      test1.createNode("retrying");
                ((baseClass) currentClass).extent.removeTest(((baseClass) currentClass).test);
                //   ((baseClass) currentClass).test.createNode(String.valueOf(test1));
                if (webDriver != null) {
                    URL = webDriver.getCurrentUrl();
                    if (URL.contains("https://tryenyotalms.com/beta/super/")) {
                        webDriver.get("https://tryenyotalms.com/beta/super/login/logout");
                    } else {
                        webDriver.get("https://automationdonotuse.tryenyotalms.com/beta/admin/logout");
                    }
                }
                attemptCount++;
                return true;
            }
        }
        return false;
    }
}