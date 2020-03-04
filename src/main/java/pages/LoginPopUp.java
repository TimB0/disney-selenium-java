package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utilities;

import java.io.IOException;

import static utils.Utilities.*;


public class LoginPopUp {

    private WebDriver driver;
    private String popUpFrameId = "disneyid-iframe";

    public LoginPopUp(WebDriver driver){
        this.driver = driver;
        //driver.switchTo().frame(1);
    }

    public SignUpPage clickCreateNewAccount() {
        driver.switchTo().frame(popUpFrameId);
        driver.findElement(By.linkText("Create an Account")).click();
        return new SignUpPage(driver);
    }

    public void enterEmail() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(popUpFrameId)));
        driver.switchTo().frame(popUpFrameId);
        //driver.findElement(By.cssSelector(".ng-valid-pattern:nth-child(1)")).click();
        //driver.findElement(By.cssSelector(".ng-valid-pattern:nth-child(1)")).sendKeys(getLastAddedUsersData(2));
        //driver.findElement(By.cssSelector(".ng-touched")).sendKeys("tboland1@gmail.com");
        //driver.findElement(By.cssSelector(".ng-touched")).sendKeys(getLastAddedUsersData(2));
        //driver.findElement(By.className(".ng-touched")).sendKeys(getLastAddedUsersData(2));
        driver.findElement(By.xpath("//input[@type='email']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(getLastAddedUsersData(2));
        //driver.findElement(By.className("ng-touched")).sendKeys(getLastAddedUsersData(2));

    }

    public void enterPassword() throws IOException {
        driver.findElement(By.xpath("//input[@type='password']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(getLastAddedUsersData(3));
        //driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(getLastAddedUsersData(3));
        //driver.findElement(By.className("ng-untouched")).sendKeys(getLastAddedUsersData(3));

    }

    public void clickLoginBtn() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Please Wait While We Log You In')]")));
    }

}
