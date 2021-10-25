package po.BusinessDetailsPage;

import common.WebHelper;
import org.openqa.selenium.WebDriver;
import po.CommonPage.CommonPageFunctions;

public class BusinessDetailsPageFunctions {

    WebDriver driver;

    WebHelper webHelper;
    CommonPageFunctions commonPageFunctions;

    public BusinessDetailsPageFunctions(WebDriver driver) {
        this.driver = driver;
        webHelper = new WebHelper(driver);
        commonPageFunctions = new CommonPageFunctions(driver);
    }

    public void selectEntityCategory(String entityCategory) throws InterruptedException {
        Thread.sleep(1000);
        commonPageFunctions.clickOnInputField("Entity category");
        Thread.sleep(1000);
        webHelper.clickOnDivTag(entityCategory);
    }

    public void selectEntityType(String entityType) throws InterruptedException {
        Thread.sleep(1000);
        commonPageFunctions.clickOnInputField("Entity type");
        Thread.sleep(1000);
        webHelper.clickOnDivTag(entityType);
    }

    public void selectIndustry(String industry) throws InterruptedException {
        Thread.sleep(1000);
        commonPageFunctions.clickOnInputField("Industry");
        Thread.sleep(1000);
        webHelper.clickOnDivTag(industry);
    }

    public void selectSubIndustry(String industry) throws InterruptedException {
        Thread.sleep(1000);
        commonPageFunctions.clickOnInputField("Sub-Industry");
        Thread.sleep(1000);
        webHelper.clickOnDivTag(industry);
    }

    public void selectNumberOfEmployees (String numberOfEmployees) throws InterruptedException {
        Thread.sleep(1000);
        commonPageFunctions.clickOnInputField("Number of employees");
        Thread.sleep(1000);
        webHelper.clickOnDivTag(numberOfEmployees);
    }

    public void selectAnnualRevenue (String annualRevenue) throws InterruptedException {
        Thread.sleep(1000);
        commonPageFunctions.clickOnInputField("Annual revenue");
        Thread.sleep(1000);
        webHelper.clickOnDivTag(annualRevenue);
    }

    public void selectTotalMonthlyCardSpend (String totalMonthlyCardSpend) throws InterruptedException {
        Thread.sleep(1000);
        commonPageFunctions.clickOnInputField("What is your total monthly card spend?");
        Thread.sleep(1000);
        webHelper.clickOnDivTag(totalMonthlyCardSpend);
    }

    public void selectFirstQuestion(String answer){
        webHelper.clickElement("//div[contains(text(), 'Does any of your company directors or shareholders qualify as Politically Exposed Person (PEP), close family member or close associate of a PEP?')]/ancestor::div[2]/div[2]//div[contains(text(), '"+ answer+ "')]");
    }

    public void selectSecondQuestion(String answer){
        webHelper.clickElement("//div[contains(text(), 'Does your company have corporate shareholders with more than 10% ordinary shares?')]/ancestor::div[2]/div[4]//div[contains(text(), '"+ answer+ "')]");
    }

    public void openListFromQuestion(String questionName) {
        webHelper.clickElement("//div[@label='" + questionName + "']//div[contains(text(), 'Please select an option')]");
    }

    public void selectAnswerFromQuestion(String questionName, String answerName) throws InterruptedException {
        openListFromQuestion(questionName);
        Thread.sleep(1000);
        webHelper.clickOnDivTag(answerName);
    }
}
