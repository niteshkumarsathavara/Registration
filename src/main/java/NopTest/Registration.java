package NopTest;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Registration {
    @Test
    public void test1(){
        WebDriver driver;
//static String expectedRegisterSuccessMassage= "Your registration Completed";

        System.setProperty("webdriver.chrome.driver","src\\browserdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("http://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Yogesh");
        driver.findElement(By.id("LastName")).sendKeys("Patel");

        //Select Birth Day
        Select dateOfBirthDay =new Select(driver.findElement(By.name("DateOfBirthDay")));
       dateOfBirthDay.selectByValue("11");

      //Select Birth Month
       Select dateOfBirthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
       //dateOfBirthMonth.selectByIndex("10");
       dateOfBirthMonth.selectByValue("10");

      //Select Birth Year
       Select DateOfBirthYear =new Select(driver.findElement(By.name("DateOfBirthYear")));
       //DateOfBirthYear.selectByValue("1983");
       DateOfBirthYear.selectByVisibleText("1983");
       DateFormat dateFormat= new SimpleDateFormat("MMddyyyyHHmmss");
       Date date =new Date();
       String date1 =dateFormat.format(date);
       driver.findElement(By.id("Email")).sendKeys("yogeshpatel1+"+date1+"@gmail.com");
       driver.findElement(By.id("Company")).sendKeys("HSBC");
       driver.findElement(By.id("Password")).sendKeys("Firsttest");
       driver.findElement(By.id("ConfirmPassword")).sendKeys("Firsttest");
       driver.findElement(By.id("register-button")).click();
       driver.findElement(By.linkText("Log out")).click();
       driver.quit();
   }
   //@Test
    //public void verifyRgistration()



}


