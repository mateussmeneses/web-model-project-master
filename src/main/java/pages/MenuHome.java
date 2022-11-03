package pages;

import org.openqa.selenium.By;
import support.driver.DriverManager;

public class MenuHome extends DriverManager {

    private By mn_Users = By.id("users");

    public void clickUsers() {
    getDriver().findElement(mn_Users).click();

    }
}
