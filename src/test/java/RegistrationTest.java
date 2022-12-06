import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void preCondition() {
       if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }
   /* @Test
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name" + i + "@mail.com";
        System.out.println(email);
        //name2908@mail.com
        //name2141@mail.com
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[text()='/Sign Out']")));

    }*/

    @Test
    public void registrationWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name" + i + "mail.com";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button[text()='/Sign Out']")));
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

    }

   /* @Test
    public void registrationWithoutPoint() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mailcom";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        //Alert.
        // div[contains(text(),'Login Failed with code 401')]

    }
    @Test
    public void registrationOneLetterAfterPoint() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.c";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(3);

    }
    @Test
    public void registrationWithRussianLetters() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "имя" + i + "@mail.com";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(3);

    }

    @Test
    public void registrationWithoutEmail() {

        String email = "";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(3);

    }
    @Test
    public void registrationWithBlankEmail() {

        String email = " ";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(3);

    }*/
    @AfterMethod
    public void tearDawn(){
       // wd.quit();
    }

}
