package me.cnm.shared.module

import at.clanattack.xjkl.json.JsonDocument

/**
 * All important information of a module.json
 */
interface IModuleDescription {

    /**
     * @return The name of the module
     */
    val name: String

    /**
     * @return The version of the module
     */
    val version: String

    /**
     * @return The language of the module
     */
    val language: String

    /**
     * @return The description of the module
     */
    val description: String?

    /**
     * @return The dependencies of the module
     */
    val dependencies: List<String>

    /**
     * Soft dependencies are dependencies, that are not required for running, but should exist
     *
     * Also, the default module handler ensures, that all soft dependencies are loaded before a module if existing
     *
     * @return The soft dependencies of the module
     */
    val softDependencies: List<String>

    /**
     * @return The authors of the module
     */
    val authors: List<String>

    /**
     * The additional part is used to specify information required by a language
     *
     * For example the main class for java modules
     *
     * @return All information stored in the additional part of the module.json
     */
    val additional: JsonDocument

    /**
     * @return The whole module.json as `JsonDocument`
     */
    fun asJsonDocument(): JsonDocument
}
