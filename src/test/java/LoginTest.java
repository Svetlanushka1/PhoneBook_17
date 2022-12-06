import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod

    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
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
       // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//input[@placeholder='Email']")));
        //app.getUser().isLogged();


    }
    @AfterMethod
    public void tearDown(){
       // wd.quit();
    }
}