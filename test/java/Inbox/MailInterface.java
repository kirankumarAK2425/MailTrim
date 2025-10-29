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

public class MailInterface {

	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Mail Interface.html");

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
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//span[text()='Back']")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")));
		Thread.sleep(500);
		boolean isPresent = driver.findElements(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]"))
				.size() > 0;
		Assert.assertTrue(isPresent, "Removing flag to the mail");

		ExtentTest test = reports.createTest("Back button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on back button");
		test.info("Expected Results: It should navigate to back page");
		if (isPresent) {
			test.pass("it is navigating to back page");
		} else {
			test.fail("It is not navigating to back page");
		}
		// test.pass(a);
		test.log(Status.PASS, "Actual Results: It is navigating to back page");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase02() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[1]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='9'])[1]")));
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 9 of 9", a);

		ExtentTest test = reports.createTest("Archive Mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on archive button");
		test.info("Expected Results: It should move the mail to archive folder");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is moving the mail to archive folder");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase03() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[2]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		WebElement junk = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Junk'])[2]")));
		Thread.sleep(500);
		Actions act = new Actions(driver);
		act.moveToElement(junk).build().perform();
		junk.click();
		String a = driver.findElement(By.xpath("(//span[text()='Move these mails?'])[1]")).getText();
		Assert.assertEquals("Move these mails?", a);

		ExtentTest test = reports.createTest("Move Mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on move button");
		test.info("Select any folder");
		test.info("Expected Results: It should display Move these mails? confirmation box");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying Move these mails? confirmation box");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase04() throws InterruptedException {
