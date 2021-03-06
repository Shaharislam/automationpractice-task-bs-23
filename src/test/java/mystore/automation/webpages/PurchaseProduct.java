package mystore.automation.webpages;

import mystore.automation.helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PurchaseProduct extends DriverHelper {
    By casualDressesLinkText = By.partialLinkText("CASUAL DRESSES");
    By dressLinkText = By.linkText("DRESSES");
    By imageHover = By.xpath("//div[@class='product-image-container']");
    By addToCartClick = By.xpath("//a[@title='Add to cart']");
    By processToCheckOut = By.xpath("//a[@class='btn btn-default button button-medium']");
    By processedToCheckOut_summery = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
    By processedToCheckOut_address = By.xpath("//button[@name='processAddress']");
    By processToCheckOut_shipping = By.xpath("//button[@name='processCarrier']");
    By termsAndService = By.xpath("//input[@id='cgv']");
    By paymentCheck = By.xpath("//a[@title='Pay by check.']");
    By orderConfirm = By.xpath("//span[text()='I confirm my order']");
    By continueShopping = By.xpath("//span[@title='Continue shopping']");
    By tShirts = By.xpath("//a[@title='T-shirts']");
    By blueColorFilter = By.xpath("//input[@id='layered_id_attribute_group_14']");


    public void clickCausalDress() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(dressLinkText)).build().perform();
        driver.findElement(casualDressesLinkText).click();
    }

    public void addToCartAndProceedCheckout() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(imageHover)).build().perform();
        driver.findElement(addToCartClick).click();
        driver.findElement(continueShopping).click();
        List<WebElement> findElements = driver.findElements(tShirts);
        for (WebElement elm : findElements) {
            if (elm.isDisplayed()) {
                elm.click();
                break;
            }
        }
        driver.findElement(blueColorFilter).click();
        Actions blueAction = new Actions(driver);
        blueAction.moveToElement(driver.findElement(imageHover)).build().perform();
        driver.findElement(addToCartClick).click();
        driver.findElement(processToCheckOut).click();
        scrollDown();
        driver.findElement(processedToCheckOut_summery).click();
        scrollDown();
        driver.findElement(processedToCheckOut_address).click();
        scrollDown();
        driver.findElement(termsAndService).click();
        driver.findElement(processToCheckOut_shipping).click();
        driver.findElement(paymentCheck).click();
        driver.findElement(orderConfirm).click();
    }
}
