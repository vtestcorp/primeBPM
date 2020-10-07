package pageFactory_Admin;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.ExcelUtils;
import helperMethods.dataGenerator;
import helperMethods.waitTypes;
import junit.framework.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class AdminPage {
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

    @FindBy(xpath = "//md-icon[@md-svg-src='dist/img/icons/ic_search.svg']")
    private WebElement searchRole;

    @FindBy(xpath = "//tr[starts-with(@data-ng-repeat,'store in currentPageStores')]")
    private WebElement searchedRoleRecords;

    //End of Add New Role Popup Elements//

    //Start of Add New Role Popup Elements//
    @FindBy(id = "roleName")
    private WebElement roleInputField;

    @FindBy(id = "roleCost")
    private WebElement costInputField;

    @FindBy(id = "orgId")
    private WebElement organisationUnitDropDown;

    @FindBy(xpath = "//md-option[starts-with(@id,'select_option_')]")
    private WebElement optionFromOrganisationUnit;

    @FindBy(id = "orgCheckbox")
    private WebElement newOrganisationUnitCheckbox;

    @FindBy(id = "roleDescript")
    private WebElement descriptionTextarea;

    @FindBy(xpath = "//div[@data-ng-include='createRoleInclude']//span[contains(text(),'Submit')]")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@data-ng-include='createRoleInclude']//span[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//div[@class='toast-message']")
    private WebElement roleCreatedSuccessMsg;

    @FindBy(xpath = "//md-icon[@id='clickmore']")
    private WebElement moreBtn;

    @FindBy(xpath = "//span[@title='Download excel template to upload']")
    private WebElement excelTemplate;
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

    public String fillNewRoleDetails() {
        roleName = "Role" + produce.getRandomNumber();
        applyWait.waitForElementToBeClickable(roleInputField, 30).sendKeys(roleName);
        test.log(Status.INFO, "User enter name in role option");

        applyWait.waitForElementToBeClickable(costInputField, 30).sendKeys(String.valueOf(produce.getRandomNumber()));
        test.log(Status.INFO, "User enter cost of role");

        applyWait.waitForElementToBeClickable(descriptionTextarea, 30)
                .sendKeys("This role is accountable for- " + produce.generateRandomString());
        test.log(Status.INFO, "User enter description of role in description text area");
        return roleName;
    }

    public void clickOnSubmitBtn() {
        applyWait.waitForElementToBeClickable(submitBtn, 50).click();
        test.log(Status.INFO, "User click on Submit button");
    }

    public void clickOnSearchRoleButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(searchRole).perform();
        test.log(Status.INFO, "Click 'Search' icon on Role reposotory page");
    }

    public void clickOnMoreBtn() {
        applyWait.waitforElementToBeDisplayed(moreBtn, 30).click();
        test.log(Status.INFO, "User click on more button");
    }

    public void clickOnExcelTemplate() {
        applyWait.waitforElementToBeDisplayed(excelTemplate, 30).click();
        test.log(Status.INFO, "User click on excel template button");
    }

    public void verifynewRoleCreatedSuccessfully() {
        clickOnAdministrationTab();
        clickOnSettingTab();
        clickOnRoleRepository();
        clickOnNewRoleIcon();
        String roleName = fillNewRoleDetails();
        selectOrganisationUnitFromDropDown();
        clickOnSubmitBtn();
        applyWait.waitForElementToBeClickable(roleCreatedSuccessMsg, 90).isDisplayed();
        Assert.assertEquals(defineConstants.newRoleCreatedSuccessMsg, roleCreatedSuccessMsg.getText());
        clickOnSubmitBtn();
        applyWait.waitForElementToBeClickable(searchRole, 30).sendKeys(roleName);
        test.log(Status.INFO, "Search the name of recently added ROLE");
        Assert.assertTrue(searchedRoleRecords.isDisplayed());
    }


    public void verifyNewRoleGetImportedSuccessfully() throws Exception {
        ExcelUtils read = new ExcelUtils();
        driver.get("https://www.primebpmapp.com/ioadmin/#/view_account_admin/");
        Thread.sleep(5000);
        clickOnSettingTab();
        clickOnRoleRepository();
        clickOnMoreBtn();
        clickOnExcelTemplate();
        Thread.sleep(3000);
        String orgName = produce.generateName();
        read.Write(constants.orgName_Row, constants.orgName_Col, orgName, constants.role_Repository, "Sheet1");
        String role = produce.generateName();
        read.Write(constants.roleName_Row, constants.roleName_Col, role, constants.role_Repository, "Sheet1");
        int sal = produce.getRandomNumber();
        String salary = Integer.toString(sal);
        read.Write(constants.salary_Row, constants.salary_Col, salary, constants.role_Repository, "Sheet1");
        String details = produce.generateName();
        read.Write(constants.detail_Row, constants.detail_Col, details, constants.role_Repository, "Sheet1");

    }


}

