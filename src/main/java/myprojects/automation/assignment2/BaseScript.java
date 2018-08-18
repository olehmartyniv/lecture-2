package myprojects.automation.assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() {
        File resourceName = new File("src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", resourceName.getAbsolutePath());
        return new ChromeDriver();
    }
}
