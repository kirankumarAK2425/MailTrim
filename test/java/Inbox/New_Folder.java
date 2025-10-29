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

public class New_Folder {
	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreports = new ExtentSparkReporter("NewFolders.html");

	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {
		reports.attachReporter(sparkreports);
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
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @fill='currentColor'])[3]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//span[text()='Enter new folder name']")).getText();
		Assert.assertEquals("Enter new folder name", a);

		ExtentTest test = reports.createTest("Click on create new folder button");
		test.info("User successfully login with valid cedentials");
		test.info("Click on create new folder add button");
		test.info("Expected Results: It should display create new folder input field");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying create new folder input field");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase02() throws InterruptedException {
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("//span[text()='Enter new folder name']")).getText();
		Assert.assertEquals("Enter new folder name", a);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		Thread.sleep(2000);
		String b = driver.findElement(By.xpath("//div[text()='Please enter folder name']")).getText();
		Assert.assertEquals("Please enter folder name", b);

		ExtentTest test = reports.createTest("Click on create without enter text");
		test.info("User login successfully with valid credentials");
		test.info("Click on create new folder add button");
		test.pass(a);
		test.info("Click on create button");
		test.info("Expected Results: It should display Please enter folder name text");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying Please enter folder name text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase03() throws InterruptedException {
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//span[text()='Enter new folder name']")).getText();
		Assert.assertEquals("Enter new folder name", a);
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@placeholder='Enter folder name']")).sendKeys("Test Folder0");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		Thread.sleep(2000);
		String b = driver.findElement(By.xpath("//div[text()='Folder Created successfully']")).getText();
		Assert.assertEquals("Folder Created successfully", b);

		ExtentTest test = reports.createTest("Create new folder");
		test.info("User login successfully with valid credentials");
		test.info("Click on create new folder add button");
		test.pass(a);
		test.info("Enter text in the input folder");
		test.info("Click on create button");
		test.info("Expected Results: It should create new folder");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is creating the new folder");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase04() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//span[text()='Test Folder0'])[1]"));
		act.moveToElement(a).build().perform();
		driver.findElement(By.xpath("(//*[name()='svg' and @type='button'])[5]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//p[text()='Rename'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@placeholder='Enter folder name'])[1]")).sendKeys("1");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Change']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//div[text()='Folder renamed successfully']")).getText();
		Assert.assertEquals("Folder renamed successfully", b);

		ExtentTest test = reports.createTest("Rename the folder name");
		test.info("User login successfully with valid credentials");
		test.info("Click on three dots of any folder");
		test.info("Click on rename option");
		test.info("Rename the folder");
		test.info("Click on change");
		test.info("Expected Results: It should display Folder renamed successfully text");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying Folder renamed successfully text");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase05() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//span[text()='Test Folder01'])[1]"));
		act.moveToElement(a).build().perform();
		driver.findElement(By.xpath("(//*[name()='svg' and @type='button'])[5]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//p[text()='Delete']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//span[text()='Are you sure to delete folder Test Folder01?']"))
				.getText();
		Assert.assertEquals("Are you sure to delete folder Test Folder01?", b);

		ExtentTest test = reports.createTest("Click on delete folder");
		test.info("User login sucessfully with valid credentials");
		test.info("Click on three dots of any folder");
		test.info("Click on delete option");
		test.info("Expected Results: It should display Are you sure to delete folder popup");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying the Are you sure to delete folder popup");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase06() throws InterruptedException {
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//span[text()='Are you sure to delete folder Test Folder01?']"))
				.getText();
		Assert.assertEquals("Are you sure to delete folder Test Folder01?", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//div[text()='Folder deleted successfully']")).getText();
		Assert.assertEquals("Folder deleted successfully", b);

		ExtentTest test = reports.createTest("Click on delete folder and click on delete in popup");
		test.info("User login sucessfully with valid credentials");
		test.info("Click on three dots of any folder");
		test.info("Click on delete option");
		test.pass(a);
		test.info("Click on delete in popup");
		test.info("Expected Results: It should delete the folder and should display Folder deleted successfully text");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is deleting the folder and displaying Folder deleted successfully");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase07() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//span[text()='test'])[1]"));
		act.moveToElement(a).build().perform();
		driver.findElement(By.xpath("(//*[name()='svg' and @type='button'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//p[text()='Delete']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//span[text()='Are you sure to delete folder test?']")).getText();
		Assert.assertEquals("Are you sure to delete folder test?", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(300);
		WebElement c = driver.findElement(By.xpath("//span[text()='Are you sure to delete folder test?']"));

		ExtentTest test = reports.createTest("Click on delete and click on cancel in confirmation box");
		test.info("User login successfully with valid credentials");
		test.info("Click on three dots of any folder");
		test.info("Click on delete option");
		test.info("Click on cancel in confirmation box");
		test.info("Expected Results: It should close the confirmation box");
		if (c.isDisplayed()) {
			test.fail("❌ It is not closing the confirmation box");
		} else {
			test.pass("✅ It is closing the confirmation box");
		}
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase08() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//span[text()='test'])[1]"));
		act.moveToElement(a).build().perform();
		driver.findElement(By.xpath("(//*[name()='svg' and @type='button'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//p[text()='Delete']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//span[text()='Are you sure to delete folder test?']")).getText();
		Assert.assertEquals("Are you sure to delete folder test?", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @height='24'])[2]")).click();
		Thread.sleep(300);
		WebElement c = driver.findElement(By.xpath("//span[text()='Are you sure to delete folder test?']"));

		ExtentTest test = reports.createTest("CLick on delete and click on confirmation close button ");
		test.info("User login successfully with valid credentials");
		test.info("Click on three dots of any folder");
		test.info("Click on delete option");
		test.info("Click on confirmation box close button");
		test.info("Expected Results: It should close the confirmation box");
		if (c.isDisplayed()) {
			test.fail("It is not closing the confirmation box");
		} else {
			test.pass("It is closing the confirmation box");
		}
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase09() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//*[text()='test'])[1]"));
		act.moveToElement(a).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @type='button'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//p[text()='Empty Folder']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//span[text()='Delete all Mails from this folder?']")).getText();
		Assert.assertEquals("Delete all Mails from this folder?", b);

		ExtentTest test = reports.createTest("Click on empty folder");
		test.info("User login successfully with valid credentials");
		test.info("Click on three dots of any folder");
		test.info("CLick on empty folder option");
		test.info("Expected Results: It should display Delete all Mails from this folder? confirmation box");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying Delete all Mails from this folder? confirmation box");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase10() throws InterruptedException {
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//span[text()='Delete all Mails from this folder?']")).getText();
		Assert.assertEquals("Delete all Mails from this folder?", a);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("//div[text()='Something went wrong']")).getText();
		Assert.assertEquals("Something went wrong", b);

		ExtentTest test = reports.createTest("Click on empty folder and click on delete option");
		test.info("User login successfully with valid credentials");
		test.info("Click on three dots of any folder");
		test.info("CLick on empty folder option");
		test.pass(a);
		test.info("Expected Results: It should delete the mails in that folder");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is deleting the mails in that folder");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase11() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//*[text()='test'])[1]"));
		act.moveToElement(a).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @type='button'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//p[text()='Empty Folder']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//span[text()='Delete all Mails from this folder?']")).getText();
		Assert.assertEquals("Delete all Mails from this folder?", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(300);
		WebElement c = driver.findElement(By.xpath("//span[text()='Delete all Mails from this folder?']"));

		ExtentTest test = reports.createTest("Click on cancel in confirmation box");
		test.info("User login successfully with valid credentials");
		test.info("Click on three dots of any mail");
		test.pass(b);
		test.info("Click on cancel in confirmation box");
		test.info("Expected Results: It should close the confirmation box");
		if (c.isDisplayed()) {
			test.fail("It is not closing the confirmation box");
		} else {
			test.pass("It is closing the confirmation box");
		}
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Test Case: Test case passd");
	}

	@Test
	public void testcase12() throws InterruptedException {
		Thread.sleep(300);
		Actions act = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("(//*[text()='test'])[1]"));
		act.moveToElement(a).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @type='button'])[4]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//p[text()='Empty Folder']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//span[text()='Delete all Mails from this folder?']")).getText();
		Assert.assertEquals("Delete all Mails from this folder?", b);
		Thread.sleep(300);
		driver.findElement(By.xpath("(//*[name()='svg' and @height='24'])[2]")).click();
		Thread.sleep(300);
		WebElement c = driver.findElement(By.xpath("//span[text()='Delete all Mails from this folder?']"));

		ExtentTest test = reports.createTest("Click on cancel in confirmation box");
		test.info("User login successfully with valid credentials");
		test.info("Click on three dots of any mail");
		test.pass(b);
		test.info("Click on confirmation box close button");
		test.info("Expected Results: It should close the confirmation box");
		if (c.isDisplayed()) {
			test.fail("It is not closing the confirmation box");
		} else {
			test.pass("It is closing the confirmation box");
		}
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Test Case: Test case passd");
	}

	@AfterSuite
	public void afterSuite() {
		reports.flush();
		driver.quit();
	}

}
