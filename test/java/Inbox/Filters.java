package Inbox;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Filters {
	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Filters.html");

	@BeforeSuite
	public void beforeSuite() throws IOException, InterruptedException {
		reports.attachReporter(sparkreporter);
		System.setProperty("webdriver.chrome.driver", "/home/tvisha/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/opt/Mail trim Electron App/mailtrim_electron");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		Runtime.getRuntime().exec(new String[] { "bash", "-c",
				"xdotool search --name 'Mail Trim' windowactivate --sync key --clearmodifiers Super+Up"

		});
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7287893496@A.k");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='checkbox']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px] ']")).click();
		Thread.sleep(200);
		String d = driver.findElement(By.xpath("(//div[text()='kiran.kumar@tvisha.in'])[1]")).getText();
		Assert.assertEquals("kiran.kumar@tvisha.in", d);
		Thread.sleep(200);
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px] ']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Syncing Archive 0 / 121']")));
	}

	@Test
	public void testcase01() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//*[text()='Please specify atleast a field']")).getText();
		Assert.assertEquals("Please specify atleast a field", a);
		String b = driver.findElement(By.xpath("//*[text()='Nothing to search']")).getText();
		Assert.assertEquals("Nothing to search", b);
		Thread.sleep(200);

		ExtentTest test = reports.createTest("Search without input data");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on search filter option");
		test.info("Click on submit button");
		test.info("Expected Results: It should display error msg");
		test.pass(a);
		test.pass(b);
		test.log(Status.PASS, "It is displaying the error msg");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase02() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Google Cloud");
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='Google Cloud'])[1]")).getText();
		Thread.sleep(300);
		Assert.assertEquals("Google Cloud", a);

		ExtentTest test = reports.createTest("Search filter with input data");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on search filter option");
		test.info("Enter from data");
		test.info("Click on submit button");
		test.info("Expected Results: It should dsiplay the search related data");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying the search related data");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase03() throws Throwable {
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='Google Cloud'])[1]")).getText();
		Thread.sleep(300);
		Assert.assertEquals("Google Cloud", a);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[text()='Search'])[2]")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 10 of 10", b);

		ExtentTest test = reports.createTest("Click on search filter clear button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on search filter");
		test.info("Enter from data in the input field");
		test.info("Click on submit button");
		test.pass(a);
		test.info("Click on search filter clear button");
		test.info("Expected Results: It should clear the search filter data");
	    test.pass(b);
		test.log(Status.PASS, "Actual Results: It is clearing the search filter data");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase04() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("test");
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//*[@class='text-xs'])[1]")).getText();
		Assert.assertEquals("We didn't find anything to show here", a);

		ExtentTest test = reports.createTest("Enter invalid data in search bar");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on search filter button");
		test.info("Enter invalid data");
		test.info("Click on submit button");
		test.info("Expected Results: It should display We didn't find anything to show here text");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying We didn't find anything to show here");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase05() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='kiran.kumar@tvisha.in'])[1]")).getText();
		Assert.assertEquals("kiran.kumar@tvisha.in", a);

		ExtentTest test = reports.createTest("Click on search filter and sarch with to data");
		test.info("User login successfully with valid credentials");
		test.info("Click on search filter");
		test.info("Enter to details");
		test.info("Click on submit button");
		test.info("Expected Results: It should display that to data related mails");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying to search related mails");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase06() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("test");
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//*[@class='text-xs'])[1]")).getText();
		Assert.assertEquals("We didn't find anything to show here", a);

		ExtentTest test = reports.createTest("Click on search filter and sarch with invalid to data");
		test.info("User login successfully with valid credentials");
		test.info("Click on search filter");
		test.info("Enter invalid to details");
		test.info("Click on submit button");
		test.info("Expected Results: It should display We didn't find anything to show here text");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying We didn't find anything to show here text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase07() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("RE: Main msg");
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//*[text()='RE: Main msg'])[1]")).getText();
		Assert.assertEquals("RE: Main msg", a);

		ExtentTest test = reports.createTest("Click on search filter and search with subject");
		test.info("User login successfully with valid credentials");
		test.info("Click on search filter");
		test.info("Enter subject in the field");
		test.info("Click on submit button");
		test.info("Expected Results: It should display that subject filter related data");
		test.pass(a);
		test.log(Status.PASS, "Expected Results: It is displaying that filter related data");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase08() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("ugeygy");
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//*[@class='text-xs'])[1]")).getText();
		Assert.assertEquals("We didn't find anything to show here", a);

		ExtentTest test = reports.createTest("Click on search filter and search with invalid subject text");
		test.info("User login successfully with valid credentials");
		test.info("Click on search filter");
		test.info("Enter invalid subject in the field");
		test.info("Click on submit button");
		test.info("Expected Results: It should display We didn't find anything to show here text");
		test.pass(a);
		test.log(Status.PASS, "Expected Results: It is displaying We didn't find anything to show here text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase09() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[@role='checkbox'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@aria-haspopup='dialog'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[text()='25']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//*[text()='Sep 25']")).getText();
		Assert.assertEquals("Sep 25", a);
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Click on search filter and select any date");
		test.info("User login successfully with valid credentials");
		test.info("Click on search filter");
		test.info("Click on on date checkboix");
		test.info("Select any date");
		test.info("Click on submit button");
		test.info("Expected Results: It shoul display mails oin the selected date");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying the mails on the selected date");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase10() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[text()='Search'])[2]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[@role='checkbox'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@aria-haspopup='dialog'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//span[text()='24'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//h1[@class='text-xs'])[1]")).getText();
		Assert.assertEquals("We didn't find anything to show here", a);

		ExtentTest test = reports.createTest("Click on search filter select any date that doesn't contain mails");
		test.info("User login successfully with valid credentials");
		test.info("Click on search filter");
		test.info("Click on on date");
		test.info("Select any date");
		test.info("Click on submit button");
		test.info("Expected Results: It should display We didn't find anything to show here text");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying We didn't find anything to show here text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase11() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='kiran.kumar@tvisha.in'])[1]")).getText();
		Assert.assertEquals("kiran.kumar@tvisha.in", a);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[5]")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 10 of 10", b);

		ExtentTest test = reports.createTest("Select any search filter and click on refresh button");
		test.info("User login successfully with valid credentials");
		test.info("Click on search filder");
		test.info("Select any filter option");
		test.info("Click on submit button");
		test.pass(a);
		test.info("Click on refresh button");
		test.info("Expected Results: It should refresh the page and should display all the data");
	    test.pass(b);
		test.log(Status.PASS, "It is refreshing the page and displaying all the data");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase12() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='All']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 10 of 10", a);

		ExtentTest test = reports.createTest("Click on all flilter and select all");
		test.info("User login successfully with valid credentials");
		test.info("Click on all filter");
		test.info("Select all option");
		test.info("Expected Results: It should display all the mails");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying all the mails");
	}

	@Test
	public void testcase13() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Read']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 10 of 10", a);

		ExtentTest test = reports.createTest("Click on all filter and select read option");
		test.info("user login successfully with valid credential");
		test.info("Click on all filter");
		test.info("Select read option");
		test.info("Expected Results: It should display readed mails only");
		test.pass(a);
		test.log(Status.PASS, "It is displaying readed mails only");
	}

	@Test
	public void testcase14() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[6]")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("(//button[text()='Mark as Unread'])[1]")).click();
		Thread.sleep(800);
		String a = driver.findElement(By.xpath("(//h1[@class='text-xs'])[1]")).getText();
		Assert.assertEquals("We didn't find anything to show here", a);

		ExtentTest test = reports.createTest("Click on all filter and select read option if there are no mails");
		test.info("User login successfully with valid credentials");
		test.info("Click on all filter");
		test.info("Select read if there are no mails are present");
		test.info("Expected Results: It should display We didn't find anything to show here text");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying We didn't find anything to show here text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase15() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//span[text()='Unread'])[1]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 10 of 10", a);

		ExtentTest test = reports.createTest("Click on all filter and select unread option");
		test.info("User login successfully with valid credentials");
		test.info("Click on all filter");
		test.info("Select unread option");
		test.info("Expected Results: It should display all the undread mails");
		test.pass(a);
		test.log(Status.PASS, "It is displaying all the unread mails");
	}

	@Test
	public void testcase16() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Mark as Read']")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//h1[@class='text-xs'])[1]")).getText();
		Assert.assertEquals("We didn't find anything to show here", a);

		ExtentTest test = reports.createTest("Click on all filter and select unread option if there are no mails");
		test.info("User login successfully with valid credentials");
		test.info("Click on all filter");
		test.info("Select unread if there are no mails are present");
		test.info("Expected Results: It should display We didn't find anything to show here text");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying We didn't find anything to show here text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase17() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Flagged']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//h1[@class='text-xs'])[1]")).getText();
		Assert.assertEquals("We didn't find anything to show here", a);

		ExtentTest test = reports.createTest("Click on all filter and select flagged option if no mails are present");
		test.info("User login succcessfully with valid credentials");
		test.info("Click on all filters");
		test.info("Select flagged option");
		test.info("Expected Results: It should display We didn't find anything to show here text");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying We didn't find anything to show here text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase18() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='All']")).click();
		Thread.sleep(200);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(a).build().perform();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//img[@alt='Flag icon'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Flagged']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 1 of 1", b);

		ExtentTest test = reports.createTest("Click on all filter and select flagged option");
		test.info("User login succcessfully with valid credentials");
		test.info("Click on all filters");
		test.info("CLick flagged option");
		test.info("Expected Results: It should display all the flagged mails");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying all the flagged mail");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase19() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Unflagged']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 9 of 9", a);

		ExtentTest test = reports.createTest("Click on all filter and click on unflagged option");
		test.info("User login successfully with valid credentials");
		test.info("Click on all filter");
		test.info("Select unflagged option");
		test.info("Expected Results: It should display all the unflagged mails");
		test.pass(a);
		test.log(Status.PASS, "It is displaying all the unflagged mails");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase20() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Respond later']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Respond later']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//h1[@class='text-xs'])[1]")).getText();
		Assert.assertEquals("We didn't find anything to show here", a);

		ExtentTest test = reports.createTest("Click on all filter and select respond later if no mails are present");
		test.info("User login successfully with valid credentials");
		test.info("Click on all filter");
		test.info("Select respond later option");
		test.info("Expected Results: It should display We didn't find anything to show here text");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying We didn't find anything to show here text");
	}

	@Test
	public void testcase21() throws InterruptedException {
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//span[text()='All']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[7]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Respond Later'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Respond later']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//img[@title='Remove respond later'])[1]")).getText();
		Assert.assertEquals("Remove respond later", a);
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 1 of 1", b);

		ExtentTest test = reports.createTest("Click on all filter and select respond later option");
		test.info("User login successfully with valid credentials");
		test.info("Click on all filter");
		test.info("Select respond later option");
		test.info("Expected Results: It should display respond later mails");
		test.pass(a);
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying all the respond later mailds");
		test.pass("Test Case: Test case passed");

	}

	
	@Test
	public void testcase22() throws InterruptedException{
		Thread.sleep(300);
		WebElement a=driver.findElement(By.xpath("(//img[@class='m-auto w-[0.875rem] h-[0.875rem]'])[1]"));
		Thread.sleep(300);
		
		ExtentTest test=reports.createTest("Click on medium list viewer");
		test.info("User login successfully with valid credentials");
		test.info("Click on medium list viewer");
		test.info("Expected Results: It should display the mails in medium viewer");
		if(a.isEnabled()) {
			test.pass("It is displaying the mails in medium viewer");
		}else {
			test.fail("It is not displaying the mails in medium viewer");
		}
		test.log(Status.PASS, "It is displaying the mails in medium viewer");
		test.pass("Test Case: Test case passed");				
	}
	
	
	@Test
	public void testcase23() throws InterruptedException{
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@class='m-auto w-[0.875rem] h-[0.875rem]'])[2]")).click();
		Thread.sleep(300);
		WebElement a=driver.findElement(By.xpath("(//img[@class='m-auto w-[0.875rem] h-[0.875rem]'])[2]"));
		Thread.sleep(300);
		
		ExtentTest test=reports.createTest("Click on sidepanel list viewer");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel list viewer");
		test.info("Expected Results: It should display the mails in sidepanel viewer");
		if(a.isEnabled()) {
			test.pass("It is displaying the mails in sidepanel viewer");
		}else {
			test.fail("It is not displaying the mails in sidepanel viewer");
		}
		test.log(Status.PASS, "It is displaying the mails in sidepanel viewer");
		test.pass("Test Case: Test case passed");				
	}
	
	@Test
	public void testcase24() throws InterruptedException{
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@class='m-auto w-[0.875rem] h-[0.875rem]'])[3]")).click();
		Thread.sleep(300);
		WebElement a=driver.findElement(By.xpath("(//img[@class='m-auto w-[0.875rem] h-[0.875rem]'])[3]"));
		Thread.sleep(300);
		
		ExtentTest test=reports.createTest("Click on sidepanel big viewer");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel big viewer");
		test.info("Expected Results: It should display the mails in sidepanel big viewer");
		if(a.isEnabled()) {
			test.pass("It is displaying the mails in sidepanel big viewer");
		}else {
			test.fail("It is not displaying the mails in sidepanel big viewer");
		}
		test.log(Status.PASS, "It is displaying the mails in sidepanel big viewer");
		test.pass("Test Case: Test case passed");				
	}
	
	
	
	
	
	
	
	@AfterSuite
	public void afterSuite() {
		reports.flush();
		driver.quit();
	}

}
