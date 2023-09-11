package test;

import org.junit.After;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
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
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        js = (JavascriptExecutor) driver;
        driver.get("https://www.calculator.net/");
    }

    @Test
    public void test() {
        // Test name: Test_summ
        // Step # | name | target | value
        // 1 | open | / |
        // 2 | setWindowSize | 1054x808 |
        driver.manage().window().setSize(new Dimension(1054, 808));
        // 3 | click | css=div:nth-child(2) > a > img |

        driver.findElement(By.cssSelector("div:nth-child(2) > a > img")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.id("calcSearchTerm")).click();
        // 5 | click | id=calcSearchTerm |
        driver.findElement(By.id("calcSearchTerm")).click();
        // 6 | type | id=calcSearchTerm | Scientific Calculator
        driver.findElement(By.id("calcSearchTerm")).sendKeys("Scientific Calculator");
        // 7 | click | css=#calcSearchOut a |
        driver.findElement(By.cssSelector("#calcSearchOut a")).click();
        // 4 | click | linkText=Scientific Calculator |
        //driver.findElement(By.linkText("Scientific Calculator")).click();
        // 5 | click | css=div:nth-child(1) > .scinm:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(1) > .scinm:nth-child(2)")).click();
        // 6 | click | css=div:nth-child(3) > .sciop:nth-child(4) |
        driver.findElement(By.cssSelector("div:nth-child(3) > .sciop:nth-child(4)")).click();
        // 7 | click | css=div:nth-child(5) > .scifunc:nth-child(1) |
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(1)")).click();
        // 8 | click | css=div:nth-child(1) > .scinm:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(1) > .scinm:nth-child(2)")).click();
        // 9 | click | css=div:nth-child(2) > .sciop:nth-child(4) |
        driver.findElement(By.cssSelector("div:nth-child(2) > .sciop:nth-child(4)")).click();
        // 10 | click | css=div:nth-child(3) > .scinm:nth-child(3) |
        driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(3)")).click();
        // 11 | click | css=div:nth-child(5) > .scifunc:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(2)")).click();
        // 12 | click | css=.scieq:nth-child(4) |
        driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();

        assertThat(driver.findElement(By.id("sciOutPut")).getText(), is(" " + 8 * (8 - 3)));
        // 13 | click | css=.scieq:nth-child(3) |
        driver.findElement(By.cssSelector(".scieq:nth-child(3)")).click();
        // 14 | click | css=div:nth-child(4) > .scifunc:nth-child(5) |
        driver.findElement(By.cssSelector("div:nth-child(4) > .scifunc:nth-child(5)")).click();
        // 6 | click | css=div:nth-child(2) > .scinm:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
        // 7 | click | css=div:nth-child(2) > .scinm:nth-child(3) |
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(3)")).click();
        // 8 | click | css=div:nth-child(5) > .scifunc:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(2)")).click();
        // 9 | click | css=div:nth-child(4) > .sciop:nth-child(4) |
        driver.findElement(By.cssSelector("div:nth-child(4) > .sciop:nth-child(4)")).click();
        // 10 | click | css=div:nth-child(4) > .scifunc:nth-child(4) |
        driver.findElement(By.cssSelector("div:nth-child(4) > .scifunc:nth-child(4)")).click();
        // 11 | click | css=div:nth-child(2) > .scinm:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
        // 12 | click | css=div:nth-child(2) > .scinm:nth-child(3) |
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(3)")).click();
        // 13 | click | css=div:nth-child(5) > .scifunc:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(2)")).click();
        // 14 | click | css=div:nth-child(3) > .sciop:nth-child(4) |
        driver.findElement(By.cssSelector("div:nth-child(3) > .sciop:nth-child(4)")).click();
        // 15 | click | css=div:nth-child(5) > .scifunc:nth-child(1) |
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(1)")).click();
        // 16 | click | css=div:nth-child(2) > .scinm:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
        // 17 | click | css=div:nth-child(4) > .scifunc:nth-child(3) |
        driver.findElement(By.cssSelector("div:nth-child(4) > .scifunc:nth-child(3)")).click();
        // 18 | click | css=div:nth-child(2) > .scinm:nth-child(1) |
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(1)")).click();
        // 19 | click | css=div:nth-child(5) > .scifunc:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(2)")).click();
        // 20 | click | css=div:nth-child(3) > .sciop:nth-child(4) |
        driver.findElement(By.cssSelector("div:nth-child(3) > .sciop:nth-child(4)")).click();
        // 21 | click | css=div:nth-child(3) > .scinm:nth-child(1) |
        driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(1)")).click();
        // 22 | click | css=div:nth-child(4) > .scinm:nth-child(1) |
        driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();
        // 23 | click | css=div:nth-child(5) > .scifunc:nth-child(2) |
        driver.findElement(By.cssSelector("div:nth-child(5) > .scifunc:nth-child(2)")).click();
        // 24 | click | css=.scieq:nth-child(4) |
        driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();
        double d = Math.log10(56)/Math.log(56)*(5*Math.sqrt(4)*10);
        DecimalFormat df = new DecimalFormat("0.########");
        String outpoutString = df.format(d).replace(",", ".");

        //Math.log10(56)/Math.log(56)*(5*Math.sqrt(4)*10)

        assertThat(driver.findElement(By.id("sciOutPut")).getText(), is(" " + outpoutString));
        // 31 | close |  |
        driver.close();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}