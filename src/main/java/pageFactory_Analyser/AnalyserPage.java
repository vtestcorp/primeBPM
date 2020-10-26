package pageFactory_Analyser;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.waitTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class AnalyserPage {
    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;


    public AnalyserPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new waitTypes(driver);
        this.test = test;
    }

    defineConstants constants = new defineConstants();
    SoftAssert verify = new SoftAssert();

    //Start of Analyser page element

    @FindBy(xpath = "//button[@title='Go To Analyser']")
    private WebElement goToApprovalBtn;

    @FindBy(xpath = "//span[contains(text(),'Value Analysis')]")
    private WebElement valueAnalysisTab;

    @FindBy(xpath = "//div[@id='frameworkMenu']//div[contains(@class,'analysisbtn')]")
    private WebElement analysisBtn;

    @FindBy(xpath = "//div[contains(@id,'highcharts')]//*[name()='g']")
    private WebElement analysisGraph;

    @FindBy(xpath = "//a[@ui-sref='myprocess']")
    public WebElement myProcessTab;

    @FindBy(xpath = "//a[contains(@ng-click,'generateLink')]")
    private List<WebElement> processeslist;

    @FindBy(xpath = "//span[@title='More']")
    public WebElement moreOptionBtn;

    //Start of Analyser page method
    public void verifyValueAnalysis() throws  Exception{
        Actions actions = new Actions(driver);
        String processName;
        applyWait.waitForElementToBeClickable(myProcessTab, 30).click();
        test.log(Status.INFO, "User click on MY PROCESSES option");
        Thread.sleep(2000);
        for (int i = 0; i < processeslist.size(); i++) {
            processName = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (processName.equals(constants.searchStringForInProgressProcess)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        applyWait.waitForElementToBeClickable(moreOptionBtn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(goToApprovalBtn,30).click();
        test.log(Status.INFO, "User click on MORE and select Go to Analyser option");
        Thread.sleep(3000);
        verify.assertTrue(driver.getCurrentUrl().contains("value_analysis"));
        test.log(Status.INFO,"Landing page on Analyser takes us to Value Analysis page");
        Thread.sleep(3000);
        actions.click(analysisBtn).perform();
        test.log(Status.INFO,"User click on 'Analysis' icon");
        Thread.sleep(3000);
        Assert.assertTrue(analysisGraph.isDisplayed());
    }

}
