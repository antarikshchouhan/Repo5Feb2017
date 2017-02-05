package MavenJenkisGitProject.com.maven.jenkins.git.pages;

import MavenJenkisGitProject.com.maven.jenkins.git.base.BasePage;
import MavenJenkisGitProject.com.maven.jenkins.git.pages.SignUpPage;
import java.io.PrintStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
extends BasePage {
    protected WebDriver driver;
    @FindBy(how=How.ID, using="username")
    public WebElement emailTextBox;
    @FindBy(how=How.ID, using="password")
    public WebElement passwordTextBox;
    @FindBy(how=How.LINK_TEXT, using="Sign up for an account")
    public WebElement signUpButton;
    @FindBy(how=How.XPATH, using="//form[@name = 'signInForm']//p/a")
    public WebElement signUpLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((WebDriver)driver, (Object)((Object)this));
    }

    public SignUpPage clickSignUpLink() {
        this.signUpLink.click();
        return new SignUpPage(this.driver);
    }

    public SignUpPage clickSignUpButton() {
        this.signUpButton.click();
        return new SignUpPage(this.driver);
    }

    public boolean isEmailTextBoxEnabled() {
        return this.emailTextBox.isEnabled();
    }

    public boolean isSignUpButtonEnabled() {
        return this.signUpButton.isEnabled();
    }

    public String getPageTitle() {
        System.out.println("driver is >" + (Object)this.driver);
        return this.driver.getTitle();
    }
}