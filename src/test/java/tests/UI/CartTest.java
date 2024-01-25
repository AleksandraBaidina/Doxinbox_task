package tests.UI;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import steps.UI.InventoryListSteps;
import steps.UI.ItemSteps;
import steps.UI.LoginPageSteps;


@ExtendWith(SerenityJUnit5Extension.class)
public class CartTest {

    @Steps
    LoginPageSteps loginPageSteps;
    @Steps
    InventoryListSteps inventoryListSteps;
    @Steps
    ItemSteps itemSteps;
    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void addItemToCartTest() {
        loginPageSteps.login();
        inventoryListSteps.changeOrderToZA();
        inventoryListSteps.openItemLeftBottom(5);
        itemSteps.cartShouldBeEmpty();
        itemSteps.addToCart();
        itemSteps.removeBtnShouldBeExist();
        itemSteps.CartShouldHaveOneItem();
    }
}
