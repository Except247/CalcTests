package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TestNGClass
{
    private WebDriver driver;
    JavascriptExecutor js;
    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("firefox"))
        {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
            driver = new FirefoxDriver(firefoxOptions);
        }else if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
            driver = new ChromeDriver(chromeOptions);
        }
        js = (JavascriptExecutor) driver;
        driver.get("https://www.calculator.net/");
    }

    @Test
    public void test() {
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.cssSelector("div:nth-child(2) > a > img")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.id("calcSearchTerm")).click();
        driver.findElement(By.id("calcSearchTerm")).click();
        driver.findElement(By.id("calcSearchTerm")).sendKeys("Scientific Calculator");
        driver.findElement(By.cssSelector("#calcSearchOut a")).click();
        driver.findElement(By.cssSelector("div:nth-child(1) > .scinm:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(3) > .sciop:nth-child(4)")).click();
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div:nth-child(1) > .scinm:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) > .sciop:nth-child(4)")).click();
        driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(3)")).click();
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();

        assertThat(driver.findElement(By.id("sciOutPut")).getText(), is(" " + 8 * (8 - 3)));

        new Actions(driver).sendKeys(Keys.ESCAPE);

        driver.findElement(By.cssSelector("div:nth-child(4) > .scifunc:nth-child(5)")).click();

        new Actions(driver)
                .sendKeys("56")
                .keyDown(Keys.SHIFT)
                .sendKeys("0")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.DIVIDE)
                .perform();

        driver.findElement(By.cssSelector("div:nth-child(4) > .scifunc:nth-child(4)")).click();

        new Actions(driver)
                .sendKeys("56")
                .keyDown(Keys.SHIFT)
                .sendKeys("0")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.MULTIPLY)
                .keyDown(Keys.SHIFT)
                .sendKeys("9")
                .keyUp(Keys.SHIFT)
                .sendKeys("5")
                .sendKeys(Keys.MULTIPLY)
                .perform();

        driver.findElement(By.cssSelector("div:nth-child(4) > .scifunc:nth-child(3)")).click();

        new Actions(driver)
                .sendKeys("4")
                .keyDown(Keys.SHIFT)
                .sendKeys("0")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.MULTIPLY)
                .sendKeys("10")
                .keyDown(Keys.SHIFT)
                .sendKeys("0")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.ENTER)
                .perform();

        driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();
        double d = Math.log10(56)/Math.log(56)*(5*Math.sqrt(4)*10);
        DecimalFormat df = new DecimalFormat("0.########");
        String outpoutString = df.format(d).replace(",", ".");

        assertThat(driver.findElement(By.id("sciOutPut")).getText(), is(" " + outpoutString));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}