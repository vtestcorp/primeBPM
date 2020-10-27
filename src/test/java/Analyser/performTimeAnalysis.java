package Analyser;

import base.baseClass;
import config.defineConstants;
import helperMethods.ExcelUtils;
import org.testng.annotations.Test;
import pageFactory_Analyser.AnalyserPage;
import pageFactory_Designer.loginPage;

public class performTimeAnalysis extends baseClass {

    @Test(alwaysRun = true)
    public void performTimeAnalysis() throws  Exception{
        test = extent.createTest("Perform Time Analysis",
                "User should be able to perform Execution Time and Delay Time Analysis");
        loginPage login = new loginPage(driver, test);
        ExcelUtils read = new ExcelUtils();
        defineConstants defineConstant = new defineConstants();
        AnalyserPage analyserPage = new AnalyserPage(driver,test);
        driver.get(read.getCellData(defineConstant.AdminURL_Row, defineConstant.AdminURL_Col, "Admin"));

        login.loginWithValid_User();
        Thread.sleep(3000);
        analyserPage.verifyTimeAnalysis();
        Thread.sleep(3000);
    }
}
