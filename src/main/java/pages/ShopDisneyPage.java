package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShopDisneyPage {

    private WebDriver driver;

    public ShopDisneyPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPopUp clickSignInSignUp(){
        //List<WebElement> elements = driver.findElements(By.className("user-message"));
        //elements.size();
        WebElement signInSignUpLink = driver.findElement(By.cssSelector(".user:nth-child(1) .user-message"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(signInSignUpLink));
        signInSignUpLink.click();

        return new LoginPopUp(driver);
    }

    public void goTo() {
        driver.get("https://www.shopdisney.com/");
    }
}
