package tests.seleniumtools;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class SwitchWindowTest extends BaseTest {

    @Test
    public void switchWindowTest() {
        saveInitialTab();
        switchWindow();
        driver.get("http://google.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("google.com"));
        deleteTabAndReturnInitial();
        driver.get("http://microsoft.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("microsoft.com"));
    }
}
