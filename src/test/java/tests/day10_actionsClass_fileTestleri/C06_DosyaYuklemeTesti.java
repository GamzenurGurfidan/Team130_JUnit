package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C06_DosyaYuklemeTesti extends TestBase {
    @Test
    public void dosyaYuklemeTesti(){

        // C:\Users\Gamzenur\Desktop

        //  //https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.


        /*
            Selenium WebDriver ile calisir ve WebSayfalarinda istenen gorevleri yapar
            Ancak kendi bilgisayarimizdaki dosya yapisi icerisinde
            dosya secmek icin click YAPAMAZ

            1- upload yapacagimiz dosyanin, dosya yolunu kaydedin
            2- upload yapacagimiz sitedeki chooseFile butonunu locate edip kaydedin
            3- chooseFileButonElementi.sendKeys(yuklenecekDosyaninDosyaYolu)
         */

        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Desktop\\foto.png";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement dosyaYuklendiYazisi = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(dosyaYuklendiYazisi.isDisplayed());

        System.out.println(dosyaYuklendiYazisi.getText());



        WebElement fileUploaded = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));

        Assert.assertTrue(fileUploaded.isDisplayed());

        System.out.println(fileUploaded.getText());

        ReusableMethods.bekle(3);

    }
}
