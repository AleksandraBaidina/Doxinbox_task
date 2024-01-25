package steps.UI;

import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Step;
import pageobjects.LoginPage;


public class LoginPageSteps {
    private LoginPage loginPage;

    @Step("Default user is login")
    @Given("Default user is login")
    public void login() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }
}
