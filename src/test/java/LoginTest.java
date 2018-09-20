import common.CommonFunctions;
import completeActions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.LoginPage;
import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;
import org.testng.annotations.Test;

/**
 * Created by User on 17/9/2018.
 */
public class LoginTest extends Actions  {
    private static Logger LOG = LoggerFactory.getLogger(LoginTest.class);
    @Test
    @WebTest
    public void loginToSalesForce(){
        LOG.info("inside test method");
        login();
        searchOnHomePage("srp_help_a9b5@testng.com");
        clickOnSearchRecord();
        hoverOnTopLinkByName("Opportunities");
        hoverOnTopLinkByName("Program Admission Documents");
        LOG.info("");
    }
}
