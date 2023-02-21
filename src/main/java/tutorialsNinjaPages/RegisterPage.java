package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver){
            this.driver =driver;
    }
    private By fname = By.xpath("//input[@id='input-firstname']");
    private By lname = By.xpath("//input[@id='input-lastname']");
    private By email= By.xpath("//input[@id='input-email']");
    private By tphone = By.xpath("//input[@id='input-telephone']");

    private By pass = By.xpath("//input[@id='input-password']");

    private By passCon = By.xpath("//input[@id='input-confirm']");

    private By subscribe = By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]");
    private By agree = By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
    private By continueBtn = By.xpath("//input[@value='Continue']");
    private By RegText = By.xpath("//h1[contains(text(),'Register Account')]");
    public void VerifyRegaccText(){

        String expected = "Register Account";
        String actual = driver.findElement(RegText).getText();
        boolean boo = expected.equalsIgnoreCase(actual);
        if (boo) {
            System.out.println("Reg text is visible");
        }
        else {
            System.out.println("Reg text is not visible");
        }

    }
    public void FirstNameField(){
        driver.findElement(fname).sendKeys("Md Toasin");
        System.out.println("Fname is clicked");
    }
    public void LastNameField(){
        driver.findElement(lname).sendKeys("Habib");
        System.out.println("Lname is clicked");
    }


    public void EmailField() {
        driver.findElement(email).sendKeys("ntoasin30004@gmail.com");
        System.out.println("Email has been entered");
    }

    public void TelephoneField() {
        driver.findElement(tphone).sendKeys("01996131728");
        System.out.println("Telephone number has been entered");
    }

    public void Passwordfield() {
        driver.findElement(pass).sendKeys("1234");
        System.out.println("Password has been entered");
    }

    public void PassConfirmField() {
        driver.findElement(passCon).sendKeys("1234");
        System.out.println("Password confirm has been entered");
    }

    public void NewsletterSubscribe() {
        boolean isSelected = driver.findElement(subscribe).isSelected();

        if (isSelected == false) {
            driver.findElement(subscribe).click();
            System.out.println("Newsletter subscribe radio button has been clicked");
        }
    }

    public void PrivacyPolicy(){
        boolean isSelected = driver.findElement(agree).isSelected();
        if(isSelected==false){
            driver.findElement(agree).click();
            System.out.println("Privacy policy checkbox is clicked");
        }
    }

    public void ContinueBtn(){
        driver.findElement(continueBtn).click();
        System.out.println("Continue Btn is clicked");
    }
}
