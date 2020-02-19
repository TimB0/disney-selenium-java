package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisneyPlusPage {

    private WebDriver driver;
    private String url;

    public DisneyPlusPage(WebDriver driver){
        this.driver = driver;
        url = driver.getCurrentUrl();
    }

    public String getDisneyPlusPageUrl() {
        return url;
    }
}