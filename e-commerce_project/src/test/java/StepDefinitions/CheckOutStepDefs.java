package StepDefinitions;

import PageObjects.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static StepDefinitions.Hooks.driver;

public class CheckOutStepDefs {
    CheckoutPage checkoutPage;
    @Given("I am on the Checkout Page")
    public void iAmOnTheCheckoutPage() {

    }


    @When("I enter my personal details")
    public void iEnterMyPersonalDetails() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillDetails();
        driver.findElement(By.cssSelector("#customer-form > footer > button")).click();
    }


    @And("I enter my address")
    public void iEnterMyAddress() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillDetailsAgain();
        driver.findElement(By.cssSelector("#delivery-address > div > footer > button")).click();
    }

    @And("I click on Shipping method")
    public void iClickOnShippingMethod() {
        driver.findElement(By.cssSelector("#js-delivery > button"));
    }

    @And("I enter payment details by BANK WIRE")
    public void iEnterPaymentDetailsByBANKWIRE() {
        driver.findElement(By.cssSelector("#payment-option-2"));
        driver.findElement(By.cssSelector("#conditions_to_approve\\[terms-and-conditions\\]"));
        driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button"));
    }

    @Then("I click on Order to Pay")
    public void iClickOnOrderToPay() {
        driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button"));
    }
}
