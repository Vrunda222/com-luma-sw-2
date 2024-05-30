package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("vrunda@gmail.com");
        //Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("1A23456$%78cv90");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();
        //Verify the ‘Welcome’ text is display
        String actualText = driver.findElement(By.xpath("//span[starts-with(text(),'Welcome')]")).getText().substring(0, 7);
        Assert.assertEquals("Not redirected to login page","Welcome", actualText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("vrunda@gmail.com");
        //Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("1A23456$%78cv9");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();
        //Verify the error message ‘The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.’
        Assert.assertEquals("Not redirected to login page","The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText());
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("vrunda@gmail.com");
        //Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("1A23456$%78cv90");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();
        //Verify the ‘Welcome’ text is display
        String actualText = driver.findElement(By.xpath("//span[starts-with(text(),'Welcome')]")).getText().substring(0, 7);
        Assert.assertEquals("Not redirected to login page","Welcome", actualText);
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
