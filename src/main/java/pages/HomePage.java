package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class HomePage {

    private WebDriver driver;
    private String shopLinkLocator = ".goc-desktop:nth-child(3) > a > u";
    private String modalCloseButtonClassLocator = "sprite close";
    private String modalCloseButtonCSSLocator = "#overlaybg > p > a";
    private JavascriptExecutor js;



    public HomePage(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = js;
    }


    public void mouseOverUserMessage() {
        /**
         * If we "click" on "Hi User!", none of the drop down menu items will work
         * We have to mouse over the "Hi User!" in order for any of the drop down menu items to work
         * This may be a bug
         */
        driver.switchTo().defaultContent();
        //List<WebElement> elements = driver.findElements(By.className("user-message"));
        //elements.size();
        WebElement userMessage = driver.findElement(By.cssSelector(".user:nth-child(1) .user-message"));
        userMessage.getText();
        Actions actions = new Actions(driver);
        actions.moveToElement(userMessage).perform();
        actions.build();
        //driver.findElement(By.xpath("//*[text() = 'Hi "+signUpPage.getFirstName()+"!']")).click();
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Please Wait While We Log You In')]")));
        //wait.until(ExpectedConditions.elementToBeClickable(
        //driver.findElement(By.xpath("//*[contains(text(),'Hi ')]"))));
        //driver.getPageSource();
        //driver.findElement(By.xpath("//*[text() = 'Continue']")).click();
        //driver.findElement(By.cssSelector(".user:nth-child(1) .user-message")).click();
    }

    public void clickAboutDisneyFooterLink() {
        js.executeScript("document.getElementById('goc-ft-logo').click();");
    }

    public void clickSignOut() {
        // driver.findElement(By.className("signout")).click();
        // WebElement signout = driver.findElement(By.cssSelector(".user:nth-child(1) .signout"));
        // signout.click();
        driver.findElement(By.cssSelector(".user:nth-child(1) .signout")).click();
        // Actions builder = new Actions(driver);
        //builder.moveToElement(signout).clickAndHold().perform();
        //builder.moveToElement(signout).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'See Ya Real Soon')]")));
    }

    public AccountPage clickMyAccount() {
        WebElement myAccount = driver.findElement(By.cssSelector("[data-linkid='global_nav/upper_nav/upper_nav/account']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(myAccount).click().perform();
        return new AccountPage(driver);
    }

    public void verifyHiText(String firstName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Hi "+firstName+"!')]")));
    }



    public ShopDisneyPage clickShop() throws InterruptedException {
        waitForPopUpAd();

        /*wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.cssSelector(shopLinkLocator)))).click();*/

        driver.findElement(By.cssSelector(shopLinkLocator)).click();
        return new ShopDisneyPage(driver);
    }

    public void waitForPopUpAd() throws InterruptedException {
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
        Thread.sleep(10000);
    }

    /*    public void closePopupAd() {
            int size = driver.findElements(By.tagName("iframe")).size();
            System.out.println(size);
            driver.switchTo().frame(0);
            WebElement modalCloseButton = driver.findElement(By.cssSelector(modalCloseButtonCSSLocator));
            modalCloseButton.click();
        }*/

    public PopUpAdPage waitForPopUpAdPage() {
        return new PopUpAdPage(driver);
    }
}