package pageFactory_MyProcess;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.screenshots;
import helperMethods.waitTypes;
import java.awt.Robot;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    //End of My Processes element page//
    //Start of method of My Processes page//

    public void clickOnMyProcessesOption(){
        applyWait.waitForElementToBeClickable(myProcessTab,30).click();
        test.log(Status.INFO,"User click on MY PROCESSES option");
    }

    public void clickOnInProgressProcessMapFromList(){
        applyWait.waitForElementToBeClickable(selectProcessFromMyProcessList,30).click();
        test.log(Status.INFO,"User click on an IN PROGRESS process map name");
    }

    public void clickOnCheckInBtn(){
        boolean visibilityOfCheckInBtn = applyWait.waitForElementToBeClickable(checkinBtn,30).isDisplayed();
        if (visibilityOfCheckInBtn == true){
            applyWait.waitForElementToBeClickable(checkinBtn,30).click();
            test.log(Status.INFO,"User click on Check In button on Process Map page");

            applyWait.waitForElementToBeClickable(yesConfirmationPopup,30).click();
            test.log(Status.INFO,"User click on Yes button on confirmation popup");
        }
        verify.assertEquals(constants.checkInSuccessMsg,commonLocators.toastMsgs);
    }

    public void clickOnTaskElement(){
        Actions actions = new Actions(driver);
        actions.click(processBox).perform();
        test.log(Status.INFO, "User click on task box element");
    }

    public void clickOnViewProcedureOptionOnTaskElement(){
        applyWait.waitForElementToBeClickable(viewProcedure,30).click();
        test.log(Status.INFO,"User click on add/edit procedure option on Task element");
    }

    public void clickOnAddEditProcedureOptionOnTaskElement(){
        applyWait.waitForElementToBeClickable(addEditProcedureOnTaskElement,30).click();
        test.log(Status.INFO,"User click on add/edit procedure option on Task element");
    }

    public void addInfoOnProcedureForEditTask() throws Exception {
        applyWait.waitForElementToBeClickable(procedureDescription,30).sendKeys(produce.generateRandomString());
        test.log(Status.INFO,"User type procedure info random text");

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
        test.log(Status.INFO,"User takes screenshot and paste to procedure text area");
    }

    public void clickOnSubmitBtn(){
        Actions actions = new Actions(driver);
        driver.switchTo().defaultContent();
        actions.moveToElement(submitBtnOnForm).perform();
        actions.click(submitBtnOnForm).perform();
        test.log(Status.INFO, "User click on Submit button");
    }

    public void clickOnCheckOutBtn(){
        boolean visibilityOfCheckOutBtn = applyWait.waitForElementToBeClickable(checkoutBtn,30).isDisplayed();
        if (visibilityOfCheckOutBtn == true){
            applyWait.waitForElementToBeClickable(checkoutBtn,30).click();
            test.log(Status.INFO,"User click on Check In button on Process Map page");

            applyWait.waitForElementToBeClickable(yesConfirmationPopup,30).click();
            test.log(Status.INFO,"User click on Yes button on confirmation popup");
        }
        verify.assertEquals(constants.checkOutsuccessMsg,commonLocators.toastMsgs);
    }

    public void addOrEditProcedureInCheckedInAndCheckedOutMode() throws Exception {
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
}
