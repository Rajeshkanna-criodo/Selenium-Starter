package demo;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class IMDBrating {

    ChromeDriver driver;

    public IMDBrating() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase06() {
        try {
            // Visit the site "https://www.imdb.com/chart/top"
            driver.get("https://www.imdb.com/chart/top");

            // Get the highest rated movie
            WebElement highestRatedMovie = driver.findElement(By.xpath(
                    "//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
            String highestRatedMovieTitle = highestRatedMovie.getText();
            System.out.println("Highest Rated Movie: " + highestRatedMovieTitle);

            // Get the total number of movies
            List<WebElement> movieRows = driver
                    .findElements(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li"));
            int totalMovies = movieRows.size();
            System.out.println("Total Movies: " + totalMovies);

            // Get the oldest movie
            driver.findElement(By.xpath("//*[@id='sort-by-selector']")).click();

            // Click the release date
            WebElement Releasedate = driver.findElement(By.xpath("//*[@id='sort-by-selector']/option[4]"));
            Releasedate.click();
            Thread.sleep(3000);

            // Click the selector swap button
            WebElement swap = driver.findElement(By.xpath("//button[@id='swap-sort-order-button']"));
            swap.click();
            WebElement oldest = driver.findElement(By.xpath(
                    "//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));

            String oldestMovieTitle = oldest.getText();
            System.out.println("Oldest Movie: " + oldestMovieTitle);

            // Get the most recent movie
            swap.click();
            WebElement recentMovie = driver.findElement(By.xpath(
                    "//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
            String recentMovieTitle = recentMovie.getText();
            System.out.println("Most Recent Movie: " + recentMovieTitle);

            // Get the movie with the most user ratings
            swap.click();
            WebElement Ranking = driver.findElement(By.xpath("//*[@id='sort-by-selector']/option[2]"));
            Ranking.click();
            Thread.sleep(3000);
            WebElement mostRatedMovie = driver.findElement(By.xpath(
                    "//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
            String mostRatedMovieTitle = mostRatedMovie.getText();
            System.out.println("Movie with Most User Ratings: " + mostRatedMovieTitle);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}