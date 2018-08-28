package Framework;

import enums.Mobile;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Os {
    public static WebDriver getDriver(Mobile mobileOs) throws MalformedURLException {
        WebDriver driver = null;

        switch (mobileOs) {
            case ANDROID:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("BROWSER_NAME", "Android");
                capabilities.setCapability("VERSION", "6.0.1");
                capabilities.setCapability("deviceName","Xperia Z2");
                capabilities.setCapability("platformName","Android");

                capabilities.setCapability("autoGrantPermissions",true);
                capabilities.setCapability("noReset","true");
                capabilities.setCapability("fullReset","false");

                capabilities.setCapability("appPackage", "com.guzmanygomez.gyg.uat");
// This package name of your app (you can get it from apk info app)
                capabilities.setCapability("appActivity","com.guzmanygomez.gyg.ui.activities.SplashActivity"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
                //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
                driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

                break;




            default:
                throw new RuntimeException("Unknown browser: " + mobileOs);
        }
        return driver;
    }
}