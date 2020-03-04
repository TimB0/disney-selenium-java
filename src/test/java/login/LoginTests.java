package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPopUp;
import pages.ShopDisneyPage;
import pages.SignUpPage;
import utils.Utilities;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static utils.Utilities.getLastAddedUsersData;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin() throws InterruptedException, IOException {
        goHome();
        ShopDisneyPage shopDisneyPage = homePage.clickShop();
        LoginPopUp loginPopUp = shopDisneyPage.clickSignInSignUp();

        loginPopUp.enterEmail();
        loginPopUp.enterPassword();
        loginPopUp.clickLoginBtn();

        homePage.mouseOverUserMessage();
        AccountPage accountPage = homePage.clickMyAccount();

        String expectedCustomerName = getLastAddedUsersData(0) + " " + getLastAddedUsersData(1);
        String actualCustomerName = accountPage.getActualCustomerName();
        assertEquals(actualCustomerName, expectedCustomerName, "Customer Name doesn't matter");
        loginPopUp.toString();
    }
}
