package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import tutorialsNinjaPages.*;


public class Main {

    static  WebDriver driver;
    static HomePage objthomepage;

    static RegisterPage objtregisterpage;

    static RegisterSuccessPage objregsuccesspage;

    static AccountPage objaccpage;

    static YourStorePage objstorepage;

    static ProductPage objproductpage;

    static CartPage objcartpage;

    public static void navigatetoHomepage(){
        objthomepage = new HomePage(driver);
        objthomepage.clickonMyacc();
        objthomepage.clickonRegister();
    }
    public static void FillUpAllReqField(){
        objtregisterpage = new RegisterPage(driver);
        objtregisterpage.VerifyRegaccText();
        objtregisterpage.FirstNameField();
        objtregisterpage.LastNameField();
        objtregisterpage.EmailField();
        objtregisterpage.TelephoneField();
        objtregisterpage.Passwordfield();
        objtregisterpage.PassConfirmField();
        objtregisterpage.NewsletterSubscribe();
        objtregisterpage.PrivacyPolicy();
        objtregisterpage.ContinueBtn();

    }

    public static void VerifyRegSuccess(){
        objregsuccesspage = new RegisterSuccessPage(driver);
        objregsuccesspage.verifyRegSuccessText();
        objregsuccesspage.ClickOnContinueBtn();
    }

    public static void VerifyHeaderText_ClickOnyourStore(){
        objaccpage = new AccountPage(driver);
        objaccpage.VerifyMyAccText();
        objaccpage.ClickOnStore();
    }
    public static void ClickOnFirstItem(){
        objstorepage = new YourStorePage(driver);
        objstorepage.ClickOnFirstItemPage();
    }

    public static void ModifyQty_AddToCart(){
        objproductpage = new ProductPage(driver);
        objproductpage.modifiedQty();
        objproductpage.ClickOnAddtoCart();
        objproductpage.clickOnCartButton();
        objproductpage.clickOnViewCart();
    }

    public static void Verify_Logout(){
        objcartpage = new CartPage(driver);
        objcartpage.VerifyQuantity();
        objcartpage.VerifyTotalValue();
        objcartpage.ClickOnMyAcc();
        objcartpage.ClickOnLogout();
        objcartpage.verifyLogoutMsg();
    }

    public static void browsername(String drivername){
        if (drivername.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        } else if (drivername.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (drivername.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else{
            System.out.println("Invalid browser name");
        }
        if (driver != null) {
            driver.get("http://tutorialsninja.com/demo/");
            driver.manage().window().maximize();

        } else {
            System.out.println("Failed to load browser");
        }



    }
    public static void main(String[] args) throws InterruptedException {

       // WebDriver driver= null;

       String drivername ="chrome";

       browsername(drivername);



        navigatetoHomepage();

        Thread.sleep(2000);

        FillUpAllReqField();
        Thread.sleep(2000);
        VerifyRegSuccess();
        Thread.sleep(2000);
        VerifyHeaderText_ClickOnyourStore();
        Thread.sleep(2000);

        ClickOnFirstItem();
        Thread.sleep(2000);
        ModifyQty_AddToCart();
        Thread.sleep(2000);
        Verify_Logout();

        driver.quit();

    }
}