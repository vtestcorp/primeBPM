package Designer;

import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory_Collabration.CollabrationPage;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;
import base.baseClass;

public class VerifyPublishedProcessMap extends baseClass{

    @Test(alwaysRun = true)
    @Parameters({"framework","processName"})
    public void verifyPublishesProcessMap(String framework, String processName)throws Exception {
        test = extent.createTest("Publish Process Map",
                "User should be able to Publish an APPROVED Process Map");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        CollabrationPage collabrationPage = new CollabrationPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);
        collabrationPage.verifyPublishProcessMap(framework, processName);
        Thread.sleep(3000);
    }
}
