package MavenJenkisGitProject.com.maven.jenkins.git.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    public static Properties properties = new Properties();

    static {
        try {
            File testPropertiesFile = null;
            File locatorPropertiesFile = null;
            if (System.getProperty("user.dir") != null) {
                testPropertiesFile = new File(String.valueOf(System.getProperty("user.dir")) + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "test.properties");
                locatorPropertiesFile = new File(String.valueOf(System.getProperty("user.dir")) + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "locator.properties");
            }
            properties.load(new FileInputStream(testPropertiesFile));
            properties.load(new FileInputStream(locatorPropertiesFile));
        }
        catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    public static String getLocator(String locatorKey) {
        return properties.getProperty(locatorKey);
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getAppUrl(String url) {
        return properties.getProperty(url);
    }
}