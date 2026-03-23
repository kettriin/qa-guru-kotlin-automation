package frontend.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.SelenideElement
import frontend.components.Header
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step
import java.time.Duration

class MainPage {

    private val mainImageText: SelenideElement get() = element(byDataTestId("main-image-text"))

    @Step("Открыть главную страницу")
    fun openMainPage(): MainPage {
        open("/")
        return this
    }

    @Step("Получить название кофейни")
    fun getMainImageText(): String {
        mainImageText.shouldBe(Condition.visible, Duration.ofSeconds(2))
        return mainImageText.text
    }

    @Step("Получить Header из главной страницы")
    fun navigateToHeader(): Header {
        return Header()
    }
}