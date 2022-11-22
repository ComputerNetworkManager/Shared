package me.cnm.shared.module.java

import me.cnm.shared.IHandlerLibrary
import me.cnm.shared.module.IModuleDescription
import org.jetbrains.annotations.ApiStatus
import java.io.File

/**
 * The `java module` is used as base class for all modules coded in java
 */
abstract class JavaModule {

    /**
     * The handler library, automatically set when loaded
     */
    lateinit var handlerLibrary: IHandlerLibrary
        internal set

    /**
     * The module description, automatically set when loaded
     */
    lateinit var moduleDescription: IModuleDescription
        internal set

    /**
     * The data folder of the module, automatically set when loaded
     */
    lateinit var dataFolder: File
        internal set

    /**
     * Method called when the module should start
     */
    @ApiStatus.OverrideOnly
    open fun start() { }

    /**
     * Method called when the module should stop<br></br>
     * All resources should be released in here
     */
    @ApiStatus.OverrideOnly
    open fun stop() { }

}