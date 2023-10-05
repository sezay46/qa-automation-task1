package stepDefinitions;

import helpers.Helpers;
import pages.MainPage;
import pages.ResultPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCar extends Helpers {
    MainPage mainPage;
    ResultPage resultPage;

    @Before()
    public void setup() {
        openBrowser();
    }

    @After()
    public void tearDown() {
        closeBrowser();
    }

    @Given("the user has navigated to {string}")
    public void navigateToPageAndVerify(String url) {
        //1 - Navigate to https://www.mobile.bg/
        navigateTo(url);

        //2 - Verify that the page is correct and opened
        mainPage = new MainPage(getDriver());
        mainPage.verifyPageBeforeGivingPermissions();
        mainPage.givingPermission();
        mainPage.verifyCorrectPageOpened();
    }

    @When("the user selects {string} from dropdown")
    public void selectMarkaAndVerify(String marka) {
        //3 - Select from drop down list “Марка”, then search for Audi
        //4 - Verify that the selected name is Audi
        mainPage.selectMarkaAndVerifySelected(marka);
    }

    @When("the user fills out the maximum price field with random price")
    public void fillMaxPrice() {
        //5 - Click on the “Максимална цена” field and enter random prize
        mainPage.fillMaxPriceWithRandomPrice();
    }

    @When("the user clicks on the Search button")
    public void clickOnSearchButton() {
        //6 - Click on the “Търси” button
        mainPage.clickOnTheSearchButton();
    }

    @Then("the results from the search are shown to the user")
    public void verifyPageAndResults() {
        //7 - After page load verify the following statements
        //a - You are on a different page then previous one
        resultPage = new ResultPage(getDriver());
        resultPage.checkThatUrlChanged();
        resultPage.checkThatNewButtonsAppeared();

        //b - Price on a first vehicle is under the range you entered
        resultPage.checkThatFirstPriceIsUnderTheRange();

        //c - Vehicle name is Audi
        resultPage.checkTheVehicleName();
    }
}
