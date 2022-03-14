import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
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
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File("image.jpg");
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);


        driver.quit();
    }
}
