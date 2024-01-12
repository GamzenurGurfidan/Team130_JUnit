package tests.day05_Annotations_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AssertionMethodlari {

    // gerekli ayarlamaları yapip
    // testotomasyonu sayfasına gidin
    // sayfaya gidebildiginizi test edin

    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com");

        String expectedURL = "https://www.testotomasyonu.com/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualURL);

    }

}
