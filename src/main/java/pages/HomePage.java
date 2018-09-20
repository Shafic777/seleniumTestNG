package pages;

//import com.mycompany.test.dataObjects.CustomElement;
import common.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by User on 18/9/2018.
 */
public class HomePage extends CommonFunctions{
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "globalHeaderNameMink")
    WebElement gloabalHeaderName;
    @FindBy (id ="phSearchInput")
    private WebElement searchInputBox;
    @FindBy (id = "phSearchButton")
    private WebElement searchBtn;
    @FindBy (xpath = "//div[@class='listRelatedObject contactBlock']")
    private WebElement searchResultTable;
    public void verifyGlobalHeader(){
        Assert.assertTrue(isDisplayed(gloabalHeaderName),"Login Failed Global Header Not found");
    }

    public void enterTextToSearch(String textTosearch){
        sendKeys(this.searchInputBox, textTosearch);
    }
    public void clickOnSearchBtn(){
        click(searchBtn);
    }

    public void verifySearchResult(){
        Assert.assertTrue(isDisplayed(searchResultTable), "Search result table/ Affiliation not present");
    }


}
