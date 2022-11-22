package me.cnm.shared.utility.format

import me.cnm.shared.IHandler
import java.text.SimpleDateFormat


/**
 * The `FormatHandler` is used to format values to human-readable values
 */
interface IFormatHandler : IHandler {

    /**
     * Format the given double to 2 decimal digits
     *
     * @param value The double to be formatted
     * @return The formatted double
     *
     * @see IFormatHandler.formatDouble
     */
    fun formatDouble(value: Double): Double

    /**
     * Format the given double to n decimal digits
     *
     * @param value    The double to be formatted
     * @param decimals The amount of decimal digits
     * @return The formatted double
     *
     * @throws IllegalArgumentException If `decimals` is lower than 0
     */
    fun formatDouble(value: Double, decimals: Int): Double

    /**
     * Format bytes int a string representation using IEC standard
     *
     * For disk space use [IFormatHandler.formatBytesDecimal]
     *
     * @param bytes The bytes to be formatted
     * @return The formatted bytes
     */
    fun formatBytes(bytes: Long): String

    /**
     * Format bytes into a string representation using decimal SI units
     *
     * This is used for disk space, most other storage should use [IFormatHandler.formatBytes]
     *
     * @param bytes The bytes to be formatted
     * @return The formatted bytes
     */
    fun formatBytesDecimal(bytes: Long): String

    /**
     * Format the value into a string representation using decimal SI units
     *
     * @param value The value to be formatted
     * @return The formatted value
     *
     * @throws NullPointerException If `unit` is null
     */
    fun formatValue(value: Long, unit: String): String

    /**
     * Format the given time with a [SimpleDateFormat]
     *
     * @param time   The time to format
     * @param format The formatted use by the [SimpleDateFormat]
     * @return The formatted time
     *
     * @throws NullPointerException If `format` is null
     *
     * @see SimpleDateFormat
     */
    fun formatTime(time: Long, format: String): String

    /**
     * Formats the difference between the start and the end date
     *
     * @param startTime The start date from witch to calculate
     * @param endTime   The end date to calculate to
     * @param format    The format in witch to the time should be output
     *
     * The following placeholders are replaced:
     *
     * | Placeholder | Replacement    | Example(for 1 year 2 months 5 hours and 7 minutes) |
     * |-------------|----------------|----------------------------------------------------|
     * | %y          | Year(s)        | 2                                                  |
     * | %mo         | Month(s)       | 2                                                  |
     * | %fmo        | Full month(s)  | 14                                                 |
     * | %d          | Day(s)         | 0                                                  |
     * | %fd         | Full day(s)    | 420                                                |
     * | %h          | Hour(s)        | 5                                                  |
     * | %fh         | Full hour(s)   | 10080                                              |
     * | %m          | Minute(s)      | 7                                                  |
     * | %fm         | Full minute(s) | 604807                                             |
     * | %s          | Second(s)      | 0                                                  |
     * | %fs         | Full second(s) | 36288420                                           |
     *
     * @return The formatted time difference
     * @throws NullPointerException If `format` is null
     */
    fun formatTimeDiff(startTime: Long, endTime: Long, format: String): String

    /**
     * Formats an elapsed time in seconds as days, hh:mm:ss
     *
     * @param secs The elapsed seconds
     * @return The formatted time
     */
    fun formatElapsedSecs(secs: Long): String
}
