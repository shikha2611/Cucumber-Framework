package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	public static boolean dynamicExplicitElementWait(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementClickable = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}

	public static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File sourcefile = screenShot.getScreenshotAs(OutputType.FILE);
		String destPAth = System.getProperty("user.dir") + "\\src\\test\\java\\screenshot\\sfdc.png";
		File destination = new File(destPAth);
		FileUtils.copyFile(sourcefile, destination);
		return destPAth;
	}

	public static String pageTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;

	}

	public static boolean javaScriptButtonClick(WebDriver driver, WebElement element) {
		boolean isClick = false;
		if (element.isDisplayed()) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", element);
			isClick = true;

		} else {
			isClick = false;
		}
		return isClick;

	}

	public static String randomNameGeneration() throws IOException {
		String fix = PropertyReader.readKeywordLookup("random_String_Prefix");
		String randomString = RandomStringUtils.randomAlphanumeric(5);
		return fix.concat(randomString);

	}
	


	public static boolean pageTitleVerification(String actual, String expected) {
		if (actual.contains(expected)) {
			return true;
		} else {
			return false;
		}

	}

	public static void selectValueFromText(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(value);
	}

}
