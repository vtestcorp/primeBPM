package pageFactory_Collabration;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.waitTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CollabrationPage {

    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;


    public CollabrationPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new waitTypes(driver);
        this.test = test;
    }

    defineConstants constants = new defineConstants();
    SoftAssert verify = new SoftAssert();

    //Start of Collabration Page element
    @FindBy(xpath = "//a[@href='#/collabration']")
    private WebElement collaborationTab;

    @FindBy(xpath = "//a[contains(@ng-click,'generateLink')]")
    private List<WebElement> processeslist;

    @FindBy(xpath = "//div[@class='td ng-binding ng-scope']")
    private List<WebElement> frameworkListOnCollaboration;

    @FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='layer-base']")
    private WebElement libraryElement;

    @FindBy(xpath = "//*[name()='g' and contains(@data-element-id,'Task')]//*[name()='rect']")
    private WebElement processBox;

    @FindBy(xpath = "//button[@title='Turn on Comments']")
    private WebElement turnOnCommentsBtn;

    @FindBy(xpath = "//button//span[contains(text(),'Publish Process')]")
    private WebElement publishProcessOption;

    @FindBy(xpath = "//textarea[contains(@ng-model,'newConvContent')]")
    private WebElement publishNoteDescriptionField;

    @FindBy(xpath = "//input[@id='version']")
    private WebElement versionAfterPublished;

    @FindBy(xpath = "//tr[contains(@ng-repeat,'listmsg in Comments')]")
    private List<WebElement> commentRowsOnCommentSummary;

    @FindBy(xpath = "//button//span[contains(text(),'Comments Summary')]")
    private WebElement commentSummaryBtn;

    @FindBy(xpath = "//button[contains(@ng-click,'answer')]")
    private WebElement closeIconOnPopup;

    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    private WebElement submitBtnOnFormOfProcessMap;

    @FindBy(xpath = "//div[contains(@id,'toast-container')]")
    public WebElement toastMsgs;

    @FindBy(xpath = "//a[@ui-sref='myprocess']")
    public WebElement myProcessTab;

    //Start Of Collaboration Page method
    public void verifyPublishProcessMap() throws  Exception {
        Actions actions = new Actions(driver);
        applyWait.waitForElementToBeClickable(myProcessTab,30).click();
        test.log(Status.INFO,"User click on MY PROCESSES tab");
        Thread.sleep(3000);
        String processNameOnMyProcess;
        for (int i = 0; i < processeslist.size(); i++) {
            processNameOnMyProcess = applyWait.waitForElementToBeClickable(processeslist.get(i), 30).getText();
            if (processNameOnMyProcess.equals(constants.searchApproveProcess)) {
                applyWait.waitForElementToBeClickable(processeslist.get(i), 30).click();
                test.log(Status.INFO, "User click on an APPROVED process map");
                break;
            }
        }
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(turnOnCommentsBtn,30).click();
        Thread.sleep(3000);
        applyWait.waitForElementToBeClickable(commentSummaryBtn,30).click();
        Thread.sleep(3000);
        int commentsCount = commentRowsOnCommentSummary.size();
        verify.assertTrue(commentsCount>0);
        actions.click(closeIconOnPopup).perform();
        test.log(Status.INFO,"VIEW comments provided by the Approver; if comments provided by approver doesn’t show up flag as exception");
        applyWait.waitForElementToBeClickable(publishProcessOption,30).click();
        test.log(Status.INFO,"User click on PUBLISH PROCESS option on top ");
        applyWait.waitForElementToBeClickable(publishNoteDescriptionField,30).sendKeys("Publish Note test");
        applyWait.waitForElementToBeClickable(submitBtnOnFormOfProcessMap,30).click();
        test.log(Status.INFO,"ADD Published NOTES for the published version and hit SUBMIT");
        Thread.sleep(9000);
        verify.assertEquals(toastMsgs.getText(),constants.processPublishSuccessMsg );
        Thread.sleep(3000);
        verify.assertTrue(versionAfterPublished.getText().contains(constants.versionChangedNumber));
        applyWait.waitForElementToBeClickable(collaborationTab,30).click();
        test.log(Status.INFO,"Go to Collaborate module ");
        Thread.sleep(3000);
        String processNameOnCollaboration;
        System.out.println(frameworkListOnCollaboration.size());
        for (int i = 0; i < frameworkListOnCollaboration.size(); i++) {
            processNameOnCollaboration = applyWait.waitForElementToBeClickable(frameworkListOnCollaboration.get(i), 30).getText();
            if (processNameOnCollaboration.equals(constants.searchApproveFramework.toUpperCase())) {
                applyWait.waitForElementToBeClickable(frameworkListOnCollaboration.get(i), 30).click();
                test.log(Status.INFO, "Click on process map recently published through double clicking on Framework/Library/Process map selections");
                break;
            }
        }
        Thread.sleep(3000);
        actions.doubleClick(libraryElement).perform();
        Thread.sleep(3000);
        actions.doubleClick(processBox).perform();
        verify.assertTrue(versionAfterPublished.isDisplayed());
        test.log(Status.INFO,"verify if the published version is visible");
    }
}
