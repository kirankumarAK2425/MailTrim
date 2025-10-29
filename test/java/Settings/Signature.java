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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Signature {
	WebDriver driver;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Signature.html");

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
				"xdotool search --name 'Mail Trim' windowactivate --sync key --clearmodifiers Super+Up"

		});
		Thread.sleep(1000);
		Runtime.getRuntime().exec(
				new String[] { "bash", "-c", "xdotool search --name 'Mail Trim' windowactivate --sync key ctrl+shift+i"

				});
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("meghana.voggu@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("MeghanaV@12");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}

	@Test
	public void testcase01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//li[@value='signature']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Email Signature:']")).getText();
		Assert.assertEquals(a, "Email Signature:");
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[@data-state='checked'])[1]")).click();
		Thread.sleep(400);
		boolean isPresent = driver.findElements(By.xpath("//div[@class='flex items-center gap-4']")).size() > 0;
		Assert.assertFalse(isPresent, "Signature section should not be present after disabling");

		ExtentTest test = extent.createTest("Disable signature option");
		test.info("User login successfully with valid credentials");
		test.info("User click on settings option");
		test.info("Click on signature settings");
		test.pass(a);
		test.info("Click on disable button of signature option");
		test.info("ExpectedResults:It should disable the signature option");

		if (!isPresent) {
			test.pass("✅ Signature section is hidden as expected after disabling");
		} else {
			test.fail("❌ Signature section is still visible after disabling");
		}
		test.log(Status.PASS, "ActualResults:It is disabling signature option");
		test.pass("Test Case:Test case passed");
	}

	@Test
	public void testcase02() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//li[@value='signature']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Email Signature:']")).getText();
		Assert.assertEquals(a, "Email Signature:");
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[@data-state='unchecked'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@role='textbox']")).clear();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test test test test test test test test");
		Thread.sleep(400);
		driver.findElement(By.xpath("//button[text()='Save Signature']")).click();
		Thread.sleep(100);
		String b = driver.findElement(By.xpath("//h2[@class='font-semibold text-md']")).getText();
		Assert.assertEquals("Signature saved!", b);

		ExtentTest test = extent.createTest("Enter signature and click on save signature");
		test.info("User login successfully with valid credentials");
		test.info("User click on settings option");
		test.info("Click on signature settings");
		test.pass(a);
		test.info("Enter signature in the input field");
		test.info("Click on save signature button");
		test.info("ExpectedResults:It should save the signature");
		test.pass(b);
		test.log(Status.PASS, "ActualResults:It is saving the signature");
		test.pass("Test Case:Test case passed");
	}

	@Test
	public void testcase03() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//li[@value='signature']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Email Signature:']")).getText();
		Assert.assertEquals(a, "Email Signature:");
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@role='textbox']")).clear();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test test test test test test test test");
		Thread.sleep(400);
		driver.findElement(By.xpath("(//button[@role='checkbox'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Signature']")).click();
		Thread.sleep(100);
		String b = driver.findElement(By.xpath("//h2[@class='font-semibold text-md']")).getText();
		Assert.assertEquals("Signature saved!", b);

		ExtentTest test = extent.createTest(
				"Enter signature and select automatically include my signature on new messages that I compose and click on save signature");
		test.info("User login successfully with valid credentials");
		test.info("User click on settings option");
		test.info("Click on signature settings");
		test.pass(a);
		test.info("Enter signature in the input field");
		test.info("Click on automatically include my signature on new messages that I compose checkbox");
		test.info("Click on save signature button");
		test.info("ExpectedResults:It should save the signature");
		test.pass(b);
		test.log(Status.PASS, "ActualResults:It is saving the signature");
		test.pass("Test Case:Test case passed");
	}

	
	
	@Test
	public void testcase04() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//li[@value='signature']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Email Signature:']")).getText();
		Assert.assertEquals(a, "Email Signature:");
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@role='textbox']")).clear();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test test test test test test test test");
		Thread.sleep(400);
		driver.findElement(By.xpath("(//button[@role='checkbox'])[2]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Signature']")).click();
		Thread.sleep(100);
		String b = driver.findElement(By.xpath("//h2[@class='font-semibold text-md']")).getText();
		Assert.assertEquals("Signature saved!", b);

		ExtentTest test = extent.createTest(
				"Enter signature and select automatically include my signature on messages I forward or reply to and click on save signature");
		test.info("User login successfully with valid credentials");
		test.info("User click on settings option");
		test.info("Click on signature settings");
		test.pass(a);
		test.info("Enter signature in the input field");
		test.info("Click on automatically include my signature on messages I forward or reply to checkbox");
		test.info("Click on save signature button");
		test.info("ExpectedResults:It should save the signature");
		test.pass(b);
		test.log(Status.PASS, "ActualResults:It is saving the signature");
		test.pass("Test Case:Test case passed");
	}
	
	
	
	@Test
	public void testcase05() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//li[@value='signature']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Email Signature:']")).getText();
		Assert.assertEquals(a, "Email Signature:");
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@role='textbox']")).clear();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test test test test test test test test");
		Thread.sleep(400);
		driver.findElement(By.xpath("(//button[@role='checkbox'])[1]")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath("(//button[@role='checkbox'])[2]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Save Signature']")).click();
		Thread.sleep(100);
		String b = driver.findElement(By.xpath("//h2[@class='font-semibold text-md']")).getText();
		Assert.assertEquals("Signature saved!", b);

		ExtentTest test = extent.createTest(
				"Enter signature and select both the check boxes and click on save signature");
		test.info("User login successfully with valid credentials");
		test.info("User click on settings option");
		test.info("Click on signature settings");
		test.pass(a);
		test.info("Enter signature in the input field");
		test.info("Select both the checkboxs");
		test.info("Click on save signature button");
		test.info("ExpectedResults:It should save the signature");
		test.pass(b);
		test.log(Status.PASS, "ActualResults:It is saving the signature");
		test.pass("Test Case:Test case passed");
	}
	
	
	
	@Test
	public void testcase06() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//li[@value='signature']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Email Signature:']")).getText();
		Assert.assertEquals(a, "Email Signature:");
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[@data-state='unchecked'])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Discard Signature']")).click();
		Thread.sleep(1000);
		String b = driver.findElement(By.xpath("//h2[@class='font-semibold text-md']")).getText();
		Assert.assertEquals("Signature Discarded!", b);

		ExtentTest test = extent.createTest("Discard the signature");
		test.info("User login successfully with valid credentials");
		test.info("User click on settings option");
		test.info("Click on signature settings");
		test.pass(a);
		test.info("Click on discard signature button");
		test.info("ExpectedResults:It should discard the signature");
		test.pass(b);
		test.log(Status.PASS, "ActualResults:It is discarding the signature");
		test.pass("Test Case:Test case passed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterSuite
	public void afterSuite() {
		extent.flush();
		driver.quit();
	}

}
