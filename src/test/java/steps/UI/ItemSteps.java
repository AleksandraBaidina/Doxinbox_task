package steps.UI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import org.assertj.core.api.Assertions;
import pageobjects.InventoryItemPage;

public class ItemSteps {

    private InventoryItemPage inventoryItemPage;

    @Step("Verify that the cart is empty")
    @Then("Verify that the cart is empty")
    public void cartShouldBeEmpty() {
        Assertions.assertThat(inventoryItemPage.header.isShoppingCartEmpty()).isTrue();
    }

    @Step("Add item to the cart")
    @When("Add item to the cart")
    public void addToCart() {
        inventoryItemPage.addToCart();
    }

    @Step("Text replaced with remove")
    @Then("Add to cart text replaced with remove")
    public void removeBtnShouldBeExist() {
        inventoryItemPage.verifyRemoveBtn();
    }

    @Step("The number of items in the cart has increased")
    @Then("The number of items in the cart has increased")
    public void CartShouldHaveOneItem() {
        Assertions.assertThat(inventoryItemPage.header.getShoppingCartSize()).isEqualTo(1);
    }
}
