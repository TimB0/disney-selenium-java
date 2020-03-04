package practice;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.*;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.EventReporter;
import utils.Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * <b>Locator Types:</b>
 *
 * <br>ID
 * <br>Name
 * <br>Class Name
 * <br>CSS Selector
 * <br>XPath
 *
 */

public class LocatorPracticeTests {

    EventFiringWebDriver driver;
    JavascriptExecutor js;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.register(new EventReporter());
        js = (JavascriptExecutor) driver;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //options.setHeadless(true);
        return options;
    }


    @Test
    public void testLocatorPractice() throws InterruptedException {

        // js.executeScript("document.getElementById('goc-ft-logo').click();");

        // js.executeScript("document.getElementByClassName('main-para').textContent");

        // js.executeScript("getElementsByTagName('div')[0].setAttribute('class', 'big-text'");

        driver.get("https://duckduckgo.com/");
        driver.findElement(By.name("q")).sendKeys("giant panda");
        driver.findElement(By.id("search_button_homepage")).click();
        driver.findElement(By.className("module--about")).click();

        driver.get("https://www.disney.com");
        Thread.sleep(9000);
        driver.findElement(By.name("q")).sendKeys("fantasia");
        driver.findElement(By.className("bar-search-icon")).click();





    }



        // About Disney link ID
        /*goHome();
        homePage.waitForPopUpAd();
        homePage.clickAboutDisneyFooterLink();
        assertEquals(getCurrentUrl(), Utilities.aboutDisneyUrl);*/
}
