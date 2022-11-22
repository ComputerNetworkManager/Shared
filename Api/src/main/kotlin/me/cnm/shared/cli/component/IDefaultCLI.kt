package me.cnm.shared.cli.component

import me.cnm.shared.cli.log.LogLevel

/**
 * The `default CLI` is used by [AbstractCLIComponent] to access the system on a level deeper
 */
interface IDefaultCLI {

    /**
     * Print a message directly to the console without any processing
     *
     * **Pleas notice, that the cursor does not move up before or erase anything**
     *
     * If you want to have a pretty output, that clears the prompt, etc. use [IDefaultCLI.printToConsole]
     *
     * @param object The object to be printed to the console
     */
    fun printPlainToConsole(`object`: Any)

    /**
     * Prints a message only to the console
     *
     * @param object The Object to be printed to the console
     */
    fun printToConsole(`object`: Any)

    /**
     * Prints a message only to the console, and add a new line
     *
     * @param object The Object to be printed to the console
     */
    fun printlnToConsole(`object`: Any)

    /**
     * Print a message to the console and the log file
     *
     * @param logLevel  The log level of the message
     * @param message   The message wich should be printed
     * @param throwable A throwable, that should be logged with it
     */
    fun print(logLevel: LogLevel, message: String, throwable: Throwable? = null)

    /**
     * Get the default autocomplete option
     *
     * If there is only one input, all commands are returned, otherwise the autocomplete method of the command is called
     *
     * @param args The current input
     * @return The autocompletion provided by commands
     */
    fun getAutoComplete(args: Array<String>): List<String>

    /**
     * Handle an input via commands
     *
     * Check if the first input is a command, if it is executed that command otherwise send a help message
     *
     * @param args The current input
     */
    fun handleInput(args: Array<String>)

    /**
     * Get the default prompt
     *
     * @return The default prompt
     */
    val prompt: String
}
