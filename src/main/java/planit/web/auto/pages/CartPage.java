package planit.web.auto.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import planit.web.auto.contstants.Constant;
import planit.web.auto.entities.PurchaseDetail;
import planit.web.auto.utils.BasePageListener;
import planit.web.auto.utils.Log;

import java.util.List;

public class CartPage {
    private final By CART_PAGE = By.cssSelector(".cart-msg");

    public CartPage isAt () {
        BasePageListener.findElement(CART_PAGE);
        return this;
    }
    public CartPage verifyAllItemsBoughtAreInCartPage(List <PurchaseDetail> purchaseDetails) {
        for (PurchaseDetail s : purchaseDetails) {
            Log.info(this, s.toString());
            Assert.assertTrue(
                    BasePageListener.checkIfElementIsDisplaying("//*[contains(text(),'" + s.getItemName().trim() + "')]" +
                            "//parent::td/following-sibling::td[text()='$" + s.getItemPrice().toString() + "']" +
                            "//following-sibling::td/input[@value='" + s.getQuantity() + "']"));
        }
        return this;
    }

    public CartPage verifyIfSubtotalForEachItemAreCorrect(List <PurchaseDetail> purchaseDetails) {
        for (PurchaseDetail purchaseDetail : purchaseDetails) {
            Log.info(this, purchaseDetail.toString());
            Assert.assertTrue(
                    BasePageListener.checkIfElementIsDisplaying("//*[contains(text(),'" + purchaseDetail.getItemName().trim() + "')]" +
                            "//parent::td/following-sibling::td[text()='$" + purchaseDetail.getItemPrice().toString() + "']" +
                            "//following-sibling::td/input[@value='" + purchaseDetail.getQuantity() + "']" +
                            "/parent::td/following-sibling::td[text()='$" + purchaseDetail.getPriceSubtotal() + "']"));

        }

        return this;
    }


    public CartPage verifyIfTotalAmountIsCorrect(List <PurchaseDetail> purchaseDetails) {
        double temp = purchaseDetails.stream().mapToDouble(PurchaseDetail::getPriceSubtotal).sum();
        String expectedTotalAmount = String.format("Total: %s", temp);
        String actualAmount = BasePageListener.findElement("//strong[@class='total ng-binding']").getText();
        Log.info(this, String.format("Expected Total amount is [%s] and the Actual amount is [%s]", expectedTotalAmount, actualAmount));
        Assert.assertEquals(expectedTotalAmount, actualAmount,String.format("Expected total amount [%s] doesnt match the actual amount [%s]", expectedTotalAmount, actualAmount));
        return this;
    }
}

