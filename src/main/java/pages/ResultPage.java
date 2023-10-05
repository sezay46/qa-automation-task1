package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@data-link='//www.mobile.bg/pcgi/mobile.cgi?topmenu=1&act=2&rub=1']")
    WebElement newSearchButton;

    @FindBy(xpath = "//a[@href='javascript:openLogPopup(1);']")
    WebElement saveTheSearch;

    @FindBy(xpath = "//span[contains(@class, 'price')]")
    WebElement priceOfFirstResult;

    @FindBy(xpath = "//td/b[translate(., translate(.,'0123456789',''), '')]")
    WebElement priceInTheSearch;

    @FindBy(xpath = "//a[contains(@class, 'mmm') and contains(text(),'Audi')]")
    WebElement vehicleName;

    /**
     * Constructor for Result Page where the elements are instantiated for Page Factory
     * @param driver in type WebDriver
     */
    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to find given element with adding explicit wait to wait until given time to be displayed
     * @param element in type WebDriver
     */
    public void find(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> element.isDisplayed());
    }

    /**
     * Checking that the url is changed on the Result page
     */
    public void checkThatUrlChanged() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.mobile.bg/pcgi/mobile.cgi";
        Assertions.assertNotEquals(currentUrl, expectedUrl);
    }

    /**
     * Checking that new buttons for New Search and Save Search are appeared
     */
    public void checkThatNewButtonsAppeared() {
        this.find(newSearchButton);
        this.find(saveTheSearch);
    }

    /**
     * Checking that the price of the first vehicle is under the searched maximum price
     */
    public void checkThatFirstPriceIsUnderTheRange() {
        String firstPrice = priceOfFirstResult.getText().replaceAll("\\s","");
        firstPrice = firstPrice.substring(0, firstPrice.length() - 3);
        Assertions.assertTrue(Integer.parseInt(priceInTheSearch.getText()) > Integer.parseInt(firstPrice));
    }

    /**
     * Checking that the vehicle name is correct as expected one
     */
    public void checkTheVehicleName() {
        this.find(vehicleName);
        String currentVehicleName = vehicleName.getText().substring(0, 4);
        String expectedVehicleName = "Audi";
        Assertions.assertEquals(currentVehicleName, expectedVehicleName);
    }
}
