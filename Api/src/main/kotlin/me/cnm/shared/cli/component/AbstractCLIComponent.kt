package me.cnm.shared.cli.component

import org.jetbrains.annotations.Contract

/**
 * The `AbstractCLIComponent` is an extension of the [ICLIComponent]
 *
 * If the component is set, the `defaultCLI` is automatically initialized
 *
 * To create a custom CLI component a class must be created and extended by `AbstractCLIComponent`
 */
abstract class AbstractCLIComponent : ICLIComponent {

    /**
     * The object to store the [IDefaultCLI] object
     */
    @get:Contract(pure = true)
    var defaultCLI: IDefaultCLI? = null
        /**
         * Get the `defaultCLI`
         *
         * The `defaultCLI` is used to access deeper actions and components like the console print stream
         *
         * @return The `defaultCLI`
         * @see IDefaultCLI
         */
        get
        internal set
}