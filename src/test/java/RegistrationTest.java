import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
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
//T9  One of special characters are required [ ‘$’, ‘~’, ‘-’, ‘_’ ]
    @Test
    public void registrationWithSpecialCharInPassword() {

        String email = "name1917@mail.com";
        String password = "Hai_fa082022";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        System.out.println(email + password);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']

        //unexpected alert open: {Alert text : Wrong email or password format
       // Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
       // Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab

    }
    @Test
    //T1    Customer email - Customer email is required
    public void registrationWithoutEmail() {

        String email = "";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        //app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));

    }

    @Test
    //T2    Customer email - Email must not be blank
    public void registrationWithBlankEmail() {

        String email = " ";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        //app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));

        //Registration failed with code 400

    }

    @Test

    //T3    Customer email - Must contain only one  @
    public void registrationWithoutDotEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "mail.com";
        String password = "Haifa082022$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));

    }

    @Test
    //T3    Customer email - Must contain only one  @
    public void registration2dotsEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@@mail.com";
        String password = "Haifa082022$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        // System.out.println(email);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));

    }


    /*  @Test
    //T4    Customer email - The <<.>> symbol is required
    public void registrationWithoutPointEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mailcom";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        System.out.println(email);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));
        // div[contains(text(),'Login Failed with code 401')]

    }*/

   /* @Test
   //T5   Minimum two characters after last <<.>>
    public void registrationOneLetterAfterPointEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.c";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        System.out.println(email);
        app.getUser().submitRegistration();
        //app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }
    @Test
     //T6  English only letters
    public void registrationWithRussianLettersEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "имя" + i + "@mail.com";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        System.out.println(email);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }*/
//T7 Customer password is required
    @Test
    public void registrationWithoutPassword() {
        //int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        //String email = "name" + i + "mail.com";
        String email = "name1917@mail.com";
        String password = "";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }
//T8 Password must not be blank
    @Test
    public void registrationWithBlankPassword() {

        String email = "name1917@mail.com";
        String password = " ";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }
//T9  One of special characters are required [ ‘$’, ‘~’, ‘-’, ‘_’ ]
    @Test
    public void registrationWithoutSpecialCharInPassword() {

        String email = "name1917@mail.com";
        String password = "Haifa082022";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }


    //T10   Customer password – English only letters are required
    @Test
    public void registrationWithRussianLetterInPassword() {

        String email = "name1917@mail.com";
        String password = "082022$Хайфа";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }
    //T11 Minimum one letter in UpperCase  is required
    @Test
    public void registrationWithoutUpperCaseInPassword() {

        String email = "name1917@mail.com";
        String password = "haifa082022$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }
    //T12   Customer password – Minimum one letter in LowCase is required
    @Test
    public void registrationWithoutLowCaseInPassword() {

        String email = "name1917@mail.com";
        String password = "HAIFA082022$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }
//T13  Minimum one number  is required
    @Test
    public void registrationWithoutNumberInPassword() {

        String email = "name1917@mail.com";
        String password = "Haifaaaaaaaa$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }
//T14  Password must have minimum 8 symbols
    @Test
    public void registrationOnly7SymbolsInPassword() {

        String email = "name1917@mail.com";
        String password = "Haifa0$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        System.out.println(password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        app.getUser().click(By.xpath("//a[@href='/home']"));
    }
/*//T15 Password must have maximum 20 symbols
    @Test
    public void registrationWith21SymbolInPassword() {

        String email = "name1917@mail.com";
        String password = "Ha987654321$123456789";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        System.out.println(password);
        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        //button[text()='/Sign Out']
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Login Failed with code 401')]")));

        //unexpected alert open: {Alert text : Wrong email or password format
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        //Click Button to see alert [contains(text()),'OK')])
        Assert.assertTrue(app.getUser().isAlertPresent());
        //navigate to home tab
        //app.getUser().click(By.xpath("//a[@href='/home']"));
    }
    */
    @AfterMethod
    public void tearDawn() {
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
