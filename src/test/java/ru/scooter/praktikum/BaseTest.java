package ru.scooter.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @Before
    public void setUp() {

        //   Браузер Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Браузер Firefox
//        System.setProperty("webdriver.gecko.driver", "D:\\Programs\\Chromedriver\\ff__137.0.1__win\\firefox__137.0.1__win\\geckodriver_36.0.exe");
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
//        driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

}