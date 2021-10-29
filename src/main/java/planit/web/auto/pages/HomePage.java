package planit.web.auto.pages;

import org.openqa.selenium.By;
import planit.web.auto.utils.Actions;
import planit.web.auto.utils.BasePageListener;

public class HomePage {
    private final By HOME_PAGE = By.xpath("//*[contains(text(), 'Welcome to Jupiter Toys, a magical world for ')]");
    private final By CONTACT_NAV = By.xpath("//a[text()='Contact']");
    private final By SHOP_NAV = By.xpath("//a[text()='Shop']");

    public HomePage isAt () {
        BasePageListener.findElement(HOME_PAGE);
        return this;
    }

    public ContactPage goToContactPage () {
        Actions.click(CONTACT_NAV, "Contact Nav");
        return new ContactPage();
    }

    public ShopPage goToShopPage () {
        Actions.click(SHOP_NAV, "Shop Nav");
        return new ShopPage();
    }
}