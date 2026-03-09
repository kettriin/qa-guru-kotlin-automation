package frontend

import com.codeborne.selenide.WebDriverRunner
import frontend.components.Header
import frontend.components.HeaderLinks
import frontend.helpers.BaseUiTest
import frontend.pages.MainPage
import frontend.pages.ProductsPage
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import java.lang.Thread.sleep

class MainPageTest : BaseUiTest() {

    @Test
    @DisplayName("Названия кофейни на главной странице соответствует ожидаемому")
    fun mainImageTextTest() {
        val mainImageText = MainPage()
            .getMainImageText()

        mainImageText shouldBe "Welcome to Brew & Bean"
    }

    @Test
    @DisplayName("Переход с главной страницы на страницу Продукты через хедер")
    fun redirectToProductsByHeader() {
        MainPage().header().clickLink("Products")
        val productCardsAmmount = ProductsPage().getProductList()

        productCardsAmmount shouldHaveSize 6
    }

    @ParameterizedTest
    @DisplayName("Переход по страницам из навигации в хедере")
    @EnumSource(HeaderLinks::class)
    fun headerNaviTest(headerLinks: HeaderLinks) {
        Header().clickLink(headerLinks.linkName)
        sleep(2000)
        WebDriverRunner.url() shouldContain headerLinks.expectedUrl
    }
}