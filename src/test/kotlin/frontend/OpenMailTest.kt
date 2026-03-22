package frontend

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import frontend.helpers.BaseUiTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class OpenMailInSelenideTest : BaseUiTest() {

    @Test
    @DisplayName("Открыть mail.ru на удаленном браузере")
    fun openYoutubeMainPage() {
        Selenide.open("/")
        val title = Selenide.title()
        sleep(10000)
        title shouldBe "Mail: Почта, Облако, Календарь, Заметки, Покупки — сервисы для работы и жизни"
    }
}