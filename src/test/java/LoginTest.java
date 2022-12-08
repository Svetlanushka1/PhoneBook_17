import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    WebDriver wd;
    @BeforeMethod
   public void init(){
        wd = new ChromeDriver();
        //wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.navigate().to("https://telranedu.web.app/home");

    }

  /* public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }*/
    @Test
        public void loginPositiveTest() {
        //openLogin/Reg form
        WebElement loginBtn = wd.findElement(By.xpath("//a[text()='LOGIN']"));
        loginBtn.click();
        //type email to login\Reg form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("name851@mail.com");

        //type password to login/Reg form
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Haifa082022$");

        // click on Login button
        wd.findElement(By.xpath("//button[1]")).click();

        // Assert
//        pause(3);
       // Assert.assertTrue(wd.findElement(By.cssSelector("a[href='/add']"))!=null);
        Assert.assertTrue(wd.findElement(By.xpath("//div/a[contains(text(),'ADD')]"))!=null);


        /*String email = "name851@mail.com";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitLogin();
        pause(5);
        //if there is such element on the page , says True
        //  Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));*/

    }

   /* @Test
    public void loginNegativeTest() {
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        // String email = "Haifa@gmail.com";
        String email = "name851mail.com";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(5);
        //user stays on the loginFormPage
        app.getUser().pause(3);
        Assert.assertFalse(wd.findElement(By.xpath("//a[@href='/add']"))!=null);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//input[@placeholder='Email']")));
        //app.getUser().isLogged();


    }*/
    @AfterMethod
    public void tearDown(){
       // wd.quit();
    }
}