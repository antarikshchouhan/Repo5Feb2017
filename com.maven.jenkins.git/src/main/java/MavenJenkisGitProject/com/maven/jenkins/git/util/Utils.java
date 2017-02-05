package MavenJenkisGitProject.com.maven.jenkins.git.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static String capture(WebDriver driver, String ScreenshotName) throws IOException {
        TakesScreenshot tsh = (TakesScreenshot)driver;
        File source = (File)tsh.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir/ErrorScreenshot/" + ScreenshotName + ".png");
        File destination = new File(dest);
        FileUtils.copyFile((File)source, (File)destination);
        return dest;
    }

    public static int webtableRead() {
        return 0;
    }

    public static boolean webtableWrite() {
        return false;
    }
}
