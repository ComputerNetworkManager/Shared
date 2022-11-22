package me.cnm.shared.module.exception

/**
 * Exception thrown when a module should be loaded, started, stopped or unloaded and some dependencies are still not
 * loaded, started, stopped or unloaded
 *
 * @constructor Create the exception
 * @param module     The module witch requires a dependency to be loaded, started, stopped or unloaded
 * @param dependency The dependency required to be loaded, started, stopped or unloaded
 * @param soft       Whether the dependency is a soft-dependency
 * @param required   What the dependency state is required to be
 */
class ModuleDependencyException(
    module: String,
    dependency: String,
    soft: Boolean,
    required: Type
) : RuntimeException(
    "The ${(if (soft) "soft-" else "")} dependency $dependency (used by $module) isn't ${required.state}"
) {

    /**
     * Enum with all required states of a dependency
     */
    enum class Type(
        /**
         * The named to be shown in the message
         */
        val state: String
    ) {

        /**
         * Dependency needs to be loaded
         */
        LOADED("loaded"),

        /**
         * Dependency needs to be started
         */
        STARTED("started"),

        /**
         * Dependency needs to be stopped
         */
        STOPPED("stopped"),

        /**
         * Dependency needs to be unloaded
         */
        UNLOADED("unloaded");
    }
}
