package tests.day14_ScreenShot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.io.File;
import java.io.IOException;
import java.security.Key;

public class C02_IstenenWebElementScreenShot extends TestBase {
    @Test
    public void aramaTesti() throws IOException {

        // testotomasyon anasayfaya gidin
        driver.get("https:/www.testotomasyonu.com/");

        // aramakutusuna phone yazıp, arama kutusunun screen shot alin
        WebElement aramakutusu = driver.findElement(By.id("global-search"));

        aramakutusu.sendKeys("phone" );

            // 1- ss alacağiniz webelementi locate edip kaydedin
            // 2- ssi kaydedeceğimiz dosyayi olusturun
        File webelementSS = new File("target/webElementScreenShots/aramaKutusu.jpg");

            // 3- webelementi kullanarak ss alın ve gecici dosyaya kaydedin
        File geciciScreenShot = aramakutusu.getScreenshotAs(OutputType.FILE);

            // 4- geciciDosyayi asil dosyaya kaydedin
        FileUtils.copyFile(geciciScreenShot,webelementSS);

        // phone için arama yapin
        aramakutusu.submit();

        // arama sonucunda urun bulunabildiginiz test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unexpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(unexpectedSonucYazisi,actualSonucYazisi);
        ReusableMethods.bekle(2);

        // arama sonuc yazısının screenshot alin

        ReusableMethods.webElementScreenShot(aramaSonucElementi);


        ReusableMethods.bekle(2);
    }
}
