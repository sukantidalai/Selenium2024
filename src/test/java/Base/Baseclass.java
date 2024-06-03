package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Baseclass {
    public static WebDriver driver;
    @Parameters({"browser"})
    @BeforeSuite
    public void beforeSuite(String browser){
        switch(browser){
            case "chrome":
                driver= new ChromeDriver();
                break;
            case "firefox":
                driver= new FirefoxDriver();
                break;
            default:
                System.out.println("Wrong input");
        }
        driver.manage().window().maximize();
        driver.get("https://birdbank.pythonanywhere.com/");

    }
    @AfterSuite
    public void afterSuite(){
       driver.quit();
    }
}
