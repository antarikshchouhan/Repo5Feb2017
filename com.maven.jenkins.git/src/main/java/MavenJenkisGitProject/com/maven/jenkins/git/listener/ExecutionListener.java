package MavenJenkisGitProject.com.maven.jenkins.git.listener;

import java.io.PrintStream;
import org.testng.IExecutionListener;

public class ExecutionListener
implements IExecutionListener {
    private long startTime;

    public void onExecutionStart() {
        this.startTime = System.currentTimeMillis();
        System.out.println("TestNG is going to start" + this.startTime);
    }

    public void onExecutionFinish() {
        System.out.println("TestNG is Finished at >>>>>>>>" + System.currentTimeMillis() + " and it took around " + (System.currentTimeMillis() - this.startTime) + "ms");
    }
}
