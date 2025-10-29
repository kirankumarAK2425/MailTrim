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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Email_Rule {
	WebDriver driver;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("EmailRules.html");

	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//span[text()='Email Rules']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//h2[text()='Email Rules']")).getText();
		Assert.assertEquals("Email Rules", a);

		ExtentTest test = extent.createTest("Click on email rule option");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("ExpectedResults: It should navigate to email rules page");
		test.pass(a);
		test.log(Status.PASS, "ActualResults: It is navigating to email rules page");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase02() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Email Rules']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//h2[text()='Email Rules']")).getText();
		Assert.assertEquals("Email Rules", a);
		driver.findElement(By.xpath("//button[text()=' + Add Rule']")).click();
		Thread.sleep(100);
		String b = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", b);

		ExtentTest test = extent.createTest("Click on add rule option");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.pass(a);
		test.info("Click on add rule button");
		test.info("ExpectedResults: It should navigate to add rule page");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is navigating to add rule page");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase03() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		String b = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Back to Rule Page']")).click();
		Thread.sleep(300);
		String c = driver.findElement(By.xpath("//span[text()='Email Rules']")).getText();
		Assert.assertEquals("Email Rules", c);

		ExtentTest test = extent.createTest("Click on add rule option and click on back button in add rule page");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("Click on add rule button");
		test.pass(b);
		test.info("Click on back button");
		test.info("ExpectedResults: It should navigate to email rules home page");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is navigating to email rules home page");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase04() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		String a = driver.findElement(By.xpath("//h2[text()='Email Rules']")).getText();
		Assert.assertEquals("Email Rules", a);
		driver.findElement(By.xpath("//button[text()=' + Add Rule']")).click();
		Thread.sleep(100);
		String b = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("//div[text()='Please enter rule name']")).getText();
		Assert.assertEquals("Please enter rule name", c);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		ExtentTest test = extent.createTest("Without enter the details click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.pass(a);
		test.info("Click on add rule button");
		test.pass(b);
		test.info("ExpectedResults: It should display Please enter rule name toast msg");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is displaying Please enter rule name toast msg");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase05() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		String b = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@placeholder='Enter rule name']")).sendKeys("test1");
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("//div[text()='Please select the condition']")).getText();
		Assert.assertEquals("Please select the condition", c);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		ExtentTest test = extent.createTest("Enter rule name & without enter configurations click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("Click on add rule button");
		test.pass(b);
		test.info("Enter the rule name in the input field");
		test.info("Click on save rule button");
		test.info("ExpectedResults: It should display Please select the condition toast msg");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is displaying Please select the condition toast msg");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase06() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		String b = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[@role='combobox'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='From']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String actualMessage = "Please enter the details";
		String expectedMessage = "Please enter From mail details";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		ExtentTest test = extent.createTest("Enter rule name & select condition and click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("Click on add rule button");
		test.pass(b);
		test.info("Enter the rule name in the input field");
		test.info("Select the condition");
		test.info("Click on save rule button");
		try {

			Assert.assertEquals(actualMessage, expectedMessage, "Validation message is incorrect → Test Failed!");
			test.pass("Expeted Result:" + expectedMessage);
			test.pass("Actual Result:" + actualMessage);
			test.pass("✅ Validation Passed → Messages matched successfully");

		} catch (AssertionError e) {
			// If it fails → log as FAIL
			test.fail("❌ Validation Failed");
			test.fail("Expected Message: " + expectedMessage);
			test.fail("Actual Message: " + actualMessage);
			test.fail("Error: " + e.getMessage());

			// rethrow so TestNG marks test as failed
			throw e;

		}

	}

	@Test
	public void testcase07() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		String b = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='css-iq219e']")).sendKeys("kiran");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String actualMessage = "Please enter the details";
		String expectedMessage = "Please enter correct mail address";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		ExtentTest test = extent
				.createTest("Enter rule name & select condition and enter wrong mail and click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		// test.pass(a);
		test.info("Click on add rule button");
		test.pass(b);
		test.info("Enter the rule name in the input field");
		test.info("Select the condition");
		test.info("Enter wrong email id: kiran");
		test.info("Click on save rule button");
		try {

			Assert.assertEquals(actualMessage, expectedMessage, "Validation message is incorrect → Test Failed!");
			test.pass("Expeted Result:" + expectedMessage);
			test.pass("Actual Result:" + actualMessage);
			test.pass("✅ Validation Passed → Messages matched successfully");

		} catch (AssertionError e) {
			// If it fails → log as FAIL
			test.fail("❌ Validation Failed");
			test.fail("Expected Message: " + expectedMessage);
			test.fail("Actual Message: " + actualMessage);
			test.fail("Error: " + e.getMessage());

			// rethrow so TestNG marks test as failed
			throw e;

		}

	}

	@Test
	public void testcase08() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Thread.sleep(100);
		String b = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", b);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Syncing INBOX 200 / 370']")));
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Display Settings']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//span[text()='Email Rules']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()=' + Add Rule']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//input[@placeholder='Enter rule name']")).sendKeys("test1");
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[@role='combobox'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='From']")).click();
		Thread.sleep(300);
		WebElement fromInput = driver.findElement(By.xpath("//div[@class='css-1hmaw98-control']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(fromInput).click().sendKeys("Mailer-Daemon@server1.tvisha.com").build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[text()='Mailer-Daemon@server1.tvisha.com']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("//div[text()='Please select the action']")).getText();
		Assert.assertEquals("Please select the action", c);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		ExtentTest test = extent.createTest("Enter rule name & enter configurations click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("Click on add rule button");
		test.pass(b);
		test.info("Enter the rule name in the input field");
		test.info("Select the condition");
		test.info("Enter valid email address: notification@slack.com");
		test.info("Click on save rule button");
		test.info("ExpectedResults: It should display Please select the action toast msg");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is displaying Please select the action toast msg");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase09() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		String b = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//span[text()='Move'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("//div[text()='Please select the rule']")).getText();
		Assert.assertEquals("Please select the rule", c);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		ExtentTest test = extent.createTest(
				"Enter rule name & enter configurations & select action as move and click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("Click on add rule button");
		test.pass(b);
		test.info("Enter the rule name in the input field");
		test.info("Select the condition");
		test.info("Enter valid email address: notification@slack.com");
		test.info("Select the action as move");
		test.info("Click on save rule button");
		test.info("ExpectedResults: It should display Please select the rule toast msg");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is displaying Please select the rule toast msg");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase10() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("//div[text()='Please select the rule']")).getText();
		Assert.assertEquals("Please select the rule", c);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		ExtentTest test = extent.createTest(
				"Enter rule name & enter configurations & select action as delete and click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("Click on add rule button");
		test.info("Enter the rule name in the input field");
		test.info("Select the condition");
		test.info("Enter valid email address: notification@slack.com");
		test.info("Select the action as delete");
		test.info("Click on save rule button");
		test.info("ExpectedResults: It should display Please select the rule toast msg");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is displaying Please select the rule toast msg");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase11() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//span[text()='Move'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[@role='combobox'])[3]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//span[text()='Drafts'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("//h2[text()='New Email rule is saved']")).getText();
		Assert.assertEquals("New Email rule is saved", c);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		ExtentTest test = extent.createTest(
				"Enter rule name & enter configurations & select action as move and click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("Click on add rule button");
		test.info("Enter the rule name in the input field");
		test.info("Select the condition");
		test.info("Enter valid email address: notification@slack.com");
		test.info("Select the action as move");
		test.info("Select the rule as draft");
		test.info("Click on save rule button");
		test.info("ExpectedResults: It should save the rule and display New Email rule is saved toast msg");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is saving the rule and displaying New Email rule is saved toast msg");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase12() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(02));
		driver.findElement(By.xpath("//button[text()=' + Add Rule']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//input[@placeholder='Enter rule name']")).sendKeys("test2");
		Thread.sleep(200);
		WebElement fromInput = driver.findElement(By.xpath("//div[@class='css-1hmaw98-control']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(fromInput).click().sendKeys("sampath@tvisha.in").build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[text()='sampath@tvisha.in']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[@role='checkbox'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Rule']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("//h2[text()='New Email rule is saved']")).getText();
		Assert.assertEquals("New Email rule is saved", c);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		ExtentTest test = extent.createTest(
				"Enter rule name & enter configurations & select action as delete and click on save rule button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.info("Click on add rule button");
		test.info("Enter the rule name in the input field");
		test.info("Select the condition");
		test.info("Enter valid email address: notification@slack.com");
		test.info("Select the action as delete");
		test.info("Select the rule as All Upcoming Mails");
		test.info("Click on save rule button");
		test.info("ExpectedResults: It should save the rule and display New Email rule is saved toast msg");
		test.pass(c);
		test.log(Status.PASS, "ActualResults: It is saving the rule and displaying New Email rule is saved toast msg");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase13() throws InterruptedException {
		String a = driver.findElement(By.xpath("//h2[text()='Email Rules']")).getText();
		Assert.assertEquals("Email Rules", a);
		Thread.sleep(200);
		WebElement el = driver.findElement(By.xpath(
				"//tr[td[contains(normalize-space(),'test1')]]/td[last()]/*[local-name()='svg']/*[local-name()='path']"));
		Actions act = new Actions(driver);
		act.moveToElement(el).click().perform();
		Thread.sleep(800);
		String b = driver.findElement(By.xpath("//h2[text()='Email Rule Deleted']")).getText();
		Assert.assertEquals("Email Rule Deleted", b);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		ExtentTest test = extent.createTest("Delete the email rule");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.pass(a);
		test.info("Click on delete option of any rule");
		test.info("ExpectedResults: It should delete that rule and should display 'Email Rule Deleted' toast msg");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is deleting the rule and displaying 'Email Rule Deleted' toast msg");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase14() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String a = driver.findElement(By.xpath("//h2[text()='Email Rules']")).getText();
		Assert.assertEquals("Email Rules", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[@role='switch'])[1]")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("(//button[@aria-checked='false'])[1]")).getAttribute("aria-checked");
		Assert.assertEquals("false", b);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		ExtentTest test = extent.createTest("Disable the email rule");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on settings");
		test.info("Click on email rule option");
		test.pass(a);
		test.info("Click on rule disable button");
		test.info("ExpectedResults: It should disable that rule");
		test.pass(b);
		test.log(Status.PASS, "ActualResults: It is disabling the rule");
		test.pass("Test Case: Test case passed");

	}

	@AfterSuite
	public void afterSuite() {
		extent.flush();
		driver.quit();
	}

}
