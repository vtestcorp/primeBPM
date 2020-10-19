package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;


public class VerifyNewFrameworkCreatedOnDesignerPage extends baseClass {
    @Test(alwaysRun = true)
    public void createFramwork() throws Exception {

        test = extent.createTest("User should be able to create NEW framework/library in the designer sectiona");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        DesignerPage designer = new DesignerPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        designer.verifyNewFrameworkCreatedSuccessfully();
        Thread.sleep(3000);
    }
}
