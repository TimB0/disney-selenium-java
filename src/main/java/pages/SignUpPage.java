package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SignUpPage<js> {

    private WebDriver driver;
    private Faker faker = new Faker();

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateAccountBtn() {
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public String generateFirstName() {
        String firstName = faker.name().firstName();
        return firstName;
    }

    public String generateLastName() {
        String lastName = faker.name().lastName();
        return lastName;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.name("firstName")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.name("lastName")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public String generateEmail() {
        String email = faker.internet().emailAddress();
        return email;
    }

    public String generatePassword() {
        String password = faker.internet().password();
        return password;
    }

    public String generateDOB() {
        Date dob = faker.date().birthday();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String dobString = df.format(dob);
        return dobString;
    }

    public void enterNewPassword(String password) {
        driver.findElement(By.name("newPassword")).sendKeys(password);
    }

    public void enterVerifyPassword(String password) {
        driver.findElement(By.name("verifyPassword")).sendKeys(password);
    }

    // mm/dd/yyyy
    public void enterDOB(String dob) {
        driver.findElement(By.name("dateOfBirth")).sendKeys(dob);
    }

    public String getAccountSuccessMessage() {
        String successMsg = driver.findElement(By.cssSelector("#did-ui-view > div > section > section > h2")).getText();
        return successMsg;
    }
}
