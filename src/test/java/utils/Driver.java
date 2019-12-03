package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

    private static WebDriver driver;
 //you can not d like this ,if constructor is private Driver obj = new Driver();
    private Driver(){

    }
    //if switch statement complains on string parameter
    //change java version to 7+ at least 8
    public static WebDriver get(){
        //if webdriver object was not created yet
        if(driver==null){
            //create webdriver object based on browser value from properties file
            String browser = ConfigurationReader.getProperty("browser");
            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    //if browser type is wrong throw exception
                    //no browser will be opened
                    throw new RuntimeException("Wrong browser type");
            }
        }
        //if webdriver object was created-you can use it
        return driver;
    }

    public static void close(){
        //if driver still exist
        if(driver!=null){
            //close all browsers
            driver.quit();
            //destroy driver object, ready for go
            driver=null;
        }
    }
}