package me.cnm.shared.module.exception

import me.cnm.shared.module.loading.IModuleInterpreter

/**
 * Execution to be thrown by an [IModuleInterpreter] when something goes wrong on load, start, stop or unload
 */
class ModuleInterpreterException : Exception {

    /**
     * Create the exception
     *
     * @param message The message
     * @param cause   The cause
     */
    constructor(message: String? = null, cause: Throwable? = null) : super(message, cause)

    /**
     * Create the exception
     *
     * @param cause The cause
     */
    constructor(cause: Throwable?) : super(cause)

    /**
     * Create the exception
     *
     * @param message            The message
     * @param cause              The cause
     * @param enableSuppression  Whether to enable suppression
     * @param writableStackTrace Whether to be writeable to the stack trace
     */
    constructor(
        message: String? = null,
        cause: Throwable? = null,
        enableSuppression: Boolean = true,
        writableStackTrace: Boolean = true
    ) : super(
        message,
        cause,
        enableSuppression,
        writableStackTrace
    )

}
