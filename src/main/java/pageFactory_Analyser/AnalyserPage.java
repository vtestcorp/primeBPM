package pageFactory_Analyser;

import base.baseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.javafx.css.StyleCache;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.waitTypes;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
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
    dataGenerator produce = new dataGenerator();
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

    @FindBy(xpath = "//span[contains(@title,'More')]")
    private WebElement moreOptionBtn;

    @FindBy(xpath = "//button[contains(@class,'more')]")
    private WebElement moreOptionBtnOnSimulation;

    @FindBy(xpath = "//md-tab-item//span[contains(text(),'Time Analysis')]")
    private WebElement timeAnalysisTab;

    @FindBy(xpath = "//md-tab-item//span[contains(text(),'Simulate Analysis')]")
    private WebElement simulateAnalysisTab;

    @FindBy(xpath = "//highchart[contains(@data-title,'Annual Execution Time')]//*[name()='path']")
    private WebElement annualExecutionTimeGraphOnTimeAnalysis;

    @FindBy(xpath = "//highchart[contains(@data-title,'Annual Delay Time')]//*[name()='path']")
    private WebElement annaulDelayTimeGraphOnTimeAnalysis;

    @FindBy(xpath = "//div[contains(@id,'timeanalysisPanel')]//md-icon[@md-svg-src='dist/img/icons/ic_close.svg']")
    private WebElement closeBtnOnAnaysisPopup;

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

    @FindBy(xpath = "//md-icon[@md-svg-src='dist/img/icons/roundedplus.svg']")
    private WebElement createNewScenarioPlusIconOnSimulationTab;

    @FindBy(xpath = "//input[@ng-model='params.newScenario']")
    private WebElement nameFieldForNewScenario;

    @FindBy(xpath = "//button[contains(@ng-click,'createNewScenario')]")
    private WebElement submitBtnOnFormOfProcessMap;

    @FindBy(xpath = "//button[contains(@ng-click,'MapReportGen')]")
    private  WebElement submitBtnOnGenerateReport;

    @FindBy(xpath = "//*[name()='g' and contains(@data-element-id,'Task')]//*[name()='rect']")
    private WebElement TaskElement;

    @FindBy(xpath = "//div[@title='Delete']")
    private WebElement deleteOptionOnTask;

    @FindBy(xpath = "//span[contains(@ng-click,'Simulatecalc')]//md-icon[@md-svg-src='dist/img/icons/bpmn/save.svg']")
    private WebElement saveBtn;

    @FindBy(xpath = "//md-icon[@title='Simulation comparison']")
    private WebElement simulateComparisonBtn;

    @FindBy(xpath = "//highchart[@value='actionform.ValueAsProcess']//*[name()='rect']")
    private WebElement asIsProcessGraphForValueAnalysis;

    @FindBy(xpath = "//highchart[@value='valueSimulatedProcess']//*[name()='rect']")
    private WebElement simulateProcessGraphForValueAnalysis;

    @FindBy(xpath = "//span[contains(text(),'Execution Time')]")
    private WebElement executionTimeTabOnSimulateComparison;

    @FindBy(xpath = "//highchart[@value='actionform.ExeutionAsProcess']//*[name()='rect']")
    private WebElement asIsProcessGraphForExecutionTime;

    @FindBy(xpath = "//highchart[@value='execSimulatedProcess']//*[name()='rect']")
    private WebElement simulateProcessGraphForExecutionTime;

    @FindBy(xpath = "//span[contains(text(),'Delay Time')]")
    private WebElement delayTimeTabOnSimulationComparison;

    @FindBy(xpath = "//highchart[@value='actionform.DelayAsProcess']//*[name()='rect']")
    private WebElement asIsProcessGraphForDelayTime;

    @FindBy(xpath = "//highchart[@value='delaySimulatedProcess']//*[name()='rect']")
    private WebElement simulateProcessGraphForDelayTime;

    @FindBy(xpath = "//span[contains(text(),'Cost')]")
    private WebElement costTabSimulateComparison;

    @FindBy(xpath = "//highchart[@value='actionform.costAsProcess']//*[name()='rect']")
    private WebElement asIsProcessGraphForCostAnalysis;

    @FindBy(xpath = "//highchart[@value='costSimulatedProcess']//*[name()='rect']")
    private WebElement simulateProcessGraphForCostAnalysis;

    @FindBy(xpath = "//span[contains(text(),'Process Efficiency')]")
    private WebElement processEfficiencyTabOnSimuateComparison;

    @FindBy(xpath = "//highchart[@data-title='Process Cycle Efficiency']//*[name()='rect']")
    private WebElement asIsProcessGraphForProcessEfficiency;

    @FindBy(xpath = "//highchart[@value='ProcessSimulatedProcess']//*[name()='rect']")
    private WebElement simulateProcessGraphForProcessEfficiency;

    @FindBy(xpath = "//md-icon[contains(@title,'Simualte Analysis')]")
    private WebElement simulateAnalysisIconOnSimulateComparisonTab;

    @FindBy(xpath = "//span[contains(text(),'Changes')]")
    private WebElement changesBtn;

    @FindBy(xpath = "//input[@ng-model='arg.changes_done']")
    private WebElement nameFieldOnSuggestChangesPopup;

    @FindBy(xpath = "//input[@ng-model='arg.cost_change']")
    private WebElement costFieldOnSuggestChangesPopup;

    @FindBy(xpath = "//input[@ng-model='arg.duration_change']")
    private WebElement implementationFieldOnSuggestChangesPopup;

    @FindBy(xpath = "//md-select-value[contains(@id,'select_value_label')]//span[contains(text(),'Week')]")
    private WebElement duartionWeekDropDown;

    @FindBy(xpath = "//span[text()='Add Change']")
    private WebElement addChangesBtn;

    @FindBy(xpath = "//tr//td//span[@id='changes_text']")
    private WebElement saveChanagesTextRow;

    @FindBy(xpath = "//button[contains(@ng-click,'answer')]//md-icon[@aria-label='Close dialog']")
    private WebElement closeBtnOnSuggestChangesPopup;

    @FindBy(xpath = "//button[contains(@ng-click,'callbackClose')]//md-icon[@aria-label='Close dialog']")
    private WebElement closeBtnOnGenerateReportPopup;

    @FindBy(xpath = "//span[contains(text(),'Check In')]")
    private WebElement checkInBtnOnMoreOptionSection;

    @FindBy(xpath = "//button[contains(@class,'Yes')]")
    private WebElement yesBtnOnConfirmationPopup;

    @FindBy(xpath = "//span[contains(text(),'Check Out')]")
    private WebElement checkOutBtnOnMoreOptionSection;

    @FindBy(xpath = "//button[@title='Generate Report']//span")
    private WebElement generateReportOnAnalysis;

    @FindBy(xpath = "//button[@title='Convert to AS-IS']//span")
    private WebElement convertToAsIsOption;

    @FindBy(xpath = "//input[@id='version']")
    private WebElement versionAfterPublished;

    @FindBy(xpath = "//span[contains(@ng-show,'params.organisation')]")
    private WebElement versionNumber;

    @FindBy(xpath = "//md-select[@ng-model='mapReport.DownloadType']")
    private WebElement downloadAsTypeDropdown;

    @FindBy(xpath = "//md-option//div[contains(text(),'Word')]")
    private WebElement wordTypeOptionOfDownloadAsDrpdwn;

    @FindBy(xpath = "//md-option//div[contains(text(),'PDF')]")
    private WebElement pdfTypeOptionOfDownloadAsDrpdwn;

    @FindBy(xpath = "//md-checkbox")
    private List<WebElement> checkboxesOnGenerateReport;

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
        applyWait.waitForElementToBeClickable(closeBtnOnAnaysisPopup,30).click();
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

        applyWait.waitForElementToBeClickable(closeBtnOnAnaysisPopup,30).click();
        Select selectCostDropDown = new Select(costDropDown);
        selectCostDropDown.selectByVisibleText("Cost per Occurrence");
        test.log(Status.INFO,"From drop down list, select 'Cost per Occurrence' and notice results");
        Assert.assertTrue(amountLableBewlowTaskBox.isDisplayed());
        test.log(Status.INFO,"Verify if Task analysis (underneath tasks) displays results");

    }

    /**
     * Verify given file exits from a specific directory with extension
     * @param dirPath: file directory path
     * @param fileWithExt: file name with extension
     */
    public boolean isFileDownloaded_Ext(String dirPath, String fileWithExt){
        boolean flag=false;
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }
        for (int i = 0; i < files.length; i++) {
            if(files[i].getName().contains(fileWithExt)) {
                System.out.println("filename :"+ files[i].getName());
                flag=true;
            }
        }
        return flag;
    }

    public void selectAllCheckboxesOnGenerateReport() throws Exception{
        for (int indexOfCheckboxes=0; indexOfCheckboxes<checkboxesOnGenerateReport.size();indexOfCheckboxes++){
            applyWait.waitForElementToBeClickable(checkboxesOnGenerateReport.get(indexOfCheckboxes),30).click();
            Thread.sleep(3000);
        }
    }

    public void verifySimulationAnalysis() throws Exception{
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
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(moreOptionBtn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(goToAnalyserBtn,30).click();
        test.log(Status.INFO, "User click on MORE and select Go to Analyser option");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(simulateAnalysisTab,40).click();
        test.log(Status.INFO,"user click on Cost Analysis option ");
        verify.assertTrue(driver.getCurrentUrl().contains("createscenario"));
        test.log(Status.INFO,"Landing page on Analyser takes us to simulate Analysis page");
        applyWait.waitForElementToBeClickable(createNewScenarioPlusIconOnSimulationTab,30).click();
        test.log(Status.INFO,"User click New Scenario (+) icon");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(nameFieldForNewScenario,30).sendKeys("test" + produce.generateRandomString());
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"User provide a Scenario name and hit SUBMIT");
        Thread.sleep(9000);
        actions.click(TaskElement).perform();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(deleteOptionOnTask,30).click();
        Thread.sleep(3000);
        test.log(Status.INFO,"User delete one Non Value Added Task and click SAVE");
        Thread.sleep(5000);
        applyWait.waitForElementToBeClickable(simulateComparisonBtn,30).click();
        test.log(Status.INFO,"User click on Simulation Comparison Tab");
        Assert.assertTrue(asIsProcessGraphForValueAnalysis.isDisplayed());
        Assert.assertTrue(simulateProcessGraphForValueAnalysis.isDisplayed());
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(executionTimeTabOnSimulateComparison,30).click();
        Assert.assertTrue(asIsProcessGraphForExecutionTime.isDisplayed());
        Assert.assertTrue(simulateProcessGraphForExecutionTime.isDisplayed());
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(delayTimeTabOnSimulationComparison,30).click();
        Assert.assertTrue(asIsProcessGraphForDelayTime.isDisplayed());
        Assert.assertTrue(simulateProcessGraphForDelayTime.isDisplayed());
        Thread.sleep(4000);
        applyWait.waitForElementToBeClickable(costTabSimulateComparison,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(yesBtnOnConfirmationPopup,30).click();
        Thread.sleep(9000);
        verify.assertTrue(asIsProcessGraphForCostAnalysis.isDisplayed());
        verify.assertTrue(simulateProcessGraphForCostAnalysis.isDisplayed());
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(processEfficiencyTabOnSimuateComparison,30).click();
        Thread.sleep(3000);
        verify.assertTrue(asIsProcessGraphForProcessEfficiency.isDisplayed());
        verify.assertTrue(simulateProcessGraphForProcessEfficiency.isDisplayed());
        test.log(Status.INFO,"Verify AS-IS and TO-Be comparison in Value, Time, Cost pages");
        applyWait.waitForElementToBeClickable(simulateAnalysisIconOnSimulateComparisonTab,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(yesBtnOnConfirmationPopup,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(closeBtnOnGenerateReportPopup,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(changesBtn,30).click();
        Thread.sleep(3000);
        test.log(Status.INFO,"User come back to 'Simulate Analysis' page and click on 'Changes' section");
        applyWait.waitForElementToBeClickable(nameFieldOnSuggestChangesPopup,30).sendKeys("Introduce a New HRMS System");
        test.log(Status.INFO,"Enter a Change name - 'Introduce a New HRMS System'");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(costFieldOnSuggestChangesPopup,30).sendKeys("2000");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(implementationFieldOnSuggestChangesPopup,30).sendKeys("6");
        Thread.sleep(3000);
        actions.moveToElement(closeBtnOnSuggestChangesPopup).perform();
        applyWait.waitForElementToBeClickable(addChangesBtn,30).click();
        test.log(Status.INFO,"Provide cost as '2000', Implementation duration as '6' and Duration Unit as 'Weeks' & hit Submit");
        Thread.sleep(3000);
        Assert.assertTrue(saveChanagesTextRow.isDisplayed());
        test.log(Status.INFO,"Verify if change gets registered successfully");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(closeBtnOnSuggestChangesPopup,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(moreOptionBtnOnSimulation,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(checkInBtnOnMoreOptionSection,30).click();
        Thread.sleep(2000);
        applyWait.waitForElementToBeClickable(yesBtnOnConfirmationPopup,30).click();
        test.log(Status.INFO,"Click on MORE section and select CHECK IN and click YES");
        Thread.sleep(9000);
        actions.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(moreOptionBtnOnSimulation,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(checkOutBtnOnMoreOptionSection,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(yesBtnOnConfirmationPopup,30).click();
        test.log(Status.INFO,"Click on MORE section. select CHECK OUT and click YES");
        Thread.sleep(3000);
        actions.sendKeys(Keys.ESCAPE).perform();
        applyWait.waitForElementToBeClickable(moreOptionBtnOnSimulation,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(generateReportOnAnalysis,30).click();
        Thread.sleep(9000);
        selectAllCheckboxesOnGenerateReport();
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(wordTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(10000);
        applyWait.waitForElementToBeClickable(submitBtnOnGenerateReport,90).click();
        Thread.sleep(9000);
        Assert.assertTrue(isFileDownloaded_Ext(baseClass.DownloadFilepath, "SIMULATION.docx"), "Failed to download Expected document");
        Thread.sleep(9000);
        actions.sendKeys(Keys.ESCAPE).perform();
        applyWait.waitForElementToBeClickable(moreOptionBtnOnSimulation,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(generateReportOnAnalysis,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(pdfTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(submitBtnOnGenerateReport,30).click();
        Thread.sleep(5000);
        test.log(Status.INFO," Click MORE section again; and select GENERATE REPORT option; select download as WORD and PDF and measure results");
        Thread.sleep(9000);
        driver.switchTo().defaultContent();
        Thread.sleep(9000);
        actions.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(3000);
        actions.click(moreOptionBtnOnSimulation).perform();
        Thread.sleep(3000);
        String versionBeforeConversion = versionNumber.getText();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(convertToAsIsOption,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(yesBtnOnConfirmationPopup,30).click();
        Thread.sleep(3000);
        test.log(Status.INFO,"Click on MORE section again and select CONVERT to AS IS and press YES");
        verify.assertTrue(versionBeforeConversion.compareTo(constants.versionChangedNumber) != 0);
    }
}
