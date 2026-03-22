package frontend.components

import com.codeborne.selenide.Condition
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.WebDriverRunner
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import io.qameta.allure.Step
import java.time.Duration

class Header {

    private val linksHeader: ElementsCollection get() = elements(byDataTestGroup("nav-link"))

    @Step("Клик по ссылке в хедере")
    fun clickLink(linkName: String): Header {
        val link = linksHeader.find { it.text().contains(linkName) }
        link?.shouldBe(Condition.visible, Duration.ofSeconds(2))
        link?.click()

        Selenide.Wait().until { WebDriverRunner.url() != "http://localhost:4000/" }

        return this
    }

    @Step("Клик по всем ссылкам навигации")
    fun clickAllNavLinks(): Header {
        for (link in linksHeader) {
            link.shouldBe(Condition.visible, Duration.ofSeconds(2))
            clickLink(link.text())
        }
        return this
    }
}