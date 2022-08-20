package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;
import pages.realthome.RealtHomePage;

public class RealtListingPage extends BasePage {
    public RealtListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//div[contains(@class,'listing') and contains(@class,'highlighted')]");

    public RealtListingPage checkCountCards() {
        waitElementIsVisible(driver.findElement(card));
        int countCard = driver.findElements(card).size();
        Assert.assertEquals(countCard, 20);
        return this;
    }
}
