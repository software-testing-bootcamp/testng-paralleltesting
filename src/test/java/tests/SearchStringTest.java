package tests;

import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class SearchStringTest extends DriverManager {
    private WebElement searchElement;

    @Parameters("browser")
    @BeforeClass
     void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @Test
     void searchStrTest1() throws InterruptedException {
        driver.get("https://www.testrelic.com/bugshop/");
        Thread.sleep(1000);
        searchElement = driver.findElements(By.tagName("input")).get(1);
        searchElement.click();
        searchElement.sendKeys("A");
        searchElement.sendKeys(Keys.ENTER);
    }

    @Test
     void searchStrTest2() throws InterruptedException {
        driver.get("https://www.testrelic.com/bugshop/");
        Thread.sleep(1000);
        searchElement = driver.findElements(By.tagName("input")).get(1);
        searchElement.click();
        searchElement.sendKeys("B");
        searchElement.sendKeys(Keys.ENTER);
    }

    @AfterClass
     void afterClass() {
        driver.quit();
    }
}
