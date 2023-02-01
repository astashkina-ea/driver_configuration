import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //headless - режим
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void close() {
        if (driver != null)
            driver.quit();
    }
}