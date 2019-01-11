

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.HashMap;
import java.util.Map;

//java -jar /usr/share/jenkins/jenkins.war

public class JustTest {
    String chromePath = "/drivers/chromedriverWin.exe";
    //String chromePath = "/drivers/chromedriverUnix";
    //String chromePath = "/drivers/chromedriverMac";
    WebDriver driver;

    @Before
    public void startChrome() {
        setChromeEnvVariable();
        driver = new ChromeDriver(getChromeOptions());

    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        openUrl("http://www.google.com/xhtml");
        Thread.sleep(5000);  // Let the user actually see something!

        searchFor("brainacad");
        Thread.sleep(5000);  // Let the user actually see something
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    private void openUrl(String url) {
        driver.get(url);
    }

    private void searchFor(String text){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(text);
        searchBox.submit();
    }

    private void setChromeEnvVariable() {
        System.setProperty("webdriver.chrome.driver", getChromePath());
    }

    private String getChromePath(){
        return System.getProperty("user.dir") + chromePath;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", getMobileEmulation());
        return options;
    }

    private Map<String, String> getMobileEmulation() {
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Nexus 10");
        return mobileEmulation;
    }
    /*NOTE: Accepted devices:
        BlackBerry Z30
        Blackberry PlayBook
        Galaxy Note 3
        Galaxy Note II
        Galaxy S III
        Kindle Fire HDX
        LG Optimus L70
        Laptop with HiDPI screen
        Laptop with MDPI screen
        Laptop with touch
        Microsoft Lumia 550
        Microsoft Lumia 950
        Nexus 10
        Nexus 4
        Nexus 5
        Nexus 6
        Nexus 7
        Nokia Lumia 520
        Nokia N9
        iPad Mini
        iPhone 4
        Galaxy S5
        Nexus 5X
        Nexus 6P
        iPhone 5
        iPhone 6
        iPhone 6 Plus
        iPad
    */

}
