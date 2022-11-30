import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginPositiveTest() {
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "Haifa@gmail.com";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitLogin();
        pause(5);
        //if there is such element on the page , says True
        Assert.assertTrue(isElementPresent(By.xpath("//button")));
        //isLogged();

        logout();



    }
}