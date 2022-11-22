package me.cnm.shared.module

import me.cnm.shared.IHandler
import me.cnm.shared.module.exception.IllegalModuleDescriptionException
import me.cnm.shared.module.exception.ModuleDescriptionNotFoundException
import me.cnm.shared.module.exception.ModuleInterpreterException
import me.cnm.shared.module.loading.IModule
import me.cnm.shared.module.loading.IModuleInterpreter
import java.io.File

/**
 * The `ModuleHandler` ensures, that all important methods for handling modules are exposed
 *
 * It can be used to load, start, stop and unload modules.
 */
interface IModuleHandler : IHandler{

    /**
     * Loads a module by its directory
     *
     * If a module from this directory is already registered, it is returned
     *
     * For this, first the module description is read
     *
     * Then the interpreter for the language is determined
     *
     * After that the [IModule] class is created to store all information
     *
     * Finally, the [IModuleInterpreter.loadModule] is executed to load the module
     *
     * @param file The directory of the module
     * @return The module
     *
     * @throws IllegalArgumentException           If the file is not a directory
     * @throws ModuleDescriptionNotFoundException If the module.json doesn't exist
     * @throws IllegalModuleDescriptionException  If the module.json contains illegal content
     * @throws ModuleInterpreterException         If the interpreter fails to load the module
     *
     * @see IModule
     */
    @Throws(
        IllegalArgumentException::class,
        ModuleDescriptionNotFoundException::class,
        IllegalModuleDescriptionException::class,
        ModuleInterpreterException::class
    )
    fun loadModule(file: File): IModule

    /**
     * Start a module previously loaded by [.loadModule]
     *
     * @param module The module to start
     *
     * @throws IllegalStateException      If the module is running or not all modules specified as
     * dependencies are started
     * @throws ModuleInterpreterException If the interpreter fails to start the module
     */
    @Throws(ModuleInterpreterException::class)
    fun startModule(module: IModule)

    /**
     * Stop a module, witch means ensure, that all used resources are freed, e.g. command are unregistered etc.
     *
     * @param module The module to stop
     *
     * @throws IllegalStateException      If the module is not running or some modules witch specified
     * this module as dependency are running
     * @throws ModuleInterpreterException If the interpreter fails to stop the module
     */
    @Throws(ModuleInterpreterException::class)
    fun stopModule(module: IModule)

    /**
     * Unload a module, witch mens free it from being used by the process and be allowed to delete, override, etc. module files
     *
     * @param module The module to unload
     *
     * @throws IllegalStateException      If the module is running or some modules witch specified
     * this module as dependency are loaded
     * @throws ModuleInterpreterException If the interpreter fails to unload the module
     */
    @Throws(ModuleInterpreterException::class)
    fun unloadModule(module: IModule)

    /**
     * Get a module by its name
     *
     * If no module with that name is currently loaded, null is returned
     *
     * @param name The name of the module
     * @return The module or null
     */
    operator fun get(name: String): IModule?

    /**
     * Get all modules currently loaded
     *
     * @return List of modules loaded
     */
    val all: List<IModule?>

    /**
     * Register an module interpreter to handle a language of modules
     *
     * @param language    The language to handle
     * @param interpreter The interpreter to handle the language
     * @param aliases     The aliases, also to listen for
     *
     * @throws IllegalStateException If the language or an alias is already registered
     *
     * @see IModuleInterpreter
     */
    fun registerInterpreter(
        language: String,
        interpreter: IModuleInterpreter,
        vararg aliases: String?
    )

    /**
     * Get the interpreter for a language
     *
     * If no interpreter for this language is registered, null is returned
     *
     * @param language The language of the module
     * @return The interpreter or null
     */
    fun getInterpreter(language: String): IModuleInterpreter?
}
