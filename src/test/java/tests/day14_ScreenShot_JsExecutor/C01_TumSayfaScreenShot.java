package tests.day14_ScreenShot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C01_TumSayfaScreenShot extends TestBase {

    @Test
    public void aramaTesti (){

        // testotomasyon anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/");

        // dogru sayfaya gittiginizi test edin
        String expectedURL = "https://www.testotomasyonu.com/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualURL);

        // screen shot alin
        ReusableMethods.tumSayfaScreenShot(driver);

        // phone için arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildiginiz test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unexpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(unexpectedSonucYazisi,actualSonucYazisi);
        ReusableMethods.bekle(2);

        // screenshot alin
        ReusableMethods.tumSayfaScreenShot(driver,"aramaSonucuSS");

        ReusableMethods.bekle(2);

    }

}
