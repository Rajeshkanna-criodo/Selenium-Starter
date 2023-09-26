package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

 
 ChromeDriver driver;
    public Amazon()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts();
        
    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }    
     public void testCase05(){ 

        try {
            // Open Google and search for "amazon"
            driver.get("https://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("amazon");
            searchBox.sendKeys(Keys.RETURN);

            // Check if "amazon.in" or "amazon.com" is in the search results
            boolean  result =driver.findElement(By.xpath("//a[contains(@href,'amazon.in') or contains(@href,'amazon.com')]")).isDisplayed();
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}