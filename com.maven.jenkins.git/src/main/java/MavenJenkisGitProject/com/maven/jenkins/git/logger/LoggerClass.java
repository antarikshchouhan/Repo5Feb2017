package MavenJenkisGitProject.com.maven.jenkins.git.logger;

import org.apache.log4j.Logger;

public class LoggerClass {
    public static void logD(String message) {
        Logger logger = Logger.getLogger((String)"LoggerClass");
    }
}