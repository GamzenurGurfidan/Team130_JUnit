package tests.day11_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilitie.ReusableMethods;

import java.time.Duration;

public class C01_ImplicitlyWait_ExplicitWait {
    // Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    // Iki metod icin de asagidaki adimlari test edin.
    // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 2. Remove butonuna basin.
    // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    // 4. Add buttonuna basin
    // 5. It’s back mesajinin gorundugunu test edin

    WebDriver driver;

    @Test
    public void implicitWaitTest(){

        // Implicit wait'in gorevini ve isleyisini daha iyi anlayabilmek icin
        // TestBase class'da yaptigimiz ayarlari burada yapalim

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();


        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi = driver.findElement(By.id("message"));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        // 4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 5. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi = driver.findElement(By.id("message"));

        Assert.assertTrue(itsBackElementi.isDisplayed());


        driver.quit();
    }

    @Test
    public void explicitWaitTesti(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // implicitlyWait süğresini 1 saniyeye indirmemizin sebebi
        // tolere edemeyecegi durumlar,n olusmasi
        // ve bu durumlari explicitWait ile nasil asacagımızı göstermek

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        // impilicitlyWaitin tolere edemedigi durumlarda
        // expilitcitlyWait için WebDriverWait objesi olustururuz

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

        /*
        wait objesine bir elemenı bekletmek istedgimizde iki durum karsımıza cıkar

            1- uzerinde calıstıgımız webElement locate edilebiliyorsa
            once locate edip, sonra wait objesine istedigimiz durum gerceklesene kadar
            locate edilmş olan webElementi beklemesini soyleyebiliriz

            2- belirli bir zaman sonra hangi locater ile locate edebileceğimizi bildigimiz
            ama henuz gorunmedigi icin locate edemedigimiz webElementlerde
            bekleme ve locate birlikte yapabiliriz

            WebElement itsGoneElementi = driver.findElement(By.id("message"));

            wait.until(ExpectedConditions.visibilityOf(itsGoneElementi));

         */


        WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        // 4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 5. It’s back mesajinin gorundugunu test edin
        // WebElement itsBackElementi = driver.findElement(By.id("message"));

        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));


        Assert.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();
    }
}
