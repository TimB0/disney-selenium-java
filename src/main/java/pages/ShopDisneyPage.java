package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopDisneyPage {

    private WebDriver driver;

    public ShopDisneyPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPopUp clickSignInSignUp(){
        driver.findElement(By.cssSelector(".user:nth-child(1) .user-message")).click();
        return new LoginPopUp(driver);
    }
}
