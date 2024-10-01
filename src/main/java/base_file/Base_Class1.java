package base_file;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class1 {

	public static WebDriver driver;

	public static WebDriver browser_Launch(String name) {
		if (name.equals("chrome")) {
			ChromeOptions browser = new ChromeOptions();
			browser.addArguments("incognito");
			driver = new ChromeDriver(browser);

		} else if (name.equals("edge")) {
			EdgeOptions browser = new EdgeOptions();
			browser.addArguments("private");
			driver = new EdgeDriver(browser);
		} else if (name.equals("firefox")) {
			FirefoxOptions browser = new FirefoxOptions();
			browser.addArguments("incognito");
			driver = new FirefoxDriver(browser);
		}

		return driver;
	}

	public static void jsclick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void javascriptscrollintoview(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void implicitlywait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void minimize() {
		driver.manage().window().maximize();
	}

	public static void quit() {
		driver.quit();
	}

	public static void log(String text) {
		System.out.println(text);
	}
}
