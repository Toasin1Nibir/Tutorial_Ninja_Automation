package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private By QtyField = By.xpath("//input[@id='input-quantity']");
    private By AddtoCartBtn = By.xpath("//button[@id='button-cart']");

    private By cartBtn = By.xpath("//div[@id='cart']");
    private By viewCart = By.xpath("//strong[contains(text(),'View Cart')]");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    public void modifiedQty(){
        WebElement qty =driver.findElement(QtyField);
        qty.clear();
        qty.sendKeys("5");
        System.out.println("Quantity has been modified");

    }
    public void ClickOnAddtoCart(){
        driver.findElement(AddtoCartBtn).click();
        System.out.println("Add to cart button has been clicked");
    }

    public void clickOnCartButton() {
        driver.findElement(cartBtn).click();
        System.out.println("Cart button has been clicked");

    }
    public void clickOnViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));
        driver.findElement(viewCart).click();
        System.out.println("View cart has been clicked");

    }
}
