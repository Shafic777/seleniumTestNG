package common;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
/**
 * Created by User on 19/9/2018.
 */
public class CommonFunctions extends BaseClass {
    private static Logger LOG = LoggerFactory.getLogger(CommonFunctions.class);
    public void click(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
        catch (ElementNotFoundException e){
            LOG.info("Element not found while trying to click");
            e.printStackTrace();
        }
    }
    public void sendKeys(WebElement element, String textToSend){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(textToSend);
        }
        catch (ElementNotVisibleException e){
            LOG.info("Element not visible to enter text");
        }
    }

    public boolean isDisplayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
    public boolean isDisplayed(List<WebElement> element){
        ArrayList list = new ArrayList();
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        return element.get(0).isDisplayed();
    }
    public String getText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public WebElement waitForElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    public void titleContains(WebElement webElement, String title){
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void hover(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(element).build().perform();
        LOG.info("Hover action Performed ");
    }

    public void swtichToFrame(String frameId){
        isDisplayed(getWebDriver().findElement(By.xpath(".//iframe[contains(@id,'"+frameId+"')]")));
        getWebDriver().switchTo().frame(frameId);
    }
}
