package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

import static common.Config.IMPLICIT_WAIT;
import static common.Config.BROWSER;

public class CommonAction {
    private static WebDriver driver = null;

    private CommonAction() {
    }

    public static WebDriver createDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    driver = WebDriverManager.getInstance(DriverManagerType.CHROME).create();
                    break;
                default:
                    Assert.fail("Not valid web driver setting in config: " + BROWSER);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        }
        return driver;
    }
}
