package frontend.pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

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
}