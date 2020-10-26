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
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pageFactory_Common.CommonLocators;
import pageFactory_Designer.DesignerPage;

import java.awt.event.KeyEvent;
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
    public WebElement myProcessTab;

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

    @FindBy(xpath = "//button[contains(@ng-click,'assignuser()') and contains(text(),'Submit')]")
    private WebElement submitBtnOnProcessUser;

    @FindBy(xpath = "//button[contains(@ng-click,'sendappusers()') and contains(text(),'Submit')]")
    private WebElement submitBtnOnSendAprrovalRqst;

    @FindBy(xpath = "//button[@title='More...']")
    private WebElement moreOption;

    @FindBy(xpath = "//button[@title='Insert/edit image']")
    private WebElement imageOption;

    @FindBy(xpath = "//div//div[text()='Upload']")
    private WebElement uploadOption;

    @FindBy(xpath = "//div[@class='tox-dropzone']//input[@type='file']")
    private WebElement uploadFileBtn;

    @FindBy(xpath = "//span[@title='More']")
    public WebElement moreOptionBtn;

    @FindBy(xpath = "//md-icon[@md-svg-src='dist/images/Sendforapproval_svg.svg']")
    public WebElement sendForApproval;

    @FindBy(xpath = "//div[@title='Assign User']")
    private WebElement assignUserForLibraryElement;

    @FindBy(xpath = "//span[contains(@id,'dropdownMenu')]//md-icon")
    private WebElement backButton;

    @FindBy(xpath = "//select[@id='optgroup']")
    private WebElement selectUserFromProcessUserPopup;

    @FindBy(xpath = "//button[@id='optgroup_rightSelected']")
    private WebElement rightSelectUserIcon;

    @FindBy(xpath = "//div[contains(@id,'toast-container')]")
    public WebElement toastMsgs;

    @FindBy(xpath = "//md-select[@ng-model='processtype']")
    public WebElement sendApprovalTypeDropDown;

    @FindBy(xpath = "//md-select-menu[contains(@id,'select_menu')]//div[contains(text(),'Parallel')]")
    private WebElement selectParallelTypeDropDwnOnSendApproval;

    //End of My Processes element page//
    //Start of method of My Processes page//

    public void clickOnMyProcessesOption() {
        applyWait.waitForElementToBeClickable(myProcessTab, 30).click();
        test.log(Status.INFO, "User click on MY PROCESSES option");
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

    public void clickSubmitBtnOnProcessUser(){
        applyWait.waitForElementToBeClickable(submitBtnOnProcessUser,30).click();
        test.log(Status.INFO, "User click on Submit button");
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

    public void clickOnMoreOptionBtn() {
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        test.log(Status.INFO, "User click On More option");
    }

    public void clickOnSendForApprovalBtn() {
        applyWait.waitForElementToBeClickable(sendForApproval, 30).click();
        test.log(Status.INFO, "User click On Send For Approval option");
    }

    public void setAssignUserForLibraryElement() {
        applyWait.waitForElementToBeClickable(assignUserForLibraryElement, 30).click();
        test.log(Status.INFO,"User click on Assign User option");
    }

    public void clickOnBackBtn(){
        applyWait.waitForElementToBeClickable(backButton,30).click();
        test.log(Status.INFO,"User click on back button");
    }

    public void verifySendApprovalRequestOfProcessMapSerialCycle() throws Exception {
        DesignerPage designerPage = new DesignerPage(driver,test);
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (name.equals(constants.searchProcessForSendForApprovalSerialTest)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(3000);
        clickOnBackBtn();
        Thread.sleep(3000);
        designerPage.clickOnLibraryElement();
        Thread.sleep(3000);
        setAssignUserForLibraryElement();
        Thread.sleep(3000);
        Select selectUserDropDown = new Select(selectUserFromProcessUserPopup);
        selectUserDropDown.selectByVisibleText(constants.processApprover);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(rightSelectUserIcon,30).click();
        Thread.sleep(3000);
        selectUserDropDown.selectByVisibleText(constants.secondProcessApproverUser);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(rightSelectUserIcon,30).click();
        Thread.sleep(3000);
        clickSubmitBtnOnProcessUser();
        Thread.sleep(4000);
        verify.assertEquals(toastMsgs,constants.userAssignedMsg);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(designerPage.goToProcessMapOption,30).click();
        test.log(Status.INFO,"User click on Go To Process Map button");
        Thread.sleep(3000);
        clickOnCheckInBtn();
        Thread.sleep(3000);
        clickOnMoreOptionBtn();
        clickOnSendForApprovalBtn();
        Thread.sleep(3000);
        selectUserDropDown.selectByVisibleText(constants.processApprover);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(rightSelectUserIcon,30).click();
        Thread.sleep(3000);
        selectUserDropDown.selectByVisibleText(constants.secondProcessApproverUser);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(rightSelectUserIcon,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(submitBtnOnSendAprrovalRqst,30).click();
        Thread.sleep(4000);
        verify.assertEquals(toastMsgs,constants.sendApprovalMsg);
    }

    public void verifySendApprovalRequestOfProcessMapParallelCycle() throws Exception {
        DesignerPage designerPage = new DesignerPage(driver,test);
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (name.equals(constants.searchProcessForSendForApprovalParallelTest)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(3000);
        clickOnBackBtn();
        Thread.sleep(3000);
        designerPage.clickOnLibraryElement();
        Thread.sleep(3000);
        setAssignUserForLibraryElement();
        Thread.sleep(3000);
        Select selectUserDropDown = new Select(selectUserFromProcessUserPopup);
        selectUserDropDown.selectByVisibleText(constants.processApprover);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(rightSelectUserIcon,30).click();
        Thread.sleep(3000);
        selectUserDropDown.selectByVisibleText(constants.secondProcessApproverUser);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(rightSelectUserIcon,30).click();
        Thread.sleep(3000);
        clickSubmitBtnOnProcessUser();
        Thread.sleep(4000);
        verify.assertEquals(toastMsgs,constants.userAssignedMsg);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(designerPage.goToProcessMapOption,30).click();
        test.log(Status.INFO,"User click on Go To Process Map button");
        Thread.sleep(3000);
        clickOnCheckInBtn();
        Thread.sleep(3000);
        clickOnMoreOptionBtn();
        clickOnSendForApprovalBtn();
        Thread.sleep(3000);
        selectUserDropDown.selectByVisibleText(constants.processApprover);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(rightSelectUserIcon,30).click();
        Thread.sleep(3000);
        selectUserDropDown.selectByVisibleText(constants.secondProcessApproverUser);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(rightSelectUserIcon,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(sendApprovalTypeDropDown,30).click();
        test.log(Status.INFO," User click on type dropdown APPROVAL cycle");
        Thread.sleep(4000);
        applyWait.waitForElementToBeClickable(selectParallelTypeDropDwnOnSendApproval,30).click();
        test.log(Status.INFO," Under TYPE, select PARALLEL APPROVAL cycle");
        Thread.sleep(4000);
        applyWait.waitForElementToBeClickable(submitBtnOnSendAprrovalRqst,30).click();
        Thread.sleep(4000);
        verify.assertEquals(toastMsgs,constants.sendApprovalMsg);
    }
}