package pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    private static final String LOGIN_INP = "#user-name";
    private static final String PASSWORD_INP = "#password";
    private static final String LOGIN_BTN = "#login-button";

    public void login(String login, String password) {
        $(LOGIN_INP).sendKeys(login);
        $(PASSWORD_INP).sendKeys(password);
        $(LOGIN_BTN).click();
    }
}
