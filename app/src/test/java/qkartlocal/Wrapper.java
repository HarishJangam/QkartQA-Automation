package qkartlocal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wrapper {
    WebDriver driver;

    public Wrapper(WebDriver driver) {
        this.driver = driver;
    }
    
public WebElement find(String path){
    return driver.findElement(By.xpath(path));
}

}
