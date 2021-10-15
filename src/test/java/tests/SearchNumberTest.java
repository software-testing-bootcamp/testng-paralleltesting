package tests;

import managers.DriverManager;
import org.testng.annotations.*;
import pages.HomePage;

import java.net.MalformedURLException;

public class SearchNumberTest extends DriverManager {
    HomePage homePage = new HomePage();

    @Parameters("browser")
    @BeforeClass
     void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @Test
     void searchNumTest1() throws InterruptedException {
        homePage.searchByKeyword(driver, "1");
    }

    @Test
     void searchNumTest2() throws InterruptedException {
        homePage.searchByKeyword(driver, "2");
    }

    @AfterClass
     void afterClass() {
        driver.quit();
    }
}
