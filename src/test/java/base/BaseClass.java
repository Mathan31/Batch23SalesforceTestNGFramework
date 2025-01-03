package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import libraries.HTMLReport;
import util.PropertyFileUtil;

public class BaseClass extends HTMLReport{

	public WebDriver driver; //1234
	public static String fileName = "Environment";
	public String excelFileName = "";
	public int iBrowserType = Integer.parseInt(PropertyFileUtil.readDataFromPropertyFile(fileName, "Browser")); // 1 - Chrome, 2 - Edge, 3 - FF, 4 - IE
	public String sURL = PropertyFileUtil.readDataFromPropertyFile(fileName, "URL");
	@BeforeClass
	public  void invokeBrowser() {
		switch (iBrowserType) {
		case 1:
			System.out.println("User option is : "+iBrowserType+", So invoking the Chrome browser.");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User option is : "+iBrowserType+", So invoking the Edge browser.");
			driver = new EdgeDriver();
			break;
		case 3:
			System.out.println("User option is : "+iBrowserType+", So invoking the FireFox browser.");
			driver = new FirefoxDriver();
			break;
		case 4:
			System.out.println("User option is : "+iBrowserType+", So invoking the IE browser.");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("User option is wrong: "+iBrowserType+", So invoking the default Chrome browser.");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.navigate().to(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterClass
	public  void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider(name="TestCaseData")
	public Object[][] excelData() throws Exception {
		Object[][] values = util.DataProviderObject.getValue(excelFileName);
		return values;
	}

	@Override
	public String takeScreenshot() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
