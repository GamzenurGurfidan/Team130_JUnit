package tests.day05_Annotations_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfterNotasyonu {
    // uc farki test methodunda verilen sayfalara gidin
    // o sayfaya gidildigini test edin ve sayfayı kapatın


    WebDriver driver;

    public void baslangicAyarlariYap(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testOtomasyonuTest(){
        baslangicAyarlariYap();
        driver.get("https://www.testotomasyonu.com/");

        String expectedURL = "https://www.testotomasyonu.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        driver.quit();

    }
    @Test
    public void wisequarterTest(){
        baslangicAyarlariYap();
        driver.get("https://wisequarter.com/");

        String expectedURL = "https://wisequarter.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("WiseQuarter testi PASSED");
        } else System.out.println("WiseQuarter testi FAILED");

        driver.quit();

    }
    @Test
    public void youtubeTest (){
        baslangicAyarlariYap();
        driver.get("https://www.youtube.com/");

        String expectedURL = "https://www.youtube.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("YouTube testi PASSED");
        } else System.out.println("YouTube testi FAILED");

        driver.quit();

    }

}

