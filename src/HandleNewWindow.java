import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleNewWindow {
	public WebDriver driver;

	@BeforeTest
	public void this_is_before_test() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().window().maximize();

	}

	@Test()
	public void test_case_one() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
		clickHereButton.click();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parantId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

}
