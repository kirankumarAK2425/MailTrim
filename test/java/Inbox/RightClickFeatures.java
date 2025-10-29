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

public class RightClickFeatures {
	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("RightClickFeatures.html");

	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {
		reports.attachReporter(sparkreporter);
		System.setProperty("webdriver.chrome.driver", "/home/tvisha/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/opt/Mail trim Electron App/mailtrim_electron");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		Thread.sleep(3000);
		Runtime.getRuntime().exec(new String[] { "bash", "-c",
				"xdotool search --name 'Mail Trim' windowactivate --sync key --clearmodifiers Super+Up" });
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7287893496@A.K");
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Syncing Archive 0 / 124']")));
	}

	@Test
	public void testcase01() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(100);
		WebElement b = driver.findElement(By.xpath("(//div[@tabindex='-1'])[3]"));
		act.moveToElement(b).build().perform();
		b.click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", c);

		ExtentTest test = reports.createTest("RightClick and click on reply");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on reply option");
		test.info("Expected Results: It should display reply mail window");
		test.pass(c);
		test.log(Status.PASS, "Actual Result: It is displaying reply mail window");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase02() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//span[text()='Reply-all'])")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("(//p[text()='Reply Mail'])")).getText();
		Assert.assertEquals("Reply Mail", b);

