package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static StepDefinitions.Hooks.driver;

public class RemoveFromCartSteps {

    @Given("I have an item in the cart")
    public void iHaveAnItemInTheCart() {
        //add item to the cart
        //ex. homePage.clickItem
        // xxxx.addToCart
        driver.get("http://3.11.77.136/index.php?controller=cart&action=show");
    }

    @When("I click bin button next to an item")
    public void iClickBinButtonNextToAnItem() {
//        cartPage.clickDeleteBtn;
        driver.findElement(By.cssSelector("a.remove-from-cart"));
    }

    @Then("the item disappears and {string} message displays")
    public void theItemDisappearsAndMessageDisplays(String message) {
        Assertions.assertEquals(message, driver.findElement(By.cssSelector("span.no-items")).getText());
    }
}
