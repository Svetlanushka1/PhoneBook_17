package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public boolean isElementPresent(By locator) {
        //is this element on the Web page? return true, if such element more than 0
        return wd.findElements(locator).size() > 0;
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
    public void click(By locator) {
        //click by locator
        wd.findElement(locator).click();
    }
    public void pause(int time) {
        //to postpone WebBrowser from action for a few min
        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    //get info about new add contact:
    public String getText(By locator){
        return wd.findElement(locator).getText();

    }
}
