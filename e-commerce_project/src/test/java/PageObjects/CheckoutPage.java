package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(CheckoutPage.class);

    private static final By firstnameLocator = By.cssSelector("input[name=firstname]");
    private static final By lastnameLocator = By.cssSelector("input[name=lastname]");
    private static final By emailLocator = By.cssSelector("input[name=email]");
    private static final By addressLocator = By.cssSelector("input[name=address1]");
    private static final By cityLocator = By.cssSelector("input[name=city]");
    private static final By zipcodeLocator = By.cssSelector("input[name=postcode]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstname) {
        logger.info("First name entered");
        driver.findElement(firstnameLocator).sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        logger.info("LastName entered");
        driver.findElement(lastnameLocator).sendKeys(lastname);
    }

    public void enterEmail(String email) {
        logger.info("Email entered");
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void enterAddress(String address) {
        logger.info("Address entered");
        driver.findElement(addressLocator).sendKeys(address);
    }

    public void enterCity(String city) {
        logger.info("City entered");
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void enterZipCode(String zipcode) {
        logger.info("ZipCode entered");
        driver.findElement(zipcodeLocator).sendKeys(zipcode);
    }
}