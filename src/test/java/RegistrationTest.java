import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
//Дописать негативные тесты в Login/Registration Phonebook с обработкой alerts
    @BeforeMethod
    public void preCondition() {
       if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }
   /*@Test
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name" + i + "@mail.com";
        System.out.println(email);
        //name2908@mail.com
        //name2141@mail.com
       //name1917@mail.com
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
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));



    }



    @Test
    public void registrationOneLetterAfterPoint() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.c";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        //app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));


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
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));


    }

    @Test
    public void registrationWithoutEmail() {

        String email = "";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        //app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));


    }
    @Test
    public void registrationWithBlankEmail() {

        String email = " ";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        //app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));

        //Registration failed with code 400

    }
    @Test
    public void registrationWithoutPoint() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mailcom";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        System.out.println(email);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));
        // div[contains(text(),'Login Failed with code 401')]

    }
    @AfterMethod
    public void tearDawn(){
       // wd.quit();
    }

}

/*
*******************************************************
*   to LOGIN page:
        //div/a[3] css:div a:last-child or a[href='/login']
        //a[text()='LOGIN']" //

        to HOME page
       //a[starts-with(@href,'/ho')]   a[href^='/ho']
       //h1/following-sibling::a[1] //a[last()]/preceding-sibling::a[2]

        1) Field email
        css: input:first-child div css
        //input[@placeholder='Email']
        //input[1]  //div/a[contains(@placeholder,'Email')]

        3) Field password:
        //*[contains(@placeholder,'Password')] css: input:nth-child(2)
        //input[2]")).getTagName());
        //input[@placeholder='Password']


        5) Registration button
        //button[text()=' Registration']
 */
