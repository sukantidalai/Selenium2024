package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PayBillsPage {
    WebDriverWait wait;
    public PayBillsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
    }
    @FindBy(id="add_payee")
    private WebElement addNewBillerbtn;
    @FindBy(xpath="//input[contains(@placeholder,\"Name\")]")
    private WebElement billerNameEdt;
    @FindBy(xpath="//input[contains(@placeholder,\"Number\")]")
    private WebElement billerNumberEdt;
    @FindBy(xpath="//label[text()=\"No\"]")
    private WebElement noRadioBtn;
    @FindBy(id="save")
    private WebElement savebtn;
    @FindBy(id="confirmationMessage")
    private WebElement confirmationMsgTxt;
    @FindBy(xpath="//table/tbody/tr/td[1]")
    private List<WebElement> billerNameElements;

    public void clickAddPayeeBtn(){
        addNewBillerbtn.click();
    }
    public void doAddNewBiller(String name,String number){
        wait.until(ExpectedConditions.visibilityOf(billerNameEdt)).sendKeys(name);
        billerNumberEdt.sendKeys(number);
        noRadioBtn.click();
        savebtn.click();
    }
    public String getConfirmationText(){
       return  confirmationMsgTxt.getText();
    }
    public List<String> getBillerNames(){
        List<String> billNames = new ArrayList<>();
        for(WebElement ele:billerNameElements){
            billNames.add(ele.getText());
        }
        return billNames;
    }
}
