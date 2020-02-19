package signup;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPopUp;
import pages.ShopDisneyPage;
import pages.SignUpPage;

import static org.testng.Assert.assertEquals;

public class SignUpTests extends BaseTests {

    @Test
    public void testSuccessfulSignUp() throws InterruptedException {
        ShopDisneyPage shopDisneyPage = homePage.clickShop();

        LoginPopUp loginPopUp = shopDisneyPage.clickSignInSignUp();
        SignUpPage signUpPage = loginPopUp.clickCreateNewAccount();

        signUpPage.enterFirstName(signUpPage.generateFirstName());
        signUpPage.enterLastName(signUpPage.generateLastName());
        signUpPage.enterEmail(signUpPage.generateEmail());

        signUpPage.enterDOB(signUpPage.generateDOB());

        String password = signUpPage.generatePassword();
        signUpPage.enterNewPassword(password);
        signUpPage.enterVerifyPassword(password);

        signUpPage.clickCreateAccountBtn();
        assertEquals(signUpPage.getAccountSuccessMessage(), "Account Created!", "Results text incorrect");

        signUpPage.toString();

    }
}