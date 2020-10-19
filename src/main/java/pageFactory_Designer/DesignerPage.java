package pageFactory_Designer;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.waitTypes;
import junit.framework.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import pageFactory_Common.CommonLocators;

import java.util.List;

public class DesignerPage {
    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;
    private String roleName;


    public DesignerPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new waitTypes(driver);
        this.test = test;
    }

    defineConstants constants = new defineConstants();
    dataGenerator produce = new dataGenerator();

    //Start of Designer Page Elements//

    @FindBy(id = "Designer")
    private WebElement designerTab;

    @FindBy(xpath = "//div[@title='New Framework']")
    private WebElement newFrameworkButton;

    // End of Designer Page Elements//
    //Start of Process Framework Popup//

    @FindBy(id = "frameworkname")
    private WebElement nameInputField;

    @FindBy(xpath = "//md-sidenav[@md-component-id='rightmngntframeworkcreate']//span[contains(text(),'Submit')]")
    private WebElement submitBtn;

    @FindBy(xpath = "//md-sidenav[@md-component-id='rightmngntframeworkcreate']//span[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    //End of Process Framework Popup//
    //Start Of Framework Group Edit page//

    @FindBy(id = "InbuiltFrameworkName")
    private WebElement frameworkNameHeading;

    @FindBy(xpath = "//div[@title='Go to Library']")
    private WebElement goToLibraryOption;

    @FindBy(xpath = "//div[@title='Delete']")
    private WebElement deleteOption;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='layer-base']//*[name()='path']")
    private WebElement dataElement;

    @FindBy(xpath = "//md-icon[@md-svg-src='dist/img/icons/bpmn/save.svg']")
    private WebElement saveFrameworkBtn;

    @FindBy(xpath = "//div[@title='Add Process']")
    private WebElement addProcessIcon;

    @FindBy(xpath = "//div[@class='entry bpmn-icon-task1']")
    private WebElement addChildProcessIcon;

    @FindBy(xpath = "//div[@title='Add Value Chain']")
    private WebElement addChainIcon;

    @FindBy(xpath = "//div[@title='Add Library']")
    private WebElement addLibraryIcon;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='viewport']")
    private WebElement draggableAddProcessElement;

    @FindBy(xpath = "//*[name()='svg' and @data-element-id='Process_1']")
    private WebElement droppableToScreen;

    @FindBy(xpath = "//div[@class='bjs-container']//textarea")
    private WebElement processElement;

    @FindBy(xpath = "//div[@data-action='append.append-task']")
    private WebElement addChildProcess;

    @FindBy(xpath = "//button[@title='Check in']")
    private WebElement checkinButton;

    @FindBy(xpath = "//button//span[text()='Yes']")
    private WebElement yesConfirmationPopup;

    @FindBy(xpath = "//button[@title='Check out']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class='toast-message']")
    private WebElement SuccessMsg;

    @FindBy(xpath = "//div[@class='td ng-binding ng-scope']")
    private List<WebElement> frameworkName1;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @data-element-id='Task_0ovpt9e']")
    private WebElement processLib;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @data-element-id='Task_0j5r3u4']")
    private WebElement particularLib;

    @FindBy(xpath = "//span[@title='Check out']")
    private WebElement processCheckOut;

    @FindBy(xpath = "//span[@title='Check in']")
    private WebElement processCheckIn;

    @FindBy(xpath = "//div[@title='Go to Process Map']")
    private WebElement particularProcess;

    @FindBy(xpath = "//*[@class='color-primary PrimeIconsMrg pull-left fullScreenHide ng-isolate-scope md-default-theme']")
    private WebElement moreBtn;

    @FindBy(xpath = "//span[contains(text(),' Undo Check Out ')]")
    private WebElement undoCheckOutBtn;

    @FindBy(xpath = "//span[@class='ng-pristine ng-valid ng-scope ng-touched']")
    private WebElement btnTitle;
    //End of Framework Group Edit page//

    //Start Process map//
    @FindBy(xpath = "//div[@class='col-md-6 text-center']")
    private WebElement drawMap;

    @FindBy(xpath = "//div[@title='Create Pool/Participant']")
    private WebElement pool;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='djs-element djs-shape']")
    private WebElement shap1;

    @FindBy(xpath = "//div[contains(text(),'Double click here to add Organisation Unit')]")
    private WebElement addOrgName;

    @FindBy(xpath = "//div[contains(text(),'Double click here to add Role')]")
    private List<WebElement> addRoleName;

    @FindBy(xpath = "//md-icon[@md-svg-src='dist/img/icons/ic_add_circle_outline_24px.svg']")
    private WebElement addOrgUnitBtn;

    @FindBy(xpath = "//input[@name ='Cost']")
    private WebElement cost;

    @FindBy(xpath = "//div[@class='md-actions dispaly-block']//button[1]")
    private WebElement submitRole;

    //End Process map//
    //Start Of Designer Page methods//

    public void clickOnDesignerTab() {
        applyWait.waitForElementToBeClickable(designerTab, 50).click();
        test.log(Status.INFO, "User Click on designer tab");
    }

    public void clickOnNewFrameworkBtn() {
        applyWait.waitForElementToBeClickable(newFrameworkButton, 30).click();
        test.log(Status.INFO, "User Click on new framework button");
    }

    public void fillDetailsToCreateNewFramework() {
        String frameworkName = produce.generateName();
        applyWait.waitForElementToBeClickable(nameInputField, 50).sendKeys(frameworkName);
        test.log(Status.INFO, "User provide name for new framework");
    }

    public void clickOnSubmitBtn() {
        applyWait.waitForElementToBeClickable(submitBtn, 50).click();
        test.log(Status.INFO, "User click on Submit button");
    }

    public void clickOnLibraryElement() {
        Actions actions = new Actions(driver);
        actions.click(dataElement).perform();
        test.log(Status.INFO, "User click on library element");
    }


    public void clickOnGoToLibraryOption() {
        applyWait.waitForElementToBeClickable(goToLibraryOption, 90).click();
        test.log(Status.INFO, "User click on Go To Library option");
    }

    public void clickOnSaveFrameworkBtn() {
        applyWait.waitForElementToBeClickable(saveFrameworkBtn, 90).click();
        test.log(Status.INFO, "User click on Save button to save framework");
    }

    public void createLibrary() throws Exception {
        String parentProcess = produce.generateName();
        String childProcess1 = produce.generateName();
        Actions actions = new Actions(driver);
        applyWait.waitForElementToBeClickable(addProcessIcon, 90).click();
        test.log(Status.INFO, "User click on Add Process icon");
        Actions builder1 = new Actions(driver);
        Action drawAction1 = builder1.moveToElement(addProcessIcon, 400, -100) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(300, -400) // 2nd points (x1,y1)
                .release()
                .build();
        drawAction1.perform();
        Thread.sleep(3000);
        test.log(Status.INFO, "User drag and drop process element");
        applyWait.waitForElementToBeClickable(processElement, 30).sendKeys(parentProcess);
        test.log(Status.INFO, "User type name of Parent process element");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(addProcessIcon, 90).click();
        test.log(Status.INFO, "User click on Add Process icon on parent process element");
        Actions builder21 = new Actions(driver);
        Action drawAction21 = builder21.moveToElement(addProcessIcon, 700, 150) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(700, 300) // 2nd points (x1,y1)
                .release()
                .build();
        drawAction21.perform();
        test.log(Status.INFO, "User drag and drop first child process element");
        applyWait.waitForElementToBeClickable(processElement, 50).sendKeys(childProcess1, Keys.ENTER);
        test.log(Status.INFO, "User type name of the first child process element");
        Thread.sleep(3000);
        clickOnSaveFrameworkBtn();
        test.log(Status.INFO, "Click SAVE option to confirm changes are registered");
        applyWait.waitForElementToBeClickable(SuccessMsg, 90).isDisplayed();
        Assert.assertEquals(defineConstants.newLibrarySuccessMsg, SuccessMsg.getText());
    }

    public void verifyNewFrameworkCreatedSuccessfully() throws Exception {
        clickOnDesignerTab();
        clickOnNewFrameworkBtn();
        fillDetailsToCreateNewFramework();
        clickOnSubmitBtn();
        Thread.sleep(3000);
        clickOnSaveFrameworkBtn();
        Thread.sleep(8000);
        clickOnLibraryElement();
        Thread.sleep(3000);
        clickOnGoToLibraryOption();
        Thread.sleep(3000);
        createLibrary();
    }

    public void undoCheckout() throws Exception {
        String frameworkName;
        clickOnDesignerTab();
        Thread.sleep(3000);
        System.out.println(frameworkName1.size());
        for (int i = 0; i < frameworkName1.size(); i++) {
            frameworkName = applyWait.waitForElementToBeClickable(frameworkName1.get(i), 30).getText();
            if (frameworkName.equals(constants.searchString)) {
                applyWait.waitForElementToBeClickable(frameworkName1.get(i), 30).click();
                test.log(Status.INFO, "Click Particular Framework");
                break;
            }
        }
        applyWait.waitforElementToBeDisplayed(processLib, 30).click();
        test.log(Status.INFO, "Click Particular Process Lib");
        clickOnGoToLibraryOption();
        applyWait.waitforElementToBeDisplayed(particularLib, 30).click();
        test.log(Status.INFO, "Click Particular Library");
        applyWait.waitforElementToBeDisplayed(particularProcess, 30).click();
        test.log(Status.INFO, "Click Particular Process");
        Thread.sleep(5000);
        if (processCheckIn.isDisplayed()) {
            applyWait.waitforElementToBeDisplayed(processCheckIn, 30).click();
            test.log(Status.INFO, "Click on process check in button");
            applyWait.waitforElementToBeDisplayed(yesConfirmationPopup, 30).click();
            test.log(Status.INFO, "Click on yes button");
        }
        applyWait.waitforElementToBeDisplayed(processCheckOut, 30).click();
        test.log(Status.INFO, "Click on process check out button");
        applyWait.waitforElementToBeDisplayed(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "Click on yes button");
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(moreBtn, 30).click();
        test.log(Status.INFO, "Click on more button");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(undoCheckOutBtn, 30).click();
        test.log(Status.INFO, "Click on undo check out button");
        applyWait.waitforElementToBeDisplayed(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "Click on yes button");
        Thread.sleep(3000);
        System.out.println(SuccessMsg.getText());
        Assert.assertEquals(defineConstants.undoCheckoutSuccessMsg, SuccessMsg.getText());
    }

    public void drawProcessMap() throws Exception {
        String parentProcess = produce.generateName();
        clickOnDesignerTab();
        clickOnNewFrameworkBtn();
        fillDetailsToCreateNewFramework();
        clickOnSubmitBtn();
        Thread.sleep(3000);
        clickOnSaveFrameworkBtn();
        Thread.sleep(8000);
        clickOnLibraryElement();
        Thread.sleep(5000);
        clickOnGoToLibraryOption();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(addProcessIcon, 90).click();
        test.log(Status.INFO, "User click on Add Process icon");
        Actions builder1 = new Actions(driver);
        Action drawAction1 = builder1.moveToElement(addProcessIcon, 400, -100) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(300, -400) // 2nd points (x1,y1)
                .release()
                .build();
        drawAction1.perform();
        Thread.sleep(3000);
        test.log(Status.INFO, "User drag and drop process element");
        applyWait.waitForElementToBeClickable(processElement, 30).sendKeys(parentProcess, Keys.ENTER);
        Thread.sleep(3000);
        clickOnSaveFrameworkBtn();
        test.log(Status.INFO, "Click SAVE option to confirm changes are registered");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(shap1, 30).click();
        test.log(Status.INFO, "Click on process ");
        applyWait.waitforElementToBeDisplayed(particularProcess, 30).click();
        test.log(Status.INFO, "Click Particular Process");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(drawMap, 30).click();
        test.log(Status.INFO, "Click Drawing Processing  Map");
        applyWait.waitforElementToBeDisplayed(pool, 30).click();
        test.log(Status.INFO, "Click on pool");
        Actions builder12 = new Actions(driver);
        Action drawAction12 = builder12.moveToElement(pool, 600, -100) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(500, -400) // 2nd points (x1,y1)
                .release()
                .build();
        drawAction12.perform();
        Thread.sleep(3000);
        test.log(Status.INFO, "User drag and drop process element");
        Actions actions = new Actions(driver);
        actions.doubleClick(addOrgName).perform();
        String orgName = "Org" + produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(orgName);
        test.log(Status.INFO, "Click  organisation unit");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(addOrgUnitBtn, 30).click();
        test.log(Status.INFO, "Click on add organisation unit");
        Thread.sleep(3000);
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(addRoleName.get(0)).perform();
        Thread.sleep(3000);
        String roleName = "Role" + produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(roleName);
        test.log(Status.INFO, "Click  Role Name ");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(addOrgUnitBtn, 30).click();
        test.log(Status.INFO, "Click on  add Role name");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(cost, 30).sendKeys("10");
        test.log(Status.INFO, "Fill the cost for role");
        applyWait.waitforElementToBeDisplayed(submitRole, 30).click();
        // applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(Keys.ENTER);
        test.log(Status.INFO, "Click on submit role button");
        Thread.sleep(5000);
        Actions actions21 = new Actions(driver);
        actions21.doubleClick(addRoleName.get(1)).perform();
        Thread.sleep(3000);
        String roleName1 = "Role" + produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(roleName);
        test.log(Status.INFO, "Click  Role Name ");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(addOrgUnitBtn, 30).click();
        test.log(Status.INFO, "Click on  add Role name");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(cost, 30).sendKeys("10");
        test.log(Status.INFO, "Fill the cost for role");
        applyWait.waitforElementToBeDisplayed(submitRole, 30).click();
        test.log(Status.INFO, "Click on submit role button");

    }
}
