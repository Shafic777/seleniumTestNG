import dataObjects.signUpData;
import pages.SignInSignUpPage;
import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.dataprovider.DataProviderFactory;
import com.paypal.selion.platform.dataprovider.DataResource;
import com.paypal.selion.platform.dataprovider.SeLionDataProvider;
import com.paypal.selion.platform.dataprovider.impl.FileSystemResource;
import com.paypal.selion.platform.grid.Grid;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpTest {



   /* @DataProvider(name = "simpleReader")
    public Object[][] setupExcelDataProvider () throws IOException, NoSuchMethodException {
        //Lets first initialize the data provider and specify the file from which data is to be read from.
        DataResource resource = new FileSystemResource("src/test/resources/testdata/signUpData.xlsx", signUpData.class);
        ExcelDataProvider dataProvider = (ExcelDataProvider) DataProviderFactory.getDataProvider(resource);
        return dataProvider.getAllData();
    }*/

    @DataProvider(name = "excelDataProvider")
    public Object[][] getExcelDataProvider() throws Exception {
        DataResource resource =
                new FileSystemResource("src/test/resources/testdata/signUpData.xls",
                        signUpData.class);
        SeLionDataProvider dataProvider =
                DataProviderFactory.getDataProvider(resource);
        return dataProvider.getAllData();
    }

    @Test(dataProvider = "excelDataProvider")
 //   @Test
    @WebTest
    public void signup(signUpData dt) throws InterruptedException {

        Grid.driver().get("https://scrabble-apply-now.cs47.force.com/?acctid=0016000000YlgUM");
        SignInSignUpPage signInSignUpPage = new SignInSignUpPage(Grid.driver());
        signInSignUpPage.fill(dt);
        signInSignUpPage.clickAgreementButton();
        signInSignUpPage.clickBeginButton();


    }
/*
    @DataProvider(name = "simpleReader")
    public Object[][] setupExcelDataProvider () throws IOException{
        //Lets first initialize the data provider and specify the file from which data is to be read from.
        DataResource resource =
                new FileSystemResource("src/test/resources/testdata/signUpData.xls",
                        signUpData.class);
        SeLionDataProvider dataProvider = DataProviderFactory.getDataProvider(resource);

        return dataProvider.getAllData();
    }

    @Test(dataProvider = "simpleReader")
    public void testExcelDataValues (signUpData data) {
        Reporter.log("Running test for " + data, true);
        System.out.println(data.getFirstName());
    }*/

}