		ExtentTest test = reports.createTest("Right click and click on reply all");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on reply all");
		test.info("Expected Results: It should display reply screen");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying reply screen");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase03() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(200);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Forward']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//p[text()='Forward Mail']")).getText();
		Assert.assertEquals("Forward Mail", b);

		ExtentTest test = reports.createTest("Right click and click on forward");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on forward");
		test.info("Expected Results: It should display forward screen");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying forward screen");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase04() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(200);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("//div[text()='Copy']"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[text()='test']")).click();
		Thread.sleep(500);
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(500);
		WebElement c = driver.findElement(By.xpath("//div[text()='Copy']"));
		act.moveToElement(c).build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='test']")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mail copied successfully']")));
		Thread.sleep(500);
		String d = driver.findElement(By.xpath("//h2[text()='Mail copied successfully']")).getText();
		Assert.assertEquals("Mail copied successfully", d);

		ExtentTest test = reports.createTest("Right click and click on copy");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on copy");
		test.info("Click on any folder");
		test.info("Expected Results: It should copy the mail to selected folder");
		test.pass(d);
		test.log(Status.PASS, "Actual Results: It is coping the mail to selected folder");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase05() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//div[text()='Move'])"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[text()='test']")).click();
		Thread.sleep(500);
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(500);
		WebElement c = driver.findElement(By.xpath("(//div[text()='Move'])"));
		act.moveToElement(c).build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='test']")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mail copied successfully']")));
		Thread.sleep(500);
		String d = driver.findElement(By.xpath("//h2[text()='Mail moved successfully']")).getText();
		Assert.assertEquals("Mail moved successfully", d);

		ExtentTest test = reports.createTest("Right click and click on move");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on move");
		test.info("Click on any folder");
		test.info("Expected Results: It should move the mail to selected folder");
		test.pass(d);
		test.log(Status.PASS, "Actual Results: It is moving the mail to selected folder");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase06() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//div[text()='Categorise'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[text()='FRIENDS'])[1]")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[text()='Added to category FRIENDS'])[1]")));
		Thread.sleep(300);
		String c = driver.findElement(By.xpath("(//h2[text()='Added to category FRIENDS'])[1]")).getText();
		Assert.assertEquals("Added to category FRIENDS", c);

		ExtentTest test = reports.createTest("Right click and click on category");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on category");
		test.info("Select on any required category");
		test.info("Expected Results: It should move those mails to selected category");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is moving those mails to the selected ctegory");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase07() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[3]")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		Boolean d = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h2[text()='Create Rule']")));

		ExtentTest test = reports.createTest("Right click and click on create rule and click on rule close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.info("Click on close button");
		test.info("Expected Results: It should close the create rule window");
		test.pass(c);

		if (d) {
			test.pass("It is closing the create rule window");
		} else {
			test.fail("It is not closing the create rule window");
		}
		test.log(Status.PASS, "Actual Results: It is closing the create rule window");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase08() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		b.click();
		Thread.sleep(300);
		String c = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String d = driver.findElement(By.xpath("(//div[text()='Please select the rule'])[1]")).getText();
		Assert.assertEquals("Please select the rule", d);

		ExtentTest test = reports
				.createTest("Right click and click on create rule without selecting rule click on submit");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.info("Click on submit button");
		test.info("Expected Results: It should display Please select the rule toast msg");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is displaying Please select the rule toast msg");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase09() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		b.click();
		Thread.sleep(300);
		String c = driver.findElement(By.xpath("//h2[text()='Create Rule']")).getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String d = driver.findElement(By.xpath("(//div[text()='Please select the rule'])[1]")).getText();
		Assert.assertEquals("Please select the rule", d);

		ExtentTest test = reports
				.createTest("Right click and click on create rule without selecting rule click on submit");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.info("Click on submit button");
		test.info("Expected Results: It should display Please select the rule toast msg");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is displaying Please select the rule toast msg");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase10() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		b.click();
		Thread.sleep(300);
		String c = driver.findElement(By.id("radix-11")).getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//span[text()='test'])[3]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(300);
		String d = driver.findElement(By.xpath("(//span[text()='Created'])[1]")).getText();
		Assert.assertEquals("Created", d);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		Thread.sleep(500);

		ExtentTest test = reports
				.createTest("Right click and click on create rule and select any rule and folder and click on submit");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.pass(c);
		test.info("Select any folder");
		test.info("Click on submit button");
		test.info("Expected Results: It should save that rule");
		test.pass(d);
		test.log(Status.PASS, "Actual Results: It is saving that rule");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase11() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		b.click();
		Thread.sleep(2000);
		String c = driver
				.findElement(By.xpath("//h2[contains(@class,'font-semibold') and contains(text(),'Create Rule')]"))
				.getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//p[text()='Create New Folder'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Create'])[1]")).click();
		Thread.sleep(300);
		String d = driver.findElement(By.xpath("(//div[text()='Please enter folder name'])[1]")).getText();
		Assert.assertEquals("Please enter folder name", d);
		Thread.sleep(500);

		ExtentTest test = reports.createTest(
				"Right click and click on create rule and click on create new folder and without enter folder name and click on create");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.pass(c);
		test.info("Select any folder");
		test.info("Click on create new folder button");
		test.info("Click on create button");
		test.info("Expected Results: It should display Please enter folder name toast msg");
		test.pass(d);
		test.log(Status.PASS, "Actual Results: It is displaying Please enter folder name toast msg");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase12() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		b.click();
		Thread.sleep(2000);
		String c = driver.findElement(By.xpath("//h2[contains(text(),'Create Rule')]")).getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//p[text()='Create New Folder'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@placeholder='Enter folder name']")).sendKeys("Automation Rule");
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[text()='Create'])[1]")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Folder Created successfully']")));
		Thread.sleep(500);
		String d = driver.findElement(By.xpath("//div[text()='Folder Created successfully']")).getText();
		Assert.assertEquals("Folder Created successfully", d);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(1000);
		String e = driver.findElement(By.xpath("(//span[text()='Created'])[1]")).getText();
		Assert.assertEquals("Created", e);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		Thread.sleep(500);

		ExtentTest test = reports
				.createTest("Right click and click on create rule and add new folder and click on submit");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.pass(c);
		test.info("Select any folder");
		test.info("Click on create new folder button");
		test.info("Enter the folder name");
		test.info("Click on create button");
		test.pass(d);
		test.info("Click on submit button");
		test.info("Expected Results: It should save that rule");
		test.pass(e);
		test.log(Status.PASS, "Actual Results: It is saving that rule");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase13() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		b.click();
		Thread.sleep(2000);
		String c = driver.findElement(By.xpath("//h2[contains(text(),'Create Rule')]")).getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[@aria-autocomplete='none'])[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(1000);
		String e = driver.findElement(By.xpath("(//span[text()='Created'])[1]")).getText();
		Assert.assertEquals("Created", e);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		Thread.sleep(500);

		ExtentTest test = reports
				.createTest("Right click and click on create rule and select rule as delete and click on submit");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.pass(c);
		test.info("Select any folder");
		test.info("Click on create new folder button");
		test.info("Click on rule selection dropdown");
		test.info("Select the rule as delete");
		test.info("Click on submit button");
		test.info("Expected Results: It should save that rule");
		test.pass(e);
		test.log(Status.PASS, "Actual Results: It is saving that rule");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase14() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		b.click();
		Thread.sleep(2000);
		String c = driver.findElement(By.xpath("//h2[contains(text(),'Create Rule')]")).getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[@aria-autocomplete='none'])[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@id='upcoming']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(1000);
		String e = driver.findElement(By.xpath("(//span[text()='Created'])[1]")).getText();
		Assert.assertEquals("Created", e);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		Thread.sleep(500);

		ExtentTest test = reports.createTest(
				"Right click and click on create rule and select rule as delete and select the option as Only Upcoming Mails and click on submit");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.pass(c);
		test.info("Select any folder");
		test.info("Click on create new folder button");
		test.info("Click on rule selection dropdown");
		test.info("Select the rule as delete");
		test.info("Click on Only Upcoming Mails option");
		test.info("Click on submit button");
		test.info("Expected Results: It should save that rule");
		test.pass(e);
		test.log(Status.PASS, "Actual Results: It is saving that rule");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase15() throws InterruptedException {

		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//span[text()='Create Rule'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		b.click();
		Thread.sleep(2000);
		String c = driver.findElement(By.xpath("//h2[contains(text(),'Create Rule')]")).getText();
		Assert.assertEquals("Create Rule", c);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[@aria-autocomplete='none'])[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@id='existing']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(1000);
		String e = driver.findElement(By.xpath("(//span[text()='Created'])[1]")).getText();
		Assert.assertEquals("Created", e);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		Thread.sleep(500);

		ExtentTest test = reports.createTest(
				"Right click and click on create rule and select rule as delete and select the option as All Mails and click on submit");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on create rule");
		test.pass(c);
		test.info("Select any folder");
		test.info("Click on create new folder button");
		test.info("Click on rule selection dropdown");
		test.info("Select the rule as delete");
		test.info("Click on All Mails option");
		test.info("Click on submit button");
		test.info("Expected Results: It should save that rule");
		test.pass(e);
		test.log(Status.PASS, "Actual Results: It is saving that rule");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase16() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Spam']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mail moved successfully']")));
		String b = driver.findElement(By.xpath("//h2[text()='Mail moved successfully']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Mail moved successfully", b);

		ExtentTest test = reports.createTest("Right click and click on spam");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on spam");
		test.info("Expected Results: It should add the mail to spam");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is adding the mail to spam");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase17() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//span[text()='Archive'])[2]")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mail moved successfully']")));
		String b = driver.findElement(By.xpath("//h2[text()='Mail moved successfully']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Mail moved successfully", b);

		ExtentTest test = reports.createTest("Right click and click on archive");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on archive");
		test.info("Expected Results: It should move the mail to archive");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is moving the mail to archive");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase18() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Block User']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='User blocked']")));
		String b = driver.findElement(By.xpath("//h2[text()='User blocked']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("User blocked", b);

		ExtentTest test = reports.createTest("Right click and click on block user");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on block user");
		test.info("Expected Results: It should block that user");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is blocking that user");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase19() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[2]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Block User']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Self-blocking not allowed']")));
		String b = driver.findElement(By.xpath("//div[text()='Self-blocking not allowed']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Self-blocking not allowed", b);

		ExtentTest test = reports.createTest("Right click and click on block user of self mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on block user of self user");
		test.info("Expected Results: It should display Self-blocking not allowed");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying Self-blocking not allowed");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase20() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Block Domain']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//span[text()='Are you sure to want to block domain ? ']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Are you sure to want to block domain ? ", b);

		ExtentTest test = reports.createTest("Right click and click on block domain");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on block domain");
		test.info("Expected Results: It should display Are you sure to want to block domain ? confirmation box");
		test.pass(b);
		test.log(Status.PASS,
				"Actual Results: It is displaying Are you sure to want to block domain ? confirmation box");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase21() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Block Domain']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//span[text()='Are you sure to want to block domain ? ']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Are you sure to want to block domain ? ", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@d='M18 6 6 18']")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		boolean confirmationBox = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//span[text()='Are you sure to want to block domain ? ']")));

		ExtentTest test = reports
				.createTest("Right click and click on block domain and click on confirmation close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on block domain");
		test.pass(b);
		test.info("Click on confirmation box close button");
		test.info("Expected Results: It should close the confirmation box");
		if (confirmationBox) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase22() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Block Domain']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//span[text()='Are you sure to want to block domain ? ']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Are you sure to want to block domain ? ", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Block User']")).click();
		Thread.sleep(300);
		String c = driver.findElement(By.xpath("//h2[text()='User blocked']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("User blocked", c);
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Right click and click on block domain and click on block user");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on block domain");
		test.pass(b);
		test.info("Click on block user");
		test.info("Expected Results: It should block the user");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is blocking the user");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase23() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Block Domain']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//span[text()='Are you sure to want to block domain ? ']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Are you sure to want to block domain ? ", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Block domain']")).click();
		Thread.sleep(300);
		String c = driver.findElement(By.xpath("//h2[text()='Domain blocked']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Domain blocked", c);
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Right click and click on block domain and click on block domain option");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on block domain");
		test.pass(b);
		test.info("Click on block domain option");
		test.info("Expected Results: It should block the domain");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is blocking the domain");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase24() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Block Domain']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//span[text()='Are you sure to want to block domain ? ']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Are you sure to want to block domain ? ", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		boolean confirmationBox = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//span[text()='Are you sure to want to block domain ? ']")));

		ExtentTest test = reports.createTest("Right click and click on block domain and click on cancel");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on block domain");
		test.pass(b);
		test.info("Click on cancel in confirmation box");
		test.info("Expected Results: It should close the confirmation box");
		if (confirmationBox) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase25() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[2]"));
		act.moveToElement(a).contextClick().build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mail moved successfully']")));
		String b = driver.findElement(By.xpath("//h2[text()='Mail moved successfully']")).getText();
		Thread.sleep(200);
		Assert.assertEquals("Mail moved successfully", b);

		ExtentTest test = reports.createTest("Right click and click on delete");
		test.info("Login the user successfully with valid credentials");
		test.info("Right click on any mail");
		test.info("Click on delete");
		test.info("Expected Results: It should delete the mail");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is deleting the mail");
		test.pass("Test Case: Test case passed");
	}

	@AfterSuite
	public void afterSuite() {
		reports.flush();
		driver.quit();
	}

}
