package test;

import Base.Baseclass;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.PayBillsPage;
import Pages.loginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPayBills extends Baseclass {
    @BeforeTest
    public void beforetest(){
        HomePage hm= new HomePage(driver);
        hm.clickLoginButton();
        loginPage lg = new loginPage(driver);
        lg.login("testuser1","testpassword");
    }
    @Test
    public void testAddNewPayee(){
        AccountPage account = new AccountPage(driver);
        account.clickPayBills();
        PayBillsPage payBills = new PayBillsPage(driver);
        payBills.clickAddPayeeBtn();
        payBills.doAddNewBiller("Mike","768435843");
        Assert.assertEquals(payBills.getConfirmationText(),"Payee Added Successful");
        Assert.assertTrue(payBills.getBillerNames().contains("Mike"),"Biller name is not listed");
    }
}
