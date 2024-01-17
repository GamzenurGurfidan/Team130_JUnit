package utilitie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


}
