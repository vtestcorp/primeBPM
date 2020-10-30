package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory_Designer.DesignerPage;
import pageFactory_Designer.loginPage;

public class VerifyRapidProcessMappingDesign extends baseClass {
    @Test(alwaysRun = true)
    @Parameters("framework")
    public void verifyRapidProcessMapping(String framework)throws Exception {
        test = extent.createTest("Build Process Map",
                "Designing of Process Map using: Rapid Process MappingDrawing Process Map");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        DesignerPage designer = new DesignerPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);
        designer.designingOfProcessMapUsingRapidDesignProcess(framework);
        Thread.sleep(1000);
    }
}
