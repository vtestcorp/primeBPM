package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;
import pageFactory_MyProcess.MyProcessesPage;

public class VerifyRejectApprovalOfProcessMap extends baseClass {

    @Test(alwaysRun = true)
    public  void verifyRejectProcessMap() throws Exception {
        test = extent.createTest("Reject Process Map",
                "User should be able to reject Approval of Process Map");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        MyProcessesPage processesPage = new MyProcessesPage(driver,test);
        DesignerPage designerPage = new DesignerPage(driver, test);
        String framework = defineConstant.framework;
        String process = defineConstant.childProcess1;
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);
        designerPage.verifyNewFrameworkCreatedSuccessfully(framework,process);
        designerPage.designingOfProcessMapUsingRapidDesignProcess(framework);
        processesPage.verifySendApprovalRequestOfProcessMapSerialCycle(process);
        Thread.sleep(3000);
        login.logoutFromApp();
        login.loginAsProcessApproval_User();
        Thread.sleep(3000);
        designerPage.verifyRejectApproval(process);
        login.logoutFromApp();
        Thread.sleep(3000);
        login.loginAsSecondProcessApproval_User();
        designerPage.verifyRejectApproval(process);
        Thread.sleep(3000);
    }
}
