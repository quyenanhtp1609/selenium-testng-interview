package po.RegistrationPage;


import common.WebHelper;
import org.openqa.selenium.WebDriver;
import po.CommonPage.CommonPageFunctions;

public class RegistrationPageFunctions {
    WebDriver driver;
    WebHelper webHelper;
    CommonPageFunctions commonPageFunctions;

    public RegistrationPageFunctions(WebDriver driver) {
        this.driver = driver;
        webHelper = new WebHelper(driver);
        commonPageFunctions = new CommonPageFunctions(driver);
    }

    public void InputWhereDidYouHear(String whereName) throws InterruptedException {
        commonPageFunctions.inputIntoField("Where did you hear about us?", whereName);
        Thread.sleep(1000);
        webHelper.clickOnDivTag(whereName);
    }

    public void inputMobileNumber(String mobileNumber){
        webHelper.inputText("//input[@name='phone']", mobileNumber);
    }
}
