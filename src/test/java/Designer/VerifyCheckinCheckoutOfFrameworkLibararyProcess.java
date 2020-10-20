package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;

import static base.baseClass.extent;

public class VerifyCheckinCheckoutOfFrameworkLibararyProcess  extends baseClass{
    @Test(alwaysRun = true)
    public void VerifyCheckinCheckoutOfFrameworkLibararyProcess() throws Exception {

        test = extent.createTest("Verify with valid username, password",
                "The user should be logged in successfully ");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        DesignerPage designer = new DesignerPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        designer.checkinCheckoutFramework();
        designer.checkinCheckoutLibrary();
        designer.checkinCheckoutProcess();
        Thread.sleep(3000);
    }
}
