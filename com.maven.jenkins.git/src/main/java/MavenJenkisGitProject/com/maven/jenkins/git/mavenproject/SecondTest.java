package MavenJenkisGitProject.com.maven.jenkins.git.mavenproject;

import java.io.PrintStream;
import org.testng.annotations.Test;

public class SecondTest {
    @Test(groups={"B", "C"})
    public void secondTest() {
        System.out.println("Second test without TesatNG");
    }
}