package com.flipedds.mavensearch.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.shell.standard.commands.Clear
import org.springframework.shell.standard.commands.History
import org.springframework.shell.standard.commands.Script
import org.springframework.shell.standard.commands.Stacktrace
import org.springframework.shell.standard.commands.Version

@Configuration
class BuiltInCommands {
    @Bean
    fun disableClear(): Clear.Command? {
        return null
    }

    @Bean
    fun disableStackTrace(): Stacktrace.Command? {
        return null
    }

    @Bean
    fun disableHistory(): History.Command? {
        return null
    }

    @Bean
    fun disableVersion(): Version.Command? {
        return null
    }

    @Bean
    fun disableScript(): Script.Command? {
        return null
    }
}