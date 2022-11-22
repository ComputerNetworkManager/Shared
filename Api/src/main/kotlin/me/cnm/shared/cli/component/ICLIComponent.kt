package me.cnm.shared.cli.component

import me.cnm.shared.cli.log.LogLevel
import org.jetbrains.annotations.ApiStatus

/**
 * The CLI can be modified by setting a custom CLI component
 *
 * Custom CLI components can modify outputs, autocompletion and inputs
 */
interface ICLIComponent {

    /**
     * Method called when a message should be printed to the log
     *
     * @param logLevel  The log level of the message
     * @param message   The message wich should be printed
     * @param throwable A throwable, that should be logged with it
     */
    @ApiStatus.OverrideOnly
    fun print(logLevel: LogLevel, message: String, throwable: Throwable?)

    /**
     * Method called when the `tab` key is pressed
     *
     * On each candidate it is automatically check, if the current input starts with the argument
     *
     * @param args The current input, split by " "
     * @return All possible autocompletion
     */
    @ApiStatus.OverrideOnly
    fun getAutoComplete(args: Array<String>): List<String>

    /**
     * Method called when the `enter` key is pressed
     *
     * @param args The current input, split by " "
     */
    @ApiStatus.OverrideOnly
    fun handleInput(args: Array<String>)

    /**
     * Get the prompt to be shown in the console
     *
     * @return The prompt
     */
    val prompt: String
}
