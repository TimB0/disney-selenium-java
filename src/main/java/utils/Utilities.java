package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utilities {

    public static WebDriver driver;

    public static void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
