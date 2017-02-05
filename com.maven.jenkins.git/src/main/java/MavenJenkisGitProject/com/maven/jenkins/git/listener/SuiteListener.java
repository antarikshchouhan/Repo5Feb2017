package MavenJenkisGitProject.com.maven.jenkins.git.listener;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlSuite;

public class SuiteListener
implements ISuiteListener {
    public void onStart(ISuite suite) {
        System.out.println("on SUITE START  -->" + suite.getName());
        XmlSuite xmlSuite = suite.getXmlSuite();
        if (!xmlSuite.getTest().isEmpty()) {
            HashMap<String, String> parms = new HashMap<String, String>();
            parms.put("ui", "web");
            System.out.println("Set ui param value");
            xmlSuite.setParameters(parms);
            System.out.println(parms.values());
        }
    }

    public void onFinish(ISuite suite) {
        System.out.println("on SUITE FINISH -->" + suite.toString());
    }
}
