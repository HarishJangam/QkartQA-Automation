package qkartlocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchProduct {
    WebElement parentElement;
    public SearchProduct(WebElement parentElement){
        this.parentElement=parentElement;
    }
    public void addToCart() throws InterruptedException{
        WebElement btn=parentElement.findElement(By.xpath("./button[text()='Add to cart']"));
        btn.click();
        Thread.sleep(2000);
    }
}
