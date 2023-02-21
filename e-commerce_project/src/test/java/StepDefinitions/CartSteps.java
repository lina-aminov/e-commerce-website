package StepDefinitions;

import PageObjects.CartPage;
import PageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class CartSteps {

    CartPage cartPage;

    public CartSteps(){
        cartPage = new CartPage(driver);
    }

    @When("I click bin button next to an item")
    public void iClickBinButtonNextToAnItem() {
        cartPage.clickDeleteItemBtn();
    }

    @Then("the item disappears and {string} message displays")
    public void theItemDisappearsAndMessageDisplays(String message) {
        cartPage.checkEmptyCartMSG(message);
    }
}