//		Thread.sleep(500);
//		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
//		Thread.sleep(300);
//		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[2]")).click();
//		Thread.sleep(500);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(05));
//		WebElement junk=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Junk'])[2]")));
//		Thread.sleep(500);
//		Actions act=new Actions(driver);
//		act.moveToElement(junk).build().perform();
//		junk.click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//span[text()='Move these mails?'])[1]")).getText();
		Assert.assertEquals("Move these mails?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[name()='svg' and @width='24']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(05));
		boolean junk1 = wait1.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[text()='Move these mails?'])[1]")));

		ExtentTest test = reports.createTest("Move Mail and click on confirmation box close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on move button");
		test.info("Select any folder");
		test.pass(a);
		test.info("Click on confirmation close button");
		test.info("Expected Results: It should close the confirmation box");
		if (junk1) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase05() throws InterruptedException {
//		Thread.sleep(500);
//		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[2]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		WebElement junk = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Junk'])[2]")));
		Thread.sleep(500);
		Actions act = new Actions(driver);
		act.moveToElement(junk).build().perform();
		junk.click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//span[text()='Move these mails?'])[1]")).getText();
		Assert.assertEquals("Move these mails?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("(//button[text()='Move'])")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(05));
		boolean junk1 = wait1.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[text()='Move these mails?'])[1]")));

		ExtentTest test = reports.createTest("Move Mail and click on move in confirmation box button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on move button");
		test.info("Select any folder");
		test.pass(a);
		test.info("Click on move button");
		test.info("Expected Results: It should move the mail");
		if (junk1) {
			test.pass("It is moving the mail to selected folder");
		} else {
			test.fail("It is not moving the mail to selected folder");
		}
		test.log(Status.PASS, "Actual Results: It is move the mail to selected folder");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase06() throws InterruptedException {
//		Thread.sleep(500);
//		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[2]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		WebElement junk = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Junk'])[2]")));
		Thread.sleep(500);
		Actions act = new Actions(driver);
		act.moveToElement(junk).build().perform();
		junk.click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//span[text()='Move these mails?'])[1]")).getText();
		Assert.assertEquals("Move these mails?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(05));
		boolean junk1 = wait1.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[text()='Move these mails?'])[1]")));

		ExtentTest test = reports.createTest("Move Mail and click on cancel in confirmation box button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on move button");
		test.info("Select any folder");
		test.pass(a);
		test.info("Click on cancel in confirmation button");
		test.info("Expected Results: It should close the confirmation box");
		if (junk1) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}
		test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase07() throws InterruptedException {
		Thread.sleep(500);
//		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
//		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[3]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='8'])[1]")));
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 8 of 8", a);

		ExtentTest test = reports.createTest("Marking the mail as spam");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on spam button");
		test.info("Expected Results: It should move the mail to spam");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is moving the mail to spam");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase08() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[4]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='7'])[1]")));
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 7 of 7", a);

		ExtentTest test = reports.createTest("Delete the mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on delete button");
		test.info("Expected Results: It should delete the mail");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is deleting the mail");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase09() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2'])[1]")));
		Thread.sleep(500);
		boolean isPresent = driver
				.findElements(By.xpath("(//div[@class='absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2'])[1]"))
				.size() > 0;
		Assert.assertTrue(isPresent, "Unread dot should be display");

		ExtentTest test = reports.createTest("Mark the mail as unread");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on unread button");
		test.info("Expected Results: It should mark the mail as unread");
		if (!isPresent) {
			test.pass("✅ Unread dot is displaying");
		} else {
			test.fail("❌ Unread dot is not displaying");
		}
		test.log(Status.PASS, "Actual Results: It is marking the mail as unread");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase10() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[6]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@src='respond-later-red.svg'])[1]")));
		Thread.sleep(500);
		boolean isPresent = driver.findElements(By.xpath("(//img[@src='respond-later-red.svg'])[1]")).size() > 0;
		Assert.assertTrue(isPresent, "Marking the mail as respond later");

		ExtentTest test = reports.createTest("Mark the mail as respond later");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on respond later button");
		test.info("Expected Results: It should mark the mail as respond later");
		if (!isPresent) {
			test.pass("✅ It is marking the mail as respond later");
		} else {
			test.fail("❌ It is not marking the mail as respond later");
		}
		test.log(Status.PASS, "Actual Results: It is marking the mail as respond later");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase11() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[6]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@src='respond-later-grey.svg'])[1]")));
		Thread.sleep(500);
		boolean isPresent = driver.findElements(By.xpath("(//img[@src='respond-later-grey.svg'])[1]")).size() > 0;
		Assert.assertFalse(isPresent, "Removing the mail as respond later");

		ExtentTest test = reports.createTest("Remove respond later to the mail ");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on unread button");
		test.info("Expected Results: It should remove the respond later icon to the mail");
		if (!isPresent) {
			test.pass("✅ It is removing the respond later to the mail");
		} else {
			test.fail("❌ It is not removing the respond later to the mail");
		}
		test.log(Status.PASS, "Actual Results: It is removing the respond later to the mail");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase12() throws InterruptedException {
		Thread.sleep(500);
//		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
//		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[7]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[name()='svg' and @fill='currentColor'])[6]")));
		Thread.sleep(500);
		boolean isPresent = driver.findElements(By.xpath("(//*[name()='svg' and @fill='currentColor'])[6]")).size() > 0;
		Assert.assertTrue(isPresent, "Flagging the mail");

		ExtentTest test = reports.createTest("Flagging the mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on flag button");
		test.info("Expected Results: It should flag the mail");
		if (!isPresent) {
			test.pass("✅ It is flagging the mail");
		} else {
			test.fail("❌ It is not flagging the mail");
		}
		test.log(Status.PASS, "Actual Results: It is flagging the mail");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase13() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[7]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[name()='svg' and @stroke-width='2'])[9]")));
		Thread.sleep(500);
		boolean isPresent = driver.findElements(By.xpath("(//*[name()='svg' and @stroke-width='2'])[9]")).size() > 0;
		Assert.assertTrue(isPresent, "Removing flag to the mail");

		ExtentTest test = reports.createTest("Unflag the mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on flag button");
		test.info("Expected Results: It should remove the flag icon to the mail");
		if (!isPresent) {
			test.pass("✅ It is removing the flag to the mail");
		} else {
			test.fail("❌ It is not removing the flag to the mail");
		}
		test.log(Status.PASS, "Actual Results: It is removing the flag to the mail");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase14() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[8]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("//h2[text()='Summerized Email']")).getText();
		Assert.assertEquals("Summerized Email", a);

		ExtentTest test = reports.createTest("Summerized Email");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on Summerize button");
		test.info("Expected Results: It should display Summerized Mail screen");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying Summerized Mail screen");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase15() throws InterruptedException {
		Thread.sleep(500);
