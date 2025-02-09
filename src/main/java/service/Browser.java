package service;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class Browser {
    protected static WebDriver driver;

    public static WebDriver initDriver() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream( "src/test/resources/browser.properties"));
        String browserProperty = properties.getProperty("testBrowser");
        System.out.println("browserProperty = " + browserProperty);

        BrowserType browserType = BrowserType.valueOf(browserProperty);
        switch (browserType){
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
                break;
            case YANDEX:
                //указать путь для Яндекс драйвера
                System.setProperty("webdriver.chrome.driver", "C:/users/user/Downloads/yandexdriver-24.12.0.1810-win64/yandexdriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser undefined");
        }
        return driver;
    }
}
