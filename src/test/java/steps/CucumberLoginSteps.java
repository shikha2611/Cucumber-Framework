package steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CucmberLoginPage;
import utils.PropertyReader;
import utils.Utilities;

public class CucumberLoginSteps {
//
//	WebDriver driver = CucumberBaseStep.getDriver();
//	ExtentTest test = CucumberBaseStep.extent.createTest("Login to SFDC TC02");
	protected static Logger log = LogManager.getLogger(CucumberLoginSteps.class.getName());
//	CucmberLoginPage lp = new CucmberLoginPage(driver, test);
	WebDriver driver;
	ExtentTest test;
	CucmberLoginPage lp;

	@Given("User launches the Application")
	public void user_launches_the_Application() throws IOException {
		log.info("user_launches_the_Application()...");
		test = CucumberBaseStep.extent.createTest("Login to SFDC TC02");
		driver = CucumberBaseStep.getDriver();
		lp = new CucmberLoginPage(driver, test);
		Assert.assertTrue("Salesforce Application should be launched", lp.launchApp(driver));
		Assert.assertEquals("login page title should be  found", PropertyReader.readpageTitle("login_page_title"),
				Utilities.pageTitle(driver));
		log.info("user_launches_the_Application()...done succesfully...");

	}

	@When("User enters the valid username and password")
	public void user_enters_the_valid_username_and_password() throws IOException {
		log.info("user_enters_the_valid_username_and_password()......");
		Assert.assertTrue("username should be entered",
				lp.enterUserName(driver, PropertyReader.readLoginUsernamePassword("username")));
		Assert.assertTrue("password should be entered",
				lp.enterPassword(driver, PropertyReader.readLoginUsernamePassword("password")));
		log.info("user_enters_the_valid_username_and_password()...done successfully...");
	}

	@When("User clicks the Login button")
	public void user_clicks_the_login_button() throws IOException {
		Assert.assertTrue("login button should be clicked", lp.clickloginButton(driver));
	}

	@Then("User should login and land on HomePage")
	public void user_should_login_and_land_on_home_page() throws IOException {
		Assert.assertEquals("Home page title should be displayed", Utilities.pageTitle(driver),
				PropertyReader.readpageTitle("home_Page_title"));

	}

	@When("User enters the username as {string} and password as {string}")
	public void user_enters_the_username_as_and_password_as(String username, String password)
			throws IOException, InterruptedException {
		log.info("user_enters_the_username_as_and_password_through_PARAMETRIZATION()....");
		Assert.assertTrue("username should be entered", lp.enterUserName(driver, username));
		Thread.sleep(1000);
		Assert.assertTrue("password should be entered", lp.enterPassword(driver, password));
		log.info("user_enters_the_username_as_and_password_as()...done successfully.");
	}

	@Then("User should see the appropriate error message")
	public void user_should_see_the_appropriate_error_message() throws IOException {
		String actualmessage = lp.loginErrorMsg.getText();
		Assert.assertEquals("Login error message should be displayed", PropertyReader.readErrorMsg("wrong_username"),
				actualmessage);
	}

//	@When("When User enters the username and password and clicks on Login button")
//	public void user_enters_the_username_and_password_and_clicks_on_Login_button(DataTable dataTable)
//			throws IOException, InterruptedException {
//		log.info("user_enters_the_username_as_and_password_through DATATABLE()....");
//
//		List<Map<String, String>> credetials = dataTable.asMaps(String.class, String.class);
//
//		for (Map<String, String> map : credetials) {
//			lp.enterUserName(driver, map.get("username"));
//			lp.enterPassword(driver, map.get("password"));
//			lp.clickloginButton(driver);
//		}
//	}

	@When("User enters the username and password and clicks on Login button")
	public void user_enters_the_username_and_password_and_clicks_on_login_button(DataTable dataTable)
			throws IOException {
		log.info("user_enters_the_username_as_and_password_through DATATABLE()....");
		List<Map<String, String>> credetials = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> map : credetials) {
			Assert.assertTrue("Username should be entered", lp.enterUserName(driver, map.get("username")));
			Assert.assertTrue("Password should be entered", lp.enterPassword(driver, map.get("password")));
			Assert.assertTrue("login button should be clicked", lp.clickloginButton(driver));
		}
	}

}
