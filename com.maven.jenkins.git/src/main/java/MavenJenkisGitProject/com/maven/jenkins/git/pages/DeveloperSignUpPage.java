package MavenJenkisGitProject.com.maven.jenkins.git.pages;

import MavenJenkisGitProject.com.maven.jenkins.git.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DeveloperSignUpPage
extends BasePage {
    protected WebDriver driver;

    public DeveloperSignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((WebDriver)this.driver, (Object)((Object)this));
    }

    public boolean isUserInDeveloperSingUpPage() {
        return this.driver.getCurrentUrl().contains("/developers/register");
    }
}