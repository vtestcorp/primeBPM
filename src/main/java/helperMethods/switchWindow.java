package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by manisha.jadhav on 12-02-2020.
 * In helperMethods
 */
public class switchWindow {

    WebDriver driver;
    String primaryWindowHandle;

    public switchWindow(WebDriver driver) {
        this.driver = driver;
        this.primaryWindowHandle = driver.getWindowHandle();
    }

    public void switchToNewFrame() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void closeCurrentWindowAndSwitchToPrimaryFrame() {
        driver.close();
        driver.switchTo().window(primaryWindowHandle);
    }

    public void switchToParentFrame() {
        driver.switchTo().window(primaryWindowHandle);
    }

    public int windowCount() {
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        int size = (tabs.size());
        /*for (int i =1;i<tabs.size();i++){
            driver.switchTo().window(tabs.get(i));
        }*/
        //  driver.switchTo().window(tabs.get(0));
        return size;
    }

}