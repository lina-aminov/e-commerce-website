package StepDefinitions;

import PageObjects.AllProductsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class FiltersAndCategoriesSteps {

    AllProductsPage allProductsPage;

    public FiltersAndCategoriesSteps() {
        allProductsPage = new AllProductsPage(driver);
    }

    @When("I go to All Products Page")
    public void iGoToAllProductsPage() {
        allProductsPage.clickAllProductsBtn();
    }

    @When("I choose filters I want to apply")
    public void iChooseFiltersIWantToApply(DataTable filters) {
        allProductsPage.chooseFilters(filters);
    }

    @Then("the filters are applied")
    public void theFiltersAreApplied() {
        allProductsPage.checkFiltersDisplayed();
    }
}
