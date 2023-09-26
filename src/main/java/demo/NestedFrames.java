package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

    ChromeDriver driver;

    public NestedFrames() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase07() {
        try {
            // Visit the site "https://the-internet.herokuapp.com/nested_frames"
            driver.get("https://the-internet.herokuapp.com/nested_frames");

            // Switch to the top frame
            WebElement Top = driver.findElement(By.name("frame-top"));
            driver.switchTo().frame(Top);

            // Switch to left frame
            WebElement Left = driver.findElement(By.name("frame-left"));
            driver.switchTo().frame(Left);
            String Text = driver.findElement(By.tagName("body")).getText();
            System.out.println(Text);
            driver.switchTo().defaultContent();
            driver.switchTo().frame(Top);
            
            // Switch to the middle frame
            WebElement middle = driver.findElement(By.name("frame-middle"));
            driver.switchTo().frame(middle);
            Text = driver.findElement(By.tagName("body")).getText();
            System.out.println(Text);
            driver.switchTo().defaultContent();
            driver.switchTo().frame(Top);
            
            // Switch to the right frame
            WebElement right = driver.findElement(By.name("frame-right"));
            driver.switchTo().frame(right);
            Text = driver.findElement(By.tagName("body")).getText();
            System.out.println(Text);
            driver.switchTo().defaultContent();

            // Switch to bottom frame
            WebElement Bottom = driver.findElement(By.name("frame-bottom"));
            driver.switchTo().frame(Bottom);
            Text = driver.findElement(By.tagName("body")).getText();
            System.out.println(Text);
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}