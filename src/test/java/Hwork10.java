import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hwork10 {
    private static WebDriver driverChrome;
private static NgWebDriver ngWebDrv;
    @BeforeClass

    public static void beforeClass(){
    System.setProperty("webdriver.chrome.driver",DriversHwork10.CHROMEDRIVER_PATH);
    driverChrome = SingeltonDrv.getDrvInstance();
    ngWebDrv = new NgWebDriver((JavascriptExecutor) driverChrome);


    }

    @Test
    public  static void T1_CheckBox(){
    driverChrome.get("https://dgotlieb.github.io/Selenium/synchronization.html");
    driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driverChrome.findElement(By.id("checkbox")).isDisplayed();
    driverChrome.findElement(By.id("btn")).click();
    driverChrome.findElement(By.id("message")).isDisplayed();
    }

//1
    @Test
    public static void T2_showHidden() throws InterruptedException {
        driverChrome.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        driverChrome.findElement(By.id("hidden")).click();
        Thread.sleep(5000);
        driverChrome.findElement(By.id("finish1"));

    }
    @Test
    public static void T3_render(){
        driverChrome.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        driverChrome.findElement(By.id("rendered")).click();
        WebDriverWait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
        String output = driverChrome.findElement(By.id("finish2")).getText();
        Assert.assertEquals(output,"This is a new element");
    }
//2
    @Test
    public static void T4_angular()  {
        driverChrome.get("https://dgotlieb.github.io/AngularJS/main.html");
        ngWebDrv.waitForAngularRequestsToFinish();
        driverChrome.findElement(ByAngular.model("firstName")).clear();
        driverChrome.findElement(ByAngular.model("firstName")).sendKeys("Serzh");
        Assert.assertEquals(driverChrome.findElement(By.xpath("/html/body/label[1]/input")).getAttribute("value"),"Serzh");
    }

//3 PageLoadTimeOut is used to say Selenium how long wait for a page to load

//    4
    @Test
    public static void T5_POMConstants() throws InterruptedException {
        driverChrome.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println(driverChrome.findElement(By.id(Constants.button7)).getSize());
        System.out.println(driverChrome.findElement(By.id("six")).isDisplayed());
        CalculateFormula.pressEight();
//        Thread.sleep(2000);
        CalculateFormula.pressAdd();
        CalculateFormula.pressEight();
        CalculateFormula.pressEqual();
        String expectedResult = "16";
        Assert.assertEquals(expectedResult,CalculateFormula.getResult());


    }


    @AfterClass

    public static void afterClass(){
        driverChrome.close();

    }
}
