package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberBaseStep {

	public static WebDriver driver;
	public static ExtentReports extent = null;
//	protected static Logger log = LogManager.getLogger(CucumberBaseStep.class.getName());

	@Before(order = 2)
	public void setDriver() {
//		log.info("setDriver().........");
		driver = CucumberBaseStep.getBrowserType("chrome", false);
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
//		log.info("etDriver().....");
		return driver;
	}

	@After(order = 2)
	public void closeDriver() {
		driver.close();
	}

	@Before(order = 1)
	public void setUp() {
//		log.info("setUp().....");
		extentReport();
	}

	@After(order = 1)
	public void tearDown() {
//		log.info("tearDown()..........");
		extent.flush();
	}

	public void extentReport() {
//		log.info("extentReport().............");
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\reports\\sfdc.html";
		extent = new ExtentReports();
		ExtentSparkReporter reporthtml = new ExtentSparkReporter(path);
		extent.attachReporter(reporthtml);
	}

	public static WebDriver getBrowserType(String browsername, boolean headless) {
//		log.info("getBrowserType()...");
		WebDriver driver = null;
		String browser = browsername.toLowerCase();

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if (headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;

		case "edge":
			if (headless) {
				EdgeOptions eo = new EdgeOptions();
				eo.addArguments("--headless");
				driver = new EdgeDriver(eo);
			} else {
				driver = new EdgeDriver();
			}
			break;

		default:
			System.out.println("Please use either Chrome or edge broswer");

		}
		return driver;

	}
}
