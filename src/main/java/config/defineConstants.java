package config;

/**
 * Created by manisha.jadhav on 12-02-2020.
 * In config
 */
public class defineConstants {

    //Test data file Path
    public static final String Path_TestData = "Test_Data/Test_Data.xlsx";
    public static final String reportData = "report/DetailedReport.zip";
    //Admin Credentials
    public static final int AdminURL_Row = 2;
    public static final int AdminURL_Col = 3;

    public static final int AdminUserName_Row = 7;
    public static final int AdminUserName_Col = 1;

    public static final int AdminPassword_Row = 7;
    public static final int AdminPassword_Col = 2;

    public static final int AdminTenant_Row = 7;
    public static final int AdminTenant_Col = 3;

    public static final int AdminUserName_Row1 = 8;
    public static final int AdminUserName_Col1 = 1;

    public static final int AdminPassword_Row1 = 8;
    public static final int AdminPassword_Col1 = 2;

    public static final int TenantAdminUserName_Row1 = 9;
    public static final int TenantAdminUserName_Col1 = 1;

    public static final int TenantAdminPassword_Row1 = 9;
    public static final int TenantAdminPassword_Col1 = 2;

    public static final int TenantAdminTenant_Row = 9;
    public static final int TenantAdminTenant_Col = 3;

    //Admin create New Role Data
    public static final String newRoleCreatedSuccessMsg = "Role added successfully";

    //Designer Page Data for New Framework
    public static final String frameworkName="HS Corporate 12";
    public static final String parentProcess = "Test1";
    public static final String childProcess1 = "Test2";
    public static final String childProcess2 = "Test3";

    public static final String loginErrormsg = "Sign in failed";
}