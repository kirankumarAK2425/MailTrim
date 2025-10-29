package Settings;

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
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Email_Categories {

	WebDriver driver;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Email Category.html");

	@BeforeSuite
	public void beforeMethod() throws InterruptedException, IOException {

		extent.attachReporter(sparkreporter);
		System.setProperty("webdriver.chrome.driver", "/home/tvisha/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/opt/Mail trim Electron App/mailtrim_electron");
		options.setBinary("/opt/Mail trim Electron App/mailtrim_electron"); // like: /opt/mailtrim/mailtrim
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		Thread.sleep(3000);
		Runtime.getRuntime().exec(new String[] { "bash", "-c",
				"xdotool search --name 'Mail Trim' windowactivate --sync key --clearmodifiers Super+Up" });
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("meghana.voggu@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("MeghanaV@12");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test
	public void testcase01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Email Categories']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Email Categories:']")).getText();
		Assert.assertEquals("Email Categories:", a);

		ExtentTest test = extent.createTest("Click on Email Categories option");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on Email Categories option");
		test.info("ExpectedResults: It should navigate to Email Categories page");
		test.pass(a);
		test.log(Status.PASS, "ActualResults: It is navigating to Email Categories page");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase02() throws InterruptedException {
		String a = driver.findElement(By.xpath("//span[text()='Email Categories:']")).getText();
		Assert.assertEquals("Email Categories:", a);
		driver.findElement(By.xpath("//button[@role='switch']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//button[@data-state='unchecked']")).getAttribute("data-state");
		Assert.assertEquals("unchecked", b);

		ExtentTest test = extent.createTest("Disable the categories option");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on Email Categories option");
		test.pass(a);
		test.info("Click on category dissable button");
		test.info("ExpectedResults: It should disable the categories option");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is disabling  the category options");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase03() throws InterruptedException {
		String a = driver.findElement(By.xpath("//span[text()='Email Categories:']")).getText();
		Assert.assertEquals("Email Categories:", a);
		String b = driver.findElement(By.xpath("//button[@data-state='unchecked']")).getAttribute("data-state");
		Assert.assertEquals("unchecked", b);
		Thread.sleep(400);
		driver.findElement(By.xpath("//button[@role='switch']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("//button[@data-state='checked']")).getAttribute("data-state");
		Assert.assertEquals("checked", c);

		ExtentTest test = extent.createTest("Enable the Categories option");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on Email Categories option");
		test.pass(a);
		test.pass(b);
		test.info("Click on category enable button");
		test.info("ExpectedResults: It should enable the categories option");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is enabling the category options");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase04() throws InterruptedException {
		String a = driver.findElement(By.xpath("//span[text()='Email Categories:']")).getText();
		Assert.assertEquals("Email Categories:", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[text()=' Create New']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Create ']")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Category name cannot be empty.']")).getText();
		Assert.assertEquals("Category name cannot be empty.", b);

		ExtentTest test = extent.createTest("Without enter category click on create button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on Email Categories option");
		test.pass(a);
		test.info("Click on create new button");
		test.info("Click on create button");
		test.info("ExpectedResults: It should display Category name cannot be empty");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is displaying Category name cannot be empty");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase05() throws InterruptedException {
		String a = driver.findElement(By.xpath("//span[text()='Email Categories:']")).getText();
		Assert.assertEquals("Email Categories:", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//span[text()='Email Rules']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Email Categories']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[text()=' Create New']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@placeholder='Enter Category name']")).sendKeys("Test Test Test");
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Create ']")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//h2[text()='Category Created!']")).getText();
		Assert.assertEquals("Category Created!", b);

		ExtentTest test = extent.createTest("Create new category");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on Email Categories option");
		test.pass(a);
		test.info("Click on create new button");
		test.info("Enter text in the input field");
		test.info("Click on create button");
		test.info("ExpectedResults: It should create new category");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is creating the new category");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase06() throws InterruptedException {
		String a = driver.findElement(By.xpath("//span[text()='Email Categories:']")).getText();
		Assert.assertEquals("Email Categories:", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[text()=' Create New']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@placeholder='Enter Category name']")).sendKeys("Test Test Test");
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Create ']")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Duplicate category']")).getText();
		Assert.assertEquals("Duplicate category", b);

		ExtentTest test = extent.createTest("Enter duplicate category name");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on Email Categories option");
		test.pass(a);
		test.info("Click on create new button");
		test.info("Enter duplicate category name in the input field");
		test.info("Click on create button");
		test.info("ExpectedResults: It should display Duplicate category text");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is displaying Duplicate category text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase07() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//li[@value='accountSettings ']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Email Categories']")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("//span[text()='Email Categories:']")).getText();
		Assert.assertEquals("Email Categories:", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("(//img[@class='cursor-pointer'])[18]")).click();
		Thread.sleep(200);
		WebElement c = driver.findElement(By.xpath("(//input[contains(@class,'border-input')])[10]"));
		Thread.sleep(200);
		c.clear();
		Thread.sleep(200);
		c.sendKeys("Test Test Test 1");
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Changes']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//h2[text()='Category Updated!']")).getText();
		Assert.assertEquals("Category Updated!", b);

		ExtentTest test = extent.createTest("Edit the category name");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on Email Categories option");
		test.pass(a);
		test.info("Click on category edit button");
		test.info("Clear/edit the category name");
		test.info("Click on save changes button");
		test.info("ExpectedResults: It should update the category name");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is updating the category name");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase08() throws InterruptedException {

		String a = driver.findElement(By.xpath("//span[text()='Email Categories:']")).getText();
		Assert.assertEquals("Email Categories:", a);
		Thread.sleep(200);

		driver.findElement(By.xpath("(//img[@class='cursor-pointer'])[19]")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//div[text()='Email Category Deleted']")).getText();
		Assert.assertEquals("Email Category Deleted", b);

		ExtentTest test = extent.createTest("Delete the category");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on Email Categories option");
		test.pass(a);
		test.info("Click on category delete button");
		test.info("ExpectedResults: It should delete the category");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is deleting the category");
		test.pass("Test Case: Test case passed");
	}

	@AfterSuite
	public void afterMethod() {
		extent.flush();
		driver.quit();
	}

}
