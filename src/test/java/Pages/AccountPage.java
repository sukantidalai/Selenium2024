package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    public WebDriver driver;
    public AccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText="PAY BILLS")
    private WebElement payBillsLink;

    public void clickPayBills(){
        payBillsLink.click();
    }
}
