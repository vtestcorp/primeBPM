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

import org.testng.asserts.SoftAssert;
import pageFactory_Common.CommonLocators;
import org.openqa.selenium.support.ui.Select;

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

    SoftAssert verify = new SoftAssert();
    defineConstants constants = new defineConstants();
    dataGenerator produce = new dataGenerator();
    CommonLocators commonLocators = new CommonLocators();

    //Start of Designer Page Elements//

    @FindBy(id = "Designer")
    private WebElement designerTab;

    @FindBy(xpath = "//div[@title='New Framework']")
    private WebElement newFrameworkButton;

    // End of Designer Page Elements//
    //Start of Framework page//

    @FindBy(id = "frameworkname")
    private WebElement nameInputField;

    @FindBy(xpath = "//md-sidenav[@md-component-id='rightmngntframeworkcreate']//span[contains(text(),'Submit')]")
    private WebElement submitBtn;

    @FindBy(xpath = "//md-sidenav[@md-component-id='rightmngntframeworkcreate']//span[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    //End of Framework page//
    //Start Of Library page//

    @FindBy(id = "InbuiltFrameworkName")
    private WebElement frameworkNameHeading;

    @FindBy(xpath = "//div[@title='Go to Library']")
    private WebElement goToLibraryOption;

    @FindBy(xpath = "//div[@title='Delete']")
    private WebElement deleteOption;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='layer-base']")
    private WebElement dataElement;

    @FindBy(xpath = "//md-icon[@md-svg-src='dist/img/icons/bpmn/save.svg']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@title='Add Process']")
    private WebElement addProcessIcon;

    @FindBy(xpath = "//div[@class='entry bpmn-icon-task1']")
    private WebElement addChildProcessIcon;

    @FindBy(xpath = "//div[@title='Add Value Chain']")
    private WebElement addChainIcon;

    @FindBy(xpath = "//div[@title='Add Library']")
    private WebElement addLibraryIcon;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='viewport']")
    private WebElement draggableElement;

    @FindBy(xpath = "//*[name()='svg' and @data-element-id='Process_1']")
    private WebElement droppableToScreen;

    @FindBy(xpath = "//div[@class='bjs-container']//textarea")
    private WebElement processElement;

    @FindBy(xpath = "//div[@data-action='append.append-task']")
    private WebElement addChildProcess;

    /*@FindBy(xpath = "//div[@class='td ng-binding ng-scope']")
    private List<WebElement> frameworkName21;*/

    @FindBy(xpath = "//div[@class='td ng-binding ng-scope']")
    private List<WebElement> frameworkNameTable;

    @FindBy(xpath = "//span[contains(@id,'dropdownMenu')]//md-icon")
    private WebElement backButton;

    //End of Library page//
    //Start Of Process element page//

    @FindBy(xpath = "//div[contains(@class,'open')]//div[@title='Go to Process Map']")
    private WebElement goToProcessMapOption;

    //End Of Process elementPage//
    //Start Of Process Map page//

    @FindBy(xpath = "//img[@src='dist/img/bpmn_process_map.PNG']")
    private WebElement selectProcessMapDesign;

    @FindBy(xpath = "//div[@class='djs-palette open']//div[@title='Create StartEvent']")
    private WebElement startEventCircle;

    @FindBy(xpath = "//div[@class='djs-palette open']//div[@title='Create EndEvent']")
    private WebElement endEventCircle;

    @FindBy(xpath = "//*[name()='g' and contains(@data-element-id,'Task')]//*[name()='rect']")
    private WebElement processBox;

    @FindBy(xpath = "//*[name()='g' and contains(@data-element-id,'EndEvent')]")
    private WebElement endProcessElement;

    @FindBy(xpath = "//img[@src='dist/img/smart_process_map.PNG']")
    private WebElement selectDesignTypeOnRapidProcessMap;

    @FindBy(xpath = "//img[@src='dist/img/bpmn_process_map.PNG']")
    private WebElement selectDesignDrawingProcessMap;

    @FindBy(xpath = "//md-icon[@title='Add New Organisation Unit']")
    private WebElement addNewOrganistaionUnit;

    @FindBy(xpath = "//input[@ng-model='actionForm.Name']")
    private WebElement nameFieldOnFormOnProcessMap;

    @FindBy(xpath = "//md-icon[@title='Add New Role']")
    private WebElement addnewRoleOnProcessMap;

    @FindBy(xpath = "//md-icon[@title='Add New Document']")
    private WebElement addNewDocumentOnProcessMap;

    @FindBy(xpath = "//md-icon[@title='Add New System']")
    private WebElement addNewSystemOnProcessmap;

    @FindBy(xpath = "//md-switch[@ng-model='switchDesignButton']")
    private WebElement moveToDesignView;

    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    private WebElement submitBtnOnFormOfProcessMap;

    @FindBy(xpath = "//input[@ng-model='actionForm.Cost']")
    private WebElement costOfRoleOnProcessMap;

    @FindBy(xpath = "//input[@ng-model='actionForm.URL']")
    private WebElement urlFieldOnFormAtProcessMap;

    @FindBy(xpath = "//textarea[@ng-model='actionForm.description']")
    private WebElement descriptionFieldOnFromAtProcessMap;

    @FindBy(xpath = "//*[@id=\"taskList\"]/tr[2]/td[1]/div")
    private WebElement taskNameField;

    @FindBy(xpath = "//tr[not(contains(@id,'templateTaskRow'))]//select[@class='roleName']")
    private WebElement selectRoleFromDropDown;

    @FindBy(xpath = "//tr[not(contains(@id,'templateTaskRow'))]//select[@class='docName']")
    private WebElement selectDocuemntFromDropDown;

    @FindBy(xpath = "//tr[not(contains(@id,'templateTaskRow'))]//select[@class='sysName']")
    private WebElement selectSystemFromDropDown;

    @FindBy(xpath = "//tr[not(contains(@id,'templateTaskRow'))]//md-icon[1]")
    private WebElement plusIconToAddNewTask;

    @FindBy(xpath = "//button[contains(@class,'Yes')]//span")
    private WebElement yesConfirmationPopup;

    @FindBy(xpath = "//button[@ng-model='checkIn']")
    public WebElement checkinBtn;

    @FindBy(xpath = "//span[contains(@title,'Check in')]//span[contains(text(),'Check In')]")
    public WebElement checkinBtnOnProcessMap;

    @FindBy(xpath = "//button[@ng-model='checkOut']")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//span[contains(@title,'Check out')]//span[contains(text(),'Check Out')]")
    public WebElement checkoutBtnOnProcessMap;

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

    @FindBy(xpath = "//div[contains(text(),'Double click here to add Role')]")
    private WebElement addRoleName1;

    @FindBy(xpath = "//md-icon[@md-svg-src='dist/img/icons/ic_add_circle_outline_24px.svg']")
    private WebElement addOrgUnitBtn;

    @FindBy(xpath = "//input[@name ='Cost']")
    private WebElement cost;

    @FindBy(xpath = "//div[@class='md-actions dispaly-block']//button[1]")
    private WebElement submitRole;

    @FindBy(xpath = "//div[@title='Create StartEvent']")
    private WebElement startEvn;

    @FindBy(xpath = "//div[@title='Create Task']")
    private WebElement createTask;

    @FindBy(xpath = "//div[@title='Append Task']")
    private WebElement appendTask;

    @FindBy(xpath = "//div[@title='Create System']")
    private WebElement createSystem;

    @FindBy(xpath = "//div[@class='djs-context-pad open']//div[6]")
    private WebElement arrow;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='djs-group'][3]")
    private WebElement doneStartEvn;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='djs-group'][5]")
    private WebElement doneTask1;

    @FindBy(xpath = "//input[@name='URL']")
    private WebElement systemURL;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='djs-group'][6]")
    private WebElement doneSystem;

    @FindBy(xpath = "//div[@title='Create Document']")
    private WebElement document;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='djs-group'][7]")
    private WebElement doneDocument;
    //End Process map//
    @FindBy(xpath = "//div[contains(@id,'toast-container')]")
    public WebElement toastMsgs;
    //End Of Process Map page//
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

    public void clickOnSaveBtn() {
        applyWait.waitForElementToBeClickable(saveBtn, 90).click();
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
        clickOnSaveBtn();
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
        clickOnSaveBtn();
        Thread.sleep(3000);
        verify.assertEquals(constants.frameworkSavedSuccessMsg, toastMsgs);
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
            if (frameworkName.equals(constants.frameworkNameAuto)) {
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
        clickOnSaveBtn();
        Thread.sleep(5000);
        clickOnLibraryElement();
        Thread.sleep(3000);
        clickOnGoToLibraryOption();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(addProcessIcon, 90).click();
        test.log(Status.INFO, "User click on Add Process icon");
        Actions builder1 = new Actions(driver);
        builder1.moveToElement(addProcessIcon, 300, -100) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(300, -100) // 2nd points (x1,y1)
                .release()
                .build()
                .perform();
        Thread.sleep(5000);
        test.log(Status.INFO, "User drag and drop process element");
        applyWait.waitForElementToBeClickable(processElement, 30).sendKeys(parentProcess, Keys.ENTER);
        Thread.sleep(5000);
        clickOnSaveBtn();
        test.log(Status.INFO, "Click SAVE option to confirm changes are registered");
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(shap1, 30).click();
        test.log(Status.INFO, "Click on process ");
        applyWait.waitforElementToBeDisplayed(particularProcess, 30).click();
        test.log(Status.INFO, "Click Particular Process");
        Thread.sleep(10000);
        applyWait.waitforElementToBeDisplayed(drawMap, 30).click();
        test.log(Status.INFO, "Click Drawing Processing  Map");
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(pool, 30).click();
        test.log(Status.INFO, "Click on pool");
        Actions builder12 = new Actions(driver);
        Action drawAction12 = builder12.moveToElement(pool, 600, -200) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(500, -400) // 2nd points (x1,y1)
                .release()
                .build();
        drawAction12.perform();
        Thread.sleep(5000);
        test.log(Status.INFO, "User drag and drop process element");
        Actions actions = new Actions(driver);
        actions.doubleClick(addOrgName).perform();
        String orgName = "Org" + produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(orgName);
        test.log(Status.INFO, "Click  organisation unit");
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(addOrgUnitBtn, 30).click();
        test.log(Status.INFO, "Click on add organisation unit");
        System.out.println(addRoleName.size());
        Thread.sleep(5000);
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(addRoleName.get(0)).perform();
        Thread.sleep(5000);
        String roleName = "Role" + produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(roleName);
        test.log(Status.INFO, "Click  Role Name ");
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(addOrgUnitBtn, 30).click();
        test.log(Status.INFO, "Click on  add Role name");
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(cost, 30).sendKeys("10");
        test.log(Status.INFO, "Fill the cost for role");
        applyWait.waitforElementToBeDisplayed(submitRole, 30).click();
        //   applyWait.waitforElementToBeDisplayed(addOrgName, 30).click();
        test.log(Status.INFO, "Click on submit role button");
        Thread.sleep(8000);
        Actions actions21 = new Actions(driver);
        actions21.doubleClick(addRoleName.get(0)).perform();
        //  Thread.sleep(8000);
        String roleName1 = "Role" + produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(roleName1);
        test.log(Status.INFO, "enter  Role Name ");
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(addOrgUnitBtn, 30).click();
        test.log(Status.INFO, "Click on  add Role name");
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(cost, 30).sendKeys("10");
        test.log(Status.INFO, "Fill the cost for role");
        applyWait.waitforElementToBeDisplayed(submitRole, 30).click();
        test.log(Status.INFO, "Click on submit role button");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(startEvn, 30).click();
        test.log(Status.INFO, "Click on start event");
        Actions builder22 = new Actions(driver);
        Action drawAction22 = builder22.moveToElement(startEvn, 100, 100) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(150, 130) // 2nd points (x1,y1)
                .release()
                .build();
        drawAction22.perform();
       /* applyWait.waitforElementToBeDisplayed()
        Actions start = new Actions(driver);
        start.doubleClick(startEvn).perform();*/

       /* applyWait.waitforElementToBeDisplayed(createTask, 30).click();
        test.log(Status.INFO, "Click on create task");
        Actions builder22 = new Actions(driver);
        Action drawAction22 = builder22.moveToElement(createTask, 350, 150) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(450, 150) // 2nd points (x1,y1)
                .release()
                .build();
        drawAction22.perform();
        Thread.sleep(5000);
        String taskName1 = produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(taskName1, Keys.ENTER);
        test.log(Status.INFO, "enter create task name ");*/
        applyWait.waitforElementToBeDisplayed(createTask, 30).click();
        test.log(Status.INFO, "Click on append task");
        Actions appendT = new Actions(driver);
        appendT.moveToElement(createTask, 300, -100) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(400, -300) // 2nd points (x1,y1)
                .release()
                .build()
                .perform();
        Thread.sleep(5000);
        String taskName2 = produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(taskName2);
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(Keys.ENTER);
        test.log(Status.INFO, "enter append task name ");

       /* applyWait.waitforElementToBeDisplayed(appendTask, 30).click();
        test.log(Status.INFO, "Click on append task")*/
        ;
        String startEvnName = produce.generateName();
        Actions start = new Actions(driver);
        start.doubleClick(doneStartEvn).perform();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(startEvnName);
        applyWait.waitforElementToBeDisplayed(doneStartEvn, 30).click();
        test.log(Status.INFO, "enter start event name ");
        applyWait.waitforElementToBeDisplayed(arrow, 30).click();
        test.log(Status.INFO, "User click on arrow");
        applyWait.waitforElementToBeDisplayed(doneTask1, 30).click();
        test.log(Status.INFO, "User draw the arrow");
        /*Actions appendT2 = new Actions(driver);
        Action drawTask2 = appendT2.moveToElement(arrow,600, -400) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveToElement(doneTask1) // 2nd points (x1,y1)
                .release()
                .build();
        drawTask2.perform();*/
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(createSystem, 30).click();
        test.log(Status.INFO, "Click on create System");
        Actions system = new Actions(driver);
        system.moveToElement(createSystem, 200, -200) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(150, -300) // 2nd points (x1,y1)
                .release()
                .build()
                .perform();
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(doneSystem, 30).click();
        Thread.sleep(3000);
        Actions syst = new Actions(driver);
        syst.doubleClick(doneSystem).perform();
        String system1 = produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(system1);
        test.log(Status.INFO, "enter System Name ");
        applyWait.waitforElementToBeDisplayed(addOrgUnitBtn, 30).click();
        test.log(Status.INFO, "Click on add System ");
        String sysURL = "-";
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(systemURL, 30).sendKeys(sysURL);
        test.log(Status.INFO, "User enter System url ");
        applyWait.waitforElementToBeDisplayed(submitRole, 30).click();
        //   applyWait.waitforElementToBeDisplayed(addOrgName, 30).click();
        test.log(Status.INFO, "Click on submit System button");
        applyWait.waitforElementToBeDisplayed(doneTask1, 30).click();
        applyWait.waitforElementToBeDisplayed(arrow, 30).click();
        test.log(Status.INFO, "User click on arrow");
        applyWait.waitforElementToBeDisplayed(doneSystem, 30).click();
        test.log(Status.INFO, "User draw the arrow");
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(document, 30).click();
        test.log(Status.INFO, "Click on create document");
        Actions document1 = new Actions(driver);
        document1.moveToElement(document, 200, -200) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(150, -300) // 2nd points (x1,y1)
                .release()
                .build()
                .perform();
        Thread.sleep(5000);
        applyWait.waitforElementToBeDisplayed(doneSystem, 30).click();
        Actions docu = new Actions(driver);
        docu.doubleClick(doneDocument).perform();
        String doc1 = produce.generateName();
        applyWait.waitforElementToBeDisplayed(processElement, 30).sendKeys(doc1);
        test.log(Status.INFO, "enter document Name ");
        applyWait.waitforElementToBeDisplayed(addOrgUnitBtn, 30).click();
        test.log(Status.INFO, "Click on add document ");
        String docURL = "-";
        Thread.sleep(3000);
        applyWait.waitforElementToBeDisplayed(systemURL, 30).sendKeys(docURL);
        test.log(Status.INFO, "User enter System url ");
        applyWait.waitforElementToBeDisplayed(submitRole, 30).click();
        //   applyWait.waitforElementToBeDisplayed(addOrgName, 30).click();
        test.log(Status.INFO, "Click on submit System button");


    }

    public void clickOnCheckinBtn() throws InterruptedException {
        applyWait.waitForElementToBeClickable(checkinBtn, 30).click();
        test.log(Status.INFO, "User click on Check In lock button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "User click on Yes button at confirmation box");
        Thread.sleep(3000);
        verify.assertEquals(constants.checkInSuccessMsg, toastMsgs);
    }

    public void clickOnCheckinBtnOnProcessMap() throws InterruptedException {
        applyWait.waitForElementToBeClickable(checkinBtnOnProcessMap, 30).click();
        test.log(Status.INFO, "User click on Check In lock button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "User click on Yes button at confirmation box");
        Thread.sleep(3000);
        verify.assertEquals(constants.checkInSuccessMsg, toastMsgs);
    }

    public void clickOnCheckoutBtn() throws InterruptedException {
        applyWait.waitForElementToBeClickable(checkoutBtn, 30).click();
        test.log(Status.INFO, "User click on check Out button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "User click on Yes button at confirmation box");
        Thread.sleep(4000);
        verify.assertEquals(constants.checkInSuccessMsg, toastMsgs);
    }

    public void clickOnCheckoutBtnOnProcessMap() throws InterruptedException {
        applyWait.waitForElementToBeClickable(checkoutBtnOnProcessMap, 30).click();
        test.log(Status.INFO, "User click on check Out button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "User click on Yes button at confirmation box");
        Thread.sleep(4000);
        verify.assertEquals(constants.checkInSuccessMsg, toastMsgs);
    }

    //Start Of Process Element and Process Map page methods//
    public void clickOnGoToProcessMap() {
        Actions actions = new Actions(driver);
        actions.click(processBox).perform();
        test.log(Status.INFO, "User click on library element");
        applyWait.waitForElementToBeClickable(goToProcessMapOption, 30).click();
        test.log(Status.INFO, "User click on Go To Process Map button");
    }

    public void createProcessMap() throws Exception {
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(startEventCircle, 30).click();
        actions.moveByOffset(-100, 150).perform();
        actions.release(draggableElement).perform();
        Thread.sleep(3000);
        test.log(Status.INFO, "User darg and drop Start element");

        actions.doubleClick(draggableElement).perform();
        Thread.sleep(3000);
        actions.moveToElement(processElement).perform();
        applyWait.waitForElementToBeClickable(processElement, 30).sendKeys("start");
        Thread.sleep(3000);
        test.log(Status.INFO, "User enter name for start Process element");

        applyWait.waitForElementToBeClickable(endEventCircle, 30).click();
        actions.moveByOffset(100, 150).perform();
        actions.release(draggableElement).perform();
        Thread.sleep(3000);
        test.log(Status.INFO, "User drag and drop End Process element");

        actions.doubleClick(endProcessElement).perform();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(processElement, 30).sendKeys("end");
        test.log(Status.INFO, "User enter name for End Process element");
        actions.click(droppableToScreen).perform();
        clickOnSaveBtn();
        test.log(Status.INFO, "User save process map by clicking on Save button");
        Thread.sleep(3000);
        verify.assertEquals(constants.processMapSavedSuccessMsg, toastMsgs);
    }

    public void checkinCheckoutFramework() throws Exception {
        Actions actions = new Actions(driver);
        clickOnDesignerTab();
        Thread.sleep(3000);
        String frameworkName;
        clickOnDesignerTab();
        actions.moveToElement(newFrameworkButton).perform();
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
        Thread.sleep(3000);
        test.log(Status.INFO, "User click existing framework from famework list");
        Thread.sleep(3000);
        clickOnCheckinBtn();
        Thread.sleep(3000);
        clickOnCheckoutBtn();
        Thread.sleep(3000);
    }

    public void checkinCheckoutLibrary() throws Exception {
        Thread.sleep(3000);
        clickOnLibraryElement();
        clickOnGoToLibraryOption();
        Thread.sleep(9000);
        clickOnCheckinBtn();
        Thread.sleep(3000);
        clickOnCheckoutBtn();
    }

    public void clickOnBackBtn() {
        applyWait.waitForElementToBeClickable(backButton, 30).click();
        test.log(Status.INFO, "User click on back button");
    }

    public void setDesignRapidProcessMap() {
        applyWait.waitForElementToBeClickable(selectDesignTypeOnRapidProcessMap, 30).click();
    }

    public void setDesignDrawingProcessMap() {
        applyWait.waitForElementToBeClickable(selectDesignDrawingProcessMap, 30).click();
    }

    public void checkinCheckoutProcess() throws Exception {
        clickOnGoToProcessMap();
        setDesignDrawingProcessMap();
        createProcessMap();
        clickOnCheckinBtnOnProcessMap();
        clickOnCheckoutBtnOnProcessMap();
    }

    public void addNewOrganisationUnitOnTaskCreation() {
        applyWait.waitForElementToBeClickable(addNewOrganistaionUnit, 30).click();
        test.log(Status.INFO, "User click + sign on Organisation Unit option");
    }

    public void fillFormForAddOrganisationAtProcessMap() {
        applyWait.waitForElementToBeClickable(nameFieldOnFormOnProcessMap, 30).sendKeys("Organisation" + produce.generateRandomString());
        test.log(Status.INFO, "User provide name of organisation at form");

        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap, 30).click();
        test.log(Status.INFO, "User click on submit button");
    }

    public void clickOnPlusIconToAddNewRoleOnProcessMap() {
        applyWait.waitForElementToBeClickable(addnewRoleOnProcessMap, 30).click();
        test.log(Status.INFO, "User click + Icon on Role at Process Map page");
    }

    public void clickOnPlusIconToAddNewDocumentOnProcessMap() {
        applyWait.waitForElementToBeClickable(addNewDocumentOnProcessMap, 30).click();
        test.log(Status.INFO, "User click + Icon on Document at Process Map page");
    }

    public void clickOnPlusIconToAddNewSystemOnProcessMap() {
        applyWait.waitForElementToBeClickable(addNewSystemOnProcessmap, 30).click();
        test.log(Status.INFO, "User click + Icon on System at Process Map page");
    }

    public void addNewRoleFormOnProcessMap() {
        applyWait.waitForElementToBeClickable(nameFieldOnFormOnProcessMap, 30).sendKeys("Role" + produce.generateRandomString());
        test.log(Status.INFO, "User provide name of new role on form at Process Map page");

        applyWait.waitForElementToBeClickable(costOfRoleOnProcessMap, 30).sendKeys(String.valueOf(produce.getRandomNumber()));
        test.log(Status.INFO, "User enter cost of role");

        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap, 30).click();
        test.log(Status.INFO, "User click on submit button");
    }

    public void addNewDocumentFormOnProcessMap() {
        applyWait.waitForElementToBeClickable(nameFieldOnFormOnProcessMap, 30).sendKeys("Document" + produce.generateRandomString());
        test.log(Status.INFO, "User provide name of new document on form at Process Map page");

        applyWait.waitForElementToBeClickable(urlFieldOnFormAtProcessMap, 30).sendKeys("-");
        test.log(Status.INFO, "User enter url on form at Process Map");

        applyWait.waitForElementToBeClickable(descriptionFieldOnFromAtProcessMap, 30).sendKeys(produce.generateRandomString());
        test.log(Status.INFO, "User enter description on form at Process Map");

        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap, 30).click();
        test.log(Status.INFO, "User click on submit button");
    }

    public void addNewSystemFormOnProcessMap() {
        applyWait.waitForElementToBeClickable(nameFieldOnFormOnProcessMap, 30).sendKeys("System" + produce.generateRandomString());
        test.log(Status.INFO, "User provide name of new document on form at Process Map page");

        applyWait.waitForElementToBeClickable(urlFieldOnFormAtProcessMap, 30).sendKeys("-");
        test.log(Status.INFO, "User enter url on form at Process Map");

        applyWait.waitForElementToBeClickable(descriptionFieldOnFromAtProcessMap, 30).sendKeys(produce.generateRandomString());
        test.log(Status.INFO, "User enter description on form at Process Map");

        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap, 30).click();
        test.log(Status.INFO, "User click on submit button");
    }

    public void addMultipleTasksOnProcessMap(int tasksCount) {
        Actions actions = new Actions(driver);
        applyWait.waitForElementToBeClickable(taskNameField, 30).sendKeys("task" + produce.generateRandomString());
        test.log(Status.INFO, "User enter task name on Process Map Rapid design");

        applyWait.waitForElementToBeClickable(selectRoleFromDropDown, 30).click();
        test.log(Status.INFO, "User click on role drop down on Process Map Rapid design");

        Select selectRoleDropDown = new Select(selectRoleFromDropDown);
        selectRoleDropDown.selectByIndex(tasksCount);

        Select selectDocumentDropDown = new Select(selectDocuemntFromDropDown);
        selectDocumentDropDown.selectByIndex(tasksCount);

        Select selectSystemDropDown = new Select(selectSystemFromDropDown);
        selectSystemDropDown.selectByIndex(tasksCount);
        if (tasksCount > 1) {
            clickOnPlusIconToAddNewDocumentOnProcessMap();
        }
    }

    public void clickOnPlusIconToAddNewTask() {
        applyWait.waitForElementToBeClickable(plusIconToAddNewTask, 30).click();
        test.log(Status.INFO, "User click on + icon to add new task row on Process Map");
    }

    public void clickOnMoveToDesignViewBtn() {
        applyWait.waitForElementToBeClickable(moveToDesignView, 30).click();
        test.log(Status.INFO, "User click on move to design view switch button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup, 30).click();
        test.log(Status.INFO, "User click on Yes button on confirmation popup");
    }

    public void designingOfProcessMapUsingRapidDesignProcess() throws Exception {
        String name;
        Thread.sleep(3000);
        clickOnDesignerTab();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(newFrameworkButton).perform();
        Thread.sleep(3000);
        System.out.println(frameworkName1.size());
        for (int i = 0; i < frameworkName1.size(); i++) {
            name = applyWait.waitForElementToBeClickable(frameworkName1.get(i), 30).getText();
            if (name.equals(constants.searchStringForDrawingDesignMap)) {
                applyWait.waitForElementToBeClickable(frameworkName1.get(i), 30).click();
                test.log(Status.INFO, "Click Particular Framework");
                break;
            }
        }
        Thread.sleep(3000);
        clickOnLibraryElement();
        Thread.sleep(3000);
        clickOnGoToLibraryOption();
        Thread.sleep(3000);
        clickOnGoToProcessMap();
        setDesignRapidProcessMap();
        addNewOrganisationUnitOnTaskCreation();
        fillFormForAddOrganisationAtProcessMap();
        Thread.sleep(3000);
        clickOnPlusIconToAddNewRoleOnProcessMap();
        addNewRoleFormOnProcessMap();
        Thread.sleep(3000);
        clickOnPlusIconToAddNewDocumentOnProcessMap();
        addNewDocumentFormOnProcessMap();
        clickOnPlusIconToAddNewSystemOnProcessMap();
        addNewSystemFormOnProcessMap();
        addMultipleTasksOnProcessMap(1);
        clickOnSaveBtn();
        clickOnMoveToDesignViewBtn();
        Thread.sleep(3000);
        verify.assertEquals(constants.processMapSavedSuccessMsg, toastMsgs);
    }

}
