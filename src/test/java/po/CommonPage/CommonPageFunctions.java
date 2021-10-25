package po.CommonPage;

import common.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPageFunctions {

    WebDriver driver;

    WebDriverWait wait;

    WebHelper webHelper;

    public CommonPageFunctions(WebDriver driver) {
        this.driver = driver;
        webHelper = new WebHelper(driver);
    }

    public void openBrowserAndGoToWebsite(String url){
        webHelper.openBrowser(url);
        webHelper.maximizeBrowserWindow();
    }

    public void inputIntoField(String fieldName, String value){
        webHelper.inputText("//div[contains(text(), '" + fieldName + "')]/ancestor::div[2]/label//div/input", value);
    }

    public void clickOnInputField(String fieldName) {
        webHelper.clickElement("//div[contains(text(), '" + fieldName + "')]/ancestor::div[2]/label//div/input");
    }

    public void inputOTP(String value) throws InterruptedException {
        webHelper.inputText("//input[@inputmode='numeric']", "1234");
        Thread.sleep(1000);
    }

    public void clickOnCheckBox() {
        webHelper.clickElement("//div[@class='q-checkbox__bg absolute']");
    }

    public void clickOnRegisterLink() {
        webHelper.clickOnATagContainsText("Register");
    }

    public void clickOnBtn(String btnName){
        webHelper.clickOnSpanTag(btnName);
    }

    public void selectOptionOnField(String label) throws InterruptedException {
        Thread.sleep(10000);
        webHelper.clickOnDivTagContainsText(label);
    }

    public void selectSolutionLookingFor(String solutions) throws InterruptedException {
        Thread.sleep(2000);
        webHelper.clickOnDivTagContainsText("Select applicable options");
        Thread.sleep(1000);
        webHelper.clickOnDivTag(solutions);
        webHelper.clickOnDivTagContainsText("Additional details");
        Thread.sleep(1000);
    }

    public void clickOnGetStartedOnStandardRegistration() throws InterruptedException {
        webHelper.clickElement("//div[@class='auth-form__card']/div[2]//span[text()='Get Started']");
        Thread.sleep(1000);
    }
}
