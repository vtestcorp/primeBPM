package pageFactory_Designer;


import base.baseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.waitTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageFactory_Common.CommonLocators;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class DesignerPage {
    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;


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

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and contains(@data-element-id,'Task')]")
    private WebElement processMapElement;

    @FindBy(xpath = "//md-icon[@md-svg-src='dist/img/icons/bpmn/save.svg']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@title='Add Process']")
    private WebElement addProcessIcon;

    @FindBy(xpath = "//div[@title='Add Library']")
    private WebElement addLibraryIcon;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='viewport']")
    private WebElement draggableElement;

    @FindBy(xpath = "//*[name()='svg' and @data-element-id='Process_1']")
    private WebElement droppableToScreen;

    @FindBy(xpath = "//div[@class='bjs-container']//textarea")
    private WebElement processElement;

    @FindBy(xpath = "//div[contains(@class,'djs-context-pad open')]//div[@title='Add Process']")
    private WebElement addChildProcess;

    @FindBy(xpath = "//div[@class='td ng-binding ng-scope']")
    private List<WebElement> frameworkName1;

    @FindBy(xpath = "//a[contains(@ng-click,'ppRedirection')]")
    private List<WebElement> approveProcessList;

    @FindBy(xpath = "//div[@class='td ng-binding ng-scope']")
    private List<WebElement> frameworkNameTable;

    @FindBy(xpath = "//span[contains(@id,'dropdownMenu')]//md-icon")
    private WebElement backButton;

    @FindBy(xpath = "//a[@href='#/dashboard']")
    private WebElement dashboardTab;

    @FindBy(xpath = "//a[@ui-sref='myprocess']")
    public WebElement myProcessTab;

    //End of Library page//
    //Start Of Process element page//

    @FindBy(xpath = "//div[contains(@class,'open')]//div[@title='Go to Process Map']")
    public WebElement goToProcessMapOption;

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

    @FindBy(xpath = "//button//span[contains(text(),'Submit')]")
    private WebElement submitBtnOnFormOfProcessMap;

    @FindBy(xpath = "//input[@ng-model='actionForm.Cost']")
    private WebElement costOfRoleOnProcessMap;

    @FindBy(xpath = "//input[@ng-model='actionForm.URL']")
    private WebElement urlFieldOnFormAtProcessMap;

    @FindBy(xpath = "//textarea[@ng-model='actionForm.description']")
    private WebElement descriptionFieldOnFromAtProcessMap;

    @FindBy(xpath = "//tr[not(contains(@id,'templateTaskRow'))]//div[@class='taskNames']")
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

    @FindBy(xpath = "//div[contains(@id,'toast-container')]")
    public WebElement toastMsgs;

    @FindBy(xpath = "//md-icon[@title='Process Pending For Approval']")
    public WebElement approvalTab;

    @FindBy(xpath = "//button[contains(@ng-click,'approvalPopup')]")
    private WebElement approveBtn;

    @FindBy(xpath = "//button[contains(@ng-click,'Reject')]")
    private WebElement rejectBtn;

    @FindBy(xpath = "//*[contains(@data-element-id,'DataObject')]")
    private WebElement documentElement;

    @FindBy(xpath = "//div[contains(@class,'DataObject')]//div[@title='comment']")
    private WebElement commentIconOnDocumentElement;

    @FindBy(xpath = "//textarea[@name='comments']")
    private WebElement commentBox;

    @FindBy(xpath = "//div[contains(@class,'Task')]//div[@title='comment']")
    private WebElement commentIconOnTaskElement;

    @FindBy(xpath = "//button[contains(text(),'Add Generic Comments')]")
    private WebElement addGenericCommentsOption;

    @FindBy(xpath = "//input[contains(@ng-model,'processmap')]")
    private WebElement processMapCheckBoxOnApprovePopup;

    @FindBy(xpath = "//div[contains(text(),'Pending Approvals')]")
    private WebElement approvalTabOnDashboard;

    @FindBy(xpath = "//input[contains(@ng-model,'processattr')]")
    private WebElement processInformationCheckboxOnApprovePopup;

    @FindBy(xpath = "//input[contains(@ng-model,'processtask')]")
    private WebElement taskInformationCheckboxOnApprovePopup;

    @FindBy(xpath = "//span[@title='More']")
    public WebElement moreOptionBtn;

    @FindBy(xpath = "//button[@title='SOP Report']")
    private WebElement sopReportBtn;

    @FindBy(xpath = "//button[@title='BPR Report']")
    private WebElement bprReportBtn;

    @FindBy(xpath = "//md-select[@ng-model='mapReport.DownloadType']")
    private WebElement downloadAsTypeDropdown;

    @FindBy(xpath = "//md-option//div[contains(text(),'Word')]")
    private WebElement wordTypeOptionOfDownloadAsDrpdwn;

    @FindBy(xpath = "//md-option//div[contains(text(),'PDF')]")
    private WebElement pdfTypeOptionOfDownloadAsDrpdwn;

    @FindBy(xpath = "//tr[contains(@ng-repeat,'listmsg in Comments')]")
    private List<WebElement> commentRowsOnCommentSummary;

    @FindBy(xpath = "//button[contains(text(),'Comments Summary')]")
    private WebElement commentSummaryBtn;

    @FindBy(xpath = "//button[contains(@ng-click,'answer')]")
    private WebElement closeIconOnPopup;

    @FindBy(xpath = "//a[contains(@ng-click,'generateLink')]")
    private List<WebElement> processeslist;

    @FindBy(xpath = "//md-checkbox[@role='checkbox']")
    private WebElement selectAllCheckboxesOptionOnReportPopup;

    //End Of Process Map page//
    //Start Of Designer Page methods//

    public void clickOnDesignerTab(){
        applyWait.waitForElementToBeClickable(designerTab, 50).click();
        test.log(Status.INFO, "User Click on designer tab");
    }

    public void clickOnNewFrameworkBtn(){
        applyWait.waitForElementToBeClickable(newFrameworkButton, 30).click();
        test.log(Status.INFO, "User Click on new framework button");
    }

    public  void fillDetailsToCreateNewFramework(String frameworkName){
        applyWait.waitForElementToBeClickable(nameInputField, 50).sendKeys(frameworkName);
        test.log(Status.INFO, "User provide name for new framework");
    }

    public void clickOnSubmitBtn(){
        applyWait.waitForElementToBeClickable(submitBtn, 50).click();
        test.log(Status.INFO, "User click on Submit button");
    }

    public void clickOnProcessMapElement(){
        Actions actions = new Actions(driver);
        actions.click(processMapElement).perform();
        test.log(Status.INFO, "User click on library element");
    }

    public void clickOnGoToLibraryOption(){
        applyWait.waitForElementToBeClickable(goToLibraryOption, 90).click();
        test.log(Status.INFO, "User click on Go To Library option");
    }

    public void clickOnSaveBtn(){
        applyWait.waitForElementToBeClickable(saveBtn, 90).click();
        test.log(Status.INFO, "User click on Save button to save framework");
    }

    public void createLibrary(String processName) throws Exception{
        Actions actions = new Actions(driver);
        applyWait.waitForElementToBeClickable(addProcessIcon, 90).click();
        test.log(Status.INFO, "User click on Add Process icon");

        actions.moveByOffset(10,10).perform();
        actions.release(draggableElement).perform();
        test.log(Status.INFO, "User drag and drop process element");

        applyWait.waitForElementToBeClickable(processElement,30).sendKeys(processName);
        test.log(Status.INFO, "User type name of Parent process element");
        Thread.sleep(3000);

        applyWait.waitForElementToBeClickable(addProcessIcon, 90).click();
        test.log(Status.INFO, "User click on Add Process icon on parent process element");

        actions.moveByOffset(150,170).perform();
        actions.release(draggableElement).perform();
        test.log(Status.INFO, "User drag and drop first child process element");

        applyWait.waitForElementToBeClickable(processElement,50).sendKeys(constants.childProcess1);
        test.log(Status.INFO, "User type name of the first child process element");
        Thread.sleep(3000);

        applyWait.waitForElementToBeClickable(addChildProcess, 90).click();
        test.log(Status.INFO, "User click on Add Process icon on child process element");

        actions.moveByOffset(190,230).perform();
        actions.release(draggableElement).perform();
        test.log(Status.INFO, "User drag and drop second child process element");

        applyWait.waitForElementToBeClickable(processElement,30).sendKeys(constants.childProcess2);
        test.log(Status.INFO, "User type name of the second child process element");

        actions.click(droppableToScreen).perform();
        clickOnSaveBtn();
        test.log(Status.INFO, "Click SAVE option to confirm changes are registered");
        Thread.sleep(3000);
        verify.assertEquals(constants.frameworkSavedSuccessMsg,toastMsgs);
    }

    public void verifyNewFrameworkCreatedSuccessfully(String frameworkName,String processName)throws Exception {
        clickOnDesignerTab();
        clickOnNewFrameworkBtn();
        fillDetailsToCreateNewFramework(frameworkName);
        clickOnSubmitBtn();
        Thread.sleep(3000);
        clickOnSaveBtn();
        Thread.sleep(3000);
        verify.assertEquals(constants.frameworkSavedSuccessMsg,toastMsgs);
        Thread.sleep(8000);
        clickOnProcessMapElement();
        Thread.sleep(3000);
        clickOnGoToLibraryOption();
        Thread.sleep(3000);
        createLibrary(processName);
    }

    public void clickOnCheckinBtn() throws InterruptedException {
        applyWait.waitForElementToBeClickable(checkinBtn,30).click();
        test.log(Status.INFO,"User click on Check In lock button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup,30).click();
        test.log(Status.INFO,"User click on Yes button at confirmation box");
        Thread.sleep(3000);
        verify.assertEquals(constants.checkInSuccessMsg,toastMsgs);
    }

    public void clickOnCheckinBtnOnProcessMap() throws InterruptedException {
        applyWait.waitForElementToBeClickable(checkinBtnOnProcessMap,30).click();
        test.log(Status.INFO,"User click on Check In lock button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup,30).click();
        test.log(Status.INFO,"User click on Yes button at confirmation box");
        Thread.sleep(3000);
        verify.assertEquals(constants.checkInSuccessMsg,toastMsgs);
    }

    public void clickOnCheckoutBtn() throws InterruptedException {
        applyWait.waitForElementToBeClickable(checkoutBtn,30).click();
        test.log(Status.INFO,"User click on check Out button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup,30).click();
        test.log(Status.INFO,"User click on Yes button at confirmation box");
        Thread.sleep(4000);
        verify.assertEquals(constants.checkInSuccessMsg,toastMsgs);
    }

    public void clickOnCheckoutBtnOnProcessMap() throws InterruptedException {
        applyWait.waitForElementToBeClickable(checkoutBtnOnProcessMap,30).click();
        test.log(Status.INFO,"User click on check Out button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup,30).click();
        test.log(Status.INFO,"User click on Yes button at confirmation box");
        Thread.sleep(3000);
        verify.assertEquals(constants.checkInSuccessMsg,toastMsgs);
    }

    //Start Of Process Element and Process Map page methods//
    public void clickOnGoToProcessMap(){
        Actions actions = new Actions(driver);
        actions.click(processBox).perform();
        test.log(Status.INFO, "User click on library element");
        applyWait.waitForElementToBeClickable(goToProcessMapOption,30).click();
        test.log(Status.INFO,"User click on Go To Process Map button");
    }

    public void createProcessMap() throws  Exception{
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(startEventCircle,30).click();
        actions.moveByOffset(-100, 150).perform();
        actions.release(draggableElement).perform();
        Thread.sleep(3000);
        test.log(Status.INFO,"User darg and drop Start element");

        actions.doubleClick(draggableElement).perform();
        Thread.sleep(3000);
        actions.moveToElement(processElement).perform();
        applyWait.waitForElementToBeClickable(processElement,30).sendKeys("start");
        Thread.sleep(3000);
        test.log(Status.INFO,"User enter name for start Process element");

        applyWait.waitForElementToBeClickable(endEventCircle,30).click();
        actions.moveByOffset(100, 150).perform();
        actions.release(draggableElement).perform();
        Thread.sleep(3000);
        test.log(Status.INFO,"User drag and drop End Process element");

        actions.doubleClick(endProcessElement).perform();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(processElement,30).sendKeys("end");
        test.log(Status.INFO,"User enter name for End Process element");
        actions.click(droppableToScreen).perform();
        clickOnSaveBtn();
        test.log(Status.INFO,"User save process map by clicking on Save button");
        Thread.sleep(3000);
        verify.assertEquals(constants.processMapSavedSuccessMsg,toastMsgs);
    }

    public void checkinCheckoutFramework(String framework) throws Exception{
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
            if (frameworkName.equals(framework.toUpperCase())) {
                applyWait.waitForElementToBeClickable(frameworkName1.get(i), 30).click();
                test.log(Status.INFO, "Click Particular Framework");
                break;
            }
        }
        Thread.sleep(3000);
        test.log(Status.INFO,"User click existing framework from famework list");
        Thread.sleep(3000);
        clickOnCheckinBtn();
        Thread.sleep(3000);
        clickOnCheckoutBtn();
        Thread.sleep(3000);
    }

    public void checkinCheckoutLibrary() throws Exception{
        Thread.sleep(3000);
        clickOnProcessMapElement();
        clickOnGoToLibraryOption();
        Thread.sleep(9000);
        clickOnCheckinBtn();
        Thread.sleep(3000);
        clickOnCheckoutBtn();
    }

    public void clickOnBackBtn(){
        applyWait.waitForElementToBeClickable(backButton,30).click();
        test.log(Status.INFO,"User click on back button");
    }

    public void setDesignRapidProcessMap(){
        applyWait.waitForElementToBeClickable(selectDesignTypeOnRapidProcessMap,30).click();
    }

    public void setDesignDrawingProcessMap(){
        applyWait.waitForElementToBeClickable(selectDesignDrawingProcessMap,30).click();
    }

    public void checkinCheckoutProcess() throws Exception {
        clickOnGoToProcessMap();
        clickOnCheckinBtnOnProcessMap();
        clickOnCheckoutBtnOnProcessMap();
    }

    public void addNewOrganisationUnitOnTaskCreation(){
        applyWait.waitForElementToBeClickable(addNewOrganistaionUnit,30).click();
        test.log(Status.INFO,"User click + sign on Organisation Unit option");
    }

    public void fillFormForAddOrganisationAtProcessMap() throws Exception{
        Actions actions = new Actions(driver);
        applyWait.waitForElementToBeClickable(nameFieldOnFormOnProcessMap,30).sendKeys("Organisation" + produce.generateRandomString());
        test.log(Status.INFO,"User provide name of organisation at form");
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"User click on submit button");
    }

    public void clickOnPlusIconToAddNewRoleOnProcessMap(){
        applyWait.waitForElementToBeClickable(addnewRoleOnProcessMap,30).click();
        test.log(Status.INFO,"User click + Icon on Role at Process Map page");
    }

    public void clickOnPlusIconToAddNewDocumentOnProcessMap(){
        applyWait.waitForElementToBeClickable(addNewDocumentOnProcessMap,30).click();
        test.log(Status.INFO,"User click + Icon on Document at Process Map page");
    }

    public void clickOnPlusIconToAddNewSystemOnProcessMap(){
        applyWait.waitForElementToBeClickable(addNewSystemOnProcessmap,30).click();
        test.log(Status.INFO,"User click + Icon on System at Process Map page");
    }

    public void addNewRoleFormOnProcessMap(){
        applyWait.waitForElementToBeClickable(nameFieldOnFormOnProcessMap,30).sendKeys("Role" + produce.generateRandomString());
        test.log(Status.INFO,"User provide name of new role on form at Process Map page");

        applyWait.waitForElementToBeClickable(costOfRoleOnProcessMap, 30).sendKeys(String.valueOf(produce.getRandomNumber()));
        test.log(Status.INFO, "User enter cost of role");

        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"User click on submit button");
    }

    public void addNewDocumentFormOnProcessMap(){
        applyWait.waitForElementToBeClickable(nameFieldOnFormOnProcessMap,30).sendKeys("Document" + produce.generateRandomString());
        test.log(Status.INFO,"User provide name of new document on form at Process Map page");

        applyWait.waitForElementToBeClickable(urlFieldOnFormAtProcessMap, 30).sendKeys("-");
        test.log(Status.INFO, "User enter url on form at Process Map");

        applyWait.waitForElementToBeClickable(descriptionFieldOnFromAtProcessMap,30).sendKeys(produce.generateRandomString());
        test.log(Status.INFO, "User enter description on form at Process Map");

        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"User click on submit button");
    }

    public void addNewSystemFormOnProcessMap(){
        applyWait.waitForElementToBeClickable(nameFieldOnFormOnProcessMap,30).sendKeys("System" + produce.generateRandomString());
        test.log(Status.INFO,"User provide name of new document on form at Process Map page");

        applyWait.waitForElementToBeClickable(urlFieldOnFormAtProcessMap, 30).sendKeys("-");
        test.log(Status.INFO, "User enter url on form at Process Map");

        applyWait.waitForElementToBeClickable(descriptionFieldOnFromAtProcessMap,30).sendKeys(produce.generateRandomString());
        test.log(Status.INFO, "User enter description on form at Process Map");

        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"User click on submit button");
    }

    public void addMultipleTasksOnProcessMap(int tasksCount){
        Actions actions = new Actions(driver);
        applyWait.waitForElementToBeClickable(taskNameField,30).sendKeys("task"+ produce.generateRandomString());
        test.log(Status.INFO,"User enter task name on Process Map Rapid design");

        applyWait.waitForElementToBeClickable(selectRoleFromDropDown,30).click();
        test.log(Status.INFO,"User click on role drop down on Process Map Rapid design");

        Select selectRoleDropDown = new Select(selectRoleFromDropDown);
        selectRoleDropDown.selectByIndex(tasksCount);

        Select selectDocumentDropDown = new Select(selectDocuemntFromDropDown);
        selectDocumentDropDown.selectByIndex(tasksCount);

        Select selectSystemDropDown = new Select(selectSystemFromDropDown);
        selectSystemDropDown.selectByIndex(tasksCount);
        if (tasksCount>1){
            clickOnPlusIconToAddNewDocumentOnProcessMap();
        }
    }

    public void clickOnPlusIconToAddNewTask(){
        applyWait.waitForElementToBeClickable(plusIconToAddNewTask,30).click();
        test.log(Status.INFO,"User click on + icon to add new task row on Process Map");
    }

    public void clickOnMoveToDesignViewBtn(){
        applyWait.waitForElementToBeClickable(moveToDesignView,30).click();
        test.log(Status.INFO,"User click on move to design view switch button");

        applyWait.waitForElementToBeClickable(yesConfirmationPopup,30).click();
        test.log(Status.INFO,"User click on Yes button on confirmation popup");
    }

    public void designingOfProcessMapUsingRapidDesignProcess(String framework)throws Exception{
        String name;
        Thread.sleep(3000);
        clickOnDesignerTab();
        Thread.sleep(3000);
        Actions actions =new Actions(driver);
        actions.moveToElement(newFrameworkButton).perform();
        Thread.sleep(3000);
        System.out.println(frameworkName1.size());
        for (int i = 0; i < frameworkName1.size(); i++) {
            name = applyWait.waitForElementToBeClickable(frameworkName1.get(i), 30).getText();
            if (name.equals(framework.toUpperCase())) {
                applyWait.waitForElementToBeClickable(frameworkName1.get(i), 30).click();
                test.log(Status.INFO, "Click Particular Process");
                break;
            }
        }
        Thread.sleep(3000);
        clickOnProcessMapElement();
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
        verify.assertEquals(constants.processMapSavedSuccessMsg,toastMsgs);
    }

    public void approveProcessMap(String processName) throws Exception {
        applyWait.waitForElementToBeClickable(approvalTab,30).click();
        test.log(Status.INFO,"User click on 'Process Pending for Approval' option on TOP menu bar");
        String name;
        Thread.sleep(3000);
        Actions actions =new Actions(driver);
        Thread.sleep(5000);
        for (int i = 0; i < approveProcessList.size(); i++) {
            name = applyWait.waitForElementToBeClickable(approveProcessList.get(i), 30).getText();
            if (name.equals(processName)) {
                applyWait.waitForElementToBeClickable(approveProcessList.get(i), 30).click();
                test.log(Status.INFO, "Click Particular Process");
                break;
            }
        }
        applyWait.waitForElementToBeClickable(documentElement,30).click();
        test.log(Status.INFO,"User click on document element");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentIconOnDocumentElement,30).click();
        test.log(Status.INFO,"User click on comment option");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentBox,30).sendKeys("comment"+produce.generateRandomString());
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"User add a comments and click on submit");
        Thread.sleep(4000);
        verify.assertEquals(constants.commentAddedSuccessMsg,toastMsgs.getText());
        actions.click(processBox).perform();
        applyWait.waitForElementToBeClickable(commentIconOnTaskElement,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentBox,30).sendKeys("comment"+produce.generateRandomString());
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        Thread.sleep(3000);
        verify.assertEquals(constants.commentAddedSuccessMsg,toastMsgs.getText());
        test.log(Status.INFO,"Single click on a Task and add a COMMENT against it; hit SUBMIT");
        applyWait.waitForElementToBeClickable(addGenericCommentsOption,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentBox,30).sendKeys("comment"+produce.generateRandomString());
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        Thread.sleep(3000);
        test.log(Status.INFO," Click on 'ADD GENERIC Comment' and add 1 comment; hit SUBMIT");
        verify.assertEquals(constants.commentAddedSuccessMsg,toastMsgs.getText());
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentSummaryBtn,30).click();
        Thread.sleep(3000);
        int commentsCount = commentRowsOnCommentSummary.size();
        verify.assertTrue(commentsCount>0);
        Thread.sleep(2000);
        actions.click(closeIconOnPopup).perform();
        test.log(Status.INFO,"Assert ALL comments get added successfully");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        test.log(Status.INFO, "User click On More option");
        applyWait.waitForElementToBeClickable(sopReportBtn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(wordTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(10000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,90).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        applyWait.waitForElementToBeClickable(sopReportBtn,30).click();
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(pdfTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO, "Click on MORE icon and generate SOP report (PDF and WORD format)");
        Thread.sleep(5000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        Thread.sleep(5000);
        applyWait.waitForElementToBeClickable(bprReportBtn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(pdfTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(bprReportBtn,30).click();
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(wordTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO, "Click on MORE icon and generate BPR report (PDF and WORD format)");
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(approveBtn,30).click();
        test.log(Status.INFO,"User click on APPROVE option on top right corner");

        applyWait.waitForElementToBeClickable(processMapCheckBoxOnApprovePopup,30).click();
        applyWait.waitForElementToBeClickable(processInformationCheckboxOnApprovePopup,30).click();
        applyWait.waitForElementToBeClickable(taskInformationCheckboxOnApprovePopup,30).click();
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"User check ALL 3 boxes and hit SUBMIT On the item selection page");
        Thread.sleep(8000);
        verify.assertEquals(constants.ProcessApprovedMsg,toastMsgs.getText().toString());
        Thread.sleep(3000);
        for (int i = 0; i < approveProcessList.size(); i++) {
            name = applyWait.waitForElementToBeClickable(approveProcessList.get(i), 30).getText();
            verify.assertNotSame(processName,name);
        }

    }

    public void verifyRejectApproval(String processName) throws Exception{
        applyWait.waitForElementToBeClickable(approvalTabOnDashboard,30).click();
        test.log(Status.INFO,"User click on 'Process Pending for Approval' option on TOP menu bar");
        String name;
        Thread.sleep(3000);
        Actions actions =new Actions(driver);
        Thread.sleep(5000);
        for (int i = 0; i < approveProcessList.size(); i++) {
            name = applyWait.waitForElementToBeClickable(approveProcessList.get(i), 30).getText();
            if (name.equals(processName)) {
                applyWait.waitForElementToBeClickable(approveProcessList.get(i), 30).click();
                test.log(Status.INFO, "Click Particular Process");
                break;
            }
        }
        applyWait.waitForElementToBeClickable(documentElement,30).click();
        test.log(Status.INFO,"User click on document element");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentIconOnDocumentElement,30).click();
        test.log(Status.INFO,"User click on comment option");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentBox,30).sendKeys("comment"+produce.generateRandomString());
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        Thread.sleep(4000);
        verify.assertEquals(constants.commentAddedSuccessMsg,toastMsgs.getText());
        Thread.sleep(3000);
        test.log(Status.INFO,"User add a comments and click on submit");
        Thread.sleep(2000);
        actions.click(processBox).perform();
        applyWait.waitForElementToBeClickable(commentIconOnTaskElement,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentBox,30).sendKeys("comment"+produce.generateRandomString());
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        Thread.sleep(4000);
        test.log(Status.INFO,"Single click on a Task and add a COMMENT against it; hit SUBMIT");
        verify.assertEquals(constants.commentAddedSuccessMsg,toastMsgs.getText());
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(addGenericCommentsOption,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentBox,30).sendKeys("comment"+produce.generateRandomString());
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        Thread.sleep(4000);
        verify.assertEquals(constants.commentAddedSuccessMsg,toastMsgs.getText());
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentSummaryBtn,30).click();
        Thread.sleep(3000);
        int commentsCount = commentRowsOnCommentSummary.size();
        verify.assertTrue(commentsCount>0);
        Thread.sleep(2000);
        actions.click(closeIconOnPopup).perform();
        test.log(Status.INFO,"Assert ALL comments get added successfully");
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        test.log(Status.INFO, "User click On More option");
        applyWait.waitForElementToBeClickable(sopReportBtn,30).click();
        Thread.sleep(3000);
        test.log(Status.INFO," Click on 'ADD GENERIC Comment' and add 1 comment; hit SUBMIT");

        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(wordTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        Thread.sleep(5000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        applyWait.waitForElementToBeClickable(sopReportBtn,30).click();
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(pdfTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO, "Click on MORE icon and generate SOP report (PDF and WORD format)");
        Thread.sleep(5000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        Thread.sleep(5000);
        applyWait.waitForElementToBeClickable(bprReportBtn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(pdfTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(bprReportBtn,30).click();
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(wordTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO, "Click on MORE icon and generate BPR report (PDF and WORD format)");
        Thread.sleep(9000);
        applyWait.waitForElementToBeClickable(rejectBtn,30).click();
        test.log(Status.INFO,"User click on REJECT option on top right corner");
        applyWait.waitForElementToBeClickable(processMapCheckBoxOnApprovePopup,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(processInformationCheckboxOnApprovePopup,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(taskInformationCheckboxOnApprovePopup,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"User check ALL 3 boxes and hit SUBMIT On the item selection page");
        Thread.sleep(8000);
        verify.assertEquals(constants.processRejectApprovalMsg,toastMsgs.getText().toString());
        Thread.sleep(3000);
        for (int i = 0; i < approveProcessList.size(); i++) {
            name = applyWait.waitForElementToBeClickable(approveProcessList.get(i), 30).getText();
            verify.assertNotSame(processName,name);
        }
    }

    public void clickOnMyProcessesOption() {
        applyWait.waitForElementToBeClickable(myProcessTab, 30).click();
        test.log(Status.INFO, "User click on MY PROCESSES option");
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

    public void selectAllCheckBoxOnReportOption() throws  Exception{
        String checkboxSelected = applyWait.waitForElementToBeClickable(selectAllCheckboxesOptionOnReportPopup,30).getAttribute("aria-checked");
         if(checkboxSelected.equals("false")){
             applyWait.waitForElementToBeClickable(selectAllCheckboxesOptionOnReportPopup,30).click();
             Thread.sleep(3000);
            }
    }

    public void verifyDownloadSOPWordFormatReport( String processName) throws Exception {
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (name.equals(processName)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(2000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        test.log(Status.INFO, "User click On More option");
        applyWait.waitForElementToBeClickable(sopReportBtn,30).click();
        Thread.sleep(3000);
        selectAllCheckBoxOnReportOption();
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(wordTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(10000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,90).click();
        Thread.sleep(10000);
        Assert.assertTrue(isFileDownloaded_Ext(baseClass.DownloadFilepath, "SOP.docx"), "Failed to download Expected document");
        Thread.sleep(9000);
    }

    public void verifyDownloadSOPFormatPDFReport(String processName) throws Exception {
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (name.equals(processName)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(2000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        test.log(Status.INFO, "User click On More option");
        applyWait.waitForElementToBeClickable(sopReportBtn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(pdfTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(10000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,90).click();
        Thread.sleep(9000);
        Assert.assertTrue(isFileDownloaded_Ext(baseClass.DownloadFilepath, "SOP.pdf"), "Failed to download Expected document");
        Thread.sleep(9000);
    }

    public void verifyBprPdfReportDownloaded(String processName) throws Exception{
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (name.equals(processName)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(2000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        test.log(Status.INFO, "User click On More option");
        applyWait.waitForElementToBeClickable(bprReportBtn,30).click();
        Thread.sleep(3000);
        selectAllCheckBoxOnReportOption();
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(pdfTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(10000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,90).click();
        Thread.sleep(9000);
        Assert.assertTrue(isFileDownloaded_Ext(baseClass.DownloadFilepath, "BPR.pdf"), "Failed to download Expected document");
        Thread.sleep(9000);
    }

    public void verifyBprReprtDownloadInWordFormat(String processName) throws Exception{
        String name;
        Thread.sleep(3000);
        clickOnMyProcessesOption();
        Thread.sleep(3000);
        for (int i = 0; i < processeslist.size(); i++) {
            name = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (name.equals(processName)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "Click Particular In-Progress Process");
                break;
            }
        }
        Thread.sleep(2000);
        applyWait.waitForElementToBeClickable(moreOptionBtn, 30).click();
        test.log(Status.INFO, "User click On More option");
        applyWait.waitForElementToBeClickable(bprReportBtn,30).click();
        Thread.sleep(9000);
        selectAllCheckBoxOnReportOption();
        applyWait.waitForElementToBeClickable(downloadAsTypeDropdown,30).click();
        applyWait.waitForElementToBeClickable(wordTypeOptionOfDownloadAsDrpdwn,30).click();
        Thread.sleep(10000);
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,90).click();
        Thread.sleep(20000);
        Assert.assertTrue(isFileDownloaded_Ext(baseClass.DownloadFilepath, "BPR.docx"), "Failed to download Expected document");
        Thread.sleep(9000);
    }
}
