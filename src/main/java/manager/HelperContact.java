package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

  /*  public void openAddNewContactForm() {
        //click() + wd.locator -> tab [LOGIN]
        click(By.cssSelector("a[href='/login']"));
        //a[@href='/add']
    }

    public void fillingAddContactForm(String name, String lastName, String phone, String email, String address, String description) {
        type(By.xpath("//input[@placeholder='Name']"), name);
        //div.add_form__2rsm2>input:first-child
        type(By.xpath("//input[@placeholder='Last Name']"), lastName);
        type(By.xpath("/input[@placeholder='Phone']"), phone);
        type(By.xpath("//input[@placeholder='email']"), email);
        type(By.xpath("//input[@placeholder='Address']"), address);
        type(By.xpath("//input[@placeholder='description']"), description);

    }

    public void submitAddNewContact() {
        // click button [Save]
        click(By.xpath("//b[text()='Save']"));
    }

*/
}
