package StepDefinitions;

import PageObjects.AllProductsPage;
import PageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class SortByFunctionSteps {

    HomePage homePage;
    AllProductsPage allProductsPage;

    public SortByFunctionSteps() {
        homePage = new HomePage(driver);
        allProductsPage = new AllProductsPage(driver);
    }


    @And("I click on the link to women's section")
    public void iClickOnTheLinkToWomenSSection() {
        allProductsPage.clickOnTheLink();

    }

    @And("I select Name, low to high from the drop down.")
    public void iSelectNameAToZFromTheSortByDropDown() {
        allProductsPage.filterFromLowToHigh();
    }

    @Then("the items are sorted in low to high order:")
    public void theItemsAreSortedFromLowToHigh() {
        allProductsPage.assertTheValues();
    }

    @When("I capture the product values.")
    public void iCaptureTheProductValues() {
        allProductsPage.captureProductPageValue();
    }
}
