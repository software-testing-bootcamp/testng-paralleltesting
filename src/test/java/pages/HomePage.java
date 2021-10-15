package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public  void searchByKeyword(WebDriver driver, String searchKey) throws InterruptedException {
        driver.get("https://www.testrelic.com/bugshop/");
        Thread.sleep(1000);
        WebElement searchElement = driver.findElements(By.tagName("input")).get(1);
        searchElement.click();
        searchElement.sendKeys(searchKey);
        searchElement.sendKeys(Keys.ENTER);
    }
}
