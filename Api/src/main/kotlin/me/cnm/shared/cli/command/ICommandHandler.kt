package me.cnm.shared.cli.command

import me.cnm.shared.IHandler

/**
 * The `CommandHandler` handels everything about CLI commands
 */
interface ICommandHandler : IHandler {

    /**
     * Register a command
     *
     * @param command The command to register
     *
     * @throws CommandRegistrationException If a command with the same name or alias is already registered
     */
    fun register(command: Command)

    /**
     * Remove a command
     *
     * If the command is not registered, the call is ignored
     *
     * @param command The command to be removed
     */
    fun remove(command: Command)

    /**
     * Remove a command by its name
     *
     * If the command is not registered or an alias is provided, the call is ignored
     *
     * @param command The command to be removed
     */
    fun remove(command: String)

    /**
     * Get a command by its name or alias, if no command with that name or alias exists, null is returned
     *
     * @param commandOrAlias The name or alias of the command
     * @return The command or null
     */
    operator fun get(commandOrAlias: String): Command?

    /**
     * Get all registered commands
     *
     * @return All registered commands
     */
    val all: List<Command>
}

