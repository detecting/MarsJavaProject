package pagesPackage;

import helperPackage.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilityPackage.CustomWait;
import utilityPackage.ExcelDataConfig;

import java.awt.*;
import java.io.IOException;


public class LoginPage {

    //BrowserFactory browserObj;
    //driver constructor for the page
    public LoginPage() {
        PageFactory.initElements(BrowserFactory.driver, this);
    }

    //Webdriver wait
    WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 20);

    //Click on Sign In button
    @FindBy(how = How.XPATH, using = "//*[@id='home']/div/div[1]/div[1]/div/a[2]")
    @CacheLookup
    static WebElement SignIn;

    //Username definition
    @FindBy(how = How.XPATH, using = "//*[@id='generalModal']/div/div[1]/form/div[1]/input")
    @CacheLookup
    static WebElement Email;

    //Password definition
    @FindBy(how = How.XPATH, using = "//*[@id='generalModal']/div/div[1]/form/div[2]/input")
    @CacheLookup
    static WebElement Password;

    //Login button definition
    @FindBy(how = How.XPATH, using = "//*[@id='generalModal']/div/div[1]/form/div[4]/div")
    @CacheLookup
    static WebElement LoginButton;


    //Method to perform login actions
    public void loginSteps() throws HeadlessException {

        ExcelDataConfig excel = new ExcelDataConfig("./TestData/TestData.xlsx");

        //Click on SignIn button
//        CustomWait.wait("//*[@id='home']/div/div[1]/div[1]/div/a[2]", 30, 1);
        //use the rel path is better than abs one
        CustomWait.wait("//a[contains(text(),'Sign In')]", 30, 1);
        SignIn.click();

        //Send Value to the UserName textBox
        //wait until the title is displayed
        CustomWait.wait("//*[@id='generalModal']/div/div[1]/form/div[1]/input", 50, 2);
        Email.sendKeys(excel.getData("Login", 1, 0));
        System.out.println("Entered Username");


        //Send value to the password textBox
        CustomWait.wait("//*[@id='generalModal']/div/div[1]/form/div[2]/input", 50, 2);
        Password.sendKeys(excel.getData("Login", 1, 1));
        System.out.println("Entered Password");


        //Click on Login Button
        CustomWait.wait("//*[@id='generalModal']/div/div[1]/form/div[4]/div", 50, 1);
        LoginButton.click();
        System.out.println("Clicked on Login button");


    }

}
