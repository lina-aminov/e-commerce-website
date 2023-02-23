package StepDefinitions;

import PageObjects.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static StepDefinitions.Hooks.driver;

public class CheckOutStepDefs {

    CheckoutPage checkoutPage;

    public CheckOutStepDefs() {
        checkoutPage = new CheckoutPage(driver);
    }

    @When("I am on the Checkout Page")
    public void iAmOnTheCheckoutPage() {
        checkoutPage = new CheckoutPage(driver);
    }

    @And("I click on Shipping method")
    public void iClickOnShippingMethod() {
        driver.findElement(By.cssSelector("button[name=confirmDeliveryOption]")).click();
    }

    @And("I enter payment details by BANK WIRE")
    public void iEnterPaymentDetailsByBANKWIRE() {
        driver.findElement(By.cssSelector("#payment-option-2")).click();
        driver.findElement(By.cssSelector("input[name=\"conditions_to_approve[terms-and-conditions]\"]")).click();
    }

    @Then("I click on Order to Pay")
    public void iClickOnOrderToPay() {
        driver.findElement(By.cssSelector("button.btn.btn-primary.center-block[type=submit]")).click();
    }

    @And("I click proceed to checkout again")
    public void iClickProceedToCheckoutAgain() {
        driver.findElement(By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a")).click();
    }

    @And("I enter my personal details like firstname {string} lastname {string} email {string}")
    public void iEnterMyPersonalDetailsLikeFirstnameLastnameEmail(String firstname, String lastname, String email) {
        checkoutPage.enterFirstName(firstname);
        checkoutPage.enterLastName(lastname);
        checkoutPage.enterEmail(email);
        driver.findElement(By.cssSelector("button[name=continue]")).click();
    }

    @And("I enter my address {string} city {string} zipcode {string}")
    public void iEnterMyAddressCityZipcode(String address, String city, String zipcode) {
        checkoutPage.enterAddress(address);
        checkoutPage.enterCity(city);
        Select drpState = new Select(driver.findElement(By.name("id_state")));
        drpState.selectByVisibleText("Delaware");
        checkoutPage.enterZipCode(zipcode);
        driver.findElement(By.cssSelector("button[name=confirm-addresses]")).click();
    }

}



