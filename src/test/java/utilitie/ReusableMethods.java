package utilitie;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods extends TestBase{

    public static void bekle (int saniye) {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> strListeCevir (List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement each : webElementList) {

            stringList.add(each.getText());
        }

     return stringList ;
    }

    public static void titleIleWindowDegistir(String hedefTitle, WebDriver driver){

        Set<String> whdSeti = driver.getWindowHandles();

        for (String eachWhd : whdSeti
        ) {
            driver.switchTo().window(eachWhd);

            String oldugumuzSayfaTitle = driver.getTitle();

            if (oldugumuzSayfaTitle.equals(hedefTitle)){
                break;
            }
        }

    }

    public static void tumSayfaScreenShot(WebDriver driver)  {

        //1- bir takesScreenShot objesi olusturun ve deger olarak drivera atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

        //2- ScreenShoti kaydedecegimiz bir dosya olusturalim
        // SS ismini unique yapabilmek için timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMdd.HHmmss");
        String timeStamp = ldt.format(zamanFormati);

        File tumSayfaScreenShot = new File("target/tumSayfaScreenShot/tumSayfa" + timeStamp + ".jpeg");

        //3- tss objesini kullanarak screenShot alin ve bir file olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4- geciciDosyayi deger olarak asil kaydedilecek file'a kopyalayin

        try {

            FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaScreenShot(WebDriver driver,String resimAdi)  {

        //1- bir takesScreenShot objesi olusturun ve deger olarak drivera atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

        //2- ScreenShoti kaydedecegimiz bir dosya olusturalim

        File tumSayfaScreenShot = new File("target/tumSayfaScreenShot/"+ resimAdi +".jpeg");

        //3- tss objesini kullanarak screenShot alin ve bir file olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4- geciciDosyayi deger olarak asil kaydedilecek file'a kopyalayin

        try {

            FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementScreenShot(WebElement webElement){

        // 1- ss alacağiniz webelementi locate edip kaydedin
        // 2- ssi kaydedeceğimiz dosyayi olusturun
        // SS ismini unique yapabilmek için timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMdd.HHmmss");
        String timeStamp = ldt.format(zamanFormati);

        File webelementSS = new File("target/webElementScreenShots/webElement" + timeStamp + ".jpg");

        // 3- webelementi kullanarak ss alın ve gecici dosyaya kaydedin
        File geciciScreenShot = webElement.getScreenshotAs(OutputType.FILE);

        // 4- geciciDosyayi asil dosyaya kaydedin

        try {
            FileUtils.copyFile(geciciScreenShot,webelementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void webElementScreenShot(WebElement webElement,String screenShotIsim){

        // 1- ss alacağiniz webelementi locate edip kaydedin
        // 2- ssi kaydedeceğimiz dosyayi olusturun
        // SS ismini unique yapabilmek için timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMdd.HHmmss");
        String timeStamp = ldt.format(zamanFormati);

        File webelementSS = new File("target/webElementScreenShots/" + screenShotIsim + "." + timeStamp + ".jpg");

        // 3- webelementi kullanarak ss alın ve gecici dosyaya kaydedin
        File geciciScreenShot = webElement.getScreenshotAs(OutputType.FILE);

        // 4- geciciDosyayi asil dosyaya kaydedin

        try {
            FileUtils.copyFile(geciciScreenShot,webelementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
