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

    public static final int PAUserName_Row = 8;
    public static final int PAUserName_Col = 1;

    public static final int PAPassword_Row = 8;
    public static final int PAPassword_Col = 2;

    public static final int PASecondUserName_Row = 9;
    public static final int PASecondUserName_Col = 1;

    public static final int PASecondPassword_Row = 9;
    public static final int PASecondPassword_Col = 2;

    public static final int salary_Row = 2;
    public static final int salary_Col = 2;

    public static final int detail_Row = 2;
    public static final int detail_Col = 3;
    //Admin create New Role Data
    public static final String newRoleCreatedSuccessMsg = "Role added successfully";
    public static final String newRoleUploadedSuccessMsg = "Role repository excel uploaded successfully.";

    //Designer Page Data for New Framework
    public final String framework = "framework" + produce.generateRandomString();
    public final String childProcess1 = "Test2" + produce.generateRandomString();
    public final String childProcess2 = "Test3" + produce.generateRandomString();

    public static final String frameworkSavedSuccessMsg = "Success\n" + "Framework updated successfully.";
    public static final String librarySavedSuccessMsg = "Success\n" + "Process library updated successfully.";
    public static final String processMapSavedSuccessMsg = "Success\n" + "Process Map saved successfully.</div>";

    public static final String checkInSuccessMsg = "Success\n" + "Check in successful.";
    public static final String checkOutsuccessMsg = "Success\n" + "Check out successful.";
    public static final String savedProcedureMsg = "Success\n" + "Procedure saved successfully";
    public static final String searchStringForInProgressProcess = "costProcess";
    public static final String userAssignedMsg= "Success\n" + "Users assigned successfully.";
    public static final String sendApprovalMsg = "Success\n"+"Process sent for approval successfully.";
    public static final String processRejectApprovalMsg  = "Success\n" + "The Process is rejected";
    public static final String ProcessApprovedMsg = "×\n" + "Success\n" + "The process map is approved";
    public static final String commentAddedSuccessMsg = "Success\n" + "Comment added successfully.";
    public static final String searchApproveProcess = "Map";
    public static final String searchApproveFramework = "TESTZDOUU6CFSX";
    public static final String processPublishSuccessMsg="Success\n" + "Process published successfully.";
    public static final String versionChangedNumber = "X.0";

    //User Details
    public static final String processApprover = "Test User PA (PA)";
    public static final String secondProcessApproverUser = "PA  User (PA)";
    public static final String processEditor =  "Test user PE (PE)";

    public static final String loginErrormsg = "Sign in failed";
}