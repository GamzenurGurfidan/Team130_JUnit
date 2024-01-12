package tests.day05_Annotations_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {

    WebDriver driver;

    @After
    public void teardown(){
        driver.quit();
    }


    @Test
    public void test01(){

        // gerekli ayarlamaları yapip
        // testotomasyonu sayfasınagidin
        // sayfaya gidebildiginizi test edin

        /*
            JUnitin consoleda verdiği passed/failed raporu
            if elsein sonucuna bakmaz

            Junit
                - kod sorusuz çalısıp bittiyse PASSED
                - kod calısırken exception olursursa FAILED olarak degerlendirir
         */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com/");

        String expectedURL = "https://www.testotomasyonu.com";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("1. PASSED");
        } else {
            System.out.println("1. FAILED");
            throw new RuntimeException();
            // exception fırlatarak, if ile kontrol ettigimiz test failed oldugunda
            // JUnit in de failed olmasini saglayabiliriz
        }

        driver.quit();

    }
}
