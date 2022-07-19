import org.openqa.selenium.By;

public class CalculateFormula {
    public static void pressEight(){
        SingeltonDrv.getDrvInstance().findElement(By.id("eight")).click();
    }
    public static void pressAdd(){
        SingeltonDrv.getDrvInstance().findElement(By.id("add")).click();
    }
    public static void pressEqual(){
        SingeltonDrv.getDrvInstance().findElement(By.id("equal")).click();

    }
    public static String getResult(){
        return SingeltonDrv.getDrvInstance().findElement(By.id("screen")).getText();

    }
}
