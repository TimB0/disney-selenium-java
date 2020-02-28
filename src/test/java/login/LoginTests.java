package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPopUp;
import pages.ShopDisneyPage;
import pages.SignUpPage;
import utils.Utilities;

import java.io.IOException;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin() throws InterruptedException, IOException {
        ShopDisneyPage shopDisneyPage = homePage.clickShop();
        LoginPopUp loginPopUp = shopDisneyPage.clickSignInSignUp();

        loginPopUp.enterEmail();
        loginPopUp.enterPassword();
        loginPopUp.clickLoginBtn();

        homePage.mouseOverUserMessage();
        loginPopUp.toString();
    }
}
