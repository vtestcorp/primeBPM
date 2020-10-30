package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;

public class VerifyDownloadBprReportWordFormat extends baseClass {

    @Test(alwaysRun = true)
    @Parameters({"processName"})
    public void verifyDownloadBprReportWordFormat(String processName)throws Exception {
        test = extent.createTest("Download BPR Report (Word)",
                "User should be able to Download BPR Report in Word format ");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        DesignerPage designerPage = new DesignerPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));
        login.loginWithValid_User();
        designerPage.verifyBprReprtDownloadInWordFormat(processName);
    }
}
