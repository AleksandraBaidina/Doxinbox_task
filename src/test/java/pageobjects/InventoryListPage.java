package pageobjects;

import common.enums.OrderTypes;
import net.serenitybdd.core.pages.PageObject;

public class InventoryListPage extends PageObject {

    private static final String ORDER_DROPBOX = ".product_sort_container";
    private static final String INVENTORY_LIST = ".inventory_list";
    private static final String INVENTORY_ITEM = ".inventory_item";
    private static final String INVENTORY_ITEM_Nth = ".inventory_list .inventory_item:nth-child(%d)  .inventory_item_img";
    private static final String INVENTORY_ITEM_IMG = ".inventory_item_img";


    public HeaderComponent header;

    public void changeOrder(OrderTypes orderTypes) {
        $(ORDER_DROPBOX).selectByValue(orderTypes.value);
    }

    public void selectItemByN(Integer n) {
        $(INVENTORY_ITEM_Nth.formatted(n)).click();
    }

}
