package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static StepDefinitions.Hooks.driver;

public class LoginStepDef {

    HomePage homePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    public LoginStepDef() {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }

    @When("click the Sign In button")
    public void clickTheSignInButton() {
        loginPage.clickSignInButton();
    }

    @Then("the error message {string} is displayed")
    public void theErrorMessageIsDisplayed(String authenticationFailed) {
        Assert.assertEquals(authenticationFailed, loginPage.getAuthenticationFailedMessage());
    }
}
