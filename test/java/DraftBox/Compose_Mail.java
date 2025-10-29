package DraftBox;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Compose_Mail {
	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Compose mail.html");

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
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7287893496@A.K");
		Thread.sleep(500);
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
		Thread.sleep(500);
		driver.findElement(By.xpath("(//span[text()='Drafts'])[1]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//span[text()='Drafts'])[2]")).getText();
		Assert.assertEquals("Drafts", a);

		ExtentTest test = reports.createTest("Click on draft folder");
		test.info("User login successfully with valid credentials");
		test.info("Click on draft folder option");
		test.info("Expected Results: It should navigate to draft folder page");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is navigating to draft folder page");
		test.pass("Test Case: Test case passed");
	}
	
	@Test
	public void testcase02() throws InterruptedException{
		Thread.sleep(300);
		String a=driver.findElement(By.xpath("(//span[text()='Drafts'])[2]")).getText();
		Assert.assertEquals("Drafts", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='flex flex-1 items-center  '])[1]")).click();
		Thread.sleep(500);
		String b=driver.findElement(By.xpath("(//h2[text()='Compose Mail'])")).getText();
		Assert.assertEquals("Compose Mail", b);
		
		ExtentTest test=reports.createTest("Click on any mail");
		test.info("User login successfully with valid credentials");
		test.info("Click on draft folder option");
		test.pass(a);
		test.info("Click on any mail");
		test.info("Expected Results: It should display compose mail screen");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying compose mail screen");
		test.pass("Test Case: Test case passed");
	}
	
	@Test
	public void testcase03() throws InterruptedException{
		Thread.sleep(500);
		String a=driver.findElement(By.xpath("(//h2[text()='Compose Mail'])")).getText();
		Assert.assertEquals("Compose Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[4]")).click();
		Thread.sleep(500);
		String b=driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		
		ExtentTest test=reports.createTest("Click on compose mail close button");
		test.info("User login successfully with valid credentials");
		test.info("Click on draft folder option");
		test.info("Click on any mail");
		test.pass(a);
		test.info("Click on compose mail close button");
		test.info("Expected Results: It should display confirmation box");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying the confirmation box");
		test.pass("Test Case: Test case passed");
	}
	
	@Test
	public void testcase04() throws InterruptedException{
		Thread.sleep(500);
		String a=driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[5]")).click();
		Thread.sleep(500);
		String b=driver.findElement(By.xpath("(//h2[text()='Compose Mail'])")).getText();
		Assert.assertEquals("Compose Mail", b);
		
		ExtentTest test =reports.createTest("Close the confirmation box");
		test.info("User login successfully with valid credentials");
		test.info("Click on draft folder option");
		test.info("Click on any mail");
		test.info("Click on compose mail screen close button");
		test.pass(a);
		test.info("Click on confirmation close button");
		test.info("Expected Results: It should close the confirmation box");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Test Case: Test case passed");
	}
	
	@Test 
	public void testcase05() throws InterruptedException{
		Thread.sleep(500);
		String a=driver.findElement(By.xpath("(//h2[text()='Compose Mail'])")).getText();
		Assert.assertEquals("Compose Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[4]")).click();
		Thread.sleep(500);
		String b=driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Save as Draft']")).click();
		Thread.sleep(500);
		
		ExtentTest test=reports.createTest("Click on save as draft option");
		test.info("User login successfully with valid credentials");
		test.info("Click on draft folder option");
		test.info("Click on any mail");
		test.pass(a);
		test.info("Click on compose mail screen close button");
		test.pass(b);
		test.info("Click on save as draft in confirmation box");
		test.info("Expected Results: It should save the mail as draft");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is saving the mail as draft");
		test.pass("Test Case: Test case passed");
	}
	
	@Test
	public void testcase06() throws InterruptedException{
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='flex flex-1 items-center  '])[1]")).click();
		Thread.sleep(500);
		String a=driver.findElement(By.xpath("(//h2[text()='Compose Mail'])")).getText();
		Assert.assertEquals("Compose Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[4]")).click();
		Thread.sleep(500);
		String b=driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(500);
		String c=driver.findElement(By.xpath("//h2[text()='Mail discarded']")).getText();
		Assert.assertEquals("Mail discarded", c);
		
		ExtentTest test =reports.createTest("Click on discard mail option");
		test.info("User login successfully with valid credentials");
		test.info("Click on draft folder option");
		test.info("Click on any mail");
		test.pass(a);
		test.info("Click on compose mail close button");
		test.pass(b);
		test.info("Click on discard mail option");
		test.info("Expected Results: It shoul discard the mail");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is discarding the mail");
		test.pass("Test Case: Test case passed");
	}
	
	@Test
	public void testcase07() throws InterruptedException{
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='flex flex-1 items-center  '])[1]")).click();
		Thread.sleep(500);
		String a=driver.findElement(By.xpath("(//h2[text()='Compose Mail'])")).getText();
		Assert.assertEquals("Compose Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[4]")).click();
		Thread.sleep(500);
		String b=driver.findElement(By.xpath("//div[text()='Are you sure to discard this mail?']")).getText();
		Assert.assertEquals("Are you sure to discard this mail?", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(500);
		String c=driver.findElement(By.xpath("(//h2[text()='Compose Mail'])")).getText();
		Assert.assertEquals("Compose Mail", c);
		
		ExtentTest test=reports.createTest("Click on cancel option");
		test.info("User login successfully with valid credentials");
		test.info("Click on draft folder option");
		test.info("Click on any mail");
		test.pass(a);
		test.info("Click on compose mail close button");
		test.pass(b);
		test.info("Click on cancel button");
		test.info("Expected Results: It should close the confirmation box");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Test Case: Test case passed");
	}
	
	
	
	@Test
	public void testcase08() throws InterruptedException{
		Thread.sleep(500);
		String a=driver.findElement(By.xpath("(//h2[text()='Compose Mail'])")).getText();
		Assert.assertEquals("Compose Mail", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@aria-label='Remove test.te@te.in']")).click();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

	@AfterSuite
	public void afterSuite() {
	}

}
