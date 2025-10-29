package Login_Page;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class LoginPage {

	WebDriver driver;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Login.html");

	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		extent.attachReporter(sparkreporter);
		System.setProperty("webdriver.chrome.driver", "/home/tvisha/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/opt/Mail trim Electron App/mailtrim_electron"); // like: /opt/mailtrim/mailtrim
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
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
		
	}

	@Test
	public void testcase01() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//p[text()='Please enter your email']")).getText();
		AssertJUnit.assertEquals(a, "Please enter your email");
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//p[text()='Please enter your password']")).getText();
		AssertJUnit.assertEquals(b, "Please enter your password");
		Thread.sleep(300);

		ExtentTest test = extent.createTest("Without Credentials");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Login: Click on submit");
		test.info("Expected Resultl:: It should display Please enter your email & Please enter your password");
		test.pass(a);
		test.pass(b);
		test.log(Status.PASS, "Actual results:: It displaying Please enter your email & Please enter your password");
		test.pass("Test case: Test case passed");
		Thread.sleep(200);
		driver.close();

	}

	@Test
	public void testcase02() throws InterruptedException, IOException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//p[text()='Please enter a valid email']")).getText();
		AssertJUnit.assertEquals(a, "Please enter a valid email");
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//p[text()='Please enter your password']")).getText();
		AssertJUnit.assertEquals(b, "Please enter your password");
		Thread.sleep(300);

		ExtentTest test = extent.createTest("Enter invalid email only");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter invalid email: kiran");
		test.info("Login: Click on submit");
		test.info("Expected Resultl:: It should display Please enter a valid email & Please enter your password");
		test.pass(a);
		test.pass(b);
		test.log(Status.PASS, "Actual results:: It displaying Please enter a valid email & Please enter your password");
		test.pass("Test case: Test case passed");
		Thread.sleep(200);
		driver.close();

	}

	@Test
	public void testcase03() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("kiran");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//p[text()='Please enter your email']")).getText();
		AssertJUnit.assertEquals(a, "Please enter your email");
		Thread.sleep(300);

		ExtentTest test = extent.createTest("Enter password only");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("123456789");
		test.info("Login: Click on submit");
		test.info("Expected Resultl:: It should display Please enter your email");
		test.pass(a);
		test.log(Status.PASS, "Actual results:: It displaying Please enter your email");
		test.pass("Test case: Test case passed");
		Thread.sleep(200);
		driver.close();

	}

	@Test
	public void testcase04() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("kiran");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//p[text()='Please enter a valid email']")).getText();
		AssertJUnit.assertEquals(a, "Please enter a valid email");
		Thread.sleep(300);

		ExtentTest test = extent.createTest("Enter invalid email & valid password");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter invalid email:kiran");
		test.info("Enter valid password:123456789");
		test.info("Login: Click on submit");
		test.info("Expected Resultl:: It should display Please enter a valid email");
		test.pass(a);
		test.log(Status.PASS, "Actual results:: It displaying Please enter a valid email");
		test.pass("Test case: Test case passed");
		Thread.sleep(200);
		driver.close();

	}

	@Test
	public void testcase05() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("kiran");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(300);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String a = driver.findElement(By.xpath("//div[@class='text-sm opacity-90']")).getText();
		AssertJUnit.assertEquals(a, "Authentication failed");
		Thread.sleep(300);

		ExtentTest test = extent.createTest("Enter valid email & invalid password");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter valid email:kiran.kumar@tvisha.in");
		test.info("Enter invalid password:123456");
		test.info("Login: Click on submit");
		test.info("Expected Resultl:: It should display Authentication failed");
		test.pass(a);
		test.log(Status.PASS, "Actual results:: It displaying Authentication failed");
		test.pass("Test case: Test case passed");
		Thread.sleep(200);
		driver.close();

	}

	@Test
	public void testcase06() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvish");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("kiran");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//p[text()='Please enter a valid email']")).getText();
		AssertJUnit.assertEquals(a, "Please enter a valid email");
		Thread.sleep(300);

		ExtentTest test = extent.createTest("Enter invalid email & invalid password");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter invalid email:kiran.kumar@tv");
		test.info("Enter invalid password:123456");
		test.info("Login: Click on submit");
		test.info("Expected Resultl:: It should display Please enter a valid email");
		test.pass(a);
		test.log(Status.PASS, "Actual results:: It displaying Please enter a valid email");
		test.pass("Test case: Test case passed");
		Thread.sleep(200);
		driver.close();

	}

	@Test
	public void testcase07() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvish");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456789");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[name()='svg' and @width='1em']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//input[@placeholder='Password']")).getText();
		AssertJUnit.assertEquals(a, "");
		Thread.sleep(300);

		ExtentTest test = extent.createTest("Click on password view icon");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter valid email:kiran.kumar@tv");
		test.info("Enter valid password:123456");
		test.info("Click on password view icon");
		test.info("Expected Resultl:: It should view the entered password");
		test.pass(a);
		test.log(Status.PASS, "Actual results:: It displaying the entered password");
		test.pass("Test case: Test case passed");
		Thread.sleep(200);
		driver.close();

	}

	@Test
	public void testcase08() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7287893496@A.k");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-state='checked']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("//div[text()='Please accept terms and conditions']")).getText();
		AssertJUnit.assertEquals(a, "Please accept terms and conditions");
		Thread.sleep(300);

		ExtentTest test = extent.createTest("Uncheck the Terms of Use Policy & click on submit");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter valid email:kiran.kumar@tvisha.in");
		test.info("Enter valid password:123456789");
		test.info("Login: Click on submit");
		test.info("Expected Resultl:: It should display Please accept terms and conditions");
		test.pass(a);
		test.log(Status.PASS, "Actual results:: It displaying Please accept terms and conditions");
		test.pass("Test case: Test case passed");
		Thread.sleep(200);
		driver.close();

	}

	@Test
	public void testcase09() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7287893496@A.k");
		Thread.sleep(1000);
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px]']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//div[text()='meghana.voggu@tvisha.in'])[1]")).getText();
		Assert.assertEquals("meghana.voggu@tvisha.in", a);

		ExtentTest test = extent.createTest("Login with valid credentials");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter valid email:kiran.kumar@tvisha.in");
		test.info("Enter valid password:123456789");
		test.info("Login: Click on submit");
		test.info("Expected Resultl:: User should login successfully and display the user mail");
		test.pass(a);
		test.log(Status.PASS, "Actual results:: User is login successfully and displaying user mail id");
		test.pass("Test case: Test case passed");
		Thread.sleep(2000);
		driver.close();

	}

	@Test
	public void testcase10() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kiran.kumar@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7287893496@A.k");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//span[@class='font-medium text-[14px]']")).click();
		Thread.sleep(300);
		String a = driver.findElement(By.xpath("(//div[text()='meghana.voggu@tvisha.in'])[1]")).getText();
		Assert.assertEquals("meghana.voggu@tvisha.in", a);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='TEAMS']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='TEAMS']")).click();
		Thread.sleep(300);
		String b = driver.findElement(By.xpath("//h1[@class='text-xs']")).getText();
		Assert.assertEquals("We didn't find anything to show here", b);
		Thread.sleep(500);

		ExtentTest test = extent.createTest("Click on any category if there are no mails are presented");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter valid email:kiran.kumar@tvisha.in");
		test.info("Enter valid password:123456789");
		test.info("Login: Click on submit");
		test.info("User is login successfully");
		test.pass(a);
		test.info("Click on teams category");
		test.info("Expected Resultl:: It should display We didn't find anything to show here text");
		test.pass(b);
		test.log(Status.PASS, "Actual results:: It displaying We didn't find anything to show here text");
		test.pass("Test case: Test case passed");
		Thread.sleep(2000);
		driver.close();

	}

	@Test
	public void testcase11() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("meghana.voggu@tvisha.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("MeghanaV@12");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		String a = driver.findElement(By.xpath("//span[text()='MV']")).getText();
		Assert.assertEquals("MV", a);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Syncing INBOX 100 / 364']")));
		Thread.sleep(3000);
		String b = driver.findElement(By.xpath("//button[@aria-haspopup='menu']")).getAttribute("aria-haspopup");
		Assert.assertEquals("menu", b);
		Thread.sleep(500);

		ExtentTest test = extent.createTest("Get the data if there are mails are presented");
		test.log(Status.INFO, "Desktop application launched successfully");
		test.info("Navigate to application");
		test.info("Enter valid email:kiran.kumar@tvisha.in");
		test.info("Enter valid password:123456789");
		test.info("Login: Click on submit");
		test.info("User is login sucessfully");
		test.pass(a);
		test.info("Expected Resultl:: It should display all the mails manu");
		test.pass(b);
		test.log(Status.PASS, "Actual results:: It displaying all the mails");
		test.pass("Test case: Test case passed");
		Thread.sleep(2000);
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@AfterMethod
	public void afterMethod() {
		extent.flush();
		driver.quit();

	}

}
