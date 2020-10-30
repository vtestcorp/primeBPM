package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;
import pageFactory_MyProcess.MyProcessesPage;

public class VerifyApprovalProcessMap extends baseClass {

    @Test(alwaysRun = true)
    @Parameters("processName")
    public void VerifyApprovalProcessMap(String processName) throws Exception {
        test = extent.createTest("Approve Process Map",
                "User should be able to Approve Process Map");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        DesignerPage designerPage = new DesignerPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginAsProcessApproval_User();
        Thread.sleep(3000);
        designerPage.approveProcessMap(processName);
        login.logoutFromApp();
        Thread.sleep(3000);
        login.loginAsSecondProcessApproval_User();
        designerPage.approveProcessMap(processName);
        Thread.sleep(3000);
    }

}
