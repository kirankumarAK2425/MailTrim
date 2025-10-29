package Settings;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Display_Settings {
	WebDriver driver;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("displaysettings.html");

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

	}

	@Test
	public void testcase01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Display Settings']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text='Display Settings:']")).getText();
		Assert.assertEquals("Display Settings:", a);

		ExtentTest test = extent.createTest("Display settings window");
		test.info("User login successfully with valid user name and password");
		test.info("Click on settings option");
		test.info("Click on display settings option");
		test.info("ExpectedResults: It should navigate to display settings page");
		test.pass(a);
		test.log(Status.PASS, "ActualResults:It is navigating to display settings page");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase02() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Display Settings']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Display Settings:']")).getText();
		Assert.assertEquals("Display Settings:", a);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		Thread.sleep(200);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Helvetica']")));
		option.click();
		String b = driver.findElement(By.xpath("//span[text()='Helvetica']")).getText();
		Assert.assertEquals("Helvetica", b);

		ExtentTest test = extent.createTest("Change the font style");
		test.info("User login successfully with valid user name and password");
		test.info("Click on settings option");
		test.info("Click on display settings option");
		test.pass(a);
		test.info("Click on font style dropdown");
		test.info("Select any font from the dropdown");
		test.info("ExpectedResults: It should apply that font to the app");
		test.pass(b);
		test.log(Status.PASS, "ActualResults:It is applying that font to the app");
		test.pass("Test Case: Test case passed");

	}

	@Test
	public void testcase03() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//li[@value='settings']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Display Settings']")).click();
		Thread.sleep(200);
		String a = driver.findElement(By.xpath("//span[text()='Display Settings:']")).getText();
		Assert.assertEquals("Display Settings:", a);
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@role='combobox'])[2]")));
		dropdown1.click();
		WebElement option1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='110%'])[1]")));
		option1.click();
		String b = driver.findElement(By.xpath("//span[text()='110%']")).getText();
		Assert.assertEquals("110%", b);

		ExtentTest test = extent.createTest("Change the font style");
		test.info("User login successfully with valid user name and password");
		test.info("Click on settings option");
		test.info("Click on display settings option");
		test.pass(a);
		test.info("Click on font style dropdown");
		test.info("Select any font from the dropdown");
		test.info("ExpectedResults: It should apply that font to the app");
		test.pass(b);
		test.log(Status.PASS, "ActualResults:It is applying that font to the app");
		test.pass("Test Case: Test case passed");

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterSuite
	public void afterSuite() {
		extent.flush();
		driver.quit();
	}

}
