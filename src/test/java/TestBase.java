import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeSuite
    //open app
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
                //.to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    //
    public void click(By locator) {
        //click by locator
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        //input text to field
        //find html locator and put it to 'element'
        WebElement element = wd.findElement(locator);
        //click on webElement
        element.click();
        // clear field from any text
        element.clear();
        //type to field text
        element.sendKeys(text);
    }

    public void openLoginRegistrationForm() {
        //click() + wd.locator -> tab [LOGIN]
        click(By.xpath("//a[text()='LOGIN']"));

    }

    public void fillingLoginRegistrationForm(String email, String password) {
        //to fill form (locator(where) + data(what)
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin() {
        // click button [Login]
        click(By.xpath("//button[1]"));
    }

    public void submitRegistration() {
        //click button [Register]
        click(By.xpath("//button[2]"));
    }

    public boolean isElementPresent(By locator) {
        //is this element on the Web page? return true, if such element more than 0
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int time) {
        //to postpone WebBrowser from action for a few min
        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

   public boolean isLogged() {
        //is user logged?
          return isElementPresent(By.xpath("//button[text()='/Sign Out']"));
        }

    public void logout() {
        //to do log out
        WebElement signOutButton = wd.findElement(By.xpath("//button"));
        if (signOutButton.getText().equals("Sign Out")) {
            click(By.xpath("//button"));
        }


    }


}


