package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends HomePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

private WebElement type_firstname;

    private WebElement type_lastname;

    private WebElement type_email;

    private WebElement type_dateofBirth;

    private WebElement type_address;

    private WebElement type_city;

    private WebElement type_zipcode;


    public void enter_firstname(String firstname) {
        type_firstname.sendKeys(firstname);
    }
    public void enter_lastname(String lastname) {
        type_lastname.sendKeys(lastname);
}
    public void enter_email(String email) {
        type_email.sendKeys(email);
    }
    public void enter_dateofBirth(String dateofBirth) {
        type_dateofBirth.sendKeys(dateofBirth);
    }

    public void enter_address(String address) {
        type_address.sendKeys(address);
    }
        public void enter_city(String city) {
            type_city.sendKeys(city);
        }
    public void enter_zipcode(String zipcode) {
        type_zipcode.sendKeys(zipcode);
    }
    public void fillDetails() {
        enter_firstname("John");
        enter_lastname("Smith");
        enter_email("hello@username.co.uk");
        enter_dateofBirth("11/04/1999");


    }

    public void fillDetailsAgain() {
        enter_address("33 WWE Road");
        enter_city("London");
        enter_zipcode("SW12 4NQ");
    }

    }