package qkartlocal.pages;

import org.openqa.selenium.WebDriver;

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
    
}
