package trialTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseClass2;

import java.time.Duration;

public class ActionClassUse extends BaseClass2 {
    // note every method of the action class return the action class object. it forms method chaining struccture
private static WebDriver driver;

//@Test
    public static void leftClick(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo/trigger-left-click.html");
        WebElement leftClickButton=driver.findElement(By.xpath("//span[text()='left click me']"));
        Actions act=new Actions(driver);
        act.contextClick(leftClickButton).perform();
    }
  //  @Test
    public static void rightClick(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/buttons/");
        WebElement rightClickButton=driver.findElement(By.id("rightClickBtn"));
        Actions act=new Actions(driver);
        act.contextClick(rightClickButton).perform();
    }
   // @Test
    public static void doubleClick(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/buttons/");
        WebElement doubleClickButton=driver.findElement(By.id("doubleClickBtn"));
        Actions act=new Actions(driver);
        act.doubleClick(doubleClickButton).perform();

    }

   // @Test
    public static void dragAndDrop1(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement dragme=driver.findElement(By.id("box6"));
        WebElement dropMe=driver.findElement(By.id("box106"));
        Actions act=new Actions(driver);
        act.dragAndDrop(dragme,dropMe).perform();
    }
  //  @Test
    public static void dragAndDrop2(){ // drag and drop images
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(" https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement iframe1=driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iframe1);
        WebElement dragme=driver.findElement(By.xpath("(//li[@class='ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle'])[1]"));
        WebElement dropMe=driver.findElement(By.xpath("//div[@id='trash']"));

        Actions act=new Actions(driver);
        act.dragAndDrop(dragme,dropMe).perform();
    }
@Test
    public static void mouseOverAction(){
        driver= BaseClass2.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.flipkart.com/");
    Assert.assertEquals(driver.getTitle(),"sdefe");

    }
}
