package com.flipedds.mavensearch.configs

import org.jline.utils.AttributedString
import org.springframework.context.annotation.Configuration
import org.springframework.shell.jline.PromptProvider

@Configuration
class CustomShellPrompt: PromptProvider {
    override fun getPrompt(): AttributedString {
        return AttributedString("search:>")
    }
}