package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
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
        return isElementPresent(By.xpath("//button[text()='/Sign Out']"));
    }

    public void logout() {
        //to do log out
        WebElement signOutButton = wd.findElement(By.xpath("//button"));
        if (signOutButton.getText().equals("Sign Out")) {
            click(By.xpath("//button[text()='/Sign Out']"));
        }
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

}
