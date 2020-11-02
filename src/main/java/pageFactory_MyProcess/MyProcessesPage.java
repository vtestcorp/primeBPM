package pageFactory_MyProcess;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.screenshots;
import helperMethods.scrollTypes;
import helperMethods.waitTypes;

import java.awt.Robot;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageFactory_Common.CommonLocators;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MyProcessesPage {
    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;


    public MyProcessesPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new waitTypes(driver);
        this.test = test;
    }

    CommonLocators commonLocators = new CommonLocators();
    screenshots screenshot = new screenshots();
    defineConstants constants = new defineConstants();
    dataGenerator produce = new dataGenerator();
    SoftAssert verify = new SoftAssert();

    //Start of My Processes page element//
    @FindBy(xpath = "//a[@ui-sref='myprocess']")
    private WebElement myProcessTab;

    @FindBy(xpath = "//*[@id=\"content\"]/div/section/md-content/div/div/div/div[2]/table/tbody/tr[1]/td[2]/div")
    private WebElement selectProcessFromMyProcessList;                  //Change with unique id

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement addedProcedureOnTaskElement;

    @FindBy(xpath = "//a[contains(@ng-click,'generateLink')]")
    private List<WebElement> processeslist;

    @FindBy(xpath = "//span[@ng-model='checkOut']")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//span[@ng-model='checkIn']")
    public WebElement checkinBtn;

    @FindBy(xpath = "//button[contains(@class,'Yes')]//span")
    public WebElement yesConfirmationPopup;

    @FindBy(xpath = "//*[name()='g' and contains(@data-element-id,'Task')]//*[name()='rect']")
    public WebElement processBox;

    @FindBy(xpath = "//textarea[@class='tox-textarea']")
    public WebElement procedureTextareaField;

    @FindBy(xpath = "//html//body[@id='tinymce']")
    private WebElement procedureDescription;

    @FindBy(xpath = "//div[@title='Add/Edit Procedure']")
    public WebElement addEditProcedureOnTaskElement;

    @FindBy(xpath = "//div[@title='View Procedure']")
    private WebElement viewProcedure;

    @FindBy(xpath = "//div[contains(@class,'dispaly-block')]//span[contains(text(),'Submit')]")
    public WebElement submitBtnOnForm;

    @FindBy(xpath = "//button[@title='More...']")
    private WebElement moreOption;

    @FindBy(xpath = "//button[@title='Insert/edit image']")
    private WebElement imageOption;

    @FindBy(xpath = "//div//div[text()='Upload']")
    private WebElement uploadOption;

    @FindBy(xpath = "//div[@class='tox-dropzone']//input[@type='file']")
    private WebElement uploadFileBtn;

    @FindBy(xpath = "//span[contains(text(),'Procedure')]")
    private WebElement procedureTab;

    @FindBy(xpath = "//body[@id='tinymce']//p")
    private WebElement textArea;

    @FindBy(xpath = "//span[contains(text(),'Save Procedure')]")
    private WebElement saveProcedure;

    @FindBy(xpath = "//div[@id='dragger-parent']")
    private WebElement parentTask;

    @FindBy(xpath = "//div[@title='Task Attributes']")
    private WebElement taskAttribute;

    @FindBy(xpath = "//md-select[contains(@ng-model,'processMapTask.Accountable')]")
    private WebElement accountable;

    @FindBy(xpath = "//md-option[contains(@ng-value,'user.id')][1]")
    private WebElement accountableValue;

    @FindBy(xpath = "//md-select[contains(@ng-model,'processMapTask.Consulted')]")
    private WebElement consulated;

    @FindBy(xpath = "//md-select[contains(@ng-model,'processMapTask.Informed')]")
    private WebElement informed;

    @FindBy(xpath = "//div[@class='md-thumb']//following::span[contains(text(),'Apply this RACI to all task')]")
    private WebElement raci;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement volume;

    @FindBy(xpath = "//md-select[contains(@ng-model,'processMapTask.Frequency')]")
    private WebElement frequency;

    @FindBy(xpath = "//div[@class='md-thumb']//following::span[contains(text(),'Apply this Volume and Frequency to all tasks')]")
    private WebElement applyFrequency;

    @FindBy(xpath = "//md-option[@value='1']")
    private WebElement frequencyValue;

    @FindBy(xpath = "//input[contains(@ng-model,'processMapTask.ExecutionTime')]")
    private WebElement exeTime;

    @FindBy(xpath = "//input[contains(@ng-model,'processMapTask.DelayedTime')]")
    private WebElement delayTime;

    @FindBy(xpath = "//md-select[contains(@ng-model,'processMapTask.ExecutionUnit')]")
    private WebElement exeValue;

    @FindBy(xpath = "//md-select[contains(@ng-model,'processMapTask.DelayedUnit')]")
    private WebElement delayValue;

    @FindBy(xpath = "//input[@ng-model='processtaskattrib.Volume']")
    private WebElement volume1;

    @FindBy(xpath = "//md-select[@ng-model='processtaskattrib.Frequency']")
    private WebElement frequence1;

    @FindBy(xpath = "//input[contains(@ng-model,'processtaskattrib.ExecutionTime')]")
    private WebElement exetime1;

    @FindBy(xpath = "//input[contains(@ng-model,'processtaskattrib.DelayedTime')]")
    private WebElement delayTime1;

    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    private WebElement submitTaskAttr;

    @FindBy(xpath = "//span[contains(text(),'Task Attributes')]")
    private WebElement taskAttriTab;

    @FindBy(xpath = "//md-select[contains(@ng-model,'processtaskattrib.ExecutionUnit')]")
    private WebElement exeValue1;

    @FindBy(xpath = "//md-select[contains(@ng-model,'processtaskattrib.DelayedUnit')]")
    private WebElement delayValue1;
    //End of My Processes element page//


    //Start of method of My Processes page//

    public void clickOnMyProcessesOption() {
        applyWait.waitForElementToBeClickable(myProcessTab, 30).click();
        test.log(Status.INFO, "User click on MY PROCESSES option");
    }

    public void clickOnInProgressProcessMapFromList() {
        applyWait.waitForElementToBeClickable(selectProcessFromMyProcessList, 30).click();
        test.log(Status.INFO, "User click on an IN PROGRESS process map name");
    }

    public void clickOnCheckInBtn() {
        boolean visibilityOfCheckInBtn = applyWait.waitForElementToBeClickable(checkinBtn, 30).isDisplayed();
        if (visibilityOfCheckInBtn == true) {
            applyWait.waitForElementToBeClickable(checkinBtn, 30).click();
            test.log(Status.INFO, "User click on Check In button on Process Map page");

            applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
            test.log(Status.INFO, "User click on Yes button on confirmation popup");
        }
        verify.assertEquals(constants.checkInSuccessMsg, commonLocators.toastMsgs);
    }

    public void clickOnTaskElement() {
        Actions actions = new Actions(driver);
        actions.click(processBox).perform();
        test.log(Status.INFO, "User click on task box element");
    }

    public void clickOnViewProcedureOptionOnTaskElement() {
        applyWait.waitForElementToBeClickable(viewProcedure, 30).click();
        test.log(Status.INFO, "User click on add/edit procedure option on Task element");
    }

    public void clickOnAddEditProcedureOptionOnTaskElement() {
        applyWait.waitForElementToBeClickable(addEditProcedureOnTaskElement, 30).click();
        test.log(Status.INFO, "User click on add/edit procedure option on Task element");
    }

    public void clickOnTaskAttributeTab() {
        applyWait.waitForElementToBeClickable(taskAttriTab, 30).click();
        test.log(Status.INFO, "User click on task attribute tab");
    }

    public String getValoumeValue() {
        return applyWait.waitForElementToBeClickable(volume1, 30).getText();
    }

    public void addInfoOnProcedureForEditTask() throws Exception {
        applyWait.waitForElementToBeClickable(procedureDescription, 30).sendKeys(produce.generateRandomString());
        test.log(Status.INFO, "User type procedure info random text");

        Actions builder = new Actions(driver);
        Thread.sleep(3000);
        builder.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        Robot actions = new Robot();
        actions.keyPress(KeyEvent.VK_PRINTSCREEN);
        actions.keyRelease(KeyEvent.VK_PRINTSCREEN);
        Thread.sleep(5000);
        actions.keyPress(KeyEvent.VK_CONTROL);
        actions.keyPress(KeyEvent.VK_A);
        Thread.sleep(5000);
        actions.keyPress(KeyEvent.VK_CONTROL);
        actions.keyPress(KeyEvent.VK_C);
        Thread.sleep(5000);
        actions.keyPress(KeyEvent.VK_CONTROL);
        actions.keyPress(KeyEvent.VK_V);
        actions.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(7000);
        test.log(Status.INFO, "User takes screenshot and paste to procedure text area");
    }

    public void clickOnSubmitBtn() {
        Actions actions = new Actions(driver);
        driver.switchTo().defaultContent();
        actions.moveToElement(submitBtnOnForm).perform();
        actions.click(submitBtnOnForm).perform();
        test.log(Status.INFO, "User click on Submit button");
    }

    public void clickOnProcedureTab() {
        applyWait.waitforElementToBeDisplayed(procedureTab, 30).click();
        test.log(Status.INFO, "user click on procedure tab");
    }

    public void clickOnSaveProcedure() {
        scrollTypes scroll = new scrollTypes(driver);
        scroll.scrollInToView(saveProcedure);
        applyWait.waitforElementToBeDisplayed(saveProcedure, 30).click();
        test.log(Status.INFO, "user click on save procedure");
    }

    public void clickOnParentTask() {
        applyWait.waitforElementToBeDisplayed(parentTask, 30).click();
        test.log(Status.INFO, "User click on parent task");
    }

    public void clickOnTaskAttribute() {
        applyWait.waitforElementToBeDisplayed(taskAttribute, 30).click();
        test.log(Status.INFO, "User click on task attribute");
    }

    public void clickOnAccountable() {
        applyWait.waitforElementToBeDisplayed(accountable, 30).click();
        test.log(Status.INFO, "User click on accountable dropdown");
    }

    public void clickOnAccountableValue() {
        applyWait.waitforElementToBeDisplayed(accountableValue, 30).click();
        test.log(Status.INFO, "User select value frome accountable dropdown");
    }

    public void clickOnConsulaed() {
        applyWait.waitforElementToBeDisplayed(consulated, 30).click();
        test.log(Status.INFO, "User click on consulated dropdown");
    }

    public void clickOnInformed() {
        applyWait.waitforElementToBeDisplayed(informed, 30).click();
        test.log(Status.INFO, "User click on informed dropdown");
    }

    public void clickOnRACI() {
        applyWait.waitforElementToBeDisplayed(raci, 30).click();
        test.log(Status.INFO, "User click on RACI");
    }

    public void fillVolume() {
        applyWait.waitforElementToBeDisplayed(volume, 30).clear();
        applyWait.waitforElementToBeDisplayed(volume, 30).sendKeys("10");
        test.log(Status.INFO, "User enter volume");
    }

    public void clickOnFrequence() {
        applyWait.waitforElementToBeDisplayed(frequency, 30).click();
        test.log(Status.INFO, "User click on frequence");
    }

    public void clickOnApplyFrequence() {
        applyWait.waitforElementToBeDisplayed(applyFrequency, 30).click();
        test.log(Status.INFO, "User click on Apply frequence");
    }

    public void clickOnFrequenceValue() {
        applyWait.waitforElementToBeDisplayed(frequencyValue, 30).click();
        test.log(Status.INFO, "User click on Hours frequence");
    }

    public void fillExecutionTime() {
        applyWait.waitforElementToBeDisplayed(exeTime, 30).clear();
        applyWait.waitforElementToBeDisplayed(exeTime, 30).sendKeys("10");
        test.log(Status.INFO, "User enter execution time");
    }

    public void fillDelayTime() {
        applyWait.waitforElementToBeDisplayed(delayTime, 30).clear();
        applyWait.waitforElementToBeDisplayed(delayTime, 30).sendKeys("10");
        test.log(Status.INFO, "User enter delay time");
    }

    public void clickOnExecutionValue() {
        applyWait.waitforElementToBeDisplayed(exeValue, 30).click();
        test.log(Status.INFO, "User select value from execution dropdown");
    }

    public void clickOnDelayValue() {
        applyWait.waitforElementToBeDisplayed(delayValue, 30).click();
        test.log(Status.INFO, "User select value from delay dropdown");
    }

    public void fillVolume1() {
        applyWait.waitforElementToBeDisplayed(volume1, 30).clear();
        applyWait.waitforElementToBeDisplayed(volume1, 30).sendKeys("10");
        test.log(Status.INFO, "User enter volume");
    }

    public void fillFrequency1() {
        applyWait.waitforElementToBeDisplayed(frequence1, 30).click();
        test.log(Status.INFO, "User click on frequency");
    }

    public void fillExecutionTime1() {
        applyWait.waitforElementToBeDisplayed(exetime1, 30).clear();
        applyWait.waitforElementToBeDisplayed(exetime1, 30).sendKeys("10");
        test.log(Status.INFO, "User enter execution time");
    }

    public void fillDelayTime1() {
        applyWait.waitforElementToBeDisplayed(delayTime1, 30).clear();
        applyWait.waitforElementToBeDisplayed(delayTime1, 30).sendKeys("10");
        test.log(Status.INFO, "User enter delay time");
    }

    public void clickOnExecutionValue1() {
        applyWait.waitforElementToBeDisplayed(exeValue1, 30).click();
        test.log(Status.INFO, "User select value from execution dropdown");
    }

    public void clickOnDelayValue1() {
        applyWait.waitforElementToBeDisplayed(delayValue1, 30).click();
        test.log(Status.INFO, "User select value from delay dropdown");
    }

    public void clickOnSubmitTaskAttribute() {
        applyWait.waitforElementToBeDisplayed(submitTaskAttr, 30).click();
        test.log(Status.INFO, "User click on ");
    }

    public void clickOnCheckOutBtn() {
        boolean visibilityOfCheckOutBtn = applyWait.waitForElementToBeClickable(checkoutBtn, 30).isDisplayed();
        if (visibilityOfCheckOutBtn == true) {
            applyWait.waitForElementToBeClickable(checkoutBtn, 30).click();
            test.log(Status.INFO, "User click on Check In button on Process Map page");
            applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
            test.log(Status.INFO, "User click on Yes button on confirmation popup");
        }
        verify.assertEquals(constants.checkOutsuccessMsg, commonLocators.toastMsgs);
    }

    public void addOrEditProcedureInCheckedInAndCheckedOutMode() throws Exception {
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            System.out.println(name);
            if (name.equals(constants.searchStringForInProgressProcess)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(2000);
        clickOnCheckOutBtn();
        Thread.sleep(5000);
        clickOnTaskElement();
        Thread.sleep(2000);
        clickOnAddEditProcedureOptionOnTaskElement();
        Thread.sleep(9000);
        driver.switchTo().frame("ui-tinymce-1_ifr");
        addInfoOnProcedureForEditTask();
        Thread.sleep(2000);
        clickOnSubmitBtn();
        Thread.sleep(2000);
        clickOnCheckInBtn();
        Thread.sleep(5000);
        clickOnTaskElement();
        Thread.sleep(2000);
        clickOnViewProcedureOptionOnTaskElement();
        Thread.sleep(2000);
        driver.switchTo().frame("ui-tinymce-2_ifr");
        verify.assertTrue(addedProcedureOnTaskElement.isDisplayed());
    }

    public void addOrEditProcedureWithMenuBar() throws Exception {
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (name.equals(constants.searchStringForInProgressProcess)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(2000);
        boolean visibilityOfCheckOutBtn = applyWait.waitForElementToBeClickable(checkoutBtn, 30).isDisplayed();
        if (visibilityOfCheckOutBtn == true) {
            applyWait.waitForElementToBeClickable(checkoutBtn, 30).click();
            test.log(Status.INFO, "User click on Check In button on Process Map page");
            applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
            test.log(Status.INFO, "User click on Yes button on confirmation popup");
        }
        Thread.sleep(2000);
        clickOnProcedureTab();
        Thread.sleep(8000);
        driver.switchTo().frame("ui-tinymce-1_ifr");
        addInfoOnProcedureForEditTask();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        clickOnParentTask();
        clickOnSaveProcedure();
        Thread.sleep(2000);
        Assert.assertEquals(commonLocators.toastMsgs, constants.savedProcedureMsg);
    }

    public void aadTaskAttribute() throws Exception {
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            System.out.println(name);
            if (name.equals(constants.searchStringForInProgressProcess)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(2000);
        boolean visibilityOfCheckOutBtn = applyWait.waitForElementToBeClickable(checkoutBtn, 30).isDisplayed();
        if (visibilityOfCheckOutBtn == true) {
            applyWait.waitForElementToBeClickable(checkoutBtn, 30).click();
            test.log(Status.INFO, "User click on Check In button on Process Map page");
            applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
            test.log(Status.INFO, "User click on Yes button on confirmation popup");
        }
        Thread.sleep(3000);
        clickOnTaskElement();
        Thread.sleep(5000);
        clickOnTaskAttribute();
        Thread.sleep(5000);
        clickOnAccountable();
        clickOnAccountableValue();
        Thread.sleep(3000);
        clickOnConsulaed();
        clickOnAccountableValue();
        Thread.sleep(3000);
        clickOnInformed();
        clickOnAccountableValue();
        Thread.sleep(3000);
        clickOnRACI();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "User click on Yes button on confirmation popup");
        Thread.sleep(3000);
        fillVolume();
        clickOnFrequence();
        clickOnFrequenceValue();
        Thread.sleep(3000);
        clickOnApplyFrequence();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "User click on Yes button on confirmation popup");
        Thread.sleep(3000);
        fillExecutionTime();
        clickOnExecutionValue();
        clickOnFrequenceValue();
        fillDelayTime();
        clickOnDelayValue();
        clickOnFrequenceValue();
        Thread.sleep(3000);
        clickOnSubmitBtn();
        Thread.sleep(3000);
        System.out.println(commonLocators.toastMsgs);
        clickOnTaskAttributeTab();
        Thread.sleep(3000);
        System.out.println("Volume =  " + getValoumeValue());
    }

    public void addTaskAttributeUsingTaskAttributeFromTab() throws Exception {
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            System.out.println(name);
            if (name.equals(constants.searchStringForInProgressProcess)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(2000);
        boolean visibilityOfCheckOutBtn = applyWait.waitForElementToBeClickable(checkoutBtn, 30).isDisplayed();
        if (visibilityOfCheckOutBtn == true) {
            applyWait.waitForElementToBeClickable(checkoutBtn, 30).click();
            test.log(Status.INFO, "User click on Check In button on Process Map page");
            applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
            test.log(Status.INFO, "User click on Yes button on confirmation popup");
        }
        Thread.sleep(3000);
        clickOnTaskAttributeTab();
        Thread.sleep(2000);
        fillVolume1();
        Thread.sleep(2000);
        fillFrequency1();
        clickOnFrequenceValue();
        clickOnApplyFrequence();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "User click on Yes button on confirmation popup");
        fillExecutionTime1();
        clickOnExecutionValue1();
        clickOnFrequenceValue();
        fillDelayTime1();
        clickOnDelayValue1();
        clickOnFrequenceValue();
        clickOnSubmitTaskAttribute();
       // Thread.sleep(2000);
        System.out.println(commonLocators.toastMsgs);
    }
}
