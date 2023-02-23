package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static StepDefinitions.Hooks.driver;

public class RegistrationStepDef {

    HomePage homePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    public RegistrationStepDef() {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }

    @When("I click Sign In button")
    public void iClickSignInButton() {
        homePage.clickSignIn();
    }

    @And("I click the sign up link")
    public void iClickSignUpLink() {
        loginPage.clickSignUpLink();
    }

    @When("I fill in the account details with the following:")
    public void iFillInTheAccountDetailsWithTheFollowing(DataTable accountDetails) {
        registrationPage.enterAccountDetails(accountDetails);
    }

    @And("click the Save button")
    public void clickTheSaveButton() {
        registrationPage.clickSaveButton();
    }

    @Then("I am redirected to the home page with the name: {string} visible")
    public void iAmRedirectedToTheHomePageWithTheNameVisible(String fullName) {
        assert fullName.equals(registrationPage.getFullName());
    }

    @Then("I am see the error message {string}")
    public void invalidName(String invalidName) {
        Assert.assertEquals(invalidName, registrationPage.getInvalidNameMessage());
    }

    @Then("the error message {string} is visible")
    public void invalidEmailFormat(String invalidEmailFormat) {
        Assert.assertEquals(invalidEmailFormat, registrationPage.getInvalidFormatMessage());
    }

    @Then("the error message {string} becomes visible")
    public void emailIsAlreadyInUse(String alreadyRegisteredEmail) {
        Assert.assertEquals(alreadyRegisteredEmail, registrationPage.getAlreadyRegisteredMessage());
    }

}
