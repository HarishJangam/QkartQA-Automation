package qkartlocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {    
    WebDriver driver=null;
    String url="https://crio-qkart-frontend-qa.vercel.app/login";
    public Login(WebDriver driver){
        this.driver=driver;
    }
    
    public void navigateToLoginPage(){
        String getCurrentUrl=driver.getCurrentUrl();
        if(!getCurrentUrl.equals(url)){
            driver.get(url);
        }
    }

    public boolean newLogin(String username,String password) throws InterruptedException{
        boolean status=false;
        WebElement usr=driver.findElement(By.xpath("//input[@id='username']"));
        usr.clear();
        usr.sendKeys(username);
        // Thread.sleep(2000);
         WebElement password_txt_box = this.driver.findElement(By.id("password"));
        // String test_data_password = password;

        // Enter the Password value
        password_txt_box.clear();
        password_txt_box.sendKeys(password);

        WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Login to QKart']"));
        loginBtn.click();
        Thread.sleep(5000);
        status=verifyLogin(username);
        return status;

    }
    public boolean verifyLogin(String username){
        WebElement userNameField=driver.findElement(By.xpath("//p[@class='username-text']"));
        String str=userNameField.getText();
        // System.out.println("username"+str);
        if(str.equals(username)){
            return true;
        }
        return false;
    }
}
