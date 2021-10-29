package planit.web.auto.pages;

import org.openqa.selenium.By;
import planit.web.auto.contstants.Constant;
import planit.web.auto.entities.PurchaseDetail;
import planit.web.auto.utils.Actions;
import planit.web.auto.utils.BasePageListener;

public class ShopPage {
    private final By CART_NAV = By.xpath("//a[contains(text(),'Cart')]");
    private final By SHOP_PAGE = By.cssSelector(".products.ng-scope");

    public ShopPage isAt () {
        BasePageListener.findElement(SHOP_PAGE);
        return this;
    }

    public PurchaseDetail addToCard(String nameOfProduct, int quantity) {
        String productXpath = "//*[text()='" + nameOfProduct + "']";
        for (int i = 0; i < quantity; i++) {
            Actions.click(productXpath + "/following-sibling::p/a", nameOfProduct + " - Buy button");
        }
        Double productPrice = Double.parseDouble(BasePageListener.findElement(By.xpath(productXpath + "/following-sibling::p/span")).getText().replace("$", ""));
        PurchaseDetail purchaseDetail = new PurchaseDetail(nameOfProduct, quantity, productPrice);
        return purchaseDetail;
    }

    public CartPage goToCartPage () {
        Actions.click(CART_NAV, "Cart Nav");
        return new CartPage();
    }

}
