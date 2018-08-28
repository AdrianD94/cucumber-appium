package stepDefinitions;

import Framework.TestRunner;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class LoginSteps extends TestRunner {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Given("^User is on login screen$")
    public void user_is_on_login_screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     loginPage.checkLoginScreen();
    }

    @When("^User insert valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_insert_valid_and(String email, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.insertValidCredentials(email,password);
    }

    @And("^Click on Login button$")
    public void click_on_Login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       loginPage.clickLoginButton();
    }

    @Then("^Users is redirected to the app home screen$")
    public void users_is_redirected_to_the_app_home_screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.checkHomeScreenRedirect();
    }
}
