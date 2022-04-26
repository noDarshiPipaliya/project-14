package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        WebElement registerlink = driver.findElement(By.linkText("Register"));
        registerlink.click();

        String expectedMessage = "Signing up is easy!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        clickOnElement(By.linkText("Register"));

        sendTextToElement(By.id("customer.firstName"), "Devanshi");

        sendTextToElement(By.id("customer.lastName"), "Pipaliya");

        sendTextToElement(By.id("customer.address.street"), "Margeholes");

        sendTextToElement(By.id("customer.address.city"), "Watford");

        sendTextToElement(By.id("customer.address.state"), "Northen Ireland");

        sendTextToElement(By.id("customer.address.zipCode"), "1234\"");

        sendTextToElement(By.id("customer.phoneNumber"), "9536148210");

        sendTextToElement(By.id("customer.ssn"), "563245");

        sendTextToElement(By.id("customer.username"), "Dev");

        sendTextToElement(By.id("customer.password"), "devanshi");

        sendTextToElement(By.id("repeatedPassword"), "devanshi");

        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        String expectedMessage = "Your account was created successfully. You are now logged in.";
        WebElement actualMessageelement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to page area ", expectedMessage, actualMessage);


    }
}
