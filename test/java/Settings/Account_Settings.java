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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Account_Settings {
	WebDriver driver;
	ExtentReports extent=new ExtentReports();
	ExtentSparkReporter sparkreporter=new ExtentSparkReporter("Settings.html");

	@BeforeSuite
	  public void beforeSuite() throws InterruptedException, IOException {
		 extent.attachReporter(sparkreporter);
		 System.setProperty("webdriver.chrome.driver", "/home/tvisha/chromedriver_linux64/chromedriver");
		 ChromeOptions options =new ChromeOptions();
		 options.setBinary("/opt/Mail trim Electron App/mailtrim_electron");
		 options.setBinary("/opt/Mail trim Electron App/mailtrim_electron"); // like: /opt/mailtrim/mailtrim
			options.addArguments("--remote-allow-origins=*");
			//options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			Thread.sleep(3000);
			Runtime.getRuntime().exec(new String[] { "bash", "-c",
					"xdotool search --name 'Mail Trim' windowactivate --sync key --clearmodifiers Super+Up"

			});
			Thread.sleep(1000);

			Runtime.getRuntime().exec(
					new String[] { "bash", "-c", "xdotool search --name 'Mail Trim' windowactivate --sync key ctrl+shift+i"

					});
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("meghana.voggu@tvisha.in");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("MeghanaV@12");
			Thread.sleep(300);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			
			
	  }
	
	
	
  @Test
  public void testcase01() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
	  driver.findElement(By.xpath("//li[@value='settings']")).click();
	  Thread.sleep(300);
	  driver.findElement(By.xpath("//li[@value='accountSettings ']")).click();
	  Thread.sleep(500);
	  String a=driver.findElement(By.xpath("//span[text()='Account Settings:']")).getText();
	  Assert.assertEquals(a, "Account Settings:");
	  
	  ExtentTest test=extent.createTest("Click on Account Settings option");
	  test.info("User login successfully with valid credentials");
	  test.info("User click on settings option");
	  test.info("Click on account settings");
	  test.info("ExpectedResults:It should navigate to account settings option");
	  test.pass(a);
	  test.log(Status.PASS, "ActualResults:It is navigating to account settings");
	  test.pass("Test Case:Test case passed");
	  //driver.close();
  }
 
  
  @Test
  public void testcase02() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//li[@value='settings']")).click();
	  Thread.sleep(300);
	  driver.findElement(By.xpath("//li[@value='accountSettings ']")).click();
	  Thread.sleep(200);
	  String a=driver.findElement(By.xpath("//span[text()='Account Settings:']")).getText();
	  Assert.assertEquals(a, "Account Settings:");
	  Thread.sleep(200);
	  driver.findElement(By.xpath("//input[@placeholder='Display Name']")).sendKeys("kiran");
	  Thread.sleep(200);
	  driver.findElement(By.xpath("//button[text()='Update ']")).click();
	  WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Details updated successfully']")));
	  String b=driver.findElement(By.xpath("//h2[text()='Details updated successfully']")).getText();
	  Assert.assertEquals(b, "Details updated successfully");
	  
	  ExtentTest test=extent.createTest("Update the user name");
	  test.info("User login successfully with valid credentials");
	  test.info("User click on settings option");
	  test.info("Click on account settings");
	  test.pass(a);
	  test.info("Enter user name in the field");
	  test.info("Click on update button");
	  test.info("ExpectedResults:It should update the user name");
	  test.pass(b);
	  test.log(Status.PASS, "ActualResults:It is updating the user name");
	  test.pass("Test Case:Test case passed");
	  //driver.close();
  }
  
  @Test
  public void testcase03() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//li[@value='settings']")).click();
	  Thread.sleep(300);
	  driver.findElement(By.xpath("//li[@value='accountSettings ']")).click();
	  Thread.sleep(200);
	  String a=driver.findElement(By.xpath("//span[text()='Account Settings:']")).getText();
	  Assert.assertEquals(a, "Account Settings:");
	  Thread.sleep(200);
	  WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
	  password.clear();
	  Thread.sleep(200);
	  password.sendKeys("7287893496@A.k");
	  Thread.sleep(400);
	  driver.findElement(By.xpath("//button[text()='Update ']")).click();
	  WebDriverWait wait1 =new WebDriverWait(driver,Duration.ofSeconds(03));
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Details updated successfully']")));
	  String b=driver.findElement(By.xpath("//h2[text()='Details updated successfully']")).getText();
	  Assert.assertEquals(b, "Details updated successfully");
	  
	  ExtentTest test=extent.createTest("Update the password");
	  test.info("User login successfully with valid credentials");
	  test.info("User click on settings option");
	  test.info("Click on account settings");
	 // test.pass(a);
	  test.info("Enter user name in the field");
	  test.info("Click on update button");
	  test.info("ExpectedResults:It should update the user name");
	  test.pass(b);
	  test.log(Status.PASS, "ActualResults:It is updating the user name");
	  test.pass("Test Case:Test case passed");
	  //driver.close();
  }
  

  @AfterSuite
  public void afterSuite() {
	  extent.flush();
	  driver.quit();
  
  }

}
