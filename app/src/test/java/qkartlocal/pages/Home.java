package qkartlocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class Home {
    WebDriver driver=null;
    String url="https://crio-qkart-frontend-qa.vercel.app/";
    public Home(WebDriver driver){
        this.driver=driver;
    }

    public void navigateToHomePage(){
        String currentUrl=driver.getCurrentUrl();
        if(!currentUrl.equals(url)){
            driver.get(url);
        }
    }
    public void searchFunctionality(String product){
        WebElement searchBar=driver.findElement(By.xpath("//input[@name='search']"));
        searchBar.clear();
        searchBar.sendKeys(product);
    }
    public List<WebElement> getSearchList(){
        List<WebElement>list=new ArrayList<>();
        list=driver.findElements(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root card css-s18byi']"));
        return list;
    }

    public void addToCart(String product) throws InterruptedException{
        List<WebElement>list=new ArrayList<>();
        list=driver.findElements(By.xpath("//div[contains(@class,'css-sycj1h')]"));
        for(WebElement we:list){
            String str=we.getText();
            if(str.contains(product));
            we.findElement(By.xpath(".//button[text()='Add to cart']")).click();
            Thread.sleep(2000);
        }

    }

    
    
}
