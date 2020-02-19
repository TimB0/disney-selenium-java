package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpAdPage {

    private WebDriver driver;
    private By popUpAd = By.cssSelector("overlaybg");

    public PopUpAdPage(WebDriver driver){
        this.driver = driver;
    }

    public DisneyPlusPage clickPopUpAd() {
        driver.findElement(popUpAd).click();
        return new DisneyPlusPage(driver);
    }

    public void waitForPopUpAdToClose() {

    }
}
