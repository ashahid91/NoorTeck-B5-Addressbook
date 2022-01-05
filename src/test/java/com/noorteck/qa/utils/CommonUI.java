package com.noorteck.qa.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * In this class we will create all common method that will be used when
 * interacting with UI
 * 
 * @author NoorTeck
 *
 */
public class CommonUI extends Constants {

	/**
	 * This method takes 1 string parameter and open the browser
	 * 
	 * @param browser
	 */
	public  static void openBrowser(String browser) {
		try {

			switch (browser.toLowerCase()) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();

				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			}

		} catch (Exception e) {
			System.out.println("Browser has [" + browser + "] value. Make sure to pass [chrome/ie/firefox]");
			e.printStackTrace();

		}
	}

	/**
	 * This method takes 1 string param and it sets up the implicit wait, maximizes
	 * page and navigates to URL
	 * 
	 * @param url
	 */
	public static void  navigate(String url) {

		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);

		} catch (Exception e) {
			System.out.println("Check the url [" + url + "], make sure it contains correct format");
			e.printStackTrace();

		}

	}

	/**
	 * This method returns the title of page
	 * 
	 * @return
	 */

	public static String getTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("Driver instance is NULL");
			e.printStackTrace();
			return null;

		}
	}

	/**
	 * This method takes 1 webelement parameter and checks wether it is
	 * displayed/not
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isDisplayed(WebElement element) {
		try {

			return element.isDisplayed();

		} catch (Exception e) {

			System.out.println("Element is not displayed:" + element);
			e.printStackTrace();

			return false;
		}
	}

	/**
	 * This method takes 1 webelement parameter and checks wether it is enabled or
	 * not
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isEnabled(WebElement element) {
		try {

			return element.isEnabled();

		} catch (Exception e) {

			System.out.println("Element is not enabled or does not exists:" + element);
			e.printStackTrace();

			return false;
		}
	}

	/**
	 * This method takes 1 webelement parameter and checks wether it is selected/not
	 * 
	 * @param element
	 * @return
	 */

	public static boolean isSelected(WebElement element) {
		try {

			return element.isSelected();

		} catch (Exception e) {

			System.out.println("Element does not exists:" + element);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method takes 1 webelement parameter and clicks the elements.
	 * 
	 * @param element
	 */

	public static void click(WebElement element) {

		if (isDisplayed(element)) {
			element.click();
		}
	}

	/**
	 * This method takes 1 parameter and returns the text as String
	 * 
	 * @param element
	 * @return
	 */
	public static String getText(WebElement element) {
		String text = null;

		if (isDisplayed(element)) {
			text = element.getText();
		}

		return text;
	}

	/**
	 * This method quits the browser
	 */

	public static void quitBrowser() {

		try {

			driver.quit();

		} catch (Exception e) {
			System.out.println("Driver object is null");
			e.printStackTrace();
		}
	}

	/**
	 * This methods clears the textfields then enters the value
	 * 
	 * @param element
	 * @param value
	 */

	public static void enter(WebElement element, String value) {

		if (isDisplayed(element)) {
			element.clear();
			element.sendKeys(value);
		}

	}

	/**
	 * 
	 * @param element
	 * @param methodName
	 * @param indexTextValue
	 */

	public static void selectFromDropdown(WebElement element, String methodName, String indexTextValue) {

		try {

			Select obj = new Select(element);
			methodName = methodName.toLowerCase();

			if (methodName.contains("index")) {
				int index = Integer.parseInt(indexTextValue);
				obj.selectByIndex(index);
			} else if (methodName.contains("value")) {
				obj.selectByValue(indexTextValue);
			} else if (methodName.contains("text")) {
				obj.selectByVisibleText(indexTextValue);
			} else {
				System.out.println("Dropdown can be selected only with [index, value, or text] check your parameters.");
			}

		} catch (Exception e) {
			System.out.println("Unable to find dropdown webelement: " + element);
			e.printStackTrace();
		}

	}

	/**
	 * This method cheks if alert is present or not
	 * 
	 * @return
	 */

	public static boolean isAlertPresent() {
		boolean isAlert = false;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				isAlert = true;
			}
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
			e.printStackTrace();
		}
		return isAlert;
	}

	/**
	 * This method switchs to alert and accepts
	 */

	public static void acceptAlert() {

		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();

			alert.accept();
		}
	}

	/**
	 * This method switchs to alert and declines
	 */

	public static void dismissAlert() {

		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}
	}

	/**
	 * This method takes 2 params and performs drag-and-drop actions
	 * 
	 * @param source
	 * @param target
	 */

	public static void dragAndDrop(WebElement source, WebElement target) {

		try {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, target).build().perform();

		} catch (Exception e) {
			System.out.println("Element does not exists");
			e.printStackTrace();
		}
	}

	/**
	 * This method hovers over the elements
	 * 
	 * @param element
	 */

	public static void moveToElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();

		} catch (Exception e) {
			System.out.println("Element does not exists");
			e.printStackTrace();
		}
	}

	/**
	 * This method hovers over the elements then clicks
	 * 
	 * @param element
	 */

	public static void moveToElementAndClick(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			System.out.println("Element does not exists");
			e.printStackTrace();
		}
	}

	public static void openBrowserOLD(String browser) {

		String key = null;
		String path = null;

		try {

			switch (browser.toLowerCase()) {

			case "chrome":
				key = "webdriver.chrome.driver";
				path = "C:\\Users\\NoorTeck\\OneDrive - glbtechexperts.com\\Desktop\\Selenium\\chromedriver.exe";
				System.setProperty(key, path);
				driver = new ChromeDriver();
				break;
			case "firefox":
				key = "webdriver.gecko.driver";
				path = "C:\\Users\\NoorTeck\\OneDrive - glbtechexperts.com\\Desktop\\Selenium\\geckodriver.exe";
				System.setProperty(key, path);
				driver = new FirefoxDriver();
				break;
			case "ie":
				key = "webdriver.ie.driver";
				path = "C:\\Users\\NoorTeck\\OneDrive - glbtechexperts.com\\Desktop\\Selenium\\iedriver.exe";
				System.setProperty(key, path);
				driver = new InternetExplorerDriver();
				break;
			}

		} catch (Exception e) {
			System.out.println("Browser has [" + browser + "] value. Make sure to pass [chrome/ie/firefox]");
			e.printStackTrace();

		}
	}

}

/**
 * chrome Firefox IE Edge Safari
 * 
 * 
 * 
 * 
 * opening browser
 * 
 * maximizing window
 * 
 * 
 * implicitly wait
 * 
 * 
 * 
 * quitting browser
 * 
 * 
 * Click
 * 
 * 
 * entering values
 * 
 * ifrmaes
 * 
 * 
 * popup
 * 
 * dropdowns
 * 
 * 
 * getText()
 * 
 * getTitle()
 * 
 * 
 * 
 */