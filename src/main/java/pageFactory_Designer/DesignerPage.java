package pageFactory_Designer;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.waitTypes;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

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

    @FindBy(xpath = "//div[@title='Add Library']")
    private WebElement addLibraryIcon;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='viewport']")
    private WebElement draggableAddProcessElement;

    @FindBy(xpath = "//*[name()='svg' and @data-element-id='Process_1']")
    private WebElement droppableToScreen;

    @FindBy(xpath = "//div[@class='bjs-container']//textarea")
    private WebElement processElement;

    @FindBy(xpath = "//div[contains(@class,'djs-context-pad open')]//div[@title='Add Process']")
    private WebElement addChildProcess;

    @FindBy(xpath = "//button[@title='Check in']")
    private WebElement checkinButton;

    @FindBy(xpath = "//button//span[text()='Yes']")
    private WebElement yesConfirmationPopup;

    @FindBy(xpath = "//button[@title='Check out']")
    private WebElement checkoutBtn;

    //End of Framework Group Edit page//
    //Start Of Designer Page methods//

    public void clickOnDesignerTab(){
        applyWait.waitForElementToBeClickable(designerTab, 50).click();
        test.log(Status.INFO, "User Click on designer tab");
    }

    public void clickOnNewFrameworkBtn(){
        applyWait.waitForElementToBeClickable(newFrameworkButton, 30).click();
        test.log(Status.INFO, "User Click on new framework button");
    }

    public  void fillDetailsToCreateNewFramework(){
        String frameworkName = produce.generateName();
        applyWait.waitForElementToBeClickable(nameInputField, 50).sendKeys(frameworkName);
        test.log(Status.INFO, "User provide name for new framework");
    }

    public void clickOnSubmitBtn(){
        applyWait.waitForElementToBeClickable(submitBtn, 50).click();
        test.log(Status.INFO, "User click on Submit button");
    }

    public void clickOnLibraryElement(){
        Actions actions = new Actions(driver);
        actions.click(dataElement).perform();
        test.log(Status.INFO, "User click on library element");
    }


    public void clickOnGoToLibraryOption(){
        applyWait.waitForElementToBeClickable(goToLibraryOption, 90).click();
        test.log(Status.INFO, "User click on Go To Library option");
    }

    public void clickOnSaveFrameworkBtn(){
        applyWait.waitForElementToBeClickable(saveFrameworkBtn, 90).click();
        test.log(Status.INFO, "User click on Save button to save framework");
    }

    public void createLibrary() throws Exception{
        String parentProcess = produce.generateName();
        String childProcess1 = produce.generateName();
        Actions actions = new Actions(driver);
        applyWait.waitForElementToBeClickable(addProcessIcon, 90).click();
        test.log(Status.INFO, "User click on Add Process icon");
        actions.moveByOffset(10,10).perform();
        actions.release(draggableAddProcessElement).perform();
        test.log(Status.INFO, "User drag and drop process element");
        applyWait.waitForElementToBeClickable(processElement,30).sendKeys(parentProcess);
        test.log(Status.INFO, "User type name of Parent process element");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(addProcessIcon, 90).click();
        test.log(Status.INFO, "User click on Add Process icon on parent process element");
        actions.moveByOffset(150,170).perform();
        actions.release(draggableAddProcessElement).perform();
        test.log(Status.INFO, "User drag and drop first child process element");
        applyWait.waitForElementToBeClickable(processElement,50).sendKeys(childProcess1);
        test.log(Status.INFO, "User type name of the first child process element");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(addChildProcess, 90).click();
        test.log(Status.INFO, "User click on Add Process icon on child process element");
        actions.moveByOffset(190,230).perform();
        actions.release(draggableAddProcessElement).perform();
        test.log(Status.INFO, "User drag and drop second child process element");
        applyWait.waitForElementToBeClickable(processElement,30).sendKeys(constants.childProcess2);
        test.log(Status.INFO, "User type name of the second child process element");
        actions.click(droppableToScreen).perform();
        clickOnSaveFrameworkBtn();
        test.log(Status.INFO, "Click SAVE option to confirm changes are registered");
    }

    public void verifyNewFrameworkCreatedSuccessfully()throws Exception {
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
}
