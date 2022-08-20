package tests.base;

import common.CommonAction;
import common.Config;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.listing.RealtListingPage;
import pages.realthome.RealtHomePage;

import java.util.*;
import java.util.stream.Collectors;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected RealtHomePage realtHomePage = new RealtHomePage(driver);

    protected RealtListingPage realtListingPage = new RealtListingPage(driver);

    protected JavascriptExecutor je = (JavascriptExecutor) driver;

    protected Map<String,String> windows = new HashMap<>();
    public void switchWindow() {
        windows.put("previous", driver.getWindowHandle());
        je.executeScript("window.open()");

        String currentWindow = driver.getWindowHandles().stream().filter(x -> !x.startsWith(windows.get("previous"))).findFirst().get();
        windows.put("current", currentWindow);
        driver.switchTo().window(currentWindow);
    }

    public void deleteTabAndReturnCurrent() {
        je.executeScript("window.close()");
        windows.put("current", windows.get("previous"));
        driver.switchTo().window(windows.get("current"));
    }
}
