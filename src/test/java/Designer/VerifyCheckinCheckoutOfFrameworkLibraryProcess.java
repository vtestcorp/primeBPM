package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;

import static base.baseClass.extent;

public class VerifyCheckinCheckoutOfFrameworkLibraryProcess extends baseClass{
    @Test(alwaysRun = true)
    @Parameters("framework")
    public void VerifyCheckinCheckoutOfFrameworkLibararyProcess(String framework) throws Exception {

        test = extent.createTest("Check In / Check Out (Framework/Library/Process Map)",
                "User should be able to perform Check In / Check Out functions without errors");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        DesignerPage designer = new DesignerPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        designer.checkinCheckoutFramework(framework);
        designer.checkinCheckoutLibrary();
        designer.checkinCheckoutProcess();
        Thread.sleep(3000);
    }
}
