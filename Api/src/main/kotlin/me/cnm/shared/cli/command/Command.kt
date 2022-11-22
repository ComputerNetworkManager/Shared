package me.cnm.shared.cli.command

import at.clanattack.xjkl.scope.empty
import me.cnm.shared.IHandlerLibrary
import org.jetbrains.annotations.ApiStatus.OverrideOnly

/**
 * A command that can be executed via the CLI input
 *
 * @constructor Create a command
 * @param name    The name of the command
 * @param aliases The aliases of the command
 */
abstract class Command protected constructor(
    /**
     * The name of the command
     */
    val name: String,
    vararg val aliases: String
) {


    /**
     * The handler library to be used by the command
     */
    lateinit var handlerLibrary: IHandlerLibrary
        internal set

    /**
     * Create a command
     *
     * @param name The name of the command
     */
    protected constructor(name: String) : this(name, *emptyArray())

    /**
     * Execute this command with the specific arguments
     *
     * @param args Arguments used to invoke the command
     */
    abstract fun execute(args: Array<String>)

    /**
     * Autocomplete this command
     *
     * On each candidate it is automatically check, if the current input starts with the argument
     *
     * @param args        Arguments used to invoke the autocomplete
     * @param suggestions List to add the suggestions
     */
    fun autocomplete(args: Array<String>, suggestions: List<String>) = empty()

    /**
     * The description of the command
     *
     * Displayed in the "help" command
     */
    @get:OverrideOnly
    val description: String? = null

    /**
     * Syntax of the command
     * Should not contain the leading command, for example for the command "command <arg>" this should return "<arg>"
     *
     * Displayed in the "help command"
     */
    @get:OverrideOnly
    val syntax: String? = null
}