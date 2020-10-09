package Admin;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Admin.AdminPage;
import pageFactory_Designer.loginPage;


public class VerifyRoleGetUploadedSuccessfully extends baseClass {
    @Test(alwaysRun = true)
    public void validLogin() throws Exception {

        test = extent.createTest("User should be able to insert Roles through Admin (Settings) page by uploading Excel Templates");

        loginPage login = new loginPage(driver, test);
        AdminPage admin = new AdminPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));
        login.loginWithValid_User();
        admin.verifyNewRoleGetImportedSuccessfully();
        Thread.sleep(3000);
    }
}
