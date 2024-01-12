package tests.day05_Annotations_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_BeforeClass_AfterClass {
    // uc test methodu olusturuo asagıdaki gorevleri tamamlayınız
    // 1- Testotomasyonu sayfasına gidip sayfaya gittigimiz test edin
    // 2- phone icin arama yapip, urun bulunabildigini test edin
    // 3- ilk ürüne tıklayip, urun acıklamasında case sensitive olmadan phone gectigini test edin

    /*
        Eger baslangıc ayarlarının en basta sadece bir kere yapılamsını
        test methodlarını bittikten sonra da
        bitis ayarlarının yaoılmasını istiyorsanız

        @befor ve @After yerine
        @befroreclass ve @AfterClass kullanırız

        Onemli NOT : @before class ve @afterclass kullanan methodlar sadece static olmak ZORUNDADIR
     */


    static WebDriver driver;
    List<WebElement> bulunanUrunlerListesi;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01() {
        // 1- Testotomasyonu sayfasına gidip sayfaya gittigimiz test edin
        driver.get("https://www.testotomasyonu.com/");

        String expectedURL = "https://www.testotomasyonu.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("TestOtomasyonu PASSED");
        } else System.out.println("TestOtomasyonu FAILED");

    }

    @Test
    public void test02() {
        // 2- phone icin arama yapip, urun bulunabildigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        bulunanUrunlerListesi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        int actualUrunSayisi = bulunanUrunlerListesi.size();

        if (actualUrunSayisi > 0){
            System.out.println("Urun bulma testi PASSED");
        } else System.out.println("Urun bulma testi FAILED");


    }

    @Test
    public void test03() throws InterruptedException {
        // 3- ilk ürüne tıklayip, urun acıklamasında case sensitive olmadan phone gectigini test edin
        bulunanUrunlerListesi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Thread.sleep(2000);

        bulunanUrunlerListesi.get(0).click();

        WebElement urunAciklamaElementi = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedIcerik = "phone";
        String actualAciklamaKucukHarf = urunAciklamaElementi.getText().toLowerCase();

        if (actualAciklamaKucukHarf.contains(expectedIcerik)){
            System.out.println("ilk urun testi PASSED");
        } else System.out.println("ilk urun testi FAILED");

    }
}
