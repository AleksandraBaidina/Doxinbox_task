package steps.UI;

import common.enums.OrderTypes;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Step;
import pageobjects.InventoryListPage;

public class InventoryListSteps {

    private InventoryListPage inventoryListPage;

    @Step("Change order of item from Z to A")
    @Then("Change order of item from Z to A")
    public void changeOrderToZA() {
        inventoryListPage.changeOrder(OrderTypes.Z_A);
    }

    @Step("Open a item card")
    @Then("^Open a item card (\\d+)")
    public void openItemLeftBottom(Integer number) {
        inventoryListPage.selectItemByN(number);
    }
}
