import modals.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Дописать негативные тесты в Login/Registration Phonebook с обработкой alerts
public class LoginTest extends TestBase {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        // wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.navigate().to("https://telranedu.web.app/home");

    }

    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTest() {
        //openLogin/Reg form
        WebElement loginBtn = wd.findElement(By.xpath("//a[text()='LOGIN']"));
        loginBtn.click();
        //type email to login/Reg form
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
        //is there Sign Out button?
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

        //Assert.assertTrue(wd.findElement(By.cssSelector("a[href='/add']"))!=null);
        //Assert.assertTrue(wd.findElement(By.xpath("//div/a[contains(text(),'ADD')]"))!=null);

    }

    @Test
    public void loginNegativeTest() {
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name851mail.com";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(5);
        //user stays on the loginFormPage
        app.getUser().pause(3);
        // Assert.assertFalse(wd.findElement(By.xpath("//a[@href='/add']"))!=null);
        //  Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//input[@placeholder='Email']")));
        //app.getUser().isLogged();

        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));


    }
    @Test
    public void emailWithoutPoint() {
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name851@mailcom";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(5);
        //user stays on the loginFormPage

        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        //div[@class='login_login__3EHKB'] div   Login Failed with code 401
        app.getUser().click(By.xpath("//a[@href='/home']"));


    }
    @Test
    public void emailWithOneLater() {
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name851mail.c";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(5);

        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));


    }
    @Test
    public void emailWithRussianLetter() {
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "имя851mail.com";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(5);
        app.getUser().pause(3);

        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));


    }
    @Test
    public void emailWithOneSymbolBeforePoint() {
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "name851m.com";
        String password = "Haifa082022$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(3);

        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().click(By.xpath("//a[@href='/home']"));


    }

    @Test
    public void loginSuccess() {
        User data = new User()
                .withEmail("name1917@mail.com")
                .withPassword("Haifa082022$");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillingLoginRegistrationForm(data.getEmail(),data.getPassword());
        app.getUser().submitLogin();
    }



    @AfterMethod
    public void tearDown() {
        // wd.quit();
    }
}

/*
*****************************************************
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

        4) Login button
        //button[text()=' Login']

        5) Registration button
        //button[text()=' Registration']
 */