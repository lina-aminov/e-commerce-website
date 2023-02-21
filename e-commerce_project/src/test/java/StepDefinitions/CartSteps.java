package StepDefinitions;

import PageObjects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static StepDefinitions.Hooks.driver;

public class CartSteps {

    CartPage cartPage;

    public CartSteps(){
        cartPage = new CartPage(driver);
    }

    @Given("I navigate to cart with an item in it")
    public void iNavigateToCartWithAnItemInIt() {
        //background (waiting for Haider's code)

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
