package Designer;

import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Collabration.CollabrationPage;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;
import base.baseClass;

public class VerifyPublishedProcessMap extends baseClass{

    @Test(alwaysRun = true)
    public void verifyPublishesProcessMap()throws Exception {
        test = extent.createTest("Verify with valid username, password",
                "The user should be logged in successfully ");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        CollabrationPage collabrationPage = new CollabrationPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);
        collabrationPage.verifyPublishProcessMap();
        Thread.sleep(3000);
    }
}
