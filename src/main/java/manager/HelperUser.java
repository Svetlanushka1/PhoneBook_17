package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitLogin() {
        // click button [Login]
        click(By.xpath("//button[1]"));
    }

    public void submitRegistration() {
        //click button [Register]
        click(By.xpath("//button[2]"));
    }

    public boolean isLogged() {
        //is user logged?
        return isElementPresent(By.xpath("//button"));
                //button[text()='/Sign Out']
    }

    public void logout() {
        //to do log out
        click(By.xpath("//button"));
        //button[text()='/Sign Out']
    }

    public void openLoginRegistrationForm() {
        //click() + wd.locator -> tab [LOGIN]
        //click(By.xpath("//a[text()='LOGIN']"));
        click(By.cssSelector("a[href='/login']"));

    }

    public void fillingLoginRegistrationForm(String email, String password) {
        //to fill form (locator(where) + data(what)
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void login() {

        // String email = "Haifa@gmail.com";
        String email = "name851@mail.com";
        String password = "Haifa082022$";
        openLoginRegistrationForm();
        fillingLoginRegistrationForm(email, password);
        submitLogin();
        pause(5);
        //if there is such element on the page , says True
        //Assert.assertTrue(isElementPresent(By.xpath("//button")));
        Assert.assertTrue(isElementPresent(By.cssSelector("a[href='/add']")));


    }

    /*public void submitAddNewContact() {
        click(By.xpath("//b[text()='Save']"));
    }*/
}



