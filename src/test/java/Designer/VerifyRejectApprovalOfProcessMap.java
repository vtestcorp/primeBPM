package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;

public class VerifyRejectApprovalOfProcessMap extends baseClass {

    @Test(alwaysRun = true)
    public  void verifyRejectProcessMap() throws Exception {
        test = extent.createTest("Reject Process Map",
                "User should be able to reject Approval of Process Map");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        DesignerPage designerPage = new DesignerPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginAsProcessApproval_User();
        Thread.sleep(3000);
        designerPage.verifyRejectApproval();
        login.logoutFromApp();
        Thread.sleep(3000);
        login.loginAsSecondProcessApproval_User();
        designerPage.verifyRejectApproval();
        Thread.sleep(3000);
    }
}
