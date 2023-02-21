package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AccountPage {
    private WebDriver driver;
    private By MyaccText = By.xpath("//h2[contains(text(),'My Account')]");

    private By MyOrderText = By.xpath("//h2[contains(text(),'My Orders')]");

    private By MyAffAcc = By.xpath("//h2[contains(text(),'My Affiliate Account')]");

    private By Newssettler = By.xpath("//h2[contains(text(),'Newsletter')]");

    private By YourStoreText = By.xpath("//a[contains(text(),'Your Store')]");
    public AccountPage(WebDriver driver){
        this.driver=driver;
    }
    public void VerifyMyAccText(){
        String expectedText= "My Account";
        String trueText = driver.findElement(MyaccText).getText();
        if(expectedText.equalsIgnoreCase(trueText)){
            System.out.println("Correct text is visible");
        }else{
            System.out.println("Wrong text is visible");
        }
    }
    public void ClickOnStore(){

        driver.findElement(YourStoreText).click();
        System.out.println("Your Store has been clicked");
    }
}
