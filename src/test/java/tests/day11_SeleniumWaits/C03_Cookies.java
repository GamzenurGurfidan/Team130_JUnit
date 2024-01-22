package tests.day11_SeleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- amazon anasayfaya gidin
        driver.get("https://www.walmart.com");

        ReusableMethods.bekle(1);

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSeti =driver.manage().getCookies();

        int siraNo = 1;
        for (Cookie each : cookieSeti) {

            System.out.println(siraNo + "---- " +each);
            siraNo++;
        }


        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSeti.size()>5);

        //4- ismi mobileweb olan cookie degerinin 0 oldugunu test edin
        Assert.assertEquals(driver.manage().getCookieNamed("mobileweb").getValue(),"0");

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yenicookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yenicookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        System.out.println("--------------------------------------------------");
        cookieSeti = driver.manage().getCookies();

        siraNo = 1;
        for (Cookie each : cookieSeti) {

            System.out.println(siraNo + "---- " +each);
            siraNo++;
        }

        Assert.assertEquals(driver.manage().getCookieNamed("en sevdigim cookie").getValue(),"cikolatali");

        //7- ismi mobileweb olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("mobileweb");
        System.out.println("---------------------------");
        cookieSeti = driver.manage().getCookies();

        siraNo = 1;
        boolean mobilWebVarmi = false;
        for (Cookie each : cookieSeti) {

            System.out.println(siraNo + "---- " +each);
            siraNo++;

            if (each.getName().equals("mobileweb")){
                mobilWebVarmi = true;
            }
        }

        // eger mobileWeb silindiyse False olmali
        Assert.assertFalse(mobilWebVarmi);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookieSeti = driver.manage().getCookies();

        Assert.assertTrue(cookieSeti.isEmpty());

    }
}
