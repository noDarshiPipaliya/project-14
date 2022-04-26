package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.id("username"), "Dev");
        sendTextToElement(By.id("password"), "devanshi");

        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        String expectedMessage = "Accounts Overview";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessage() {

        sendTextToElement(By.name("username"), "selenium");
        sendTextToElement(By.name("password"), "postman");

        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        String expectedMessage = "Error!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h1[contains(text(),'Error!')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLogoutSuccessfully() {

        sendTextToElement(By.name("username"),"dev");
        sendTextToElement(By.name("password"),"devanshi");

        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        String expectedMessage = "Customer Login";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);


    }
}
