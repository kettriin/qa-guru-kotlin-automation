package frontend

import frontend.components.Header
import frontend.helpers.HeaderLinks
import frontend.helpers.BaseUiTest
import frontend.pages.MainPage
import frontend.pages.CommonSteps
import frontend.pages.ProductsPage
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

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
        MainPage()
            .openMainPage()
            .navigateToHeader()
            .clickLink("Products")

        val title = ProductsPage().getTitle()
        title shouldBe "All Products"
    }

    @ParameterizedTest
    @DisplayName("Переход по страницам из навигации в хедере")
    @EnumSource(HeaderLinks::class)
    fun headerNaviTest(headerLinks: HeaderLinks) {
        MainPage()
            .openMainPage()
            .navigateToHeader()
            .clickLink(headerLinks.linkName)

        CommonSteps().getPageUrl() shouldContain headerLinks.expectedUrl
    }

    @Test
    @Disabled ("Прочерка на аликаьельность ссылок - неактуально")
    @DisplayName("Ссылки в хедере кликабельны")
    fun clickHeaderLinks() {
        Header().clickAllNavLinks()
    }
}