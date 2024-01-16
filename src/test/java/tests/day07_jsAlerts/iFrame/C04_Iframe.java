package tests.day07_jsAlerts.iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.util.List;

public class C04_Iframe extends TestBase {
    @Test
    public void iFrameTesti(){
        // 1- https://testotomasyonu.com/discount adresine gidin
        // 2- Elektronics Products yazisinin gorunur olduğunu test edin
        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        // 4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
        // 5- Fashion yazisinin gorunur olduğunu test edin
        // 6- Sayfayi kapatin

        driver.get("https://testotomasyonu.com/discount");

        // kullanacağımız elementin locateinden %100 emin olmamiza rağmen
        // NoSuchElementException verdi
        // kontrol ettiğimizde kullanacagimiz elementin bir iframe icerisinde oldugunu gorduk
            // 1. adim: geciş yapacağımız iframi lovate etmek

        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));
            // 2. adim: locate ettigimiz iframe'e gecis yapalim
        driver.switchTo().frame(electronicsIframe);
            // 3 adim: iframe icindeki elementleri kullan.

        WebElement electronicsProductsElementi = driver.findElement(By.xpath("//h2[text()='Electronics Products']"));
        Assert.assertTrue(electronicsProductsElementi.isDisplayed());

        WebElement dellIsimElementi = driver.findElement(By.xpath( "//*[text()='DELL Core I3 11th Gen ']"));

        String expectedIsim = "DELL Core I3 11th Gen";
        String actualIsim = dellIsimElementi.getText();

        Assert.assertEquals(expectedIsim,actualIsim);

        // urunler baska bir iframe icinde oldugundan once o iframe'e geciş yapalım
        // ANCAK ustteki testleri sol bolumde farkli bir iframede yapmıştık
        // sagdaki iframe locate etmeye calısmadan once
        // gecis yaptıgı soldaki iframeden anasayfaya donmeliyiz


        driver.switchTo().defaultContent();

        WebElement menSlimFitFrame = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[2]"));

        driver.switchTo().frame(menSlimFitFrame);

        List<WebElement> menSlimFitList = driver.findElements(By.xpath("//*[@class='image-gallery']"));

        List<String> strMenSlimList = ReusableMethods.strListeCevir(menSlimFitList);

        for (int i = 0; i < strMenSlimList.size() ; i++) {

            Assert.assertTrue(strMenSlimList.get(i).contains("Men Slim Fit"));

        }

        // 6- Here are some products yazısının gorunur oldugunu test edin

        WebElement hereAreSomeElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreSomeElementi.isDisplayed());



        WebElement fashion = driver.findElement(By.xpath("//*[text()='Fashion']"));

        Assert.assertTrue(fashion.isDisplayed());


        ReusableMethods.bekle(3);

    }
}
