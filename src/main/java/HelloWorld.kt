import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL


class HelloWorld {

    private lateinit var driver: AndroidDriver<MobileElement>
    private lateinit var wait: WebDriverWait

    //Elements By
    //var jobsBy = By.id("com.isinolsun.app:id/rootRelativeView")

    @BeforeMethod
    @Throws(MalformedURLException::class)
    fun setup() {
        val caps = DesiredCapabilities()
        caps.setCapability("deviceName", "Xiaomi Mi A2")
        caps.setCapability("udid", "8b90f19") //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android")
        caps.setCapability("platformVersion", "11.0")
        caps.setCapability("skipUnlock", "true")
        caps.setCapability("appPackage", "com.sulekha.businessapp.debug")
        caps.setCapability("appActivity", "com.sulekha.businessapp.base.feature.login.ui.login.LoginActivity")
        caps.setCapability("noReset", "false")
        driver = AndroidDriver<MobileElement>(URL("http://localhost:4723/wd/hub"), caps)
        wait = WebDriverWait(driver, 10)
    }

    @Test
    @Throws(InterruptedException::class)
    fun basicTest() {
        //Click and pass Splash
        println("test cases started")
        try {
            driver.findElement(By.xpath("//*[@text='NONE OF THE ABOVE']"))?.click()
            driver.findElement(By.id("edMobileNumber"))?.click()
            driver.findElement(By.id("edMobileNumber"))?.sendKeys("9003349787")
            driver.findElement(By.id("btnSendCode"))?.click()
        } catch (e: Exception) {
            println(e.stackTrace)
        }
    }


    @AfterMethod
    fun teardown() {
        driver.quit()
    }


}