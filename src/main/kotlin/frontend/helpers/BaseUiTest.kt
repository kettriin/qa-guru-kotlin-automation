package frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class BaseUiTest {

    init {
//        Configuration.baseUrl = "http://localhost:4000"
//        Configuration.timeout = 11000
//        Configuration.pageLoadStrategy = "eager"
//        Configuration.reopenBrowserOnFail = true
        Configuration.browser = DriverProvider::class.java.name
    }

    @BeforeEach
    fun openBrowser() {
        Selenide.open("/")
    }

    @AfterEach
    fun closeBrowser() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
    }
}