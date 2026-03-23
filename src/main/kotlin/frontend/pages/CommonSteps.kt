package frontend.pages

import com.codeborne.selenide.Selenide
import io.qameta.allure.Step

class CommonSteps {

    @Step("Получить урл страницы")
    fun getPageUrl(): String {
        val currentUrl = Selenide.webdriver().driver().url()
        return currentUrl
    }
}