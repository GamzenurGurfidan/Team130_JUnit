package tests.day06_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BestbuyAssertions {

    // ○ https://www.bestbuy.com/ Adresine gidin
    // ○ farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void urlTesti(){
        String unexpectedURL = "https://www.bestbuy.com/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(unexpectedURL,actualURL);
    }

    @Test
    public void titleTesti(){
        String expectedIcerik = "Rest";
        String actualIcerik = driver.getTitle();

        Assert.assertFalse(actualIcerik.contains(expectedIcerik));

    }

    @Test
    public void logoTesti(){
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());

    }

    @Test
    public void francaLinkTest(){
        WebElement franciaLinkElementi = driver.findElement(By.xpath("//*[text()='Français']"));

        Assert.assertTrue(franciaLinkElementi.isDisplayed());

    }


}
