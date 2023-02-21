package StepDefinitions;

import PageObjects.AllProductsPage;
import PageObjects.CartPage;

import static StepDefinitions.Hooks.driver;

public class FiltersAndCategoriesSteps {

    AllProductsPage allProductsPage;

    public FiltersAndCategoriesSteps() {
        allProductsPage = new AllProductsPage(driver);
    }

}
