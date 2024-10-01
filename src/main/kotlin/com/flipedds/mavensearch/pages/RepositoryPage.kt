package com.flipedds.mavensearch.pages

import com.flipedds.mavensearch.factories.WebDriverFactory
import com.flipedds.mavensearch.domain.RepositoryItem
import com.flipedds.mavensearch.pages.shared.BasePage
import org.openqa.selenium.By
import org.springframework.stereotype.Component

@Component
class RepositoryPage(
    private val webDriverFactory: WebDriverFactory): BasePage() {
    private val listOfRepositoryItens = mutableListOf<RepositoryItem>()
    private val locatorCardsRepository: By = By.xpath(
        "//h3[@data-test=\"component-card-name\"]"
    )
    private val locatorDependencyText: By = By.cssSelector("pre[data-test='snippet']")
    private val locatorDropdownBuild: By = By.xpath(
        "//select[@data-test=\"snippet-dropdown\"]"
    )
    private val locatorChoiceBuildGradle: By =
        By.xpath("//*[text()=\"Gradle (short)\"]")
    private val locatorChoiceBuildKotlin: By =
        By.xpath("//*[text()=\"Gradle (Kotlin)\"]")

    fun searchFor(name: String) {

        initDriver(webDriverFactory.createWebDriver())

        try {
            println("Searching for $name in maven repository .........")

            goToUrl("https://central.sonatype.com/search?q=$name")

            findElementsInPage(locatorCardsRepository).forEach {
                listOfRepositoryItens.add(RepositoryItem(it.text, getArtifactOfPackage(pack = it.text)))
            }

            println("Package: ${listOfRepositoryItens.first().pack} : Artifact: ${listOfRepositoryItens.first().artifact}")

            val choice = listOfRepositoryItens.first().pack

            goToUrl(
                "https://central.sonatype.com/artifact/${
                    getArtifactOfPackage(
                        choice
                    )
                }/$choice"
            )
            waitATime()
            println("MAVEN")
            println(findSingleElementInPage(locatorDependencyText)?.text)
            findSingleElementInPage(locatorDropdownBuild)?.let { waitToBeVisibleClicableAndClick(it) }
            findSingleElementInPage(locatorChoiceBuildGradle)?.let { waitToBeVisibleClicableAndClick(it) }
            println("GRADLE")
            println(findSingleElementInPage(locatorDependencyText)?.text)
            findSingleElementInPage(locatorChoiceBuildKotlin)?.let { waitToBeVisibleClicableAndClick(it) }
            println("GRADLE KOTLIN")
            println(findSingleElementInPage(locatorDependencyText)?.text)
        }catch (ex: Exception) {
            println("Maven dependency $name not found")
        } finally {
            finishDriver()
        }
    }
}