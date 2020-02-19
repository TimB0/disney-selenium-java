package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopUp {

    private WebDriver driver;

    public LoginPopUp(WebDriver driver){
        this.driver = driver;
    }

    public SignUpPage clickCreateNewAccount() {
        driver.switchTo().frame(1);
        driver.findElement(By.linkText("Create an Account")).click();
        return new SignUpPage(driver);
    }

}
