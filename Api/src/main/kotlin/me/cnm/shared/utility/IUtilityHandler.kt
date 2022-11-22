package me.cnm.shared.utility

import me.cnm.shared.IHandler
import me.cnm.shared.utility.configuration.IConfigurationHandler
import me.cnm.shared.utility.format.IFormatHandler

/**
 * Class to expose utility resources
 */
interface IUtilityHandler : IHandler {
    /**
     * Get the `ConfigurationHandler` witch is used to read and write configuration entries from/to the disk
     *
     * @return The current instance of the `ConfigurationHandler`
     * @see IConfigurationHandler
     */
    val configurationHandler: IConfigurationHandler

    /**
     * Get the `FormatHandler` witch is used to format values to be human-readable
     *
     * @return The current instance of the `FormatHandler`
     * @see IFormatHandler
     */
    val formatHandler: IFormatHandler
}
