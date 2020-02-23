package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPopUp {

    private WebDriver driver;
    private String popUpFrameId = "disneyid-iframe";

    public LoginPopUp(WebDriver driver){
        this.driver = driver;
    }

    public SignUpPage clickCreateNewAccount() {
        driver.switchTo().frame(popUpFrameId);
        driver.findElement(By.linkText("Create an Account")).click();
        return new SignUpPage(driver);
    }

}
