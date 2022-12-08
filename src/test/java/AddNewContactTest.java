import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {

    /*@BeforeClass
    public void preCondition() {
        //check that user login
        if (app.getUser().isElementPresent(By.xpath("//a[text()='ADD']"))) {
            System.out.println("Add tab present");
        } else {
            app.getUser().login();
        }
    }*/
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().pause(3);
        } else {
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillingLoginRegistrationForm("name851@mail.com","Haifa082022$");
            app.getUser().submitLogin();
            app.getUser().pause(3);
        }
    }


  /*  @Test
    public void addNewContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "name" + i;
        String lastName = "lastName" + i;
        String phone = "123456789";
        String email = "name" + i + "@mail.com";
        String address = "address" + i;
        String description = "friend" + i;

        app.getContact().openAddNewContactForm();
        app.getUser().pause(2);
        app.getContact().fillingAddContactForm(name, lastName, phone, email, address, description);
        app.getUser().pause(2);
        app.getContact().submitAddNewContact();
        System.out.println(name + email);

    }*/

    @Test
    public void addNewContactPositiveTest(){
        app.getUser().click(By.xpath("//a[@href='/add']"));
        app.getUser().click(By.cssSelector("a[href='/add']"));

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "John" + i;
        String lastname = "Snow" + i;
        String phone = "055666777" + i;
        String email = "john" + i + "@mail.com";
        String address = "Haifa, Herzel, " + i;
        String description = "friend";

        app.getUser().type(By.xpath("//input[1]"), name);
        app.getUser().type(By.xpath("//input[2]"), lastname);
        app.getUser().type(By.xpath("//input[3]"), phone);
            System.out.println(phone);
        app.getUser().type(By.xpath("//input[4]"), email);
        app.getUser().type(By.xpath("//input[5]"), address);
        app.getUser().type(By.xpath("//input[6]"), description);
        app.getUser().click(By.xpath("//div[@class='add_form__2rsm2']//button"));

        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(phone)
        );
    }

//    @AfterMethod

}

   /* @Test
    public void addNewContactNegative() {



    }*/



