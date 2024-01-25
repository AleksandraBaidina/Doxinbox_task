package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HeaderComponent extends PageObject {
    private static final String SHOPPING_CART_BADGE = ".shopping_cart_badge";

    public boolean isShoppingCartEmpty() {
        return !($(SHOPPING_CART_BADGE).isVisible());
    }

    public Integer getShoppingCartSize() {
        WebElementFacade cart = $(SHOPPING_CART_BADGE);
        return cart.isVisible() ? Integer.valueOf($(SHOPPING_CART_BADGE).getText()) : 0;
    }
}
