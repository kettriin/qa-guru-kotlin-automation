package frontend.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step
import java.time.Duration

class ProductsPage {

    private val txtTitle: SelenideElement get() = element(byDataTestId("products-title"))
    private val listItems: ElementsCollection get() = elements(byDataTestGroup("product-card"))

    @Step("Получить название страницы продуктов")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Получить список продуктов на странице")
    fun getProductList(): ElementsCollection {
        return listItems
    }

    @Step("Проверить, что страница продуктов загрузилась")
    fun waitForPageLoaded(): ProductsPage {
        txtTitle.shouldBe(Condition.visible, Duration.ofSeconds(5))
        return this
    }
}