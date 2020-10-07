package Admin;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.loginPage;
import pageFactory_Admin.AdminPage;


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
    }

    @Test
    public void VerifyAddNewRoleInAdministration() throws Exception {
        test = extent.createTest("Add Roles (Through Repository)",
                "User should be able to ADD Roles through Admin (Settings) page");
        AdminPage admin = new AdminPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        admin.verifynewRoleCreatedSuccessfully();
        Thread.sleep(3000);
    }
}
