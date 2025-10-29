package Inbox;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

public class SelectAllTopFeatures {
	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("SelectAllTopFeatures.html");

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

	}

	@Test
	public void testcase01() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px] ']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//div[text()='kiran.kumar@tvisha.in'])[1]")).getText();
		Assert.assertEquals("kiran.kumar@tvisha.in", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px] ']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Syncing Archive 100 / 121']")));
		Thread.sleep(300);
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		if (!checkboxes.isEmpty()) {
			WebElement selectAll = checkboxes.get(0);
			selectAll.click();
		}
		boolean allSelected = checkboxes.stream().allMatch(WebElement::isSelected);
		Thread.sleep(200);

		ExtentTest test = reports.createTest("Select All button functionality");
		test.info("Login the user successfully with valid credentials");
		test.pass(a);
		test.info("Click on select all checkbox");
		test.info("Expected Results: It should select all the checkboxes");
		if (allSelected) {
			test.pass("✅ All checkboxes are selected");
		} else {
			test.fail("❌ Some checkboxes are not selected");
		}

		if (allSelected) {
			test.log(Status.PASS, "Actual Results: It is selecting all the checkboxes");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not selecting all the checkboxes");
		}

		if (allSelected) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}
		Thread.sleep(300);

	}

	@Test
	public void testcase02() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[1]")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Are you sure to mark these mails as Archive?'])[1]"))
				.getText();
		Assert.assertEquals("Are you sure to mark these mails as Archive?", c);

		ExtentTest test = reports.createTest("Select any mail and click on archive");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		if (b.isSelected()) {
			test.pass("✅ checkbox is selected");
		} else {
			test.fail("❌ checkbox is not selected");
		}
		test.info("Click on Archive feature");
		test.info("Expected Results: It should display Are you sure to mark these mails as Archive? confirmation box");
		test.pass(c);
		test.log(Status.PASS,
				"Actual Result: It is displying Are you sure to mark these mails as Archive? confirmation box");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase03() throws InterruptedException {
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='Are you sure to mark these mails as Archive?'])[1]"))
				.getText();
		Assert.assertEquals("Are you sure to mark these mails as Archive?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[name()='svg' and @width='24']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("(//span[text()='Are you sure to mark these mails as Archive?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on archive and click on close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Archive feature");
		test.pass(a);
		test.info("Click on confirmation close button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}
	}

	@Test
	public void testcase04() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[1]")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Are you sure to mark these mails as Archive?'])[1]"))
				.getText();
		Assert.assertEquals("Are you sure to mark these mails as Archive?", c);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("(//span[text()='Are you sure to mark these mails as Archive?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on archive and click on cancel button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Archive feature");
		test.pass(c);
		test.info("Click on cancel button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}

	}

	@Test
	public void testcase05() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[1]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//span[text()='Are you sure to mark these mails as Archive?'])[1]"))
				.getText();
		Assert.assertEquals("Are you sure to mark these mails as Archive?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Mark as Archive']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement count = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")));
		String b = count.getText();
		Assert.assertEquals("1 - 10 of 10", b);

		ExtentTest test = reports.createTest("Select any mail and click on archive and click on Mark as Archive");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Archive feature");
		test.pass(a);
		test.info("Click on Mark as Archive button");
		test.info("Expected Results: It should move the mail to archive");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is moving the mail to archive");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase06() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[2]")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement junkOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Junk'])[2]")));

		Actions act = new Actions(driver);
		act.moveToElement(junkOption).build().perform();
		junkOption.click();

		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Move these mails?'])[1]")).getText();
		Assert.assertEquals("Move these mails?", c);

		ExtentTest test = reports.createTest("Select any mail and click on move");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		if (b.isSelected()) {
			test.pass("✅ checkbox is selected");
		} else {
			test.fail("❌ checkbox is not selected");
		}
		test.info("Click on Move feature");
		test.info("Select any folder");
		test.info("Expected Results: It should display Move these mails? confirmation box");
		test.pass(c);
		test.log(Status.PASS, "Actual Result: It is displying Move these mails? confirmation box");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase07() throws InterruptedException {
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='Move these mails?'])[1]")).getText();
		Assert.assertEquals("Move these mails?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[name()='svg' and @width='24']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[text()='Move these mails?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on move and click on close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Move feature");
		test.info("Select any folder");
		test.pass(a);
		test.info("Click on confirmation close button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}
	}

	@Test
	public void testcase08() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[2]")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement junkOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Junk'])[2]")));

		Actions act = new Actions(driver);
		act.moveToElement(junkOption).build().perform();
		junkOption.click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Move these mails?'])[1]")).getText();
		Assert.assertEquals("Move these mails?", c);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(200);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait1.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[text()='Move these mails?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on move and click on cancel button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Move feature");
		test.info("Select any folder");
		test.pass(c);
		test.info("Click on cancel button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}

	}

	@Test
	public void testcase09() throws InterruptedException {
		Thread.sleep(300);
		WebElement c = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		c.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[2]")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement junkOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Junk'])[2]")));

		Actions act = new Actions(driver);
		act.moveToElement(junkOption).build().perform();
		junkOption.click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//span[text()='Move these mails?'])[1]")).getText();
		Assert.assertEquals("Move these mails?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Move']")).click();
		Thread.sleep(200);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 9 of 9", b);

		ExtentTest test = reports.createTest("Select any mail and click on move and click on Mark as Archive");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Move feature");
		test.info("Select any folder");
		test.pass(a);
		test.info("Click on move button");
		test.info("Expected Results: It should move the mail to selected folder");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is moving the mail to selected folder");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase10() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[3]")).click();
		Thread.sleep(300);
		String c = driver.findElement(By.xpath("(//span[text()='Are you sure to mark these mails as Spam?'])[1]"))
				.getText();
		Assert.assertEquals("Are you sure to mark these mails as Spam?", c);

		ExtentTest test = reports.createTest("Select any mail and click on spam");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		if (b.isSelected()) {
			test.pass("✅ checkbox is selected");
		} else {
			test.fail("❌ checkbox is not selected");
		}
		test.info("Click on spam feature");
		test.info("Expected Results: It should display Are you sure to mark these mails as Spam? confirmation box");
		test.pass(c);
		test.log(Status.PASS,
				"Actual Result: It is displying Are you sure to mark these mails as Spam? confirmation box");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase11() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[3]")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='Are you sure to mark these mails as Spam?'])[1]"))
				.getText();
		Assert.assertEquals("Are you sure to mark these mails as Spam?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[name()='svg' and @width='24']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("(//span[text()='Are you sure to mark these mails as Spam?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on spam and click on close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on spam feature");
		test.pass(a);
		test.info("Click on confirmation close button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}
	}

	@Test
	public void testcase12() throws InterruptedException {
		Thread.sleep(200);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[3]")).click();
		Thread.sleep(200);
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Are you sure to mark these mails as Spam?'])[1]"))
				.getText();
		Assert.assertEquals("Are you sure to mark these mails as Spam?", c);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("(//span[text()='Are you sure to mark these mails as Spam?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on spam and click on cancel button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on spam feature");
		test.pass(c);
		test.info("Click on cancel button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}

	}

	@Test
	public void testcase13() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[3]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//span[text()='Are you sure to mark these mails as Spam?'])[1]"))
				.getText();
		Assert.assertEquals("Are you sure to mark these mails as Spam?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Mark as Spam']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 9 of 9", c);

		ExtentTest test = reports.createTest("Select any mail and click on spam and click on Mark as Spam");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Spam feature");
		test.pass(a);
		test.info("Click on Mark as Spam button");
		test.info("Expected Results: It should move the mail to spam");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is moving the mail to spam");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase14() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[4]")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Are you sure to delete these mails?'])[1]")).getText();
		Assert.assertEquals("Are you sure to delete these mails?", c);

		ExtentTest test = reports.createTest("Select any mail and click on delete");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		if (b.isSelected()) {
			test.pass("✅ checkbox is selected");
		} else {
			test.fail("❌ checkbox is not selected");
		}
		test.info("Click on Delete feature");
		test.info("Expected Results: It should display Are you sure to delete these mails? confirmation box");
		test.pass(c);
		test.log(Status.PASS, "Actual Result: It is displying Are you sure to delete these mails? confirmation box");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase15() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[4]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//span[text()='Are you sure to delete these mails?'])[1]")).getText();
		Assert.assertEquals("Are you sure to delete these mails?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[name()='svg' and @width='24']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("(//span[text()='Are you sure to delete these mails?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on delete and click on close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Delete feature");
		test.pass(a);
		test.info("Click on confirmation close button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}
	}

	@Test
	public void testcase16() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[4]")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Are you sure to delete these mails?'])[1]")).getText();
		Assert.assertEquals("Are you sure to delete these mails?", c);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("(//span[text()='Are you sure to delete these mails?'])[1]")));
		
		ExtentTest test = reports.createTest("Select any mail and click on delete and click on cancel button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Delete feature");
		test.pass(c);
		test.info("Click on cancel button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}

	}

	@Test
	public void testcase17() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[4]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//span[text()='Are you sure to delete these mails?'])[1]")).getText();
		Assert.assertEquals("Are you sure to delete these mails?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 7 of 7", c);

		ExtentTest test = reports.createTest("Select any mail and click on delete and click on delete button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Delete feature");
		test.pass(a);
		test.info("Click on delete button");
		test.info("Expected Results: It should move the mail to spam");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is moving the mail to spam");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase18() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Mark these mails as read?'])[1]")).getText();
		Assert.assertEquals("Mark these mails as read?", c);

		ExtentTest test = reports.createTest("Select any mail and click on mark as read");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		if (b.isSelected()) {
			test.pass("✅ checkbox is selected");
		} else {
			test.fail("❌ checkbox is not selected");
		}
		test.info("Click on Mark as read feature");
		test.info("Expected Results: It should display Mark these mails as read? confirmation box");
		test.pass(c);
		test.log(Status.PASS, "Actual Result: It is displying Mark these mails as read? confirmation box");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase19() throws InterruptedException {
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='Mark these mails as read?'])[1]")).getText();
		Assert.assertEquals("Mark these mails as read?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[name()='svg' and @width='24']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("(//span[text()='Mark these mails as read?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on mark as read and click on close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Mark as read feature");
		test.pass(a);
		test.info("Click on confirmation close button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}
	}

	@Test
	public void testcase20() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Mark these mails as read?'])[1]")).getText();
		Assert.assertEquals("Mark these mails as read?", c);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("(//span[text()='Mark these mails as read?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on mark as read and click on cancel button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Mark as read feature");
		test.pass(c);
		test.info("Click on cancel button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}

	}

	@Test
	public void testcase21() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[5]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//span[text()='Mark these mails as read?'])[1]")).getText();
		Assert.assertEquals("Mark these mails as read?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Mark as Read']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean unreadDot = wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("(//div[@class='absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2'])[1]")));

		ExtentTest test = reports
				.createTest("Select any mail and click on mark as read and click on mark as read button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Mark as read feature");
		test.pass(a);
		test.info("Click on mark as read button");
		test.info("Expected Results: It should mark that mail as read");
		if (unreadDot) {
			test.pass("It is hiding the unread dot");
		} else {
			test.fail("It is not hiding the unread dot");
		}

		if (unreadDot) {
			test.log(Status.PASS, "Actual Results: It is marking the mail as read and hiding the unread dot");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not marking the mail as read and not hiding the unread dot");
		}

		if (unreadDot) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}

	}

	@Test
	public void testcase22() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[6]")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Mark these mails as un read?'])[1]")).getText();
		Assert.assertEquals("Mark these mails as un read?", c);

		ExtentTest test = reports.createTest("Select any mail and click on mark as unread");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		if (b.isSelected()) {
			test.pass("✅ checkbox is selected");
		} else {
			test.fail("❌ checkbox is not selected");
		}
		test.info("Click on Mark as unread feature");
		test.info("Expected Results: It should display Mark these mails as unread? confirmation box");
		test.pass(c);
		test.log(Status.PASS, "Actual Result: It is displying Mark these mails as unread? confirmation box");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase23() throws InterruptedException {
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//span[text()='Mark these mails as un read??'])[1]")).getText();
		Assert.assertEquals("Mark these mails as un read?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[name()='svg' and @width='24']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("(//span[text()='Mark these mails as un read?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on mark as unread and click on close button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Mark as unread feature");
		test.pass(a);
		test.info("Click on confirmation close button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}
	}

	@Test
	public void testcase24() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[6]")).click();
		Thread.sleep(200);
		String c = driver.findElement(By.xpath("(//span[text()='Mark these mails as un read?'])[1]")).getText();
		Assert.assertEquals("Mark these mails as un read?", c);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean popup = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("(//span[text()='Mark these mails as un read?'])[1]")));

		ExtentTest test = reports.createTest("Select any mail and click on mark as unread and click on cancel button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Mark as unread feature");
		test.pass(c);
		test.info("Click on cancel button");
		test.info("Expected Results: It should close the confirmation box");
		if (popup) {
			test.pass("It is closing the confirmation box");
		} else {
			test.fail("It is not closing the confirmation box");
		}

		if (popup) {
			test.log(Status.PASS, "Actual Results: It is closing the confirmation box");
		} else {
			test.log(Status.FAIL, "Actual Results: It is not closing the confirmation box");
		}

		if (popup) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}

	}

	@Test
	public void testcase25() throws InterruptedException {
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		b.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[6]")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("(//span[text()='Mark these mails as un read?'])[1]")).getText();
		Assert.assertEquals("Mark these mails as un read?", a);
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[text()='Mark as Unread']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement unreadDot = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2'])[1]")));

		ExtentTest test = reports
				.createTest("Select any mail and click on mark as read and click on mark as unread button");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on any checkbox");
		test.info("Click on Mark as unread feature");
		test.pass(a);
		test.info("Click on mark as read button");
		test.info("Expected Results: It should mark that mail as read");
		if (unreadDot.isDisplayed()) {
			test.pass("It is displaying the unread dot");
		} else {
			test.fail("It is not displaying the unread dot");
		}

		if (unreadDot.isDisplayed()) {
			test.log(Status.PASS, "Actual Results: It is marking the mail as unread and displaying the read dot");
		} else {
			test.log(Status.FAIL,
					"Actual Results: It is not marking the mail as unread and not displaying the unread dot");
		}

		if (unreadDot.isDisplayed()) {
			test.pass("Test Case: Test case passed");
		} else {
			test.fail("Test Case: Test case failed");
		}

	}
	
	
	
	
	
	
	

	@AfterSuite
	public void afterSuite() {
		reports.flush();
		driver.quit();
	}

}
