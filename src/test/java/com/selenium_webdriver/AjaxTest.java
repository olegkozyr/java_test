package com.selenium_webdriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjaxTest {
	private final String BASE_URL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";
	private final Long IMPLICITLY_WAIT_SECONDS = 10L;
	private final Long ONE_SECOND_DELAY = 1000L;
	private WebDriver driver;

	// Overload
	private void presentationSleep() {
		presentationSleep(1);
	}

	// Overload
	private void presentationSleep(int seconds) {
		try {
			Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		presentationSleep(); // For Presentation ONLY
		// driver.close();
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(BASE_URL);
		presentationSleep(); // For Presentation ONLY
		//
		closePopup1();
	}

	@AfterMethod
	public void afterMethod() {
		presentationSleep(); // For Presentation ONLY
		// logout; clear cache; delete cookie; delete session;
		// Save Screen;
	}

	private void closePopup1() {
		presentationSleep(); // For Presentation ONLY
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		long timeStart = System.currentTimeMillis();
		List<WebElement> footerButton = driver.findElements(By.xpath("//footer[contains(@class,'cookie')]//button"));
		System.out.println("***footerButton.size() = " + footerButton.size());
		System.out.println("***time = " + (System.currentTimeMillis() - timeStart));
		if (footerButton.size() > 0) {
			footerButton.get(0).click();
			presentationSleep(); // For Presentation ONLY
		}
		//driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
	}

	private void closePopup() {
        presentationSleep(); // For Presentation ONLY
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        //List<WebElement> foooterButton = driver.findElements(By.xpath("//footer[contains(@class,'cookie')]//button"));
        Duration fiveSeconds = Duration.ofSeconds(5);
        Duration oneSeconds = Duration.ofSeconds(1);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(fiveSeconds)
                //.withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(oneSeconds)
                //.pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(NullPointerException.class)
                .ignoring(TimeoutException.class);
        //
		//ExpectedCondition expectedCondition;
        WebElement footerButton = wait.until(new Function<WebDriver, WebElement>() {
          public WebElement apply(WebDriver driver) {
              String s = null;
              System.out.println("\t***apply running ...");
              if (System.currentTimeMillis() % 2 == 0) {
				  System.out.println("\t***NullPointerException ...");
                  System.out.println(s.toString());
              }
            return driver.findElement(By.xpath("//footer[contains(@class,'cookie')]//button"));
          }
        });
        System.out.println("footerButton = " + footerButton);
        footerButton.click();
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
    }
	
	@Test
	public void AjaxIframePage1() {
		/*
		* Go to the site
		* https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/
		* In the first table (Uncontrolled Mode item), enter the letter L in the City filter.
		* Check the presence in the column of the cities of Las Vegas and London.
		* Please include the Java code as a result or link to the code.
		* */
		WebElement position = driver.findElement(By.cssSelector("#uncontrolled-mode"));
		//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", position);
		presentationSleep(2); // Do no use
		// Switch To IFrame
		driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@data-options,'/demo/grid-filtering/filter-row')]//iframe")));

		String cityXPath = "/html/body/div[2]/div/div/div/div/div/div/div/table/thead/tr[2]/th[3]/div/div/input";
		driver.findElement(By.xpath(cityXPath)).click();
		driver.findElement(By.xpath(cityXPath)).clear();
		driver.findElement(By.xpath(cityXPath)).sendKeys("L", Keys.ENTER);
		presentationSleep(2);

		List<WebElement> elements = driver.findElements(By.xpath("//td[text()='Las Vegas']"));
		if (elements.size() > 0) {
			System.out.println("Las Vegas city is presented " + elements.size() + " time(s).");
		}
		elements = driver.findElements(By.xpath("//td[text()='London']"));
		if (elements.size() > 0) {
			System.out.println("London city is presented " + elements.size() + " time(s).");
		}
	}

}