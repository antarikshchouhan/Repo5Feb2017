package MavenJenkisGitProject.com.maven.jenkins.git.pages;

import MavenJenkisGitProject.com.maven.jenkins.git.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AppDirectLandingPage {
    private WebDriver driver;
    @FindBy(how=How.XPATH, using=".//menu/ul//li[@class='login']/a")
    public WebElement loginLink;

    public AppDirectLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((WebDriver)driver, (Object)this);
    }

    public LoginPage clickLogin() {
        this.loginLink.click();
        return new LoginPage(this.driver);
    }
}