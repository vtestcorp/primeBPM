package pageFactory_Designer;

/**
 * Created by manisha.jadhav on 12-02-2020.
 * In pageFactory_MasterAdmin
 */

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.ExcelUtils;
import helperMethods.dataGenerator;
import helperMethods.waitTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;


    public loginPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new waitTypes(driver);
        this.test = test;
    }

    defineConstants constants = new defineConstants();
    dataGenerator produce = new dataGenerator();

    //Start Login Page Elements//
    @FindBy(name = "name")
    private WebElement emailID;

    @FindBy(name = "passwords")
    private WebElement password;

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    private WebElement signIn;

    @FindBy(xpath = "//a[@class='dropdown-toggle text-muted']")
    private WebElement profileIcon;

    @FindBy(xpath = "//a[@ng-click='gotoLogout();']//span")
    private WebElement logoutOption;

    //End Login Page Elements//

    //Start Login Page Methods//

    public void fillUserName(String userName) {
        applyWait.waitForElementToBeClickable(emailID, 30).sendKeys(userName);
        test.log(Status.INFO, "User entered  " + userName + " user name");
    }

    public void fillPassword(String pass) {
        applyWait.waitForElementToBeClickable(password, 30).sendKeys(pass);
        test.log(Status.INFO, "User entered " + pass + " Password");
    }

    public void clickOnSignIn() {
        applyWait.waitForElementToBeClickable(signIn, 30).click();
        test.log(Status.INFO, "User Click on sign in button");
    }

    //End Login Page Methods//

    //login with valid data//
    public void loginWithValid_User() throws Exception {
        ExcelUtils read = new ExcelUtils();
        fillUserName(read.getCellData(constants.AdminUserName_Row, constants.AdminUserName_Col, "Admin"));
        fillPassword(read.getCellData(constants.AdminPassword_Row, constants.AdminPassword_Col, "Admin"));
        clickOnSignIn();
    }

    //Login as a Process Approval
    public void loginAsProcessApproval_User() throws Exception {
        ExcelUtils read = new ExcelUtils();
        fillUserName(read.getCellData(constants.PAUserName_Row, constants.PAUserName_Col, "Admin"));
        fillPassword(read.getCellData(constants.PAPassword_Row, constants.PAPassword_Col, "Admin"));
        clickOnSignIn();
    }

    public void logoutFromApp(){
        applyWait.waitForElementToBeClickable(profileIcon,30).click();
        test.log(Status.INFO,"User click on profile icon");
        applyWait.waitForElementToBeClickable(logoutOption,30).click();
        test.log(Status.INFO,"User click on Log out option");
    }
}

