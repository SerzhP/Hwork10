import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingeltonDrv {
    private static WebDriver driver2;

    public static WebDriver getDrvInstance(){
        if (driver2 == null){
            driver2 = new ChromeDriver();
        }
        return driver2;
    }
}
