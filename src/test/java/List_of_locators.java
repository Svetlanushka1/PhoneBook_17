public class List_of_locators {/*

        Navigate
        to LOGIN page:
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


        Sign Out button full //div[@class='navbar-logged_nav__2Hx7M']/button    css:.navbar-logged_nav__2Hx7M>button
        WebElement signOutButton = wd.findElement(By.xpath("//button"));

        CONTACTS tab css:a:nth-child(4)
        WebElement contactsTab = wd.findElement(By.xpath("//a[3]"));
        */

}
