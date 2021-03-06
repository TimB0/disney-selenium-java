package signup;

import base.BaseTests;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPopUp;
import pages.ShopDisneyPage;
import pages.SignUpPage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SignUpTests extends BaseTests {

    @Test
    public void testSuccessfulSignUp() throws InterruptedException, IOException {

        goHome();
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

        /**
         * Saving the Data before we click the Create Account button,
         * just in case its needed for debugging
         **/
        signUpPage.dataSaver();
        signUpPage.clickCreateAccountBtn();
        assertEquals(signUpPage.waitForAccountSuccessMessage(), "Account Created!", "Results text incorrect");
        signUpPage.clickContinueBtn();

        homePage.mouseOverUserMessage();
        homePage.verifyHiText(signUpPage.getFirstName());
        homePage.clickSignOut();
        shopDisneyPage.clickSignInSignUp();
    }


}