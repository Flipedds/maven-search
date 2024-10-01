package com.flipedds.mavensearch.commands

import com.flipedds.mavensearch.pages.RepositoryPage
import org.springframework.shell.command.annotation.Command
import org.springframework.shell.command.annotation.Option

@Command(group = "MavenCommand")
class MavenCommand(
    private val repositoryPage: RepositoryPage
) {
    @Command(
        command = ["dependency"],
        alias = ["dep", "dp"],
        description = "search for a dependency in maven repository"
    )
    fun getDependency(
        @Option(
            longNames = ["name"],
            shortNames = ['n'],
            description = "Dependency name",
            required = true
        )
        name: String
    ) {
        repositoryPage.searchFor(name)
    }
}