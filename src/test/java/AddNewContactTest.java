import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {
    @BeforeClass
    public void preCondition() {
        //check that user login
        if (app.getUser().isElementPresent(By.xpath("//a[@href='/add']"))) {
            System.out.println("Add tab present");
            app.getUser().login();

        }

        //button[text()='Sign Out']
    }
    // public void clickAddContact()

    @Test
    public void addNewContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "name" + i;
        String lastName = "lastName" + i;
        String phone = "123456789";
        String email = "name" + i + "@mail.com";
        String address = "address" + i;
        String description = "friend" + i;
        app.getContact().openAddNewContactForm();
        app.getContact().fillingAddContactForm(name, lastName, phone, email, address, description);
        app.getContact().submitAddNewContact();
        System.out.println(name + email);

        //app.getUser().fillAddContactForm(name,lastName,phone,email,address,description);
        app.getUser().submitAddNewContact();
    }

   /* @Test
    public void addNewContactNegative() {

        */

    }

}

