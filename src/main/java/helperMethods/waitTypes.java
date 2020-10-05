package helperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by manisha.jadhav on 12-02-2020.
 * In helperMethods
 */
public class waitTypes {

    WebDriver driver;
    WebDriverWait wait;

    public waitTypes(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToBeClickable(WebElement Element, int timeout) {

        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(Element));

        } catch (Exception e) {
            e.getMessage();
        }

        return Element;
    }

    public WebElement waitforElementToBeDisplayed(WebElement Element, int timeout) {

        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(Element));

        } catch (Exception e) {
            e.getMessage();
            System.out.println("" + e.getStackTrace());
        }

        return Element;


    }

    public void fluentWaitForelement() {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.withTimeout(2, TimeUnit.SECONDS);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                WebElement element = arg0.findElement(By.xpath("//div[@class='dropdown-content']//div[contains(@class,'dropdown-notification')]//p/strong[1]//i"));
                String color = element.getText();
                System.out.println("The button text has color :" + color);
                if (color.equals("Finished")) {
                    return true;
                }
                return false;
            }

        };
        System.out.println(function);
        wait.until(function);
    }
}
