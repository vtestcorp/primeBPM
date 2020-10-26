package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;
import pageFactory_MyProcess.MyProcessesPage;

public class VerifySendForApprovalForSerialCycleProcessMap extends  baseClass{

    @Test(alwaysRun = true)
    public void verifySendApprovalRequest()throws Exception {
        test = extent.createTest("Send Process for Approval (Serial Cycle)",
                "User should be able to send process for Approval");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        MyProcessesPage myProcessesPage = new MyProcessesPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);
        myProcessesPage.verifySendApprovalRequestOfProcessMapSerialCycle();
        Thread.sleep(3000);
    }
}
