package com.flipedds.mavensearch

import com.flipedds.mavensearch.commands.MavenCommand
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.shell.command.annotation.EnableCommand

@SpringBootApplication
@EnableCommand(MavenCommand::class)
class MavenSearchApplication

fun main(args: Array<String>) {
    SpringApplication.run(MavenSearchApplication::class.java, *args)
}
