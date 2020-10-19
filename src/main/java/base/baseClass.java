package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import config.defineProperties;
import config.extentReports;
import helperMethods.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;


public class baseClass {
    public static String atest = "";
    public String space = "", hypen = "";
    int invalidLinksCount = 0;
    int invalidImageCount = 0;
    public WebDriver driver;
    public ExtentTest test;
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static String DownloadFilepath, folder, basefold;
    public static int count, Passcount, FailedCount;
    public static String Report_Path = null;
    public String Report_Timestamp;
/*
    @BeforeSuite
    public void setUp() {
        try {
            // Initialize Extent Report required static fields.

            Report_Timestamp = "Extent_Report" + (LocalDateTime.now()).getHour() + "_"
                    + (LocalDateTime.now()).getMinute() + "_" + (LocalDateTime.now()).getSecond();

            Report_Path = System.getProperty("user.dir") + "\\Report\\" + Report_Timestamp;
            System.out.println("ReportPath = "+Report_Path);
            File f1 = new File(Report_Path);
            f1.mkdir();
            File F2 = new File(Report_Path + "\\" + "Snapshot");
            F2.mkdir();
            System.out.println(F2);
            htmlReporter = extentReports.createInstance(Report_Path + "\\ExtentReport" + "_" + Report_Timestamp + ".html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Selenium Version", "3");
            extent.setSystemInfo("Environment", "Testing");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Parameters({"browserType"})
    @BeforeClass
    public void setUp(String browser) throws Exception {
        int i = 0;
        while (i < 45) {
            space += " ";

            hypen += "-";

            i++;
        }
        count += 1;

        Thread.sleep(1000);
        if (browser.equalsIgnoreCase("chrome")) {
            // defineProperties defineBrowser = new defineProperties(browser);
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
           *//* options.addArguments("excludeSwitches","ignore-certificate-errors");
            options.addArguments("headless");
            options.addArguments("window-size=0x0");
            options.addArguments("disable-infobars");*//*
            options.addArguments("--start-maximized");
            options.addArguments("window-size=1280,1024");
            String path = System.getProperty("user.dir");
            DownloadFilepath = path + "\\Test_Data\\Download";
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", DownloadFilepath);
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            defineProperties defineBrowser = new defineProperties(browser);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("internetexplorer")) {
            defineProperties defineBrowser = new defineProperties(browser);
            driver = new InternetExplorerDriver(defineBrowser.setIECapability());
            driver.manage().window().maximize();
            //   driver = new RemoteWebDriver(new URL(url), defineBrowser.SauceLabCapabilities());
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = Report_Path + "\\Snapshot\\" + fileName + dateName + ".png";

        File finalDestination = new File(destination);

        System.out.println("des= " + destination);
        Files.copy(source, finalDestination);
        return destination;
    }

    @AfterMethod(timeOut = 10000L, alwaysRun = true)
    public void checkResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            atest += "    " + FailedCount + "     " + result.getTestClass().getName() + "." + result.getName() + " - Failed\n";
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case FAILED", ExtentColor.RED));
            String screenshotPath = takeScreenshot(getDriver(), result.getName());
            System.out.println("Test = "+screenshotPath);
            test.log(Status.FAIL, "Screenshot from : " + screenshotPath, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            atest += "    " + Passcount + "     " + result.getTestClass().getName() + "." + result.getName() + " - Passed\n";
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            atest += "    " + count + "     " + result.getTestClass().getName() + "." + result.getName() + " - Skipped\n";
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.YELLOW));
        }

    }

    @AfterClass
    public void tearDown() throws IOException {
        getDriver().quit();
        extent.flush();

    }

    @AfterSuite
    public void afterSuite(ITestContext context) {
        printSuiteResults(context.getSuite());
    }

    private void printSuiteResults(ISuite suite) {
        Collection<ISuiteResult> suiteResults = suite.getResults().values();
        for (ISuiteResult suiteResult : suiteResults) {
            printAllResults(suiteResult.getTestContext());
        }
    }

    private void printAllResults(ITestContext context) {
        int passcount, failedCount, skipcount;
        System.err.println("Printing tests that passed.");
        printAllResults(context.getPassedTests().getAllResults());
        passcount = context.getPassedTests().getAllResults().size();
        System.err.println("Printing tests that failed.");
        printAllResults(context.getFailedTests().getAllResults());
        failedCount = context.getFailedTests().getAllResults().size();
        printAllResults(context.getSkippedTests().getAllResults());
        skipcount = context.getSkippedTests().getAllResults().size();
        zip(passcount, failedCount, skipcount);
    }

    private void printAllResults(Collection<ITestResult> results) {
        for (ITestResult result : results) {
            printResult(result);
        }
    }

    private void printResult(ITestResult result) {
        //   System.out.println(result.getStatus());
        // zip(result.getStatus());
    }

    public void zip(int Status, int failedCount, int skipcount) {

        try {
            ZipUtil.pack(new File(".//Report//" + Report_Timestamp + "//"), new File(".//Report.zip"));
            SendMailForFailedScenarios.SendMail(count, Status, failedCount, skipcount, hypen, space, atest);
            slackMessage slackMsg = slackMessage.builder().username("user")
                    .text("Hi,\nExecution status for test cases-\n\n" + hypen + hypen + hypen + "\n"
                            + hypen + hypen + hypen + "\n" + "Total test cases = " + count
                            + "\n\n" + "Pass Test cases = " + Status + "\n\n" + "Failed Test cases = " + failedCount + "\n\n" + "Skip Test cases = " + skipcount + "\n\n" + hypen + hypen + hypen + "\n\n Please check Email for complete report and sample test data, Thanks")
                    .icon_emoji(":zap:").build();
            slackUtils.sendMessage(slackMsg, System.getProperty("user.dir") + "\\report\\extent.html");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

    @Parameters({"browserType"})

    @BeforeClass
    public void setUp(String browser) throws Exception {
        int i = 0;
        while (i < 45) {
            space += " ";

            hypen += "-";

            i++;
        }
        count += 1;
        htmlReporter = extentReports.createInstance("report/extent.html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        Thread.sleep(1000);
        if (browser.equalsIgnoreCase("chrome")) {
            defineProperties defineBrowser = new defineProperties(browser);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
           // options.addArguments("--start-maximized");
            options.addArguments("window-size=1024,768");
            String path = System.getProperty("user.dir");
            DownloadFilepath = path + "\\Test_Data\\Download";
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", DownloadFilepath);
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            defineProperties defineBrowser = new defineProperties(browser);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("internetexplorer")) {
            defineProperties defineBrowser = new defineProperties(browser);
            driver = new InternetExplorerDriver(defineBrowser.setIECapability());
            driver.manage().window().maximize();
            //   driver = new RemoteWebDriver(new URL(url), defineBrowser.SauceLabCapabilities());
        }
        extent.setSystemInfo("Selenium Version", "3");
        extent.setSystemInfo("Environment", "Testing");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod(timeOut = 10000L, alwaysRun = true)
    public void checkResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case FAILED", ExtentColor.RED));
            test.fail(result.getThrowable());
            test.addScreenCaptureFromPath(screenshots.takeScreenshot(driver, result.getMethod().getMethodName()));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.YELLOW));
        }
        extent.flush();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @AfterSuite
    public void afterSuite(ITestContext context) {
        printSuiteResults(context.getSuite());
    }

    private void printSuiteResults(ISuite suite) {
        Collection<ISuiteResult> suiteResults = suite.getResults().values();
        for (ISuiteResult suiteResult : suiteResults) {
            printAllResults(suiteResult.getTestContext());
        }
    }

    private void printAllResults(ITestContext context) {
        int passcount, failedCount, skipcount;
        System.err.println("Printing tests that passed.");
        printAllResults(context.getPassedTests().getAllResults());
        passcount = context.getPassedTests().getAllResults().size();
        System.err.println("Printing tests that failed.");
        printAllResults(context.getFailedTests().getAllResults());
        failedCount = context.getFailedTests().getAllResults().size();
        printAllResults(context.getSkippedTests().getAllResults());
        skipcount = context.getSkippedTests().getAllResults().size();
        zip(passcount, failedCount, skipcount);
    }

    private void printAllResults(Collection<ITestResult> results) {
        for (ITestResult result : results) {
            printResult(result);
        }
    }

    private void printResult(ITestResult result) {
        //   System.out.println(result.getStatus());
        // zip(result.getStatus());
    }

    public void zip(int Status, int failedCount, int skipcount) {
        try {
            zipUtil createZip = new zipUtil("report", ".//report//DetailedReport.zip");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}