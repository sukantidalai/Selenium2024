package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    private WebDriver driver;
    public loginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name="username")
    private WebElement usernameField;
    @FindBy(name="password")
    private WebElement passwordField;
    @FindBy(id="signin")
    private WebElement signinButtonField;
   public void login(String userName,String password){
       usernameField.sendKeys(userName);
       passwordField.sendKeys(password);
       signinButtonField.click();
   }
}
