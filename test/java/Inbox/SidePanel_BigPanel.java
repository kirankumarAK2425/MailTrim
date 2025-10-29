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

public class SidePanel_BigPanel {
	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Sidepanel-Bigpanel.html");

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
		Thread.sleep(300);
		driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel.svg']")).click();
		Thread.sleep(300);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Click on sidepanel bigpanel option");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		test.info("Expected Results: It should activate sidepanel bigpanel view");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.log(Status.PASS, "Actual Results: It is activating the sidepanel bigpanel view");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase02() throws InterruptedException {
		Thread.sleep(300);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[@title='Delete']")).click();
		Thread.sleep(300);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='7'])[1]")));
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 7 of 7", b);

		ExtentTest test = reports.createTest("Delete the mail");
		test.info("User login successfully login with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on delete mail option");
		test.info("Expected Results: It should delete the mail");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is deleting the mail");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase03() throws InterruptedException {
		Thread.sleep(300);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("//div[@title='Add flag']"));
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Add flag option");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on add flag option");
		test.info("Expected Results: It should add the flag to that mail");
		if (b.isDisplayed()) {
			test.pass("It is adding flag to that mail");
		} else {
			test.fail("It is not adding flag to that mail");
		}
		test.log(Status.PASS, "Actual Results: It is adding flag to that mail");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase04() throws InterruptedException {
		Thread.sleep(300);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("//div[@title='Add flag']"));
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Unflag option");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on unflag option");
		test.info("Expected Results: It should unflag that mail");
		if (b.isDisplayed()) {
			test.pass("It is unflagging that mail");
		} else {
			test.fail("It is not unflagging that mail");
		}
		test.log(Status.PASS, "Actual Results: It is unflagging that mail");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase05() throws InterruptedException {
		Thread.sleep(500);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("//div[@title='Mark as Respond later']"));
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Respond Later");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on respond later option");
		test.info("Expected Results: It should mark the mail as respond later");
		if (b.isDisplayed()) {
			test.pass("It is marking the mail as respond later");
		} else {
			test.fail("It is not marking the mail as respond later");
		}
		test.log(Status.PASS, "Actual Results: It is marking the mail as respond later");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase06() throws InterruptedException {
		Thread.sleep(500);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("//div[@title='Mark as Respond later']"));
		Thread.sleep(300);

		ExtentTest test = reports.createTest(" Remove Respond Later");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on remove respond later option");
		test.info("Expected Results: It should remove respond later");
		if (b.isDisplayed()) {
			test.pass("It is removing respond later");
		} else {
			test.fail("It is not removing respond later");
		}
		test.log(Status.PASS, "Actual Results: It is removing respond later to the mail");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase07() throws InterruptedException {
		Thread.sleep(500);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("//div[@title='Mark as Un-Read']"));
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Mark the mail as unread");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on mark as unread");
		test.info("Expected Results: It should mark the mail as unread");
		if (b.isDisplayed()) {
			test.pass("It is marking the mail as unread");
		} else {
			test.fail("It is not marking the mail as unread");
		}
		test.log(Status.PASS, "Actual Results: It is marking the mail as unread");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase08() throws InterruptedException {
		Thread.sleep(500);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		WebElement b = driver.findElement(By.xpath("//div[@title='Mark as Un-Read']"));
		Thread.sleep(300);

		ExtentTest test = reports.createTest("Mark the mail as read");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on mark as read option");
		test.info("Expected Results: It should mark the mail as read");
		if (b.isDisplayed()) {
			test.pass("It is marking the mail as read");
		} else {
			test.fail("It is not marking the mail as read");
		}
		test.log(Status.PASS, "Actual Results: It is marking the mail as read");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase09() throws InterruptedException {
		Thread.sleep(300);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[@title='Reply with attachment']")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//p[text()='Reply Mail']")).getText();
		Assert.assertEquals("Reply Mail", b);

		ExtentTest test = reports.createTest("Click on reply mail with attachments");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on reply mail with attachment option");
		test.info("Expected Results: It should navigate reply mail");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is navigating reply mail");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase10() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		WebElement c = driver.findElement(By.xpath("//h2[text()='Mail discarded']"));
		Actions act = new Actions(driver);
		act.moveToElement(c).build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@title='Reply all with attachment']")).click();
		Thread.sleep(1000);
		String b = driver.findElement(By.xpath("//p[text()='Reply Mail']")).getText();
		Assert.assertEquals("Reply Mail", b);

		ExtentTest test = reports.createTest("Click on reply all with attachments");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on reply all with attachments option");
		test.info("Expected Results: It should navigate reply mail screen");
		test.pass(b);
		test.log(Status.PASS, "Expected Results: It is navigating reply mail screen");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase11() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(300);
		WebElement c = driver.findElement(By.xpath("//h2[text()='Mail discarded']"));
		Actions act = new Actions(driver);
		act.moveToElement(c).build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@title='Reply']")).click();
		Thread.sleep(500);
		String b = driver.findElement(By.xpath("//p[text()='Reply Mail']")).getText();
		Assert.assertEquals("Reply Mail", b);

		ExtentTest test = reports.createTest("Reply mail option");
		test.info("Login the user with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on reply mail option");
		test.info("Expected Results: It should navigate reply mail screen");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is navigating reply mail screen");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase12() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(1000);
		WebElement c = driver.findElement(By.xpath("//h2[text()='Mail discarded']"));
		Actions act = new Actions(driver);
		act.moveToElement(c).build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@title='Reply all']")).click();
		Thread.sleep(1000);
		String b = driver.findElement(By.xpath("//p[text()='Reply Mail']")).getText();
		Assert.assertEquals("Reply Mail", b);

		ExtentTest test = reports.createTest("Reply all option");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on reply all option");
		test.info("Expected Results: It should navigate reply mail screen");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is navigating reply mail screen");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase13() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(1000);
		WebElement c = driver.findElement(By.xpath("//h2[text()='Mail discarded']"));
		Actions act = new Actions(driver);
		act.moveToElement(c).build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[name()='svg' and @width='24'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@title='Forward']")).click();
		Thread.sleep(1000);
		String b = driver.findElement(By.xpath("//p[text()='Forward Mail']")).getText();
		Assert.assertEquals("Forward Mail", b);

		ExtentTest test = reports.createTest("Click on forward mail");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on forward option");
		test.info("Expected Results: It should navigate forward mail screen");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is navigating to forward mail screen");

	}

	@Test
	public void testcase14() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[name()='svg']/*[name()='path'][@fill='currentColor']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Discard']")).click();
		Thread.sleep(1000);
		WebElement c = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Archive'])[1]")).click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='124'])[1]")));
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 100 of 124", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[text()='20 per page'])[1]")).click();
		Thread.sleep(400);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 20 of 124", b);

		ExtentTest test = reports.createTest("Change the no.of mails per page");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (c.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.pass(a);
		test.info("Click on page numbers");
		test.info("Select 20 per page option");
		test.info("Expected Results: It should display the selected number of mails in that page");
		test.pass(b);
		test.log(Status.PASS, "Actual Results: It is displaying that selected number of mails in that page");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase15() throws InterruptedException {
		Thread.sleep(500);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(1000);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 20 of 124", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[2]")).click();
		Thread.sleep(500);
		String c = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("21 - 40 of 124", c);

		ExtentTest test = reports.createTest("Click on next page button");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.pass(b);
		test.info("Click on next page button");
		test.info("Expected Results: It should navigate to next page");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is navigating to next page");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase16() throws InterruptedException {
		Thread.sleep(500);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(1000);
		String b = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("21 - 40 of 124", b);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='relative inline-block group'])[1]")).click();
		Thread.sleep(500);
		String c = driver.findElement(By.xpath("(//div[@class='font-semibold cursor-pointer'])[1]")).getText();
		Assert.assertEquals("1 - 20 of 124", c);

		ExtentTest test = reports.createTest("Click on previous page button");
		test.info("User login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.pass(b);
		test.info("Click on previous page button");
		test.info("Expected Results: It should navigate to previous page");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is navigating to previous page");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase17() throws InterruptedException {
		Thread.sleep(500);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(500);
		WebElement b = driver.findElement(By.xpath("(//div[@class='flex gap-[10px]'])[1]"));

		ExtentTest test = reports.createTest("Click on select all button");
		test.info("user login successfully with valid credentials");
		test.info("Click on sidepanel bigpanel");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on select all button");
		test.info("Expected Results: It should display the top feature options");
		if (b.isDisplayed()) {
			test.pass("It is displaying the top feature options");
		} else {
			test.fail("It is not displaying top feature options");
		}
		test.log(Status.PASS, "Actual Results: It is displaying top feature options");
		test.pass("Test Case: Test case passed");
	}

	@Test
	public void testcase18() throws InterruptedException {
		Thread.sleep(400);
		WebElement a = driver.findElement(By.xpath("//img[@src='layouts/sidepanel___bigpanel-active.svg']"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(500);
		WebElement b = driver.findElement(By.xpath("(//div[@class='flex gap-[10px]'])[1]"));

		ExtentTest test = reports.createTest("Uncheck the select all checkbox");
		test.info("User login successfully with valid credentials");
		if (a.isEnabled()) {
			test.pass("It is activating the sidepanel bigpanel view");
		} else {
			test.fail("It is not activating the sidepanel bigpanel view");
		}
		test.info("Click on uncheck button of select all");
		test.info("Expected Results: It should not display top features options");
		if (b.isDisplayed()) {
			test.fail("It is displaying top feature options");
		} else {
			test.pass("It is not displaying top feature options");
		}
		test.log(Status.PASS, "Actual Results: It is hiding the top feature options");
		test.pass("Test Case: Test case passed");

	}

	@AfterSuite
	public void afterSuite() {
		reports.flush();
		driver.quit();
	}

}
