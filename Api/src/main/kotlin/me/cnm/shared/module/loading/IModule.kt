package me.cnm.shared.module.loading

import me.cnm.shared.module.IModuleDescription
import java.io.File

/**
 * The `Module` class stores information about a loaded module
 */
interface IModule {

    /**
     * Get the `module.json` of the module
     *
     * @return The `module description of the module`
     *
     * @see IModuleDescription
     */
    val moduleDescription: IModuleDescription

    /**
     * Get the data folder of the module (The "root" of the module)
     *
     * @return The data folder of the module
     */
    val dataFolder: File

    /**
     * The current running state of the module
     */
    var isRunning: Boolean
}
