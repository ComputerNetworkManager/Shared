package me.cnm.shared

/**
 * The [IHandlerLibrary] is a library, that contains all handlers that are required for the system
 * Each module can add individual handlers
 */
interface IHandlerLibrary {

    /**
     * Register a handler with its type and instance
     *
     * It's highly suggested, that the type of the handler is an interface containing all important methods
     * If a handler with the same interface is already registered, the handler is overwritten
     *
     * @param type     The class of type (interface) of the handler
     * @param instance The instance of the handler/interface
     * @param T      The type of the handler
     */
    fun <T : IHandler> registerHandler(type: Class<T>, instance: T)

    /**
     * Get a handler by its type
     *
     * @param type The class of type of the handler
     * @param T  The type of the handler
     * @return The handler
     * @throws IllegalArgumentException If no handler is found
    </T> */
    fun <T : IHandler> getHandler(type: Class<T>): T

}