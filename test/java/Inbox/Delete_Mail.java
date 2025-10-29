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

public class Delete_Mail {

	WebDriver driver;
	ExtentReports reports=new ExtentReports();
	ExtentSparkReporter sparkreporter=new ExtentSparkReporter("Delete.html");
	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {
		reports.attachReporter(sparkreporter);
		System.setProperty("webdriver.chrome.driver","/home/tvisha/chromedriver_linux64/chromedriver");
		ChromeOptions options=new ChromeOptions();
		options.setBinary("/opt/Mail trim Electron App/mailtrim_electron");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-extensions");
		driver=new ChromeDriver(options);
		Thread.sleep(3000);
		Runtime.getRuntime().exec(new String[] { "bash", "-c",
				"xdotool search --name 'Mail Trim' windowactivate --sync key --clearmodifiers Super+Up"});
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7287893496@A.k");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@role='checkbox']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	@Test
	public void testcase01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px] ']")).click();
		Thread.sleep(500);
		String a=driver.findElement(By.xpath("(//div[text()='kiran.kumar@tvisha.in'])[1]")).getText();
		Assert.assertEquals("kiran.kumar@tvisha.in", a);
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px] ']")).click();
		Thread.sleep(500);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Syncing Archive 0 / 45']")));
		Thread.sleep(1000);
		WebElement b=driver.findElement(By.xpath("(//span[text()='RE: Main msg'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(b).build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//img[@title='Delete'])[1]")).click();
		Thread.sleep(500);
		String c=driver.findElement(By.xpath("//h2[text()='Mail moved successfully']")).getText();
		Assert.assertEquals("Mail moved successfully", c);
		
		ExtentTest test=reports.createTest("Delete the Mail by clicking on it");
		test.info("Login the user successfully with valid credentials");
		test.pass(a);
		test.info("Place the cursur on any mail");
		test.info("Click on delete button");
		test.info("Expected Results: It should delete the mail");
		test.pass(c);
		test.log(Status.PASS, "Actual Results: It is deleting the mail");
		test.pass("Test Case: Test case passed");
	}

	@AfterSuite
	public void afterSuite() {
		reports.flush();
		driver.quit();
	}

}
