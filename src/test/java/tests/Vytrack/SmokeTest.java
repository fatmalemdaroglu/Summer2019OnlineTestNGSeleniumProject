package tests.Vytrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.ConfigurationReader;

public class SmokeTest extends TestBase {


    @Test(dataProvider = "navigationInfo")
    public void smokeTest(String moduleName, String subModuleName, String pageSubTitle){
        extentTest = extentReports.createTest("Verify that page subtitle is equals to "+pageSubTitle);
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("user_name") , ConfigurationReader.getProperty("password"));
        loginPage.navigateTo(moduleName, subModuleName);
        loginPage.waitUntilLoaderMaskDisappear();
        loginPage.waitForPageSubtitle(pageSubTitle);
        Assert.assertEquals(loginPage.getPageSubTitle(),pageSubTitle);
        extentTest.pass("Verified that page subtitle "+ pageSubTitle+" is displayed");
    }

    @DataProvider(name = "navigationInfo")
    public Object[][] navigationInfo(){
        return new Object[][]{
                {"Dashboards" , "Dashboard" , "Dashboard"},
                {"Dashboards", "Manage Dashboards", "All Manage Dashboards"},
                {"Fleet" , "Vehicles" , "All Cars" },
                {"Customers" , "Accounts" , "All Accounts"},
                {"Activities", "Calls", "All Calls"},
                {"Activities", "Calendar Events", "All Calendar Events"},
                {"Sales", "Opportunities", "Open Opportunities"}

        };
    }
}
