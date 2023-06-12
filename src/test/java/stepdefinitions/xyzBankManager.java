package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class xyzBankManager {
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");

	@SuppressWarnings("deprecation")
	@Given("^I navigate to the manager page$")
	public void user_is_on_home_page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "geckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
		// Verify that the user is on the correct page
		String exp_text = "Add Customer";
		String add_text = driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).getText();
		Assert.assertEquals(exp_text, add_text);
	}

	@Given("^I click add new customer button$")
	public void add_new_customer() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
	}

	@When("I enter Firstname as {string}, Lastname as {string}, Postcode as {string}")
	public void user_input(String Firstname, String Lastname, String Postcode) throws Throwable {

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(Firstname);
		Thread.sleep(1000); // 10000 milisecond

		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Lastname);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(Postcode);
		Thread.sleep(100);
	}

	@Then("^I click submit$")
	public void submit_form() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Thread.sleep(1000);
		// This method clicks on the 'OK' button of the alert box.
		try {
			Alert alertFirst = driver.switchTo().alert();
			alertFirst.accept();
		} catch (NoAlertPresentException Ex) {
			// return false;
		}

	}

	@Given("^I click Open Account$")
	public void open_account() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Open Account')]")).click();
		Thread.sleep(1000);
	}

	@When("I choose customer name as {string}, currency as {string}")
	public void input_customer_name(String customename, String currency) throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='userSelect']")).sendKeys(customename);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='currency']")).sendKeys(currency);
	}

	@Then("^I click process$")
	public void click_process() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Process')]")).click();
		Thread.sleep(100);

		// This method clicks on the 'OK' button of the alert box.

		try {
			Alert alertSecond = driver.switchTo().alert();
			alertSecond.accept();
		} catch (NoAlertPresentException Ex) {
			// return false;
		}
		Thread.sleep(1000);

	}

	@Given("^I click Customers$")
	public void click_customer() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
	}

	@When("^I enter the first name in the search bar$")
	public void input_firstname() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Harry");
		Thread.sleep(100);
	}

	@Then("^I verify the search information$")
	public void verify_information() throws Throwable {
		Thread.sleep(100);
		String FirstName = "Harry", lastname = "Potter", PostCode = "E725JB";

		String ex_FirstName = driver.findElement(By.xpath("//td[contains(text(),'Harry')]")).getText();
		String ex_LastName = driver.findElement(By.xpath("//td[contains(text(),'Potter')]")).getText();
		String ex_PostCode = driver.findElement(By.xpath("//td[contains(text(),'E725JB')]")).getText();
		Thread.sleep(100);
		Assert.assertEquals(FirstName, ex_FirstName);
		System.out.print("hello 1");
		Assert.assertEquals(lastname, ex_LastName);
		System.out.print("hello 2");
		Assert.assertEquals(PostCode, ex_PostCode);
		System.out.print("hello 3");

	}

}
