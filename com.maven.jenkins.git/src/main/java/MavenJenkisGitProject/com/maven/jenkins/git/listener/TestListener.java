package MavenJenkisGitProject.com.maven.jenkins.git.listener;

import java.io.PrintStream;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener
implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("on Test Start  -->" + result.toString());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("on Test Success  -->" + result.toString());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("on Test Failure  -->" + result.toString());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("on Test Skipped  -->" + result.toString());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("on Test Failed But Within Success Percentage-->" + result.toString());
    }

    public void onStart(ITestContext context) {
        System.out.println("on START  -->" + context.toString());
    }

    public void onFinish(ITestContext context) {
        System.out.println("on FINISH -->" + context.toString());
    }
}
