# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer

## Code 
```java=
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class HelloSelenium {


    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","tpSelenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        List<WebElement> allLinks;
        int cpt = 10;
        int randomInt = 0;
        String url= "";
        Random r = new Random();

        while(cpt > 0){
            allLinks = driver.findElements(By.xpath("//a[@href]"));
            randomInt = r.nextInt(allLinks.size());
            url = allLinks.get(randomInt).getAttribute("href");
            System.out.println("Url "+cpt+" : "+url);
            driver.get(url);
            cpt--;

        }
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("image.jpg");
        FileUtils.copyFile(SrcFile, DestFile);
        driver.quit();
    }
}
```

## Screenshot
![](https://i.imgur.com/mYhUJXK.png)

## Url path from https://www.wikipedia.org/

Url 10 : https://te.wikipedia.org/
Url 9 : https://fo.wikipedia.org/wiki/Fors%C3%AD%C3%B0a
Url 8 : https://sw.wikipedia.org/wiki/Mwanzo
Url 7 : https://rw.wikipedia.org/wiki/Intangiriro
Url 6 : https://es.wikipedia.org/wiki/
Url 5 : https://nl.wikipedia.org/wiki/
Url 4 : https://atj.wikipedia.org/wiki/Otitikowin
Url 3 : https://olo.wikipedia.org/wiki/Pi%C3%A4sivu
Url 2 : https://olo.wikipedia.org/wiki/Kategourii:Kazvatus_da_opastus
Url 1 : https://creativecommons.org/licenses/by-sa/3.0/
