package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class WebHelper {

    WebDriver driver;
    WebDriverWait wait;

    public WebHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openBrowser(String url){
        driver.get(url);
    }

    public void setupImplicitWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void maximizeBrowserWindow(){
        driver.manage().window().maximize();
    }

    public void clickElement(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public void inputText(String xpath, String value){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(value);
    }

    public void elementShouldBe(String xpath, String expected){
        WebElement element = driver.findElement(By.xpath(xpath));
        String actual = element.getText();

        Assert.assertEquals(actual, expected);
    }

    public void clickOnSpanTag(String spanText) {
        clickElement("//span[text()='"+ spanText +"']");
    }

    public void clickOnATag(String aText) {
        clickElement("//a[text()='"+ aText +"']");
    }

    public void clickOnATagContainsText(String aText) {
        clickElement("//a[contains(text(), '" + aText + "')]");
    }

    public void clickOnDivTag(String divText) {
        clickElement("//div[text()='"+ divText +"']");
    }

    public void clickOnDivTagContainsText(String divText) {
        clickElement("//div[contains(text(), '"+ divText +"')]");
    }

    public void waitUntilPageContainsElement(String xpath) {
        wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(By.xpath("xpath")));
    }
}
