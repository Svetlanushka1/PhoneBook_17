import org.openqa.selenium.Alert;
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
  /*  @Test
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name" + i + "@mail.com";
        System.out.println(email);
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email,password);
        submitRegistration();
        pause(3);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));

    }*/

    @Test
    public void registrationWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name" + i + "mail.com";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email,password);
        submitRegistration();
        pause(3);
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertFalse(isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

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
        //Alert.
        // div[contains(text(),'Login Failed with code 401')]

    }
    @Test
    public void registrationOneLetterAfterPoint() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.c";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitRegistration();
        pause(3);

    }
    @Test
    public void registrationWithRussianLetters() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "имя" + i + "@mail.com";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitRegistration();
        pause(3);

    }

    @Test
    public void registrationWithoutEmail() {

        String email = "";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitRegistration();
        pause(3);

    }
    @Test
    public void registrationWithBlankEmail() {

        String email = " ";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitRegistration();
        pause(3);

    }

}
