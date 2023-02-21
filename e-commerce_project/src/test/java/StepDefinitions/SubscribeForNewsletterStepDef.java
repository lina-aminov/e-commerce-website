package StepDefinitions;


import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import PageObjects.SubscriptionPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class SubscribeForNewsletterStepDef {

    HomePage homePage;
    RegistrationPage registrationPage;
    SubscriptionPage subscriptionPage;


    public SubscribeForNewsletterStepDef() {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        subscriptionPage = new SubscriptionPage(driver);
    }

    @When("I subscribe to the newsletter with the email address {string}")
    public void enterEmailToSubscriptionField(String email) {
        subscriptionPage.enterEmailToSubscriptionField(email);
        subscriptionPage.clickSubscribeButton();
    }



    @Then("The message: {string} is visible")
    public void iAmRedirectedToTheHomePageWithTheNameVisible(String confirmationMessage) {
        assert confirmationMessage.equals(subscriptionPage.getConfirmationMessage());
    }
}
