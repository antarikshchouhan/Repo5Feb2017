package MavenJenkisGitProject.com.maven.jenkins.git.basetest;

import MavenJenkisGitProject.com.maven.jenkins.git.pages.AppDirectLandingPage;
import MavenJenkisGitProject.com.maven.jenkins.git.properties.Browser;
import MavenJenkisGitProject.com.maven.jenkins.git.properties.PropertiesFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected PropertiesFile properties;
    public ExtentReports extent;
    public ExtentTest exTest;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$maven$project$properties$Browser;

    @BeforeSuite
    public void startReport() {
        this.extent = new ExtentReports(String.valueOf(System.getProperty("user.dir")) + "/test-output/FirstExtentReportNew.html", Boolean.valueOf(true));
        System.out.println("Initializing Extent Report PATH set");
        this.extent.addSystemInfo("Host Name", "Ant").addSystemInfo("Environment", "QA").addSystemInfo("User Name", "Ant");
        System.out.println("Initializing Extent Report SYSTEM INFO SET");
        this.extent.loadConfig(new File(String.valueOf(System.getProperty("user.dir")) + "/extent-config.xml"));
        System.out.println("Initializing Extent Report LOADED");
    }

    @BeforeMethod
    public void setup() {
        this.driver = this.getWebDriver(Browser.FIREFOX);
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == 2) {
            this.exTest.log(LogStatus.FAIL, result.getThrowable());
        }
        this.extent.endTest(this.exTest);
    }

    public WebDriver getWebDriver(Browser browser) {
        switch (BaseTest.$SWITCH_TABLE$com$maven$project$properties$Browser()[browser.ordinal()]) {
            case 1: {
                System.setProperty("webdriver.gecko.driver", "F://geckoDriver//geckodriver.exe");
                this.driver = new FirefoxDriver();
                this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                return this.driver;
            }
            case 2: {
                System.setProperty("webdriver.chrome.driver", "F://ChromeDriver//chromedriver.exe");
                this.driver = new ChromeDriver();
                this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                return this.driver;
            }
            case 3: {
                System.setProperty("webdriver.ie.driver", "F://IEDriver//IEDriverServer.exe");
                this.driver = new FirefoxDriver();
                this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                return this.driver;
            }
        }
        this.driver = null;
        System.out.println("Not implemented for the browser " + (Object)browser);
        return null;
    }

    public AppDirectLandingPage goToHomePage(WebDriver driver) {
        this.driver.get("http://www.appdirect.com/");
        return new AppDirectLandingPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }

    @AfterTest
    public void endExtentReport() {
        this.extent.flush();
        this.extent.close();
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$maven$project$properties$Browser() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$com$maven$project$properties$Browser;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[Browser.values().length];
        try {
            arrn[Browser.CHROME.ordinal()] = 2;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[Browser.FIREFOX.ordinal()] = 1;
        }
        catch (NoSuchFieldError v2) {}
        try {
            arrn[Browser.IE.ordinal()] = 3;
        }
        catch (NoSuchFieldError v3) {}
        $SWITCH_TABLE$com$maven$project$properties$Browser = arrn;
        return $SWITCH_TABLE$com$maven$project$properties$Browser;
    }
}