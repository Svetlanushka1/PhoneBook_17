import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void preCondition() {
       if (isLogged()) {
            logout();
        }
    }
    @Test
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name" + i + "@mail.com";
        System.out.println(email);
        String password = "Haifa082022$";
      //name1069@mail.com
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email,password);
        submitRegistration();
        pause(3);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));

    }
    /*
    @Test
    public void registrationWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name" + i + "mail.com";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email,password);
        submitRegistration();
        pause(3);
        Assert.assertFalse(isElementPresent(By.xpath("//button")));

    }
    @Test
    public void registrationWithoutPoint() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mailcom";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitRegistration();
        pause(3);
        Assert.assertFalse(isElementPresent(By.xpath("//button")));
    }
    @Test
    public void registrationOneLetterAfter() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@m.com";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitRegistration();
        pause(3);
        Assert.assertFalse(isElementPresent(By.xpath("//button")));
    }*/



}
