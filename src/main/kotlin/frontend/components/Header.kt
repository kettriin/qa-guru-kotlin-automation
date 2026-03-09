package frontend.components

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.elements
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import io.qameta.allure.Step

class Header {

    private val linksHeader: ElementsCollection get() = elements(byDataTestGroup("nav-link"))

    @Step("Клик по ссылке в хедере")
    fun clickLink(linkName: String): Header {
        linksHeader.find { it.text().contains(linkName) }?.click()
        return this
    }

    @Step("Клик по всем ссылкам навигации")
    fun clickAllNavLinks(): Header {
        for (link in linksHeader) clickLink(link.text())
        return this
    }
}