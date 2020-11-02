package config;

import helperMethods.dataGenerator;

/**
 * Created by manisha.jadhav on 12-02-2020.
 * In config
 */
public class defineConstants {

    dataGenerator produce = new dataGenerator();

    //Test data file Path
    public static final String Path_TestData = "Test_Data/Test_Data.xlsx";
    public static final String reportData = "report/DetailedReport.zip";
    public static final String role_Repository = "Test_Data/role_repository_template.xls";
    //Admin Credentials
    public static final int AdminURL_Row = 2;
    public static final int AdminURL_Col = 3;

    public static final int AdminUserName_Row = 7;
    public static final int AdminUserName_Col = 1;

    public static final int AdminPassword_Row = 7;
    public static final int AdminPassword_Col = 2;

    public static final int orgName_Row = 2;
    public static final int orgName_Col = 0;

    public static final int roleName_Row = 2;
    public static final int roleName_Col = 1;

    public static final int salary_Row = 2;
    public static final int salary_Col = 2;

    public static final int detail_Row = 2;
    public static final int detail_Col = 3;
    //Admin create New Role Data
    public static final String newRoleCreatedSuccessMsg = "Role added successfully";
    public static final String newRoleUploadedSuccessMsg = "Role repository excel uploaded successfully.";
    public static final String newLibrarySuccessMsg = "Process library updated successfully.";
    public static final String undoCheckoutSuccessMsg = "Undo check out successful.";

    //Designer Page Data for New Framework
    public static final String frameworkName = "HS Corporate 12";
    public static final String parentProcess = "Test1";
    public static final String childProcess1 = "Test2";
    public static final String childProcess2 = "Test3";
    public static final String importedRole = "roletest113";
    public static final String frameworkNameAuto = "AUTOMATIONFRAMEWORK";
    //    public final String frameworkName="HS CORPORATE 12" + produce.generateRandomString();
    public static final String searchString = "TESTCKZZSBUAOT";
    public static final String searchStringForDrawingDesignMap = "TESTHUIXMIJEIA";
    /* public final String parentProcess = "Test1" + produce.generateRandomString();
     public final String childProcess1 = "Test2" + produce.generateRandomString();
     public final String childProcess2 = "Test3" + produce.generateRandomString();
     */
    public static final String frameworkSavedSuccessMsg = "Success\n" + "Framework updated successfully.";
    public static final String librarySavedSuccessMsg = "Success\n" + "Process library updated successfully.";
    public static final String processMapSavedSuccessMsg = "Success\n" + "Process Map saved successfully.</div>";

    public static final String checkInSuccessMsg = "Success\n" + "Check in successful.";
    public static final String checkOutsuccessMsg = "Success\n" + "Check out successful.";
    public static final String savedProcedureMsg = "Procedure saved successfully";
    public static final String searchStringForInProgressProcess = "process";
    public static final String savedTaskAttributeMsg = "Task attributes updated succesfully";


    public static final String loginErrormsg = "Sign in failed";
}