package Designer;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Designer.loginPage;
import pageFactory_MyProcess.MyProcessesPage;

public class VerifyAddOrEditProcedureWithOptionFromMenuBar extends baseClass {

    @Test(alwaysRun = true)
    public void verifyAddOrEditProcedure() throws Exception {
        test = extent.createTest("Add/Edit Procedures (Procedure Tab on Menu Bar)",
                "User should be able to ADD or EDIT Procedures in Checked Out (editable) mode and VIEW it in Checked In (Locked) mode");

        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        MyProcessesPage myProcessesPage = new MyProcessesPage(driver, test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);

        myProcessesPage.addOrEditProcedureWithMenuBar();
    }
}