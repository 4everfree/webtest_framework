package tests.seleniumtools;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class SwitchWindowTest extends BaseTest {

    @Test
    public void switchWindowTest() {
        driver.get("http://google.com");
        saveInitialTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("google.com"));
        switchWindow();
        deleteTabAndReturnInitial();
        driver.get("http://microsoft.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("microsoft.com"));
    }
}
