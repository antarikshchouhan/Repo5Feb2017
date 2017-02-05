package MavenJenkisGitProject.com.maven.jenkins.git.listener;


import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ReporterListener
implements IReporter {
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println("**************Custom Report***************");
        ISuite suite = suites.get(0);
        Map methodsByGroup = suite.getMethodsByGroups();
        Map tests = suite.getResults();
        for (String key : tests.keySet()) {
            System.out.println("key " + key + " and value " + tests.get(key));
        }
    }
}