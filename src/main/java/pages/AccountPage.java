package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public AccountPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public String getActualCustomerName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".account-name"))).getText();
    }

    public String getActualCustomerEmail() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".account-email"))).getText();
    }
}
