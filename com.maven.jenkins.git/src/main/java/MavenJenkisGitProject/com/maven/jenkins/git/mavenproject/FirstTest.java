package MavenJenkisGitProject.com.maven.jenkins.git.mavenproject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.io.PrintStream;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
    public ExtentReports reports;
    public ExtentTest test;

    @BeforeTest
    public void createReport() {
        this.reports = new ExtentReports(String.valueOf(System.getProperty("user.dir")) + "/test-output/FirstExtentReport2.html", Boolean.valueOf(true));
        this.reports.addSystemInfo("Host Name", "Host Host").addSystemInfo("User Name", "User User").addSystemInfo("Environment", "QA");
        this.reports.loadConfig(new File(String.valueOf(System.getProperty("user.dir")) + "/extent-config.xml"));
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @Test(groups={"A"})
    public void firstTest() {
        this.test = this.reports.startTest("firstTest");
        System.out.println("First test without TesatNG");
        Assert.assertTrue((boolean)true);
        this.test.log(LogStatus.PASS, "First Test Passed");
    }

    @Test(groups={"B", "C"})
    public void secondTest() {
        this.test = this.reports.startTest("secondTest");
        System.out.println("Second test without TesatNG");
        Assert.assertTrue((boolean)false);
        this.test.log(LogStatus.FAIL, "Second test Failed");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        this.test = this.reports.startTest("secondTest");
        if (result.getStatus() == 2) {
            this.test.log(LogStatus.FAIL, result.getThrowable());
        }
        this.reports.endTest(this.test);
    }

    @AfterTest
    public void afterTest() {
        this.reports.flush();
        this.reports.close();
    }
}