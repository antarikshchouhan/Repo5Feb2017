package MavenJenkisGitProject.com.maven.jenkins.git.listener;

import java.io.PrintStream;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class InvokedMethodListener
implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Before Invocation of method TestMethod name-->" + (Object)method.getTestMethod());
        System.out.println("Before Invocation of method Method name-->" + (Object)method.getTestMethod());
        System.out.println("Before Invocation of method-->" + testResult.getStatus());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("After Invocation of method TestMethod name-->" + (Object)method.getTestMethod());
        System.out.println("After Invocation of method Method name-->" + (Object)method.getTestMethod());
        System.out.println("After Invocation of method-->" + testResult.getStatus());
    }
}