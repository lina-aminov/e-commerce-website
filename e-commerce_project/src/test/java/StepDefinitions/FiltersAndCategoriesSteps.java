package StepDefinitions;

import PageObjects.AllProductsPage;
import PageObjects.CartPage;
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
}
