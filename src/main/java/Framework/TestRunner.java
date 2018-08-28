package Framework;
import com.cucumber.listener.Reporter;
import enums.Mobile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"stepDefinitions"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },plugin = "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html")

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
   public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @BeforeMethod
    public void setUp() throws InterruptedException, MalformedURLException {

        driver = Os.getDriver(Mobile.ANDROID);


        //https://d1qoal4nguj436.cloudfront.net/sign-up

        Thread.sleep(1000);
    }


        public File[] getListOfFiles(String directoryName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File directory = new File(classLoader.getResource(directoryName).getFile());
        File[] files = directory.listFiles();
        // System.out.println("Found " + files.length + " files in " + directoryName + " folder");
        return files;
    }


    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        Reporter.loadXMLConfig(new File("src\\main\\resources\\config\\extent-config.xml"));
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException{

        driver.quit();
    }
}