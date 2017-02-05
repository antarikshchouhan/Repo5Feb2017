package MavenJenkisGitProject.com.maven.jenkins.git.listener;


import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.Test;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MethodInterceptorListener
implements IMethodInterceptor {
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        ArrayList<IMethodInstance> result = new ArrayList<IMethodInstance>();
        for (IMethodInstance m : methods) {
            Test test = m.getMethod().getMethod().getAnnotation(Test.class);
            HashSet<String> groups = new HashSet<String>();
            String[] arrstring = test.groups();
            int n = arrstring.length;
            int n2 = 0;
            while (n2 < n) {
                String group = arrstring[n2];
                groups.add(group);
                ++n2;
            }
            if (groups.contains("Regression")) {
                result.add(m);
                continue;
            }
            String testMethod = m.getMethod().getMethodName();
            System.out.println(String.valueOf(testMethod) + " is not in Regression List... so remove it");
        }
        return result;
    }
}