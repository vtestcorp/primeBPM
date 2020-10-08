package pageFactory_Common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.defineConstants;
import helperMethods.dataGenerator;
import helperMethods.waitTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement toastMsgs;

    public WebElement getToastMsgs() {
        return toastMsgs;
    }
}
