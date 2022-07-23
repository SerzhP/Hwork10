import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingeltonDrv {
    private static WebDriver driver2;

    public static WebDriver getDrvInstance(){
        if (driver2 == null){
            System.setProperty("webdriver.chrome.driver",DriversHwork10.CHROMEDRIVER_PATH);
            driver2 = new ChromeDriver();
        }
        return driver2;
    }
}
