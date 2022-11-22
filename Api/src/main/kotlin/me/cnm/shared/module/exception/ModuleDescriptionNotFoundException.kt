package me.cnm.shared.module.exception

/**
 * Method thrown when the module.json of a module directory wasn't found
 *
 * @param module The module of witch the module.json wasn't found
 */
class ModuleDescriptionNotFoundException(module: String) : RuntimeException("The module.json of $module wan't found.")
