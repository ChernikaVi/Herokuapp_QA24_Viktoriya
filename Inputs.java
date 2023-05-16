import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Inputs {

    private static final String URL = "http://the-internet.herokuapp.com/inputs";
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void InputsTest() {
        WebElement inputWindow = driver.findElement(By.tagName("input"));
        inputWindow.sendKeys("1");

        WebElement result = driver.findElement(By.tagName("input"));
        Assert.assertEquals(result.getAttribute("value"), "1");
        inputWindow.sendKeys(Keys.ARROW_UP);

        WebElement arrowUp = driver.findElement(By.tagName("input"));
        Assert.assertEquals(arrowUp.getAttribute("value"), "2");
        inputWindow.sendKeys(Keys.ARROW_DOWN);

        WebElement arrowDown = driver.findElement(By.tagName("input"));
        Assert.assertEquals(arrowDown.getAttribute("value"), "1");
        inputWindow.clear();
        inputWindow.sendKeys("vika");

        WebElement lettersResult = driver.findElement(By.tagName("input"));
        Assert.assertEquals(lettersResult.getAttribute("value"), "");
    }
}
