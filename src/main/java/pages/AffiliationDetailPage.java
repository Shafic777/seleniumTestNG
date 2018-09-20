package pages;

import common.CommonFunctions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/** this page class is for Affiliation detail page that appears
 * After clicking on one of the search record
 * Created by Javed on 20/9/2018.
 */
public class AffiliationDetailPage extends CommonFunctions {
    String AFFILIATION ="Affiliations";
    public AffiliationDetailPage(RemoteWebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void verifyAffiliationTabSelected(){
        HeaderBar headerBar= new HeaderBar(getWebDriver());
        Assert.assertTrue(headerBar.isTabSelected(AFFILIATION));
    }
}
