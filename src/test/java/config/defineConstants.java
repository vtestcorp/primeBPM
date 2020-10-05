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

    //Test data2.60.01 VTest  Envrionment
    public static final String storybookName = "2.80.01 VTest Envrionment";
    public static final String storybookNameForSQL = "2.80.01 VTest Envrionment-SQL";
    public static final String storybookNameForExchange = "2.80.01 VTest Envrionment-Exchange";
    public static final String noDataSourcestorybookName = "06302020_EmailTest";
    public static final String databaseServerName = "NX1TEST1";
    public static final String tenantName = "vtestTenant";
    public static final String ExistingstroybookName = "2.80.01 VTest Envrionment";
    public static final String editableStorybookName = "2.80.01 VTest";
    public static final String filteredStory = "vtest_Storybook1";
    public static final String type = "Processing";
    public static final String status = "Completed";
    public static final String createdby = "Manisha";
    public static final String folderPath = "\\NX1SERVICE1\\nexlpshare\\2.70\\";
    public static final String invalid_folderPath = "\\\\\\NX1SERVICE1\\nexlpshare\\2.60\\VTestSource\\albert_meyers\\albert_meyers_000_1_1.pst";
    public static final String delimitedFile = "DMfqhyonrQ";
    public static final String deletedDataSource = "nt9RJ6HPQa";
    public static final String runExportFile = "feMSCNhTta";
    public static final String deleteExportFile = "feMSCNhTta";
    public static final String entityType = "testType";
    public static final String taggedEntity = "account  ";
    public static final String deletedEntity = "asdsdffsd";
    public static final String taggedStorybook = "2.60.01 VTest Envrionment";
    public static final String userTobeaddInGroup = "test20@mailinator.com";
    public static final String storybookTobeaddInGroup = "2.70 MH Cluster Test 1";
    public static final String deletedDocstorybookName = "2.70 MH Test 1";
    public static final String databaseName = "EDDS1016103";
    public static final String tableName = "EDDSDBO.Document";
    public static final String databaseId = "ArtifactID (Int)";
    public static final String controlNumber = "ControlNumber (VarChar)";
    public static final String md5Hash = "MD5Hash (NVarChar)";
    public static final String custodian = "Custodian";
    public static final String groupId = "GroupIdentifier";
    public static final String process = "NexLP_ProcessingStatus (Int)";
    public static final String extracted = "ExtractedText";
    public static final String duplicateUser = "hannah@nexlp.com";
    public static final String editUser = "hannah.sbadmin@nexlp.com";
    public static final String tenantAdmin = "hannah.tenant@nexlp.com";
    public static final String dublicateExchange = "adasdas";
    public static final String clientId = "c359bc18d456d026e9dba19d6c";
    public static final String clientSecret = "bd6d137c8bdcb791839123f1e745df5cbd4e8aca";
    public static final String relativityURL = "https://relativity102.nexlp.com";
    public static final String relativityServiceURL = "https://relativity102.nexlp.com/Relativity.Services";
    public static final String authentication = "Windows authentication";
    public static final String bulk = "NX1DB2\\SQL2017";
    public static final String serverURL = " smtp.gmail.com";
    public static final String smtpUserName = "manisha@vtestcorp.com";
    public static final String smtpPassword = "dfecvuuffmfzokwt";
    public static final String smtpPort = "587";
    public static final String exchangeURL = "https://outlook.office365.com/EWS/Exchange.asmx";
    public static final String exchangeUserName = "NexlpTest1@nexlp.onmicrosoft.com";
    public static final String exchangegePassword = "WindyChiTst#18";
    public static final String insightGroupName = "TenantAdmin";
    public static final String insightGroupNameForTenant = "Default Tenant Admin";
    public static final String tenantSMTP ="smTenantAdmin";
    public static final String tenantSMTP1 ="TestXYmFpraR5Z";
    //Error message for storybook
    public static final String existingNameError = "A storybook with similar name and database combination already exists; please choose a new name";
    public static final String emptyNameError = "Please enter values for required fields (*)";
    public static final String successMsg = "Storybook created successfully.";
    public static final String afterDeleteMsg = "There is no data to display.";
    public static final String deleteConfirmation = "Are you sure you want to delete Export:";
    public static final String dataSourceError = "The file was unable to be uploaded because the file contains 1 column or is not comma-delimited";
    public static final String dataFileError = "Upload unsuccessful";
    public static final String duplicateError = "There is already a Data source with the name DMfqhyonrQ. Please pick another name.";
    public static final String duplicateUserError = "Couldn't create user";
    public static final String termReport = "TestjJt6yP58Ao";
    public static final String publishCosmic = "Testcosmic123";
    public static final String publishCosmicStorybook = "vtestDelta_Env";


    //Error message for system Admin
    public static final String createUserError = "Please enter values for required fields (*)";

    //Error message for login page
    public static final String loginErrormsg = "Sign in failed";
}