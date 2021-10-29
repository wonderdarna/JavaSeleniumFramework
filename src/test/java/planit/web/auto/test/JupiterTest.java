package planit.web.auto.test;

import org.testng.annotations.Test;
import planit.web.auto.contstants.Expected;
import planit.web.auto.base.BaseTest;
import planit.web.auto.entities.CartDetails;
import planit.web.auto.entities.PurchaseDetail;
import planit.web.auto.pages.Pages;
import planit.web.auto.pages.ShopPage;

import java.util.ArrayList;
import java.util.List;

public class JupiterTest extends BaseTest {

    @Test(testName = "Test Case 1", priority = 1)
    public void firstTestCase() {
        Pages.homePage().isAt()
                        .goToContactPage().isAt()
                            .clickSubmitButton()
                            .verifyIfHeaderErrMessageIs(Expected.DISPLAYING)
                            .validateIfMessageIsDisplayingOrNot("Forename is required", Expected.DISPLAYING)
                            .validateIfMessageIsDisplayingOrNot("Email is required", Expected.DISPLAYING)
                            .validateIfMessageIsDisplayingOrNot("Message is required", Expected.DISPLAYING)

                            .populateMandatoryFields("testForeName", "planitemail@gmial.com", "Planit Testing is GREAT!")
                            .verifyIfHeaderErrMessageIs(Expected.NOT_DISPLAYING)
                            .validateIfMessageIsDisplayingOrNot("Forename is required", Expected.NOT_DISPLAYING)
                            .validateIfMessageIsDisplayingOrNot("Email is required", Expected.NOT_DISPLAYING)
                            .validateIfMessageIsDisplayingOrNot("Message is required", Expected.NOT_DISPLAYING);
    }


    @Test(testName = "Test Case 2", priority = 2, invocationCount = 5)
    public void secondTestCase() {
        Pages.homePage().isAt()
                        .goToContactPage().isAt()
                            .populateMandatoryFields("testForeName", "planitemail@gmial.com", "Planit Testing is GREAT!")
                            .clickSubmitButton()
                            .verifyIfSuccessMessageIs(Expected.DISPLAYING);

    }


    @Test(testName = "Test Case 3", priority = 3)
    public void thirdTestCase() {
        List<PurchaseDetail> purchaseDetailList = new ArrayList<>();
        CartDetails cartDetails;
        ShopPage shopPage = Pages.homePage().isAt().goToShopPage().isAt();

        purchaseDetailList.add(shopPage.addToCard("Funny Cow", 2));
        purchaseDetailList.add(shopPage.addToCard("Fluffy Bunny", 1));
        cartDetails = new CartDetails(purchaseDetailList);

        shopPage.goToCartPage().isAt()
                                 .verifyAllItemsBoughtAreInCartPage(cartDetails.getPurchaseDetailList());

    }


    @Test(testName = "Test Case 4 (Advanced)", priority = 4)
    public void fourthTestCase() {
        List<PurchaseDetail> purchaseDetailList = new ArrayList<>();
        CartDetails cartDetails;
        ShopPage shopPage = Pages.homePage().isAt().goToShopPage().isAt();

        purchaseDetailList.add(shopPage.addToCard("Stuffed Frog", 2));
        purchaseDetailList.add(shopPage.addToCard("Fluffy Bunny", 5));
        purchaseDetailList.add(shopPage.addToCard("Valentine Bear", 3));
        cartDetails = new CartDetails(purchaseDetailList);

        shopPage.goToCartPage().isAt()
                    .verifyAllItemsBoughtAreInCartPage(cartDetails.getPurchaseDetailList())
                    .verifyIfSubtotalForEachItemAreCorrect(cartDetails.getPurchaseDetailList())
                    .verifyIfTotalAmountIsCorrect(cartDetails.getPurchaseDetailList());

    }
}
