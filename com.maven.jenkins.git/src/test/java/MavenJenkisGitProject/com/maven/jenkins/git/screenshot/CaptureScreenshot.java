import MavenJenkisGitProject.com.maven.jenkins.git.util.GetScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureScreenshot {
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;

    @BeforeTest
    public void init() {
        this.reports = new ExtentReports(String.valueOf(System.getProperty("user.dir")) + "/test-output/FirstExtentSCREENSHOT.html");
    }

    @Test
    public void captureScreenshot() {
        this.test = this.reports.startTest("captureScreenshot");
        this.driver = new FirefoxDriver();
        this.driver.get("http://www.google.com");
        String title = this.driver.getTitle();
        Assert.assertEquals((String)title, (String)"AA");
        this.test.log(LogStatus.FAIL, "FAILLLLLLLLLLLLLLLLLLLLLLL");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == 2) {
            String screenshotPath = GetScreenshot.capture((WebDriver)this.driver, (String)"FirstExtentScreenshot");
            this.test.log(LogStatus.FAIL, result.getThrowable());
            this.test.log(LogStatus.FAIL, "HAHA");
            this.test.log(LogStatus.FAIL, "SCREENSHOT BELOW" + this.test.addScreenCapture(screenshotPath));
        }
        this.reports.endTest(this.test);
    }

    @AfterTest
    public void tearDown() {
        this.reports.endTest(this.test);
        this.test.log(LogStatus.INFO, "----------------Ending TEST--------------");
        this.reports.flush();
        this.test.log(LogStatus.INFO, "----------------FLUSHING--------------");
        this.reports.close();
        this.test.log(LogStatus.INFO, "----------------CLOSING--------------");
    }
}