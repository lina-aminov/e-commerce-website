package StepDefinitions;

import PageObjects.HomePage;
import io.cucumber.java.en.Given;


import static StepDefinitions.Hooks.driver;

public class ExampleSteps {

    HomePage homePage;

    public ExampleSteps() {
        homePage = new HomePage(driver);
    }

    @Given("I'm on the home Page")
    public void iMOnTheHomePage() {
        homePage.goToHomePage();

    }

}
