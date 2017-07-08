package stepDefinition;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	WebDriver driver;
		
	@Given("^User Could Browse Gmail URL$")
	public void user_is_on_the_home_page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.gmail.com");		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User Navigates To The Login Page$")
	public void user_navigates_to_the_login_page() throws Throwable {
		driver.findElement(By.id("Email")).isEnabled();
		driver.findElement(By.id("next")).isEnabled();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^User Has Gmail Account$")
	public void user_Has_Gmail_Account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^User Enters Valid User Id And Password$")
	public void user_Enters_Valid_User_Id_And_Password() throws Throwable {
		driver.findElement(By.id("Email")).sendKeys("cucumberdemo53");
		driver.findElement(By.id("next")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
		driver.findElement(By.name("Passwd")).sendKeys("cucumberdemo53password");	
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^Clicks On Sign In$")
	public void clicks_On_Sign_In() throws Throwable {
		driver.findElement(By.id("signIn")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@Then("^Gmail Home Page Should Appear$")
	public void gmail_home_page_should_appear() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		System.out.println("Gmail Logged In Successfully");
		driver.quit();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@Given("^User Enters Valid User Id And InValid Password$")
	public void user_Enters_Valid_User_Id_And_InValid_Password() throws Throwable {
		driver.findElement(By.id("Email")).sendKeys("cucumberdemo53");
		driver.findElement(By.id("next")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
		driver.findElement(By.name("Passwd")).sendKeys("WrongPassword!");		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Gmail Home Page Should Not Appear$")
	public void gmail_Home_Page_Should_Not_Appear() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		Assert.assertEquals(true, isElementPresent("gbqfb"));
		
		System.out.println("Gmail Login Is Unsuccessfull");
		driver.quit();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	private boolean isElementPresent(String id){
		try{
			driver.findElement(By.id(id));
			return true;
		}catch(org.openqa.selenium.NoSuchElementException ne){
			System.out.println(ne.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	
}
