package qkartlocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.sql.Timestamp;
// import org.openqa.selenium.devtools.v125.media.model.Timestamp;

public class Register {
    WebDriver driver=null;
    public static String lastGeneratedusr=null;
    String url="https://crio-qkart-frontend-qa.vercel.app/register";
    public Register(WebDriver driver){
        this.driver=driver;
    }

    public void navigateToRegisterPage(){
        String currentUrl=driver.getCurrentUrl();
        if(!currentUrl.equals(url)){
            driver.get(url);
        }
    }

    public boolean newRegister(String username,String password,boolean makeDynamic) throws InterruptedException{
        WebElement usr=driver.findElement(By.xpath("//input[@id='username']"));
        if(makeDynamic){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            username=username+"_"+String.valueOf(timestamp.getTime());
        }
        usr.clear();
        usr.sendKeys(username);
        // Thread.sleep(2000);
         WebElement password_txt_box = this.driver.findElement(By.id("password"));
        // String test_data_password = password;

        // Enter the Password value
        password_txt_box.clear();
        password_txt_box.sendKeys(password);

        WebElement confirm_password_txt_box = this.driver.findElement(By.id("confirmPassword"));

        // Enter the Confirm Password Value
        // this.clearTextbox(confirm_password_txt_box);
        confirm_password_txt_box.clear();
        confirm_password_txt_box.sendKeys(password);
        WebElement registerBtn=driver.findElement(By.xpath("//button[text()='Register Now']"));
        registerBtn.click();
        Thread.sleep(5000);
        String str=driver.getCurrentUrl();
        if(str.contains("login")){
            lastGeneratedusr=username;
            return true;
        }
        return false;

    }

}
