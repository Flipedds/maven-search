package com.flipedds.mavensearch.factories

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.PageLoadStrategy
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.stereotype.Component

@Component
class WebDriverFactory {
    fun createWebDriver(): ChromeDriver {
        WebDriverManager.chromedriver().setup()
        val options = ChromeOptions()
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL)
        options.addArguments(
            "--headless=old",
            "--no-sandbox",
            "--disable-gpu",
            "--disable-crash-reporter",
            "--disable-extensions",
            "--disable-in-process-stack-traces",
            "--disable-logging",
            "--disable-dev-shm-usage",
            "--log-level=3",
            "--output=/dev/null"
        )
        return ChromeDriver(options)
    }
}