import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        //app.getUser().click(By.xpath("//a[@href='/add']"));
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
    /* @Test
   New Contact
T16 Contact name is required
T17 Contact name must not be blank
T18 Numbers are allowed
T19 Special characters are allowed
T20 Contact name must have minimum 1 symbol

T21  Contact last name is required
T22  Contact name must not be blank
T23  Numbers are allowed
T24  Special characters are allowed
T25  Contact Last Name must have minimum 1 symbol

T26 Customer email is required
T27 Email must not be blank
T28 Must contain only one  @
T29 The <<.>> symbol is required
T30 Minimum two characters after last <<.>>
T31 English only letters
T32 Contact Email should not be repeated with the email of a previously created contact

T33  Contact address is required
T34 Contact address must not be blank
T35 Numbers are allowed
T36 Special characters are allowed
T37 Contact name must have minimum 1 symbol

T38  Contact Phone Number - Phone Number address is required
T39  Contact Phone Number – Phone number must not be blank
T40   Contact Phone Number  – Phone number can only be digits
T41  Contact Phone Number -  Phone must have minimum 10 symbol
T42  Contact Phone Number -  Phone must have maximum 15 symbol
T43   Contact Phone Number  – Special character are not allowed
T44   Contact Phone Number  – Character are not allowed
T45   Contact Phone Number - Contact Phone Number should not be repeated with the phone number of a previously created contact


T46    Contact Description - Description  is  not required
T47    Contact Description – Numbers are allowed
T48    Contact Description – Special characters  and numbers  are allowed

    }*/

   @AfterMethod
    public void postCondition(){


   }


}


    /*
**********************************************************

        Sign Out button full //div[@class='navbar-logged_nav__2Hx7M']/button    css:.navbar-logged_nav__2Hx7M>button
        WebElement signOutButton = wd.findElement(By.xpath("//button"));

        CONTACTS tab css:a:nth-child(4)
        WebElement contactsTab = wd.findElement(By.xpath("//a[3]"));

        *
        ADD page
        tab ADD
        //a[@href='/add']  //a[text()='ADD']


        Field Name
        //input[@placeholder='Name']
        div.add_form__2rsm2>input:first-child

        field LastName
        //input[@placeholder='Last Name']
        input[placeholder='Name']

        field Phone
        //input[@placeholder='Phone' ]

        field email
        //input[@placeholder='email' ]

        field Address
        //input[@placeholder='Address' ]

        field description
        //input[@placeholder='description' ]

        button Save
        //b[text()='Save'] //button/b
        div[class='add_form__2rsm2'] button b


    */



