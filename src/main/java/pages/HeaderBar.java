package pages;

/**
 * Created by User on 20/9/2018.
 */

import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This bar contains all tabs to navigate e.g Affiliation
 */
public class HeaderBar extends CommonFunctions {
    public HeaderBar(RemoteWebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "tabContainer")
    private WebElement header;
    String SELECTED= "Selected";

    public void clickOnTabByName(String tabName){
        WebElement tab;
        tab = header.findElement(By.xpath(".//li/a[@contains(@title,'"+tabName+"')]]"));
        click(tab);
        titleContains(tab,SELECTED);
    }

    public boolean isTabSelected(String tabName){
        return  waitForElementToAppear(header.findElement(By.xpath(".//li//a[contains(@title,'"+tabName+"')]")))
                .getAttribute("title").contains(SELECTED);
    }
}
