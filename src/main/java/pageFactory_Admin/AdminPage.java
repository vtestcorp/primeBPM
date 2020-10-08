package pageFactory_Admin;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.waitTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageFactory_Common.CommonLocators;

import java.util.List;

public class AdminPage extends CommonLocators {
    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;
    private String roleName;


    public AdminPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new waitTypes(driver);
        this.test = test;
    }

    defineConstants constants = new defineConstants();
    dataGenerator produce = new dataGenerator();

    //Start of Administration Page Elements//
    @FindBy(xpath = "//a[@id='Administration']")
    private WebElement administrationTab;

    @FindBy(xpath = "//a[@href='#/administration/settings/']")
    private WebElement settingSection;

    @FindBy(xpath = "//md-tab-item//span[contains(text(),'Role Repository')]")
    private WebElement roleRepositoryOption;

    @FindBy(xpath = "//div[@title='Create new organisation/role']")
    private WebElement newRoleButton;

    @FindBy(xpath = "//label[@class='expandSearch algnlt']//input")
    private WebElement searchRole;

    @FindBy(xpath = "//tr[starts-with(@data-ng-repeat,'store in currentPageStores')]")
    private WebElement searchedRoleRecords;

    //End of Add New Role Popup Elements//

    //Start of Add New Role Popup Elements//
    @FindBy(id = "roleName")
    private WebElement roleInputField;

    @FindBy(id = "roleCost")
    private  WebElement costInputField;

    @FindBy(id = "orgId")
    private WebElement organisationUnitDropDown;

    @FindBy(xpath = "//md-option[starts-with(@id,'select_option_')]")
    private WebElement optionFromOrganisationUnit;

    @FindBy(id = "orgCheckbox")
    private WebElement newOrganisationUnitCheckbox;

    @FindBy(id = "roleDescript")
    private  WebElement descriptionTextarea;

    @FindBy(xpath = "//div[@data-ng-include='createRoleInclude']//span[contains(text(),'Submit')]")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@data-ng-include='createRoleInclude']//span[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//div[@class='toast-message']")
    private  WebElement roleCreatedSuccessMsg;

    //End of Add New Role Popup Elements//

    //Start of Administration Page Methods//

    public void clickOnAdministrationTab() {
        applyWait.waitForElementToBeClickable(administrationTab, 50).click();
        test.log(Status.INFO, "User Click on administration tab");
    }

    public void clickOnSettingTab() {
        applyWait.waitForElementToBeClickable(settingSection, 30).click();
        test.log(Status.INFO, "User Click on setting section");
    }

    public void clickOnRoleRepository() {
        applyWait.waitForElementToBeClickable(roleRepositoryOption, 30).click();
        test.log(Status.INFO, "User Click on Role Repository Option section");
    }

    public void clickOnNewRoleIcon() {
        applyWait.waitForElementToBeClickable(newRoleButton, 30).click();
        test.log(Status.INFO, "User Click on new role button section");
    }

    public void selectOrganisationUnitFromDropDown() {
        applyWait.waitForElementToBeClickable(organisationUnitDropDown, 30).click();
        test.log(Status.INFO, "User Click on organisation unit drop down section");

        applyWait.waitForElementToBeClickable(optionFromOrganisationUnit, 30).click();
        test.log(Status.INFO, "User select an option from organisation unit drop down section");
    }

    public String fillNewRoleDetails(){
        roleName = "Role" + produce.getRandomNumber();
        applyWait.waitForElementToBeClickable(roleInputField,30).sendKeys(roleName);
        test.log(Status.INFO,"User enter name in role option");

        applyWait.waitForElementToBeClickable(costInputField,30).sendKeys(String.valueOf(produce.getRandomNumber()));
        test.log(Status.INFO,"User enter cost of role");

        applyWait.waitForElementToBeClickable(descriptionTextarea,30)
                .sendKeys("This role is accountable for- "+produce.generateRandomString());
        test.log(Status.INFO,"User enter description of role in description text area");
        return roleName;
    }

    public void clickOnSubmitBtn(){
        applyWait.waitForElementToBeClickable(submitBtn,50).click();
        test.log(Status.INFO,"User click on Submit button");
    }

    public void clickOnSearchRoleButton(){
        Actions actions = new Actions(driver);
        actions.click(searchRole).perform();
        test.log(Status.INFO,"Click 'Search' icon on Role reposotory page");
    }

    public void verifyNewRoleCreatedSuccessfully(){
        CommonLocators commonElements = new CommonLocators();
        clickOnAdministrationTab();
        clickOnSettingTab();
        clickOnRoleRepository();
        clickOnNewRoleIcon();
        String roleName = fillNewRoleDetails();
        selectOrganisationUnitFromDropDown();
        clickOnSubmitBtn();
        applyWait.waitForElementToBeClickable(roleCreatedSuccessMsg, 90).isDisplayed();
        Assert.assertEquals(defineConstants.newRoleCreatedSuccessMsg,roleCreatedSuccessMsg.getText());
        clickOnSearchRoleButton();
        applyWait.waitForElementToBeClickable(searchRole,30).sendKeys(roleName);
        test.log(Status.INFO,"Search the name of recently added ROLE");
        Assert.assertTrue(searchedRoleRecords.isDisplayed());
        test.log(Status.INFO,"Verify recently added ROLE display");
    }
}

