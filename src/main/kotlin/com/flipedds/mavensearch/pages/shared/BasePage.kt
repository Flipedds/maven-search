package com.flipedds.mavensearch.pages.shared

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

abstract class BasePage {
    private lateinit var driver: ChromeDriver

    protected fun initDriver(driver: ChromeDriver) {
        this.driver = driver
    }

    protected fun goToUrl(url: String) {
        this.driver.get(url)
    }

    protected fun waitATime() {
        Thread.sleep(Duration.ofSeconds(2))
    }

    protected fun findElementsInPage(locator: By): List<WebElement> {
        return this.driver.findElements(locator)
    }

    protected fun findSingleElementInPage(locator: By): WebElement? {
        return this.driver.findElement(locator)
    }

    protected fun getArtifactOfPackage(pack: String): String {
        return this.driver.findElement(
            By.xpath(
                "//h3[@data-test=\"component-card-name\" and text()=\"$pack\"]/following-sibling::a/label/span"
            )
        ).text
    }

    protected fun finishDriver() {
        driver.quit()
    }

    protected fun waitToBeVisibleClicableAndClick(element: WebElement) {
        val wait = WebDriverWait(this.driver, Duration.ofSeconds(30))
        wait.until(ExpectedConditions.visibilityOf(element))
        wait.until(ExpectedConditions.elementToBeClickable(element))
        element.click()
    }
}