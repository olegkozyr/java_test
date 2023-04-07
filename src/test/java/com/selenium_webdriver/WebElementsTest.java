package com.selenium_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class WebElementsTest {
    private final String BASE_URL = "https://demo.opencart.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        if (driver != null) {
            driver.quit(); // close()
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        // logout;
        // Save Screen;
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to;
            // previous state, logout, etc.
            // takeScreenShot(testName);
            // takePageSource(testName);
            // driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete session;
        }
        // driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        // driver.findElement(By.cssSelector("#logo > a")).click();
        //driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]/..")).click();
        presentationSleep(); // For Presentation ONLY
    }

    @Test
    public void checkiMac() throws Exception {
        //
        /*
        * Prepare a test method with the following scenario.
        * Go to https://demo.opencart.com/
        * Select currency Euro.
        * Click on the Desktops and Mac menu.
        * Please check whether the product "iMac" at the price of 111.55 euros is present on the page.
        * You can add Java code as a result or set a reference to the code.
        * */

        // Choose Curency
        driver.findElement(By.xpath("//*[@id='form-currency']/div/a/span")).click();
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.linkText("€ Euro")).click();
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.xpath("//*[@id='narbar-menu']/ul/li[1]/a")).click();
        presentationSleep();

        driver.findElement(By.xpath("//*[@id='narbar-menu']/ul/li[1]/div/div/ul/li[2]/a")).click();
        presentationSleep();

        // Check
        WebElement price = driver.findElement(By.xpath("//*[@id='product-list']/div/form/div/div[2]/div[1]/div/span[1]"));
        Assert.assertTrue(price.getText().contains("111.55€"));
        System.out.println("***contains: " + price.getText());
        presentationSleep(); // For Presentation ONLY
    }
}
