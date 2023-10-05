package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'mobile.bg')]")
    WebElement textInHeader;

    @FindBy(xpath = "//img[contains(@alt,'mobile.bg')]")
    WebElement textInImage;

    @FindBy(xpath = "//button[@class='fc-button fc-cta-consent fc-primary-button']")
    WebElement permissionButton;

    @FindBy(xpath = "//div[@id='blocksrc']")
    WebElement searchBlock;

    @FindBy(xpath = "//img[contains(@alt,'Mobile.bg')]")
    WebElement textInImageAfterPermissions;

    @FindBy(xpath = "//select[@name='marka']")
    WebElement markaDropDown;

    @FindBy(xpath = "//input[@name='price1']")
    WebElement maxPrice;

    @FindBy(xpath = "//input[@id='button2']")
    WebElement searchButton;

    /**
     * Constructor for Main Page where the elements are initialized for Page Factory
     * @param driver in type WebDriver
     */
    public MainPage(WebDriver driver) {
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
     * Verify page before clicking on give permission button
     */
    public void verifyPageBeforeGivingPermissions() {
        this.find(textInHeader);
        this.find(textInImage);
    }

    /**
     * Click on the "To Site" button to give permission
     */
    public void givingPermission() {
        permissionButton.click();
    }

    /**
     * Verify that the opened page is correct one
     */
    public void verifyCorrectPageOpened() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.mobile.bg/pcgi/mobile.cgi";
        Assertions.assertEquals(currentUrl, expectedUrl);

        this.find(searchBlock);
        this.find(searchButton);
        this.find(textInImageAfterPermissions);
    }

    /**
     * Select marka from drop down field and verify that it is selected correctly
     * @param marka in type String
     */
    public void selectMarkaAndVerifySelected(String marka) {
        Select dropdown = new Select(markaDropDown);
        dropdown.selectByVisibleText(marka);

        WebElement selectedOptionFromDropDown = dropdown.getFirstSelectedOption();
        Assertions.assertEquals(selectedOptionFromDropDown.getText(), marka);
    }

    /**
     * Fill out the maximum price field with random generated price
     */
    public void fillMaxPriceWithRandomPrice() {
        Random rand = new Random();
        int randomPrice = rand.nextInt(1000,10000);
        maxPrice.sendKeys(Integer.toString(randomPrice));
    }

    /**
     * Click on the Search button
     */
    public void clickOnTheSearchButton() {
        searchButton.click();
    }
}
