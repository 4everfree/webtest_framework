package tests.base;

import common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.listing.RealtListingPage;
import pages.realthome.RealtHomePage;

import java.util.*;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected RealtHomePage realtHomePage = new RealtHomePage(driver);

    protected RealtListingPage realtListingPage = new RealtListingPage(driver);

    protected JavascriptExecutor je = (JavascriptExecutor) driver;

    protected Map<String,String> windows = new HashMap<>();

    public void saveInitialTab() {
        windows.put("initial", driver.getWindowHandle());
    }
    public void switchWindow() {
        Set<String> openedWindowsSet = driver.getWindowHandles();
        je.executeScript("window.open()");

        Set<String> newlyOpenedWindowsSet = driver.getWindowHandles();
        newlyOpenedWindowsSet.removeAll(openedWindowsSet);
        String currentWindow = newlyOpenedWindowsSet.stream().findFirst().get();
        windows.put("current", currentWindow);
        driver.switchTo().window(currentWindow);
    }

    public void deleteTabAndReturnInitial() {
        driver.close();
        windows.put("current", windows.get("initial"));
        driver.switchTo().window(windows.get("current"));
    }
}
