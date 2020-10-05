package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.loginPage;


public class VerifyLoginWithValidDetails extends baseClass {
    @Test(alwaysRun = true)
    public void ValidLogin() throws Exception {

        test = extent.createTest("Verify with valid username, password",
                "The user should be logged in successfully ");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);
        //  design.createFramework();
        //       // Thread.sleep(3000);

    }
}
