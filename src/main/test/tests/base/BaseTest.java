package tests.base;

import common.CommonAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.base.BasePage;
import pages.listing.RealtListingPage;
import pages.realthome.RealtHomePage;

import java.util.*;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected RealtHomePage realtHomePage;

    protected RealtListingPage realtListingPage;

    protected JavascriptExecutor je;

    protected Map<String, String> windows = new HashMap<>();

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

    @BeforeMethod
    public void before() {
        driver = CommonAction.createDriver();
        basePage = new BasePage(driver);
        realtHomePage = new RealtHomePage(driver);
        realtListingPage = new RealtListingPage(driver);
        je = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void after() {
        driver = null;
    }

    @AfterSuite
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
