package MavenJenkisGitProject.com.maven.jenkins.git.pages;

import MavenJenkisGitProject.com.maven.jenkins.git.base.BasePage;
import MavenJenkisGitProject.com.maven.jenkins.git.pages.DeveloperSignUpPage;
import java.io.PrintStream;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.PropertiesFile;

public class SignUpPage
extends BasePage {
    protected WebDriver driver;
    protected PropertiesFile properties;
    @FindBy(how=How.NAME, using="emailAddress")
    public WebElement emailTextField;
    @FindBy(how=How.NAME, using="userSignupButton")
    public WebElement signUpButton;
    @FindBy(how=How.XPATH, using="//p[@id='partnerRegisterLink']/a")
    public WebElement developerSignUpLink;
    @FindBy(how=How.XPATH, using="//div[@class='adb-local_alert--content']//h3")
    public WebElement signUpSuccess;
    @FindBy(how=How.ID, using="//div[@class='adb-local_alert adb-local_alert__error']//p")
    public WebElement duplicateEmailErrorMessage;
    @FindBy(how=How.ID, using="//div[@class='adb-local_alert adb-local_alert__error']//p")
    public WebElement invalidEmailMessage;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((WebDriver)driver, (Object)((Object)this));
    }

    public boolean isEmailTextFieldEnabled() {
        System.out.println("emailTextField is:" + (Object)this.emailTextField);
        return this.emailTextField.isEnabled();
    }

    public boolean isSignUpButtonEnabled() {
        System.out.println("signUpButton is:" + (Object)this.signUpButton);
        return this.signUpButton.isEnabled();
    }

    public boolean isSignUpSuccessMessageDisplayed() {
        return this.signUpSuccess.isDisplayed();
    }

    public boolean isInvalidEmailMessageDisplayed() {
        return this.invalidEmailMessage.isDisplayed();
    }

    public boolean isDuplicateEmailErrorMessageDisplayed() {
        return this.duplicateEmailErrorMessage.isDisplayed();
    }

    public SignUpPage clickSignUpButton() {
        this.signUpButton.click();
        return this;
    }

    public DeveloperSignUpPage clickDeveloperSignUpLink() {
        this.developerSignUpLink.click();
        return new DeveloperSignUpPage(this.driver);
    }

    public void enterEmailAddress(String emailAddress) {
        this.emailTextField.sendKeys(new CharSequence[]{emailAddress});
    }

    public void registerUser() {
        this.enterEmailAddress(this.getUniqueEmailAdress());
        this.clickSignUpButton();
    }

    public String getUniqueEmailAdress() {
        return String.valueOf(UUID.randomUUID().toString()) + "@appdir.com";
    }

    public void registerUserWithEmailId(String emailAddress) {
        this.enterEmailAddress(emailAddress);
        this.clickSignUpButton();
    }

    public void signUpAlreadyRegisteredUser() {
        String userEmailId = this.getUniqueEmailAdress();
        this.registerUserWithEmailId(userEmailId);
        if (!this.isSignUpSuccessMessageDisplayed()) {
            this.webDriverWaitForElementVisibility(this.signUpSuccess);
        }
        this.driver.get("URL of appdirect");
        this.registerUserWithEmailId(userEmailId);
    }
}