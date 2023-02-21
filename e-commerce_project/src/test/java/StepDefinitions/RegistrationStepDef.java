package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.Hooks.driver;

public class RegistrationStepDef {

    HomePage homePage;
    RegistrationPage registrationPage;

    public RegistrationStepDef() {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @When("I click Sign In button")
    public void iClickSignInButton() {
        homePage.clickSignIn();

    }

    @And("I click the sign up link")
    public void iClickSignUpLink() {
        homePage.clickSignUpLink();
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
}
