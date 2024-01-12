package tests.day05_Annotations_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfterNotasyonlari {
    // uc farki test methodunda verilen sayfalara gidin
    // o sayfaya gidildigini test edin ve sayfayı kapatın

    /*
        eger bir classda her methodundan once calısmasını istediginiz kodlar var ise
        bunu saglamak icin @Before notasyonuna sahip bir method olusturabiliriz

        eger bir class da her test methodu calıstıktan sonra calısmasını istedigimiz kodlar var
        bunu saglamak için @After notasyonuna sahip bir method olusturabilir
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("@Before calıstı");

    }

    @After
    public void teardown(){
        System.out.println("@After calıstı");
        driver.quit();
    }

    @Test
    public void testOtomasyonuTest(){

        driver.get("https://www.testotomasyonu.com/");

        String expectedURL = "https://www.testotomasyonu.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");



    }
    @Test
    public void wisequarterTest(){

        driver.get("https://wisequarter.com/");

        String expectedURL = "https://wisequarter.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("WiseQuarter testi PASSED");
        } else System.out.println("WiseQuarter testi FAILED");



    }
    @Test
    public void youtubeTest (){

        driver.get("https://www.youtube.com/");

        String expectedURL = "https://www.youtube.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("YouTube testi PASSED");
        } else System.out.println("YouTube testi FAILED");



    }
}
