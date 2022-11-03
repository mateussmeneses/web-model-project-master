package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Action;
import support.driver.DriverManager;

public class UsersGrid extends DriverManager {

    By btnNewUser = By.cssSelector("#btn-new");

    public void clickNewUser() {
        Action.getVisibleElement(btnNewUser);
        getDriver().findElement(btnNewUser).click();
    }

    public void clickShowUser(String lastUser) {

        String elem = "btn-show_" +  lastUser;
        By btnShowUser = By.id(elem);
        Action.getVisibleElement(btnShowUser);
        getDriver().findElement(btnShowUser).click();
    }

    public void clickEditUser(String lastUser) {
        String elem = "btn-edit_" +  lastUser;
        By btnShowUser = By.id(elem);
        Action.getVisibleElement(btnShowUser);
        getDriver().findElement(btnShowUser).click();
    }

    public void clickDeleteUser(String lastUser) {
        String elem = "btn-delete_" +  lastUser;
        By btnShowUser = By.id(elem);
        Action.getVisibleElement(btnShowUser);
        getDriver().findElement(btnShowUser).click();
    }

    public void clickConfirmeDelete() {
        final Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public boolean getShowButton(String lastUser) {
        String elem = "btnUserShow_" + lastUser;
        By btnUserShow = By.id(elem);
        return Action.existElement(btnUserShow, 10);
    }
}
