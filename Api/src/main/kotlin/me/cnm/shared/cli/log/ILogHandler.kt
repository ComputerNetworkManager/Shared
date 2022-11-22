package me.cnm.shared.cli.log

/**
 * The log handler is used to log messages to the config and a file
 */
interface ILogHandler {

    /**
     * Send a debug-message
     *
     * @param message The message
     *
     * @see log
     * @see LogLevel.DEBUG
     */
    fun debug(message: String)

    /**
     * Send a debug-message with a throwable
     *
     * @param message   The message
     * @param throwable The throwable
     *
     * @see log
     * @see LogLevel.DEBUG
     */
    fun debug(message: String, throwable: Throwable)

    /**
     * Send an info-message
     *
     * @param message The message
     *
     * @see log
     * @see LogLevel.INFO
     */
    fun info(message: String)

    /**
     * Send an info-message with a throwable
     *
     * @param message   The message
     * @param throwable The throwable
     *
     * @see log
     * @see LogLevel.INFO
     */
    fun info(message: String, throwable: Throwable)

    /**
     * Send a warn-message
     *
     * @param message The message
     *
     * @see log
     * @see LogLevel.WARN
     */
    fun warn(message: String)

    /**
     * Send a warn-message with a throwable
     *
     * @param message   The message
     * @param throwable The throwable
     *
     * @see log
     * @see LogLevel.WARN
     */
    fun warn(message: String, throwable: Throwable)

    /**
     * Send an error-message
     *
     * @param message The message
     *
     * @see log
     * @see LogLevel.ERROR
     */
    fun error(message: String)

    /**
     * Send an error-message with a throwable
     *
     * @param message   The message
     * @param throwable The throwable
     *
     * @see log
     * @see LogLevel.ERROR
     */
    fun error(message: String, throwable: Throwable)

    /**
     * Log a message to the console and the log file
     *
     * @param logLevel The level of the log
     * @param message  The message to be logged
     *
     * @see LogLevel
     */
    fun log(logLevel: LogLevel?, message: String)

    /**
     * Log a message to the console and the log file
     *
     * In addition, also print a throwable with it
     *
     * @param logLevel  The level of the log
     * @param message   The message to be logged
     * @param throwable The throwable to be logged
     *
     * @see LogLevel
     */
    fun log(logLevel: LogLevel?, message: String, throwable: Throwable?)
}
