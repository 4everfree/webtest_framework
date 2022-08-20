package tests.base.searchapartments;

import org.testng.annotations.Test;
import pages.base.BasePage;
import tests.base.BaseTest;

public class SearchApartTest extends BaseTest {

    @Test
     public void checkIsRedirectToListing() {

         basePage.open("https://realt.by");
         realtHomePage
                 .enterCount()
                 .clickToFind();

         realtListingPage.checkCountCards();
     }
}