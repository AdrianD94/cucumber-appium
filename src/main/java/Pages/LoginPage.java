package Pages;



import Models.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")
    private WebElement loginInButton;

    @FindBy(how = How.ID, using = "com.guzmanygomez.gyg.uat:id/rf_edit_text")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/TextInputLayout/android.widget.FrameLayout/android.widget.EditText")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "com.guzmanygomez.gyg.uat:id/f_start_but_login")
    private WebElement loginButton;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/dialog_tb_tv_text")
    private WebElement loginError;

    @FindBy (how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private WebElement welcomeMessage;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/dialog_tb_tv_text")
    private WebElement wrongLoginDialog;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/dialog_tb_but_left")
    private WebElement wrongLoginDialogOk;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/f_start_tv_forgot")
    private WebElement forgotPasswordLink;

    @FindBy (how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private WebElement resetPasswordScreen;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/rf_edit_text")
    private WebElement forgotPasswordEmailField;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/f_fp_but_submit")
    private WebElement submitButton;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/dialog_tb_tv_text")
    private WebElement wrongEmailDialog;

    @FindBy (how = How.ID, using = "com.guzmanygomez.gyg.uat:id/dialog_tb_but_left")
    private WebElement wrongEmailDialogOkButton;


    public void checkLoginScreen(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        Assert.assertTrue(loginButton.isDisplayed());

    }

    public void insertValidCredentials(String email,String password){
        Assert.assertTrue(emailField.isDisplayed());
        emailField.clear();
        emailField.sendKeys(email);
        Assert.assertTrue(passwordField.isDisplayed());
        passwordField.clear();
        passwordField.sendKeys(password);


    }

    public void clickLoginButton(){
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();

    }

    public void checkHomeScreenRedirect(){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        Assert.assertTrue(welcomeMessage.isDisplayed());
    }


}