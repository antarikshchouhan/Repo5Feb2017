package MavenJenkisGitProject.com.maven.jenkins.git.pages;

import MavenJenkisGitProject.com.maven.jenkins.git.base.BasePage;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlipKartSearchProductOnHomePage
extends BasePage {
    protected WebDriver driver;
    protected Properties properties;
    @FindBy(how=How.XPATH, using=".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[1]/div/input")
    WebElement searchBox;
    @FindBy(how=How.XPATH, using=".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button")
    WebElement searchButton;

    public FlipKartSearchProductOnHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((WebDriver)driver, (Object)((Object)this));
    }

    public FlipKartSearchProductOnHomePage searchProduct(String product) {
        this.searchBox.sendKeys(new CharSequence[]{product});
        this.searchButton.click();
        return this;
    }
}