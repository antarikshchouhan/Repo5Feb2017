package MavenJenkisGitProject.com.maven.jenkins.git.base;


import com.google.common.base.Function;
import java.io.PrintStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public String getPageTitle(WebDriver driver) {
        System.out.println("driver is >" + (Object)this.driver);
        return this.driver.getTitle();
    }

    public void webDriverWaitForElementVisibility(WebElement signUpSuccess) {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 5);
        webDriverWait.until((Function)ExpectedConditions.visibilityOf((WebElement)signUpSuccess));
    }
}