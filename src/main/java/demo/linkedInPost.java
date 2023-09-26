package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class linkedInPost
{
    ChromeDriver driver;
    public linkedInPost()
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

    public void testCase03() throws InterruptedException {
    
            // Sign in to LinkedIn https://www.linkedin.com/
            driver.get("https://www.linkedin.com/");
            Thread.sleep(3000);
            WebElement emailField = driver.findElement(By.id("session_key"));
            WebElement passwordField = driver.findElement(By.id("session_password"));
            WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));

            // Replace "your_email" and "your_password" with your actual LinkedIn credentials
            emailField.sendKeys("rajeshkcse000@gmail.com");
            passwordField.sendKeys("Password");
            signInButton.click();
            Thread.sleep(3000); 

            // Create a post with an image or video
            WebElement startPostButton = driver.findElement(By.xpath("//span[text()='Media']"));
            startPostButton.click();
            Thread.sleep(3000);

     try {
             WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
             Thread.sleep(3000);
            
            // Upload image (you will need to replace the path with the actual file path)
            String Pic = "C:\\Users\\user\\Desktop\\Automation.jpeg";
            uploadInput.sendKeys(Pic);
            Thread.sleep(5000);

            // Click next button
            WebElement NextButton=driver.findElement(By.xpath("//span[text()='Next']"));
            NextButton.click();

            // Click on the "Post" button
            WebElement postButton = driver.findElement(By.xpath("//span[text()='Post']"));
            postButton.click();
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}