package tests.day13_ExcelOtomasyon;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBase {
    @Test
    public void aramaTesti() throws IOException {
        // Testotomasyon anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // nutella için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonucunda urun bulunamadıgını test edin
        WebElement aramaSonucuElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String expectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucuElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        ReusableMethods.bekle(1);

        // testlerimiz sirasinda istersek tüm sayfanın istersek de bir
        // bir webelementin görüntüsünü kaydedebiliriz
        // Eger tüm sayfa screenshot almak isterseniz

            //1- bir takesScreenShot objesi olusturun ve deger olarak drivera atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

            //2- ScreenShoti kaydedecegimiz bir dosya olusturalim

        File tumSayfaScreenShot = new File("target/tumSayfaScreenShot/tss.jpeg");

            //3- tss objesini kullanarak screenShot alin ve bir file olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

            //4- geciciDosyayi deger olarak asil kaydedilecek file'a kopyalayin

        FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);

        ReusableMethods.bekle(2);
    }
}
