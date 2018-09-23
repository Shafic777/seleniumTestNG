package pages;

import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains all the link on top on which user hover and new poup opens
 * Created by Javed on 20/9/2018.
 */
public class HoverLinks extends CommonFunctions {
    private static Logger LOG = LoggerFactory.getLogger(HoverLinks.class);
    public HoverLinks(RemoteWebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='listHoverLinks']")
    private WebElement listOfElemntsToHover;

    public void hoverOnLinkByName(String linkNameToHover){
        WebElement elementHoveredOn;
        waitForElementToAppear(listOfElemntsToHover);
        elementHoveredOn=listOfElemntsToHover
        .findElement(By.xpath(".//a//span[contains(@class,'listTitle') and text()='"+linkNameToHover+"']"));
        hover(elementHoveredOn);
        swtichToFrame("RLPanelFrame");
    }

    public Oppertunities oppertunitiesPopup(){
        return new Oppertunities(getWebDriver());
    }

    public class Oppertunities{
        @FindBy (id = "0032a00000TPk6j_00N60000002aLWE_body")
        private WebElement OppertunitiesTable;
        private  WebElement row;
        public Oppertunities(RemoteWebDriver driver){
            PageFactory.initElements(driver,this);
        }

        public Oppertunities getRowByIndex(int rowIndex){
          row =  waitForElementToAppear(OppertunitiesTable.findElement(By.xpath("//tr[contains(@class, 'dataRow')][position()=" + rowIndex + "]")));
        return this;
        }

        public void clickOnrow(){
            click(row.findElement(By.xpath(".//th[contains(@class,'dataCell')]//a")));
        }
    }
}
