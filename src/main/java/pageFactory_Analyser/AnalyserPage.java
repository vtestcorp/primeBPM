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
import org.openqa.selenium.support.ui.Select;
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
    private WebElement goToAnalyserBtn;

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
    private WebElement moreOptionBtn;

    @FindBy(xpath = "//md-tab-item//span[contains(text(),'Time Analysis')]")
    private WebElement timeAnalysisTab;

    @FindBy(xpath = "//highchart[contains(@data-title,'Annual Execution Time')]//*[name()='path']")
    private WebElement annualExecutionTimeGraphOnTimeAnalysis;

    @FindBy(xpath = "//highchart[contains(@data-title,'Annual Delay Time')]//*[name()='path']")
    private WebElement annaulDelayTimeGraphOnTimeAnalysis;

    @FindBy(xpath = "//md-select[contains(@ng-model,'totalTipType')]")
    private WebElement timeFilterGraphDropDown;

    @FindBy(xpath = "//div[contains(text(),' Delay Time per Annum')]")
    private WebElement selectDelayTimePerAnnumOptionFromDropDown;

    @FindBy(xpath = "//div[@class='analyticalToolTip DTA']")
    private WebElement DTAOnTaskAtTaskAnalysis;

    @FindBy(xpath = "//md-tab-item//span[contains(text(),'Cost Analysis')]")
    private WebElement costAnalysisTab;

    @FindBy(xpath = "//highchart[contains(@data-title,'Annual Execution Cost')]//*[name()='path']")
    private WebElement annaulExecutionCostGraphOnCostAnalysis;

    @FindBy(xpath = "//select[contains(@ng-model,'totalTipType')]")
    private WebElement costDropDown;

    @FindBy(xpath = "//div[@class='analyticalToolTip OEC']")
    private WebElement amountLableBewlowTaskBox;

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
        applyWait.waitForElementToBeClickable(goToAnalyserBtn,30).click();
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

    public void verifyTimeAnalysis() throws  Exception {
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
        applyWait.waitForElementToBeClickable(goToAnalyserBtn,30).click();
        test.log(Status.INFO, "User click on MORE and select Go to Analyser option");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(timeAnalysisTab,40).click();
        test.log(Status.INFO,"user click on Time Analysis option ");
        verify.assertTrue(driver.getCurrentUrl().contains("time_framework_analysis"));
        test.log(Status.INFO,"Landing page on Analyser takes us to Time Analysis page");
        Thread.sleep(3000);
        actions.click(analysisBtn).perform();
        test.log(Status.INFO,"User click on 'Analysis' icon");
        Thread.sleep(3000);
        Assert.assertTrue(annualExecutionTimeGraphOnTimeAnalysis.isDisplayed());
        Assert.assertTrue(annaulDelayTimeGraphOnTimeAnalysis.isDisplayed());
        test.log(Status.INFO,"Verify if analysis appears as added in designer section");
        applyWait.waitForElementToBeClickable(timeFilterGraphDropDown,30).click();
        applyWait.waitForElementToBeClickable(selectDelayTimePerAnnumOptionFromDropDown,30).click();
        test.log(Status.INFO,"From drop down list, select 'Delay Time Per Annum' and notice results");
        Assert.assertTrue(DTAOnTaskAtTaskAnalysis.isDisplayed());
        test.log(Status.INFO,"Verify if Task analysis (underneath tasks) displays results");
    }

    public void verifyCostAnalysis() throws Exception {
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
        applyWait.waitForElementToBeClickable(goToAnalyserBtn,30).click();
        test.log(Status.INFO, "User click on MORE and select Go to Analyser option");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(costAnalysisTab,40).click();
        test.log(Status.INFO,"user click on Cost Analysis option ");
        verify.assertTrue(driver.getCurrentUrl().contains("cost_framework_analysis"));
        test.log(Status.INFO,"Landing page on Analyser takes us to Time Analysis page");
        Thread.sleep(3000);
        actions.click(analysisBtn).perform();
        test.log(Status.INFO,"User click on 'Analysis' icon");
        Thread.sleep(3000);
        Assert.assertTrue(annaulExecutionCostGraphOnCostAnalysis.isDisplayed());
        test.log(Status.INFO,"Verify if analysis appears as added in designer section");
        Select selectCostDropDown = new Select(costDropDown);
        selectCostDropDown.selectByVisibleText("Cost per Occurrence");
        test.log(Status.INFO,"From drop down list, select 'Cost per Occurrence' and notice results");
        Assert.assertTrue(amountLableBewlowTaskBox.isDisplayed());
        test.log(Status.INFO,"Verify if Task analysis (underneath tasks) displays results");

    }
}
