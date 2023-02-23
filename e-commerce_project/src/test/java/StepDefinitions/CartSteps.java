package StepDefinitions;

import PageObjects.CartPage;
import PageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class CartSteps {

    HomePage homePage;
    CartPage cartPage;

    public CartSteps() {
        homePage = new HomePage(driver);
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

    @And("I change the quantity from {int} to {int}")
    public void iChangeTheQuantityFromTo(int quantity, int newQuantity) {
    }

    @Then("I see the changed {int} items quantity")
    public void iSeeTheChangedItemQuantity(int quantity) {
        cartPage.checkItemQuantity(quantity);
    }

    @When("^I am adding manually (-?\\d+) items into the cart$")
    public void iAmAddingManuallyItemsIntoTheCart(int num) {
        cartPage.addManuallyQuantity(num);
    }

    @When("^I am adding negative ([+-]?\\d+\\.?\\d*) items into the cart$")
    public void iAnAddingNegativeItemsIntoTheCart(int num) {
        cartPage.addManuallyQuantity(num);
    }

    @Then("I should see as {int} max value")
    public void iShouldSeeInvalidInput(int value) {
        cartPage.addManuallyQuantity(value);
    }

    @When("I am clicking {int} times on up button")
    public void iClickTimesOnUpButton(int quantity) {
        cartPage.clickChangeQuantity(quantity);
    }

    @And("I click {int} times on down button")
    public void iClickOnDownButton(int quantity) {
        cartPage.clickOnDownButton(quantity);
    }

}
