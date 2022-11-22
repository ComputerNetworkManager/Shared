package me.cnm.shared.module.loading

import me.cnm.shared.module.exception.ModuleInterpreterException

/**
 * The `ModuleInterpreter` handles modules that have a specific langauge specified
 */
interface IModuleInterpreter {
    /**
     * Loads a module<br></br>
     * In this method, all necessary attributes in the additional part of the module.json should be checked<br></br>
     * Afterwards, all required files should be loaded into the java project
     *
     * @param module The module, witch should be loaded
     * @throws ModuleInterpreterException If something went wrong, the exception should be wrapped in
     * an [ModuleInterpreterException]
     */
    @Throws(ModuleInterpreterException::class)
    fun loadModule(module: IModule?)

    /**
     * Starts a module<br></br>
     * In this method, the in the [.loadModule] method loaded files should be executed<br></br>
     * The system ensures, that the module was loaded before
     *
     * @param module The module, witch should be started
     * @throws ModuleInterpreterException If something went wrong, the exception should be wrapped in
     * an [ModuleInterpreterException]
     */
    @Throws(ModuleInterpreterException::class)
    fun startModule(module: IModule?)

    /**
     * Stops a module<br></br>
     * In this method, the code should be cleaned up (unregister commands, etc.)
     *
     * @param module The module, witch should be stopped
     * @throws ModuleInterpreterException If something went wrong, the exception should be wrapped in
     * an [ModuleInterpreterException]
     */
    @Throws(ModuleInterpreterException::class)
    fun stopModule(module: IModule?)

    /**
     * Unloads a module<br></br>
     * In this method, all classed loaded in the [.loadModule] method should be released
     *
     * @param module The module, witch should be unloaded
     * @throws ModuleInterpreterException If something went wrong, the exception should be wrapped in
     * an [ModuleInterpreterException]
     */
    @Throws(ModuleInterpreterException::class)
    fun unloadModule(module: IModule?)
}
