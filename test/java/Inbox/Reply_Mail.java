package Inbox;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeSuite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Reply_Mail {
	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Reply.html");

	@BeforeSuite
	public void beforeSuite() throws IOException, InterruptedException {
		reports.attachReporter(sparkreporter);
		System.setProperty("webdriver.chrome.driver", "/home/tvisha/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/opt/Mail trim Electron App/mailtrim_electron");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		Thread.sleep(3000);
		Runtime.getRuntime().exec(new String[] { "bash", "-c",
				"xdotool search --name 'Mail Trim' windowactivate --sync key --clearmodifiers Super+Up"

		});
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7287893496@A.k");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}

	@Test
	public void testcase01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px] ']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//div[text()='kiran.kumar@tvisha.in'])[1]")).getText();
		Assert.assertEquals("kiran.kumar@tvisha.in", a);
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px] ']")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Syncing Archive 0 / 44']")));
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(200);
		String d = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", d);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Reply mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.info("Expected Results: It should display reply screen");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying reply screen");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase02() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Save as Draft']")).click();
		Thread.sleep(5000);
		String a = driver.findElement(By.xpath("//h2[text()='Mail saved as draft']")).getText();
		Assert.assertEquals("Mail saved as draft", a);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on close button and click on save as draft");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.info("Click on close button");
		test.info("Click on save as draft option in the confirmation box");
		test.info("Expected Results: It should save the mail as draft");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is saving the mail as draft");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);
	}

	@Test
	public void testcase03() throws InterruptedException {
		Thread.sleep(500);
		Actions act = new Actions(driver);
		WebElement b = driver.findElement(By.xpath(
				"(//div[@class='flex items-center border-b border-b-[#f0f2f6]  cursor-pointer group pr-3'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("//h2[text()='Mail discarded']")).getText();
		Assert.assertEquals("Mail discarded", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on close button and click on discard");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Click on close button");
		test.info("Click on discard option in the confirmation box");
		test.info("Expected Results: It should discard the mail");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is discarding the mail");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase04() throws InterruptedException {
		Thread.sleep(500);
		Actions act = new Actions(driver);
		WebElement b = driver.findElement(By.xpath(
				"(//div[@class='flex items-center border-b border-b-[#f0f2f6]  cursor-pointer group pr-3'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on close button and click on cancel");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Click on close button");
		test.info("Click on cancel option in the confirmation box");
		test.info("Expected Results: It should close the confirmation box and should display the reply screen");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box and displaying reply screen");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase05() throws InterruptedException {
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg'][@class='lucide lucide-x h-4 w-4']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on close button and click on confirmation box close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Click on close button");
		test.info("Click on confirmation box close button");
		test.info("Expected Results: It should close the confirmation box and should display the reply screen");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box and displaying reply screen");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase06() throws InterruptedException {
		Thread.sleep(2000);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg' and @width='14']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Send ']")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Please select the to mail']")).getText();
		Assert.assertEquals("Please select the to mail", b);

		ExtentTest test = reports.createTest("Remove the To mail and click on send button");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Click on mail remove button");
		test.info("Click on send button");
		test.info("Expected Results: It should display error msg as Please select the to mail");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying error msg as Please select the to mail");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase07() throws InterruptedException {
		Thread.sleep(1000);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		WebElement toField = driver.findElement(By.xpath("//div[@class='css-19bb58m']"));
		toField.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(toField).click().sendKeys("test.te@te.in").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//br[@class='ProseMirror-trailingBreak'])[1]")).sendKeys("Test Test Test 1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Send ']")).click();
		Thread.sleep(500);
		WebElement b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")));
		Thread.sleep(1000);
		String c = b.getText();
		Assert.assertEquals("1 - 76 of 76", c);
		Thread.sleep(500);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//p[text()='Reply Mail'])[1]")));
		Thread.sleep(2000);

		ExtentTest test = reports.createTest("Reply any mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on send button");
		test.info("Expected Results: It should send the mail");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is sending the mail");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase08() throws InterruptedException {
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		WebElement toField = driver.findElement(By.xpath("(//div[@class='css-19bb58m'])[2]"));
		toField.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(toField).click().sendKeys("test.te@te.in").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//br[@class='ProseMirror-trailingBreak'])[1]")).sendKeys("Test Test Test 1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Send ']")).click();
		Thread.sleep(500);
		WebElement b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")));
		Thread.sleep(1000);
		String c = b.getText();
		Assert.assertEquals("1 - 76 of 76", c);
		Thread.sleep(500);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//p[text()='Reply Mail'])[1]")));
		Thread.sleep(2000);

		ExtentTest test = reports.createTest("Reply any mail by CC");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter CC mail");
		test.info("Enter text in the input field");
		test.info("Click on send button");
		test.info("Expected Results: It should send the mail");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is sending the mail");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase09() throws InterruptedException {
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Bcc']")).click();
		Thread.sleep(300);
		WebElement toField = driver.findElement(By.xpath("(//div[@class='css-19bb58m'])[3]"));
		toField.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(toField).click().sendKeys("test.te@te.in").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//br[@class='ProseMirror-trailingBreak'])[1]")).sendKeys("Test Test Test 1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Send ']")).click();
		Thread.sleep(500);
		WebElement b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")));
		Thread.sleep(1000);
		String c = b.getText();
		Assert.assertEquals("1 - 76 of 76", c);
		Thread.sleep(500);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//p[text()='Reply Mail'])[1]")));
		Thread.sleep(2000);

		ExtentTest test = reports.createTest("Reply any mail by BCC");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Click on BCC");
		test.info("Enter BCC mail");
		test.info("Enter text in the input field");
		test.info("Click on send button");
		test.info("Expected Results: It should send the mail");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is sending the mail");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase10() throws InterruptedException {
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(2000);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on dismiss reply button");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on dismiss reply button");
		test.info("Expected Results: It should display confirmation box");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying confirmation box");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase11() throws InterruptedException {
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Save as Draft']")).click();
		Thread.sleep(500);
		String c = driver.findElement(By.xpath("//h2[text()='Mail saved as draft']")).getText();
		Assert.assertEquals("Mail saved as draft", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on dismiss reply button and click on save as draft option");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on dismiss reply button");
		test.pass(b);
		test.info("Click on save as draft option");
		test.info("Expected Results: It should save the mail as draft");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is saving the mail as draft");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase12() throws InterruptedException {
		Thread.sleep(500);
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("//h2[text()='Mail discarded']")).getText();
		Assert.assertEquals("Mail discarded", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on dismiss reply button and click on discard option");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on dismiss reply button");
		test.pass(b);
		test.info("Click on discard option");
		test.info("Expected Results: It should display mail discarded toast msg");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is displaying mail discarded toast msg ");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase13() throws InterruptedException {
		Thread.sleep(500);
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on dismiss reply button and click on cancel option");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on dismiss reply button");
		test.pass(b);
		test.info("Click on cancel option");
		test.info("Expected Results: It should close the confirmation box and should display reply mail window");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box and displaying reply mail window");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase14() throws InterruptedException {
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg'][@class='lucide lucide-x h-4 w-4']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on dismiss reply button and click on close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on dismiss reply button");
		test.pass(b);
		test.info("Click on close button");
		test.info("Expected Results: It should close the confirmation box and should display reply mail window");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box and displaying reply mail window");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase15() throws InterruptedException {
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='15'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[text()='Save as Draft'])[1]")).click();
		Thread.sleep(3000);
		String c = driver.findElement(By.xpath("//h2[text()='Mail saved as draft']")).getText();
		Assert.assertEquals("Mail saved as draft", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on three dots and click on save as draft");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("CLick on three dots");
		test.info("Click on save as draft option");
		test.info("Expected Results: It should save the mail as draft");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is saving the mail as draft");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase16() throws InterruptedException, AWTException {
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//img[@alt='Attach file'])[1]")).click();
		Thread.sleep(500);
		Robot rb = new Robot();
		Thread.sleep(1000);
		StringSelection str = new StringSelection("/home/tvisha/Pictures/Screenshot from 2025-09-02 16-57-02.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		// release Control+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("//p[text()='Screenshot from 2025-09-03 12-27-22.png']")).getText();
		Assert.assertEquals("Screenshot from 2025-09-03 12-27-22.png", c);

		ExtentTest test = reports.createTest("Add attachment");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on add attachments icon");
		test.info("Select any attachment");
		test.info("Expected Results: It should select the attachment");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is selecting the attachment");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase17() throws InterruptedException, AWTException {
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//img[@alt='Attach file'])[1]")).click();
		Thread.sleep(500);
		Robot rb = new Robot();
		Thread.sleep(1000);
		StringSelection str = new StringSelection("/home/tvisha/Pictures/Screenshot from");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_CONTROL);

		// Move to second file using DOWN (or RIGHT, depending on your file chooser)
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);

		// Select with SPACE
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);

		// Move to next file
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);

		// Select again
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);

		rb.keyRelease(KeyEvent.VK_CONTROL);

		// Confirm with ENTER
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("//p[text()='Screenshot from 2025-09-03 12-27-22.png']")).getText();
		Assert.assertEquals("Screenshot from 2025-09-03 12-27-22.png", c);

		ExtentTest test = reports.createTest("Add multiple attachments");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on add attachments icon");
		test.info("Select multiple attachments");
		test.info("Expected Results: It should select multiple attachments");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is selecting multiple attachments");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase18() throws InterruptedException, AWTException {

		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		String c = driver.findElement(By.xpath("//p[text()='Screenshot from 2025-09-03 12-27-22.png']")).getText();
		Assert.assertEquals("Screenshot from 2025-09-03 12-27-22.png", c);
		Thread.sleep(500);
		WebElement b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")));
		Thread.sleep(1000);
		String d = b.getText();
		Assert.assertEquals("1 - 76 of 76", d);
		Thread.sleep(500);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//p[text()='Reply Mail'])[1]")));
		Thread.sleep(2000);

		ExtentTest test = reports.createTest("Add attachments and click on send button");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on add attachments icon");
		test.info("Select any attachments");
		test.pass(c);
		test.info("Click on send button");
		test.info("Expected Results: It should send the mail");
		test.pass(d);
		test.log(Status.PASS, "Actual Results: It is sending the mail");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	
	
	@Test
	public void testcase19() throws InterruptedException {
		Thread.sleep(500);
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(200);
		String d = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", d);
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 10).click().build().perform();  
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on reply and click on outside of the reply screen");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(d);
		test.info("Click on outside of the reply screen");
		test.info("Expected Results: It should display confirmation box");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying confirmation box");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}
	
	
	
	@Test
	public void testcase20() throws InterruptedException {
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Save as Draft']")).click();
		Thread.sleep(500);
		String c = driver.findElement(By.xpath("//h2[text()='Mail saved as draft']")).getText();
		Assert.assertEquals("Mail saved as draft", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on outside of the reply screen and click on save as draft option");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on outside of the reply screen");
		test.pass(b);
		test.info("Click on save as draft option");
		test.info("Expected Results: It should save the mail as draft");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is saving the mail as draft");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase21() throws InterruptedException {
		Thread.sleep(500);
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 10).click().build().perform();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("//h2[text()='Mail discarded']")).getText();
		Assert.assertEquals("Mail discarded", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on outside of the reply screen and click on discard option");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on outside of the reply screen");
		test.pass(b);
		test.info("Click on discard option");
		test.info("Expected Results: It should display mail discarded toast msg");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is displaying mail discarded toast msg ");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase22() throws InterruptedException {
		Thread.sleep(500);
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//span[text()='RE: Main msg']"));
		act.moveToElement(e).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Reply'])[1]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 10).click().build().perform();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on outside of the reply screen and click on cancel option");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on outside of the reply screen");
		test.pass(b);
		test.info("Click on cancel option");
		test.info("Expected Results: It should close the confirmation box and should display reply mail window");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box and displaying reply mail window");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase23() throws InterruptedException {
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 10).click().build().perform();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg'][@class='lucide lucide-x h-4 w-4']")).click();
		Thread.sleep(1000);
		String c = driver.findElement(By.xpath("(//p[text()='Reply Mail'])[1]")).getText();
		Assert.assertEquals("Reply Mail", c);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on outside of the reply screen and click on close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on reply button");
		test.pass(a);
		test.info("Enter To mail");
		test.info("Enter text in the input field");
		test.info("Click on outside of the reply screen");
		test.pass(b);
		test.info("Click on close button");
		test.info("Expected Results: It should close the confirmation box and should display reply mail window");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box and displaying reply mail window");
		test.pass("Test Case: Test case passed");
		Thread.sleep(1000);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterSuite
	public void afterSuite() {
		reports.flush();
		driver.quit();

	}

}
