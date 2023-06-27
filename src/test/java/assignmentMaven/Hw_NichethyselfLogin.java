//1. Create a Maven Project>add dependency>
//write a testcase>Run from the command Prompt

package assignmentMaven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Hw_NichethyselfLogin {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void nTLoginTestNGTest() {
		// a. Enter your username ("stc123")

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		WebElement username = driver.findElement(By.name("username"));

		username.sendKeys("stc123");
		// Thread.sleep(5000);

		// b. Enter your password ("12345")
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("12345");
		// Thread.sleep(5000);

		// c. Click on Submit button

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/br/following-sibling::button")));
		driver.findElement(By.xpath("//form/br/following-sibling::button")).click();

		// Thread.sleep(5000);

		// d. Verify that the login was successful

		String expectPageTitle = "My account";
		wait.until(ExpectedConditions.titleIs("My account"));
		String actualPageTitle = driver.getTitle();

		assertEquals(actualPageTitle, expectPageTitle, "Test Case Failed! as page title is not as expected.");

	}

	@BeforeMethod
	public void beforeMethod() {
		// 8. Go to https://nichethyself.com/tourism/home.html
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://nichethyself.com/tourism/home.html");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("I am inside the BeforeMethod of Hw_nichethyselfLogin");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am inside the AfterMethod of Hw_nichethyselfLogin");
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am inside the BeforeClass of Hw_nichethyselfLogin");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am inside the AfterClass of Hw_nichethyselfLogin");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am inside the BeforeSuite of Hw_nichethyselfLogin");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am inside the AfterSuite of Hw_nichethyselfLogin");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am inside the BeforeTest of Hw_nichethyselfLogin");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am inside the AfterTest of Hw_nichethyselfLogin");
	}
}
