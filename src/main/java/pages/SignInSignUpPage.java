package pages;

import java.sql.Timestamp;
import java.util.Map;

import com.paypal.selion.reports.runtime.SeLionReporter;
import dataObjects.signUpData;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInSignUpPage extends PageFactory{
    private Map<String, String> data;
   private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "Registration:j_id118:submit")
    @CacheLookup
    private WebElement begin;

    @FindBy(id = "Registration:j_id118:confirmemail")
    @CacheLookup
    private WebElement confirmEmailAddress;

    @FindBy(id = "Registration:j_id118:secondPassword")
    @CacheLookup
    private WebElement confirmPassword;

    @FindBy(id = "Registration:j_id118:countrycode")
    @CacheLookup
    private WebElement countryCodeUnitedStates1Canada;

    @FindBy(id = "Registration:j_id104:usernameLogin")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "Registration:j_id118:email")
    @CacheLookup
    private WebElement emailAddress;

    @FindBy(id = "Registration:j_id118:firstname")
    @CacheLookup
    private WebElement firstName;

    @FindBy(css = "a.forgot_password")
    @CacheLookup
    private WebElement forgotPassword;

    @FindBy(id = "Registration:j_id118:lastname")
    @CacheLookup
    private WebElement lastNameSurname;

    private final String pageLoadedText = "";

    private final String pageUrl = "/?acctid=0016000000YlgUM";

    @FindBy(id = "Registration:j_id104:passwordLogin")
    @CacheLookup
    private WebElement password1;

    @FindBy(id = "Registration:j_id118:password")
    @CacheLookup
    private WebElement password2;

    @FindBy(id = "Registration:j_id118:phonenumber")
    @CacheLookup
    private WebElement phoneNumber;

    @FindBy(name = "Registration:j_id104:j_id109")
    @CacheLookup
    private WebElement signIn;

    @FindBy(name = "Registration:j_id118:j_id145")
    @CacheLookup
    private WebElement agreementButton;

    public SignInSignUpPage() {
    }

    public SignInSignUpPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public SignInSignUpPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public SignInSignUpPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Begin Button.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage clickBeginButton() {
        begin.click();
        SeLionReporter.log("Submit data",true);
        return this;
    }

    public SignInSignUpPage clickAgreementButton() {
        agreementButton.click();
        return this;
    }
    /**
     * Click on Forgot Password Link.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage clickForgotPasswordLink() {
        forgotPassword.click();
        return this;
    }

    /**
     * Click on Sign In Button.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage clickSignInButton() {
        signIn.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the SignInSignUpPage class instance.
     * @param data
     */
    public SignInSignUpPage fill(signUpData data) {

        setFirstNameTextField(data.getFirstName().toString());
        setLastNameSurnameTextField(data.getLastName().toString());
        setCountryCode();
     //   setPhoneNumberTextField(Integer.parseInt(data.getPhoneNumber().toString().trim()));
        setPhoneNumberTextField(getRandomNumber().substring(0,8));
        setEmailAddressTextField(data.getEmailAdd().toString());
        setConfirmEmailAddressTextField(data.getEmailAdd().toString());
        setPassword2PasswordField(data.getPassword().toString());
        setConfirmPasswordPasswordField(data.getPassword().toString());
        SeLionReporter.log("Data signup",true);
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the SignInSignUpPage class instance.
     */
  /*  public SignInSignUpPage fillAndSubmit() {
        fill();
        return submit();
    }
*/
    /**
     * Set default value to Confirm Email Address Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setConfirmEmailAddressTextField() {
        return setConfirmEmailAddressTextField(data.get("CONFIRM_EMAIL_ADDRESS"));
    }

    /**
     * Set value to Confirm Email Address Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setConfirmEmailAddressTextField(String confirmEmailAddressValue) {
        confirmEmailAddress.sendKeys(confirmEmailAddressValue);
        return this;
    }

    /**
     * Set default value to Confirm Password Password field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setConfirmPasswordPasswordField() {
        return setConfirmPasswordPasswordField(data.get("CONFIRM_PASSWORD"));
    }

    /**
     * Set value to Confirm Password Password field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setConfirmPasswordPasswordField(String confirmPasswordValue) {
        confirmPassword.sendKeys(confirmPasswordValue);
        return this;
    }

    /**
     * Set default value to Country Code United States 1 Canada 1 Egypt 20 South Africa 27 Greece 30 Netherlands
     * 31 Spain 32 Belgium 32 Italy 39 Romania 40 Switzerland 41 United Kingdom 44 Poland 48 Germany 49 Mexico
     * 52 Chile 56 Australia 61 Singapore 65 China 86 Turkey 90 India 91 Tunisia 216 Ivory Coast 225 Ghana 233
     * Nigeria 234 Luxembourg 352 Ireland 353 Lebanon 961 Saudi Arabia 966 Uae 971 Qatar 974 Drop Down List field.
     *
     * @return the SignInSignUpPage class instance.
     */
  /*  public SignInSignUpPage setCountryCodeUnitedStates1CanadaDropDownListField() {
        return setCountryCode(data.get("COUNTRY_CODE_UNITED_STATES_1_CANADA"));
    }*/

    /**
     * Set value to Country Code United States 1 Canada 1 Egypt 20 South Africa 27 Greece 30 Netherlands 31 Spain 32 Belgium 32 Italy 39 Romania 40 Switzerland 41 United Kingdom 44 Poland 48 Germany 49 Mexico 52 Chile 56 Australia 61 Singapore 65 China 86 Turkey 90 India 91 Tunisia 216 Ivory Coast 225 Ghana 233 Nigeria 234 Luxembourg 352 Ireland 353 Lebanon 961 Saudi Arabia 966 Uae 971 Qatar 974 Drop Down List field.
     *
     * @return the SignInSignUpPage class instance.
     */

    public SignInSignUpPage setCountryCode() {
        new Select(countryCodeUnitedStates1Canada).selectByValue("+"+65);
        return this;
    }

    public SignInSignUpPage setCountryCode(String cc) {
        new Select(countryCodeUnitedStates1Canada).selectByValue("+"+cc.trim());
        return this;
    }

    /**
     * Set default value to Email Address Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setEmailAddressTextField() {
        return setEmailAddressTextField(data.get("EMAIL_ADDRESS"));
    }

    /**
     * Set value to Email Address Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setEmailAddressTextField(String emailAddressValue) {
        emailAddress.sendKeys(emailAddressValue);
        return this;
    }

    /**
     * Set default value to Email Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setEmailTextField() {
        return setEmailTextField(data.get("EMAIL"));
    }

    /**
     * Set value to Email Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setEmailTextField(String emailValue) {
        email.sendKeys(emailValue);
        return this;
    }

    /**
     * Set default value to First Name Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setFirstNameTextField() {
        return setFirstNameTextField(data.get("FIRST_NAME"));
    }

    /**
     * Set value to First Name Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setFirstNameTextField(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
        return this;
    }

    /**
     * Set default value to Last Name Surname Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setLastNameSurnameTextField() {
        return setLastNameSurnameTextField(data.get("LAST_NAME_SURNAME"));
    }

    /**
     * Set value to Last Name Surname Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setLastNameSurnameTextField(String lastNameSurnameValue) {
        lastNameSurname.sendKeys(lastNameSurnameValue);
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setPassword1PasswordField() {
        return setPassword1PasswordField(data.get("PASSWORD_1"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setPassword1PasswordField(String password1Value) {
        password1.sendKeys(password1Value);
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setPassword2PasswordField() {
        return setPassword2PasswordField(data.get("PASSWORD_2"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setPassword2PasswordField(String password2Value) {
        password2.sendKeys(password2Value);
        return this;
    }

    /**
     * Set default value to Phone Number Text field.
     *
     * @return the SignInSignUpPage class instance.
     * @param i
     */
    public SignInSignUpPage setPhoneNumberTextField(int i) {
        return setPhoneNumberTextField(data.get("PHONE_NUMBER"));
    }

    /**
     * Set value to Phone Number Text field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage setPhoneNumberTextField(String phoneNumberValue) {
        phoneNumber.sendKeys(phoneNumberValue);
        return this;
    }

   /* *//**
     * Submit the form to target page.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage submit() {
        clickBeginButton();
        SignInSignUpPage target = new SignInSignUpPage(driver, data, timeout);
        PageFactory.initElements(driver, target);
        return target;
    }

    /**
     * Unset default value from Country Code United States 1 Canada 1 Egypt 20 South Africa 27 Greece 30 Netherlands 31 Spain 32 Belgium 32 Italy 39 Romania 40 Switzerland 41 United Kingdom 44 Poland 48 Germany 49 Mexico 52 Chile 56 Australia 61 Singapore 65 China 86 Turkey 90 India 91 Tunisia 216 Ivory Coast 225 Ghana 233 Nigeria 234 Luxembourg 352 Ireland 353 Lebanon 961 Saudi Arabia 966 Uae 971 Qatar 974 Drop Down List field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage unsetCountryCodeUnitedStates1CanadaDropDownListField() {
        return unsetCountryCodeUnitedStates1CanadaDropDownListField(data.get("COUNTRY_CODE_UNITED_STATES_1_CANADA"));
    }

    /**
     * Unset value from Country Code United States 1 Canada 1 Egypt 20 South Africa 27 Greece 30 Netherlands 31 Spain 32 Belgium 32 Italy 39 Romania 40 Switzerland 41 United Kingdom 44 Poland 48 Germany 49 Mexico 52 Chile 56 Australia 61 Singapore 65 China 86 Turkey 90 India 91 Tunisia 216 Ivory Coast 225 Ghana 233 Nigeria 234 Luxembourg 352 Ireland 353 Lebanon 961 Saudi Arabia 966 Uae 971 Qatar 974 Drop Down List field.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage unsetCountryCodeUnitedStates1CanadaDropDownListField(String countryCodeUnitedStates1CanadaValue) {
        new Select(countryCodeUnitedStates1Canada).deselectByVisibleText(countryCodeUnitedStates1CanadaValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the SignInSignUpPage class instance.
     */
    public SignInSignUpPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the SignInSignUpPage class instance.
     *//*
    public SignInSignUpPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }*/


    public static String getRandomNumber() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long randomLong=timestamp.getTime();
        return String.valueOf(randomLong);
    }
}
