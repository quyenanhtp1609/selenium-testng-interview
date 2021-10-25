package po.PersonalDetailsPage;

import common.WebHelper;
import org.openqa.selenium.WebDriver;
import po.CommonPage.CommonPageFunctions;

public class PersonalDetailsPageFunctions {

    WebDriver driver;
    WebHelper webHelper;
    CommonPageFunctions commonPageFunctions;

    public PersonalDetailsPageFunctions(WebDriver driver) {
        this.driver = driver;
        webHelper = new WebHelper(driver);
        commonPageFunctions = new CommonPageFunctions(driver);
    }

    public void inputDateOfBirth() throws InterruptedException {
        commonPageFunctions.clickOnInputField("Date of birth");
        Thread.sleep(1000);

        //Change year
        webHelper.clickOnSpanTag("2021");
        Thread.sleep(1000);
        webHelper.clickElement("//i[@class='fas fa-chevron-left q-icon notranslate']");
        Thread.sleep(1000);
        webHelper.clickOnSpanTag("2000");
        Thread.sleep(1000);
        webHelper.clickOnSpanTag("17");
        Thread.sleep(1000);
    }
}
