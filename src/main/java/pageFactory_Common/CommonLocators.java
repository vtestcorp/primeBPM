package pageFactory_Common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.screenshots;
import helperMethods.waitTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CommonLocators {
    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;
    private String roleName;

    public void commonLocators(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new waitTypes(driver);
        this.test = test;
    }

    @FindBy(xpath = "//div[contains(@id,'toast-container')]")
    public WebElement toastMsgs;

    @FindBy(xpath = "//button[@ng-model='checkIn']")
    public WebElement checkinBtn;

    @FindBy(xpath = "//button[contains(@class,'Yes')]//span")
    public WebElement yesConfirmationPopup;

    @FindBy(xpath = "//button[@ng-model='checkOut']")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    public WebElement submitBtnOnForm;



    //End Of Common locators throughout application//
    //Start of common methods//
}
