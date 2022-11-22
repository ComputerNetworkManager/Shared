package me.cnm.shared.utility.configuration

import com.google.gson.JsonSyntaxException
import me.cnm.shared.IHandler

/**
 * Interface for handling configurations, stored on the device (file)
 */
interface IConfigurationHandler : IHandler {

    /**
     * Get the entry of a configuration by its key and map it to the corresponding type
     *
     * If the value doesn't exist null is returned
     *
     * @param key   The key of the entry
     * @param clazz The class of the type to witch it should be mapped
     * @param T     The type to witch the value should be mapped
     * @return The mapped value or null
     * @throws JsonSyntaxException If the value is from another type
     */
    fun <T> getEntry(key: String, clazz: Class<T>): T?

    /**
     * Get the entry of a configuration by its key and map it to the corresponding type
     *
     * If the value doesn't exist the `def` value is stored to the configuration and returned
     *
     * @param key   The key of the entry
     * @param def   The default value
     * @param clazz The class of the type to witch it should be mapped
     * @param T     The type to witch the value should be mapped
     * @return The mapped value or the default value
     * @throws ClassCastException If the value is from another type
     * @throws RuntimeException If the file doesn't exist
     */
    fun <T> getEntry(key: String, def: T, clazz: Class<T>): T

    /**
     * Saves an entry to the configuration and store it to the file system
     *
     * @param key   The key of the entry
     * @param value The value of the entry
     * @throws RuntimeException If the file doesn't exist
     */
    fun saveEntry(key: String, value: Any)
}
