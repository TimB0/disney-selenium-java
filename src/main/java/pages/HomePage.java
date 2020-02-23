package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;
    private String shopLinkLocator = ".goc-desktop:nth-child(3) > a > u";
    private String modalCloseButtonClassLocator = "sprite close";
    private String modalCloseButtonCSSLocator = "#overlaybg > p > a";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

/*    public void closePopupAd() {
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        driver.switchTo().frame(0);
        WebElement modalCloseButton = driver.findElement(By.cssSelector(modalCloseButtonCSSLocator));
        modalCloseButton.click();
    }*/

    public ShopDisneyPage clickShop() throws InterruptedException {
        // closePopupAd();
        //WebDriverWait wait = new WebDriverWait(driver, 30);

        //WebElement modalCloseButton = driver.findElement(By.className(modalCloseButtonClassLocator));

        //WebElement modalCloseButton = driver.findElement(By.cssSelector(modalCloseButtonCSSLocator));

        //WebElement modalCloseButton = driver.findElement(By.cssSelector("a.sprite"));

        //WebElement modalCloseButton = driver.findElement(By.cssSelector("a.sprite close"));

        // WebElement modalCloseButton = driver.findElement(By.cssSelector("span#timer"));

        // wait.until(ExpectedConditions.visibilityOf(modalCloseButton));

        // JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("arguments[0].click();", modalCloseButton);

        /**
         * Popup ad is not currently visible to selenium, not even Selenium IDE, I
         * will need to handle it via cookie or javascript source code...
         * putting in sleep for now
         */
            Thread.sleep(15000);

        /*wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.cssSelector(shopLinkLocator)))).click();*/

        driver.findElement(By.cssSelector(shopLinkLocator)).click();
        return new ShopDisneyPage(driver);
    }

    public PopUpAdPage waitForPopUpAdPage() {
        return new PopUpAdPage(driver);
    }
}