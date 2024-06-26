package github.page.instance;

import github.util.GitHubJobUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver instance;

    public static WebDriver getInstance() {
        if(instance != null) {
            return instance;
        }
        synchronized (Driver.class) {
            if (instance == null) {
                    instance = GitHubJobUtil.getDriverWithOptions(ChromeDriver.class);
            }
        }
    return instance;
    }

    public static void setNull() {
        if(instance == null) {
            return;
        }
        synchronized (Driver.class) {
            if (instance != null) {
                instance = null;
            }
        }
    }
}