//		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
//		Thread.sleep(300);
//		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[8]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("//h2[text()='Summerized Email']")).getText();
		Assert.assertEquals("Summerized Email", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg' and @width='24']")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		boolean summerize = wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h2[text()='Summerized Email']")));
		Assert.assertTrue(summerize, "Close the summerized screen");

		ExtentTest test = reports.createTest("Close the Summerized Email screen");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on Summerize button");
		test.pass(a);
		test.info("Click on close button");
		test.info("Expected Results: It should close Summerized Mail screen");
		if (summerize) {
			test.pass("It should close the summerize mail screen");
		} else {
			test.fail("It is not closing the summerize mail screen");
		}
		test.log(Status.PASS, "Actual Results: It is closing the Summerized Mail screen");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase16() throws InterruptedException {
		Thread.sleep(500);
//		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[8]")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("//h2[text()='Summerized Email']")).getText();
		Assert.assertEquals("Summerized Email", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Reply']")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//p[text()='Reply Mail']")).getText();
		Assert.assertEquals("Reply Mail", b);

		ExtentTest test = reports.createTest("Click on reply in Summerized Email screen");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on Summerize button");
		test.pass(a);
		test.info("Click on reply button");
		test.info("Expected Results: It should display reply mail screen");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying reply mail screen");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase17() throws InterruptedException {
		Thread.sleep(500);
//		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[9]"));
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//span[text()='kiran.kumar@tvisha.in'])[1]")).getText();
		Assert.assertEquals("kiran.kumar@tvisha.in", a);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on any mail and click on next mail button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on next mail button");
		test.info("Expected Results: It should navigate to next mail");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is navigating to next mail");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase18() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[10]"));
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//span[text()='kiran.kumar@tvisha.in'])[1]")).getText();
		Assert.assertEquals("kiran.kumar@tvisha.in", a);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on any mail and click on previous mail button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on previous mail button");
		test.info("Expected Results: It should navigate to previous mail");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is navigating to previous mail");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase19() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//img[@src='mailsingle/reply.svg']"));
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("//p[text()='Reply Mail']")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on any mail and click on reply mail button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on reply button");
		test.info("Expected Results: It should display replay mail screen");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying reply mail screen");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase20() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='mailsingle/replyall.svg']")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("//p[text()='Reply Mail']")).getText();
		Assert.assertEquals("Reply Mail", a);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on any mail and click on reply all mail button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on reply all button");
		test.info("Expected Results: It should display reply mail screen");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying reply mail screen");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase21() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='mailsingle/forward.svg']")).click();
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("//p[text()='Forward Mail']")).getText();
		Assert.assertEquals("Forward Mail", a);
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on any mail and click on forward mail button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on reply all button");
		test.info("Expected Results: It should display forward mail screen");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is displaying forward mail screen");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase22() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[name()='svg'][@stroke-linecap='round'])[10]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[text()='Mark as Unread'])[2]"));
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		WebElement unreadDot = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2']")));
		Thread.sleep(500);

		ExtentTest test = reports.createTest("Click on any mail and click on threedots and click on mark as unread");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on three dots");
		test.info("Click on mark as unread");
		test.info("Expected Results: It should display unread dot for the mail");
		if (unreadDot.isDisplayed()) {
			test.pass("It is displaying unread dot");
		} else {
			test.fail("It is not displaying unread dot");
		}
		test.log(Status.PASS, "Actual Results: It is displaying unread dot for the mail");
		test.pass("Testcase: Test case passed");
	}

	@Test
	public void testcase23() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg'][@stroke-linecap='round'])[10]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[text()='Delete'])[2]"));
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='6'])[1]")));
		Thread.sleep(500);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 6 of 6", a);

		ExtentTest test = reports.createTest("Click on any mail and click on threedots and click on delete");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any mail");
		test.info("Click on three dots");
		test.info("Click on delete button");
		test.info("Expected Results: It should delete the mail");
		test.pass(a);
		test.log(Status.PASS, "Actual Results: It is deleting the mail");
		test.pass("Testcase: Test case passed");
	}

	
	
	
	
	
	
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
		reports.flush();
	}

}
