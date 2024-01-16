package tests.day07_jsAlerts.iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C02_JavaScriptAlerts extends TestBase {

    // 1. Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 1.alert’e tiklayin
    // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
    // - OK tusuna basip alert’i kapatin

    @Test
    public void birinciAlertTesti() {

        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        String actualAlertYAzi = driver.switchTo().alert().getText();
        String expectedAlertYazi = "I am a JS Alert";
        Assert.assertEquals(expectedAlertYazi, actualAlertYAzi);
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);
    }

    //2.Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 2.alert’e tiklayalim
    // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin

    @Test
    public void ikinciAlertTesti() {
        driver.get("https://testotomasyonu.com/javascriptAlert");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        ReusableMethods.bekle(1);
    }


    //3.Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 3.alert’e tiklayalim
    // - Cikan prompt ekranina “Abdullah” yazdiralim
    // - OK tusuna basarak alert’i kapatalim
    // - Cikan sonuc yazisinin Abdullah icerdigini test edelim

    @Test
    public void ucuncuAlertTesti() {
        driver.get("https://testotomasyonu.com/javascriptAlert");
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedSonucYazisi2 = "Abdullah";
        String actualSonucYazisi2 = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi2.contains(expectedSonucYazisi2));
        ReusableMethods.bekle(1);
    }
}
