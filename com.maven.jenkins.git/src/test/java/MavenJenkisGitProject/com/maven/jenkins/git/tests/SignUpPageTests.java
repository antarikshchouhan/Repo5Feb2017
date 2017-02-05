package MavenJenkisGitProject.com.maven.jenkins.git.tests;


import MavenJenkisGitProject.com.maven.jenkins.git.basetest.BaseTest;
import MavenJenkisGitProject.com.maven.jenkins.git.pages.AppDirectLandingPage;
import MavenJenkisGitProject.com.maven.jenkins.git.pages.DeveloperSignUpPage;
import MavenJenkisGitProject.com.maven.jenkins.git.pages.LoginPage;
import MavenJenkisGitProject.com.maven.jenkins.git.pages.SignUpPage;
import MavenJenkisGitProject.com.maven.jenkins.git.properties.PropertiesFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.PrintStream;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTests
extends BaseTest {
    @Test(description="TC01 : Go To HomePage and verify title", groups={"Regression"})
    public void verifyLoginLink() {
        this.exTest = this.extent.startTest("verifyLoginLink");
        LoginPage loginPage = this.goToHomePage(this.driver).clickLogin();
        String pageTitle = loginPage.getPageTitle();
        System.out.println("page title" + PropertiesFile.getProperty((String)"loginPage.title"));
        Assert.assertEquals((String)pageTitle, (String)PropertiesFile.getProperty((String)"loginPage.title"), (String)"Verify that user is in Login Page");
        this.exTest.log(LogStatus.PASS, "Assert PASS");
        this.exTest.log(LogStatus.FAIL, "Assert FAIL");
    }

    @Test(description="TC02 : To validate login page elements", groups={"Regression"})
    public void validateLoginPageElements() throws InterruptedException {
        this.exTest = this.extent.startTest("validateLoginPageElements");
        LoginPage loginPage = this.goToHomePage(this.driver).clickLogin();
        Assert.assertTrue((boolean)loginPage.isEmailTextBoxEnabled());
        Assert.assertTrue((boolean)loginPage.isSignUpButtonEnabled(), (String)"My Message TC02");
    }

    @Test(description="TC03 : To Validate signup Page elements", groups={"Regression"})
    public void validateSignUpPageElements() {
        this.exTest = this.extent.startTest("validateSignUpPageElements");
        LoginPage loginPage = this.goToHomePage(this.driver).clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpButton();
        Assert.assertTrue((boolean)signUpPage.isEmailTextFieldEnabled(), (String)" my Message TC03");
        Assert.assertTrue((boolean)signUpPage.isSignUpButtonEnabled(), (String)" my Message TC03");
    }

    @Test(description="TC04 : To validate successful signIn to appdirect", groups={"Regression"})
    public void validateSuccessfulSignUp() {
        this.exTest = this.extent.startTest("validateSignUpPageElements");
        LoginPage loginPage = this.goToHomePage(this.driver).clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpButton();
        signUpPage.registerUser();
        Assert.assertTrue((boolean)signUpPage.isSignUpSuccessMessageDisplayed(), (String)"Message TC04");
    }

    @Test(description="TC05 : To Validate developer signup link navigates to DeveloperSignUp page", groups={"Regression"})
    public void verifyDevelpoerSignUpLink() throws InterruptedException {
        this.exTest = this.extent.startTest("validateSignUpPageElements");
        LoginPage loginPage = this.goToHomePage(this.driver).clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpButton();
        Thread.sleep(5000);
        DeveloperSignUpPage developerSignUpPage = signUpPage.clickDeveloperSignUpLink();
        Thread.sleep(5000);
        Assert.assertTrue((boolean)developerSignUpPage.isUserInDeveloperSingUpPage(), (String)"Message TC05");
    }

    @Test(description="TC06 : To Verify error message for signup already registered user", groups={"Regression"})
    public void verifyErrorMessageForAlreadyRegisteredUser() {
        this.exTest = this.extent.startTest("validateSignUpPageElements");
        LoginPage loginPage = this.goToHomePage(this.driver).clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        signUpPage.signUpAlreadyRegisteredUser();
        Assert.assertTrue((boolean)signUpPage.isDuplicateEmailErrorMessageDisplayed(), (String)"Error message not visible when already registered user tries to register again");
    }

    @Test(description="TC07 : Test to verify user cannot login with invalid email address", groups={"Regression"})
    public void verifyUserCannotLoginWithInvalidEmailAddress(String invalidEmailAddress) {
        this.exTest = this.extent.startTest("validateSignUpPageElements");
        LoginPage loginPage = this.goToHomePage(this.driver).clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpButton();
        signUpPage.registerUserWithEmailId(invalidEmailAddress);
    }
}