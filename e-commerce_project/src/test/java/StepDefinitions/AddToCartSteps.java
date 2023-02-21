package StepDefinitions;

import PageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class AddToCartSteps {

    HomePage homePage;

    public AddToCartSteps() {
        homePage = new HomePage(driver);
    }

    @Given("I'm on the home Page")
    public void iMOnTheHomePage() {
        homePage.goToHomePage();
    }

    @When("I click on a product")
    public void iClickOnAProduct() {
        homePage.clickOnProduct();
    }

    @And("I add a product to Cart")
    public void iAddAProductToCart() {
        homePage.addToCart();
    }

    @And("I click proceed to checkout")
    public void clickProceedToCheckout() {
        homePage.clickProceedToCheckout();
    }

    @Then("Confirm i am on the Checkout page")
    public void checkOutPageConfirmation() {
        homePage.checkOutPageConfirmation();
    }






}
