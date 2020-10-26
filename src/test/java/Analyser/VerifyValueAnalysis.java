package Analyser;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Analyser.AnalyserPage;
import pageFactory_Designer.loginPage;

public class VerifyValueAnalysis extends baseClass{

    @Test(alwaysRun = true)
    public void verifyValueAnalysis() throws  Exception{
        test = extent.createTest("Perform Value Analysis",
                "User should be able to perform Value Analysis");
        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        AnalyserPage analyserPage = new AnalyserPage(driver,test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);
        analyserPage.verifyValueAnalysis();
        Thread.sleep(3000);
    }
}
