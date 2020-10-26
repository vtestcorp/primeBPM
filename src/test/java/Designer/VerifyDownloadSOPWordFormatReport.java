package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;

public class VerifyDownloadSOPWordFormatReport extends baseClass{

        @Test(alwaysRun = true)
        public void verifyDownloadSOPWordFormatReport()throws Exception {
            test = extent.createTest("Download SOP Report (WORD)",
                    "User should be able to Download SOP Report in WORD format");

            loginPage login = new loginPage(driver, test);
            ExcelUtils read = new ExcelUtils();
            defineConstants defineConstant = new defineConstants();
            DesignerPage designerPage = new DesignerPage(driver, test);
            driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));
            login.loginWithValid_User();
            designerPage.verifyDownloadSOPWordFormatReport();
        }
}
