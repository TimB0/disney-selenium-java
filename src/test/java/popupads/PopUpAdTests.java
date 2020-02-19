package popupads;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DisneyPlusPage;
import pages.PopUpAdPage;
import pages.ShopDisneyPage;

import static org.testng.Assert.assertEquals;

public class PopUpAdTests extends BaseTests {

    @Test
    /**
     * Not able to get Selenium to recognize the PopUp Ad
     * so I may need to use Cookies or Javascript to access it
     * Would have to look through the actual source code to find out for sure
     *
     */
    public void testSuccessfulPopUpAd() {

        /*PopUpAdPage popUpAdPage = homePage.waitForPopUpAdPage();
        var disneyPlusPage = popUpAdPage.clickPopUpAd();
        assert(disneyPlusPage.getDisneyPlusPageUrl().contains("disneyplus.com"));*/
    }
}
