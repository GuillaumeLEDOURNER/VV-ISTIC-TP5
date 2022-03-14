import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class HelloSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","tpSelenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
        Random r = new Random();
        System.out.println(allLinks.size());
        int i = r.nextInt(allLinks.size());
        driver.get(allLinks.get(i).getAttribute("href"));
        //allLinks.forEach((v)-> System.out.println(v.getAttribute("href")));
        /*driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));


        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        searchBox.getAttribute("value"); */// => "Selenium"

        driver.quit();
    }
}
