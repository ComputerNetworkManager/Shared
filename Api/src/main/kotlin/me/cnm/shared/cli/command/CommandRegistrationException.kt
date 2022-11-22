package me.cnm.shared.cli.command

/**
 * Exception thrown when the registration of a command fails
 *
 * @constructor Create the exception
 * @param message The message containing what went wrong
 */
class CommandRegistrationException(message: String?) : RuntimeException(message)