package MavenJenkisGitProject.com.maven.jenkins.git.mavenproject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogGeneration {
    ExtentReports reports;
    ExtentTest test;

    @BeforeTest
    public void config() {
        this.reports = new ExtentReports(String.valueOf(System.getProperty("user.dir")) + "/test-output/FirstExtentLOGS11.html");
    }

    @Test
    public void testExtentLogs() {
        this.test = this.reports.startTest("testExtentLogs");
        this.test.log(LogStatus.INFO, "First LOG using Extent Logs");
        this.test.log(LogStatus.INFO, "First LOG using Extent Logs");
        this.test.log(LogStatus.INFO, "First LOG using Extent Logs");
        this.test.log(LogStatus.INFO, "First LOG using Extent Logs");
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