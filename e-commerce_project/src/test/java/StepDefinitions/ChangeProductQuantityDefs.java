package StepDefinitions;

import PageObjects.CartPage;
import PageObjects.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class ChangeProductQuantityDefs {

    HomePage homePage;
    CartPage cartPage;

    public ChangeProductQuantityDefs() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @When("I click {int} times on change quantity button")
    public void iClickOnChangeQuantityButton(int clicks) {
        homePage.clickChangeQuantityHomePage(clicks);
    }

    @Then("I see the changed {int} items product quantity")
    public void iSeeTheChangedProductQuantity(int product) {
        homePage.addingProductQuantity(product);
    }
}
