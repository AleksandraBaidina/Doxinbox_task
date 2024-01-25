package pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class InventoryItemPage extends PageObject {

    private final static String ADD_TO_CART = ".btn.btn_primary.btn_small.btn_inventory";
    private final static String REMOVE_FROM_CART = ".btn.btn_secondary.btn_small.btn_inventory";
    private final static String remove_text = "Remove";

    public HeaderComponent header;

    public void addToCart() {
        $(ADD_TO_CART).click();
    }

    public void removeFromCart() {
        $(REMOVE_FROM_CART).click();
    }

    public void verifyRemoveBtn() {
        $(REMOVE_FROM_CART).shouldBeVisible().shouldContainText(remove_text);
    }

}
