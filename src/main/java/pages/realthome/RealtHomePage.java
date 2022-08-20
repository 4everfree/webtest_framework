package pages.realthome;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class RealtHomePage extends BasePage {

    public RealtHomePage(WebDriver driver) {
        super(driver);
    }

    By roomsCount = By.xpath("//select[@id='rooms']");
    By option2rooms = By.xpath("//select[@id='rooms']/option[@value='2']");
    By submit = By.xpath("//div[@class='inputs-buttons-right']//a[contains(@class,'btn-primary')]");

    @Step("enter count of rooms")
    public RealtHomePage enterCount() {
        driver.findElement(roomsCount).click();
        driver.findElement(option2rooms).click();
        return this;
    }

    @Step("click to find apartments")
    public RealtHomePage clickToFind() {
        driver.findElement(submit).click();
        return this;
    }
}
