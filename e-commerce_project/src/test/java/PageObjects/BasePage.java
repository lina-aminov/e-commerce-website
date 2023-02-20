package PageObjects;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
 abstract class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
    }

}
