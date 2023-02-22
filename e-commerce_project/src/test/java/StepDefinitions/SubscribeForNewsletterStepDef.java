package StepDefinitions;


import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import PageObjects.SubscribeForNewsletterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static StepDefinitions.Hooks.driver;

public class SubscribeForNewsletterStepDef {

    HomePage homePage;
    RegistrationPage registrationPage;
    SubscribeForNewsletterPage subscribeForNewsletterPage;


    public SubscribeForNewsletterStepDef() {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        subscribeForNewsletterPage = new SubscribeForNewsletterPage(driver);
    }

    @When("I subscribe to the newsletter with the email address {string}")
    public void enterEmailToSubscriptionField(String email) {
        subscribeForNewsletterPage.enterEmailToSubscriptionField(email);
        subscribeForNewsletterPage.clickSubscribeButton();
    }



    @Then("The message: {string} is visible")
    public void confirmationMessageIsVisible(String confirmationMessage) {
        Assert.assertEquals(confirmationMessage, subscribeForNewsletterPage.getConfirmationMessage());
    }

    @When("I attempt to resubscribe to the newsletter with the email address {string}")
    public void enterSubscribedEmailToSubscriptionField(String subscribedEmail) {
        subscribeForNewsletterPage.enterSubscribedEmailToSubscriptionField(subscribedEmail);
        subscribeForNewsletterPage.clickSubscribeButton();
    }

    @Then("The message: {string} is shown instead")
    public void errorMessageIsVisible(String errorMessage) {
        Assert.assertEquals(errorMessage, subscribeForNewsletterPage.getErrorMessage());
    }

    @When("I attempt to subscribe to the newsletter without entering an email")
    public void iAttemptToSubscribeToTheNewsletterWithoutEnteringAnEmail() {
        subscribeForNewsletterPage.clickSubscribeButton();
    }

    @Then("The error message: {string} is shown")
    public void theErrorMessageIsShown(String invalidEmailMessage) {
        Assert.assertEquals(invalidEmailMessage, subscribeForNewsletterPage.getInvalidEmailMessage());
    }
}

