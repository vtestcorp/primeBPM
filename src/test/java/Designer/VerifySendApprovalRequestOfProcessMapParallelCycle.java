package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;
import pageFactory_MyProcess.MyProcessesPage;

public class VerifySendApprovalRequestOfProcessMapParallelCycle extends baseClass {

    @Test(alwaysRun = true)
    public void verifySendForApprovalParallelCycle() throws Exception{
        test = extent.createTest("Send Process for Approval (Parallel Cycle)",
                "User should be able to send process for Approval");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        MyProcessesPage myProcessesPage = new MyProcessesPage(driver, test);
        DesignerPage designerPage = new DesignerPage(driver,test);
        String framework = defineConstant.framework;
        String process = defineConstant.childProcess1;
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(9000);
        designerPage.verifyNewFrameworkCreatedSuccessfully(framework,process);
        designerPage.designingOfProcessMapUsingRapidDesignProcess(framework);
        designerPage.checkinCheckoutProcess();
        Thread.sleep(3000);
        myProcessesPage.verifySendApprovalRequestOfProcessMapParallelCycle(defineConstant.childProcess1);
        Thread.sleep(3000);
    }
}
