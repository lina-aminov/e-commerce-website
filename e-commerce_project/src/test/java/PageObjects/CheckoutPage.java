package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    private static By firstnameLocator = By.cssSelector("input[name=firstname]");
    private static By lastnameLocator = By.cssSelector("input[name=lastname]");
    private static By emailLocator = By.cssSelector("input[name=email]");
    private static By addressLocator = By.cssSelector("input[name=address1]");
    private static By cityLocator = By.cssSelector("input[name=city]");
    private static By zipcodeLocator = By.cssSelector("input[name=postcode]");



    public CheckoutPage(WebDriver driver) {
        super(driver);


    }


    public void enterfirstname(String firstname) {

        driver.findElement(firstnameLocator).sendKeys(firstname);


    }
    public void enterlastname(String lastname) {

        driver.findElement(lastnameLocator).sendKeys(lastname);


    }
    public void enteremail(String email) {

        driver.findElement(emailLocator).sendKeys(email);


    }
    public void enteraddress(String address) {

        driver.findElement(addressLocator).sendKeys(address);


    }
    public void entercity(String city) {

        driver.findElement(cityLocator).sendKeys(city);


    }
    public void enterzipcode(String zipcode) {

        driver.findElement(zipcodeLocator).sendKeys(zipcode);


    }
}