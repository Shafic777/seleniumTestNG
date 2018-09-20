package completeActions;

import com.paypal.selion.platform.grid.Grid;
import common.CommonFunctions;
import pages.*;

/**
 * Created by User on 20/9/2018.
 */
public class Actions extends CommonFunctions {
    private HomePage homePage;

    /**
     * This method will use default credentials from property file
     */
    public void  login(){
        getWebDriver().get("https://cs47.salesforce.com/");
        LoginPage loginPage = new LoginPage(Grid.driver());
        loginPage.enterUserName("ramesh_testng@salesforce.com");
        loginPage.enterPassword("Testng@123");
        loginPage.clickOnLoginBtn();
        homePage = new HomePage(getWebDriver());
        homePage.verifyGlobalHeader();
    }

    /**
     * This method is used when you want to specify the userName and password
     * @param userName
     * @param password
     */
    public void login(String userName, String password)
    {
        driver.get("https://cs47.salesforce.com/");
        LoginPage loginPage = new LoginPage(Grid.driver());
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginBtn();
        homePage = new HomePage(getWebDriver());
        homePage.verifyGlobalHeader();
    }

    public void searchOnHomePage(String textToSearch){
        homePage.enterTextToSearch(textToSearch);
        homePage.clickOnSearchBtn();
        homePage.verifySearchResult();
        HomePageSearchResult homePageSearchResult= new HomePageSearchResult(getWebDriver());
        homePageSearchResult.getNumberOfSearchResult();
    }

    public void clickOnSearchRecord(){
        HomePageSearchResult homePageSearchResult= new HomePageSearchResult(getWebDriver());
        homePageSearchResult.getRowByIndex(1)
        .clickOnCellByColumnName("Name");
        AffiliationDetailPage affiliationDetailPage = new AffiliationDetailPage(getWebDriver());
        affiliationDetailPage.verifyAffiliationTabSelected();
    }

    public void hoverOnTopLinkByName(String nameOfLinkToHover){
        HoverLinks hoverLinks = new HoverLinks(getWebDriver());
        hoverLinks.hoverOnLinkByName(nameOfLinkToHover);
        hoverLinks.oppertunitiesPopup().getRowByIndex(1).clickOnrow();
    }
}
