package tests.Vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.ConfigurationReader;
import utils.Driver;

//we write extends tests.TestBase to inherits @before and @after methods
//this class will be dedicated to tests related to login page only
//we don't have to find elements here
//we should find elements in page classes only
public class LoginTests extends TestBase {

    @Test(description = "Verify that page title is a 'Dashboard'")
    public void test1(){
        //create page object
        LoginPage loginpage = new LoginPage();
        //call login method
        //provide username and password
        loginpage.login(ConfigurationReader.getProperty("user_name"),ConfigurationReader.getProperty("password"));
        /*
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        //this is an explicit wait
        //it waits until title is ''Dashboard
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        */
        //verification page
        Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
    }
}




