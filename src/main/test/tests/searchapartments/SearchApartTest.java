package tests.searchapartments;

import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;
@Listeners({TestListenerAdapter.class})
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
