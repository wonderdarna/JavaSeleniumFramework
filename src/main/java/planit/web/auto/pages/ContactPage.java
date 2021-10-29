package planit.web.auto.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import planit.web.auto.contstants.Expected;
import planit.web.auto.utils.Actions;
import planit.web.auto.utils.BasePageListener;

public class ContactPage {
    private final By CONTACT_PAGE = By.xpath("//*[contains(text(), 'Welcome to Jupiter Toys, a magical world for ')]");
    private final By SUBMIT_BUTTON = By.xpath("//a[text()='Submit']");
    private final By FORENAME_FIELD = By.id("forename");
    private final By EMAIL_FIELD = By.id("email");
    private final By MESSAGE_FIELD = By.id("message");
    private final By HEADER_ERR_MESSAGE = By.cssSelector(".alert.alert-error.ng-scope");
    private final By HEADER_SUCCESS_MESSAGE = By.cssSelector(".alert.alert-success");
    private final By FORENAME_REQ_ERR_MSSG = By.cssSelector("#forename-err");
    private final By EMAIL_REQ_ERR_MSSG = By.cssSelector("#email-err");
    private final By MESSAGE_REQ_ERR_MSSG = By.cssSelector("#message-err");


    public ContactPage isAt () {
        BasePageListener.findElement(CONTACT_PAGE);
        return this;
    }

    public ContactPage clickSubmitButton () {
        Actions.click(SUBMIT_BUTTON, "Submit Button");
        return this;
    }

    public ContactPage validateIfMessageIsDisplayingOrNot (String message, Expected expectedEnum) {
        boolean expected = expectedEnum.getExpected().toLowerCase().equalsIgnoreCase("displaying");
        Assert.assertEquals(expected, BasePageListener.checkIfElementIsDisplaying(By.xpath("//*[text()=\""+ message + "\"]")),"The message " + message + expectedEnum.getExpected().toLowerCase());
        return this;
    }

    public ContactPage populateMandatoryFields (String foreName, String email, String message) {
        Actions.enter(FORENAME_FIELD, "Forename Field" ,foreName);
        Actions.enter(EMAIL_FIELD, "Email Field" , email);
        Actions.enter(MESSAGE_FIELD, "Message Field" , message);
        return this;
    }

    public ContactPage verifyIfHeaderErrMessageIs (Expected expectedEnum) {
        boolean expected = expectedEnum.getExpected().toLowerCase().equalsIgnoreCase("displaying");
        boolean actual = BasePageListener.checkIfElementIsDisplaying(HEADER_ERR_MESSAGE);
        Assert.assertEquals(expected, actual, "The header error message is " + expected);
        return this;
    }

    public ContactPage verifyIfSuccessMessageIs (Expected expectedEnum) {
        boolean expected = expectedEnum.getExpected().toLowerCase().equalsIgnoreCase("displaying");
        boolean actual = BasePageListener.checkIfElementIsDisplaying(HEADER_SUCCESS_MESSAGE, 20L);
        Assert.assertEquals(expected, actual, "The success message is " + expected);
        return this;
    }

}

