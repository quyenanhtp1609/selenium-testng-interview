package scripts;

import common.WebHelper;
import data.WorkFlowsData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import po.BusinessDetailsPage.BusinessDetailsPageFunctions;
import po.CommonPage.CommonPageFunctions;
import po.PersonalDetailsPage.PersonalDetailsPageFunctions;
import po.RegistrationPage.RegistrationPageFunctions;

public class WorkFlows {

    WebDriver driver;
    WebHelper webHelper;
    CommonPageFunctions commonPageFunctions;
    RegistrationPageFunctions registrationPageFunctions;
    PersonalDetailsPageFunctions personalDetailsPageFunctions;
    BusinessDetailsPageFunctions businessDetailsPageFunctions;

    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        webHelper = new WebHelper(driver);
        commonPageFunctions = new CommonPageFunctions(driver);
        personalDetailsPageFunctions = new PersonalDetailsPageFunctions(driver);
        registrationPageFunctions = new RegistrationPageFunctions(driver);
        businessDetailsPageFunctions = new BusinessDetailsPageFunctions(driver);

        webHelper.setupImplicitWait();

        commonPageFunctions.openBrowserAndGoToWebsite(WorkFlowsData.url);
    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void WorkFlowFW0001() throws InterruptedException {
        //Click on Register link
        Thread.sleep(7000);
        commonPageFunctions.clickOnRegisterLink();

        //Input value into Full Name as per ID
        commonPageFunctions.inputIntoField("Full Name as per ID", WorkFlowsData.fullName);

        //Input value into Preferred name
        commonPageFunctions.inputIntoField("Preferred name", WorkFlowsData.preferredName);

        //Input value into Email address
        commonPageFunctions.inputIntoField("Email address", WorkFlowsData.email);

        //Input value into Mobile number
        registrationPageFunctions.inputMobileNumber(WorkFlowsData.phoneNumber);

        //Input value into Where did you hear about us? and select item
        registrationPageFunctions.InputWhereDidYouHear(WorkFlowsData.whereDidYouHearAboutUs);

        commonPageFunctions.clickOnCheckBox();

        Thread.sleep(1000);

        commonPageFunctions.clickOnBtn("Continue");

        Thread.sleep(5000);

        //Navigate to Enter phone OTP page
        //Input phone OTP
        commonPageFunctions.inputOTP("1234");

        Thread.sleep(3000);

        //Navigate to Tell us more about yourself
        //Select I am a registered director of the company
        commonPageFunctions.selectOptionOnField("I am a registered director of the company");

        //Navigate to Additional details page
        commonPageFunctions.selectSolutionLookingFor(WorkFlowsData.solutions);

        //Click on Continue button
        commonPageFunctions.clickOnBtn("Continue");

        Thread.sleep(3000);

        //Navigate to Choose a registration method page
        commonPageFunctions.clickOnGetStartedOnStandardRegistration();

        Thread.sleep(3000);

        //Navigate to Personal Details page
        personalDetailsPageFunctions.inputDateOfBirth();
//        commonPageFunctions.inputIntoField("");

        //Navigate to  Business Details page
        //Input Business legal name
        commonPageFunctions.inputIntoField("Business legal name", WorkFlowsData.businessLegalName);

        //Input Entity category
        businessDetailsPageFunctions.selectEntityCategory(WorkFlowsData.entityCategory);

        //Input Entity type
        businessDetailsPageFunctions.selectEntityType(WorkFlowsData.entityType);

        //Input Business registration number (UEN)
        commonPageFunctions.inputIntoField("Business registration number (UEN)", WorkFlowsData.uEN);

        //Input Industry
        businessDetailsPageFunctions.selectIndustry(WorkFlowsData.industry);

        Thread.sleep(1000);

        //Input Sub-Industry
        businessDetailsPageFunctions.selectSubIndustry(WorkFlowsData.subIndustry);

        Thread.sleep(1000);

        //Click on Continue button
        commonPageFunctions.clickOnBtn("Continue");

        //Navigate to Enter your business’ details page
        //Input Business activity
        commonPageFunctions.inputIntoField("Business activity", WorkFlowsData.businessActivity);

        //Input  Detailed & specific example of your product/services
        commonPageFunctions.inputIntoField(" Detailed & specific example of your product/services", WorkFlowsData.exampleProductAndServices);

        //Input  Live business website
        commonPageFunctions.inputIntoField(" Live business website", WorkFlowsData.liveBusinessWebsite);

        //Input Number of employees
        businessDetailsPageFunctions.selectNumberOfEmployees(WorkFlowsData.numberOfEmployees);

        //Input Annual revenue
        businessDetailsPageFunctions.selectAnnualRevenue(WorkFlowsData.annualRevenue);

        //Input What is your total monthly card spend?
        businessDetailsPageFunctions.selectTotalMonthlyCardSpend(WorkFlowsData.totalMonthlyCardSpend);

        Thread.sleep(1000);

        //Click on Submit button
        commonPageFunctions.clickOnBtn("Submit");

        //Navigate on Enter your business’ details page
        //Answer the question "Does any of your company directors or shareholders qualify as Politically Exposed Person (PEP), close family member or close associate of a PEP?"
        businessDetailsPageFunctions.selectFirstQuestion("Yes");

        //Answer the question "Does your company have corporate shareholders with more than 10% ordinary shares? "
        businessDetailsPageFunctions.selectSecondQuestion("Yes");

        //Click on Continue button
        commonPageFunctions.clickOnBtn("Continue");
    }
}
