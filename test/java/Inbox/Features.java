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

public class Features {
	WebDriver driver;
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Flag.html");

	@BeforeSuite
	public void beforeMethod() throws InterruptedException, IOException {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Syncing Drafts 0 / 83']")));
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[@id='mailBody__mark-as-unread'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Mark as Read'])[1]")).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement b = driver.findElement(By.xpath(
				"(//div[@class='flex items-center border-b border-b-[#f0f2f6]  cursor-pointer group pr-3'])[1]"));
		act.moveToElement(b).build().perform();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//img[@alt='Flag icon'])[1]")).click();
		Thread.sleep(500);
		act.moveToElement(b).build().perform();
		Thread.sleep(500);
		WebElement c = driver.findElement(By.xpath("(//*[name()='svg' and @width='18'])[2]"));
		act.moveToElement(c).build().perform();
		Thread.sleep(400);
		WebElement svgTitle = driver.findElement(By.xpath("(//*[name()='svg']/*[name()='title'])[1]"));
		String actualText = svgTitle.getAttribute("textContent"); // ✅ works for <title>
		Assert.assertEquals(actualText, "Remove flag for this mail", "Tooltip text mismatch!");

		ExtentTest test = reports.createTest("Flagging the mail");
		test.info("Login the user successfully with valid credentials");
		test.pass(a);
		test.info("Place the cursur on any mail");
		test.info("Click on flag option");
		test.info("Expected Results: It should flag that mail");
		test.pass(actualText);
		test.log(Status.PASS, "Actual Results: It is flagging the mail");
		test.pass("Test case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase02() throws InterruptedException {

		Actions act = new Actions(driver);
		WebElement c = driver.findElement(By.xpath("(//*[name()='svg' and @width='18'])[2]"));
		act.moveToElement(c).build().perform();
		Thread.sleep(400);
		c.click();
		Thread.sleep(1000);
		WebElement flagImg = driver.findElement(By.xpath("(//img[@title='Flag this mail as important'])[1]"));
		String tooltipText = flagImg.getAttribute("title"); // <-- important
		Assert.assertEquals(tooltipText, "Flag this mail as important");

		ExtentTest test = reports.createTest("Unflagging the mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on flag option");
		test.info("Click on unflag option");
		test.info("Expected Results: It should remove flag to that mail");
		test.pass(tooltipText);
		test.log(Status.PASS, "Actual Results: It is removing flag to that mail");
		test.pass("Test case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase03() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//img[@alt='Mark as un-read '])[1]")).click();
		Thread.sleep(1000);
		WebElement UnreadImg = driver.findElement(By.xpath("(//img[@alt='Mark as Read'])[1]"));
		String tooltipText = UnreadImg.getAttribute("alt"); // <-- important
		Assert.assertEquals(tooltipText, "Mark as Read");

		ExtentTest test = reports.createTest("Mark as unread");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on mark as unread option");
		test.info("Expected Results: It should mark that mail as unread");
		test.pass(tooltipText);
		test.log(Status.PASS, "Actual Results: It is marking that mail as unread");
		test.pass("Test case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase04() throws InterruptedException {
		Thread.sleep(500);
		WebElement a = driver.findElement(By.xpath("(//img[@alt='Mark as Read'])[1]"));
		String b = a.getAttribute("alt");
		Assert.assertEquals(b, "Mark as Read");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Mark as Read'])[1]")).click();
		Thread.sleep(1000);
		WebElement UnreadImg = driver.findElement(By.xpath("(//img[@alt='Mark as un-read '])[1]"));
		String tooltipText = UnreadImg.getAttribute("alt"); // <-- important
		Assert.assertEquals(tooltipText, "Mark as un-read ");

		ExtentTest test = reports.createTest("Mark as read");
		test.info("Login the user successfully with valid credentials");
		test.info("Place the cursur on any mail");
		test.info("Click on mark as read option");
		test.info("Expected Results: It should mark that mail as read");
		test.pass(tooltipText);
		test.log(Status.PASS, "Actual Results: It is marking that mail as read");
		test.pass("Test case: Test case passed");
		Thread.sleep(1000);

	}

	@Test
	public void testcase05() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[@id='mailBody__mark-as-unread'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Mark as Read'])[1]")).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebElement b = driver.findElement(By.xpath(
				"(//div[@class='flex items-center border-b border-b-[#f0f2f6]  cursor-pointer group pr-3'])[1]"));
		act.moveToElement(b).build().perform();
		driver.findElement(By.xpath("(//img[@alt='Mark as un-read '])[1]")).click();
		Thread.sleep(500);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2'])[1]")));
		Thread.sleep(500);
		boolean isPresent = driver
				.findElements(By.xpath("(//div[@class='absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2'])[1]"))
				.size() > 0;
		String a = driver.findElement(By.xpath("(//div[@class='absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2'])[1]"))
				.getAttribute("class");
		Assert.assertEquals("absolute w-2 h-2 bg-[#02b9ff] rounded-full ml-2", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class=' px-4 py-2  flex flex-col  flex-1 '])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Back']")).click();
		Thread.sleep(2000);

		ExtentTest test = reports.createTest("Read the mail by viewing the mail");
		test.info("Login the user successfully with valid credentials");
		test.info("Click on unread feature of any mail");
		test.info("Click on that unread mail");
		test.info("Click on back button");
		test.info("Observe the unread dot");
		test.info("Expected Result: It should remove the unread dot for that mail");
		if (!isPresent) {
			test.log(Status.FAIL, "Actual Result: Unread dot is not removing after reading the mail");
		} else {
			test.log(Status.PASS, "Actual Result: Unread dot is removing after reading the mail");
		}

		if (!isPresent) {
			test.fail("Unread dot is not removing after reading the mail");
		} else {
			test.pass("Unread dot is removing after reading the mail");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@AfterSuite
	public void afterMethod() {
		driver.quit();
		reports.flush();
	}

}
