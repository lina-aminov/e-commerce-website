package PageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage(){
        driver.get("http://3.11.77.136/index.php");
    }
}
