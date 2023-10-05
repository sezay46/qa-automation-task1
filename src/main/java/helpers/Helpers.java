package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Helpers {
    WebDriver driver;

    /**
     * Creates an instance of a Chrome driver by given options
     */
    public void openBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * Closes the instance of the Chrome driver
     */
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * Gets the driver if it needs to be used in some place
     * @return driver in type WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Navigates to given url
     * @param url in type String
     */
    public void navigateTo(String url) {
        driver.get(url);
    }
}
