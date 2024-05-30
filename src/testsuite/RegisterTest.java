package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay(){
        //click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//div[@class='panel wrapper']//a[text()='Create an Account']")).click();
        //Verify the text ‘Create New Customer Account’
        Assert.assertEquals("Not redirected to login page","Create New Customer Account",driver.findElement(By.xpath("//div[@class='page-title-wrapper']//span")).getText());
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//div[@class='panel wrapper']//a[text()='Create an Account']")).click();
        //Enter First name
        driver.findElement(By.id("firstname")).sendKeys("Vrunda");
        //Enter Last name
        driver.findElement(By.id("lastname")).sendKeys("Vyas");
        //Click on checkbox Sign Up for Newsletter
        //there is no checkbox
        //Enter Email
        driver.findElement(By.id("email_address")).sendKeys("vrunda@gmail.com");
        //Enter Password
        driver.findElement(By.id("password")).sendKeys("1A23456$%78cv90");
        //Enter Confirm Password
        driver.findElement(By.id("password-confirmation")).sendKeys("1A23456$%78cv90");
        //Click on Create an Account button
        driver.findElement(By.className("primary")).click();
        //Verify the text 'Thank you for registering with Main Website Store.’
        Assert.assertEquals("Not redirected to login page","Thank you for registering with Main Website Store.", driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText());
        //Click on down aero near Welcome
        driver.findElement(By.className("switch")).click();
        //Click on Sign Out link
        driver.findElement(By.xpath("//div[@class='customer-menu']//a[text()='\n" +
                "Sign Out ']")).click();

        //Verify the text ‘You are signed out’
        Assert.assertEquals("Not redirected to login page","You are signed out", driver.findElement(By.className("base")).getText());
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
