package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomenJacketsPage(){
        //Click on ‘Sale’ Menu tab
        driver.findElement(By.xpath("//span[text()='Sale']")).click();
        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.xpath("//div[@class='categories-menu']//ul[1]//a[text()='Jackets']")).click();
        //Verify the text ‘Jackets’ is displayed
        Assert.assertEquals("","Jackets", driver.findElement(By.xpath("//span[@class='base']")).getText());
        //Count the Total Item Displayed on Page and print the name of all items into console.
        List<WebElement> totalJacket = driver.findElements(By.xpath("//li[@class='item product product-item']"));
        System.out.println("Total item displayed on page are: " + totalJacket.size());
        System.out.println("All items names: ");
        List<WebElement> printName = driver.findElements(By.xpath("//li[@class='item product product-item']//a[@class='product-item-link']"));
        for (WebElement webElement : printName){
            String name = webElement.getText();
            System.out.println(name);
        }
        //Verify total 12 Items displayed on page.
        Assert.assertEquals("Not redirected to login page", 12, totalJacket.size());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
