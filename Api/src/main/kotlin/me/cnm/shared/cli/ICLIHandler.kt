package me.cnm.shared.cli

import me.cnm.shared.IHandler
import me.cnm.shared.cli.command.ICommandHandler
import me.cnm.shared.cli.component.AbstractCLIComponent
import me.cnm.shared.cli.component.ICLIComponent
import me.cnm.shared.cli.component.system.ILoadingBar
import me.cnm.shared.cli.log.ILogHandler


/**
 * The `CLIHandler` contains a
 *
 * - command handler, for handling cli inputs,
 * - log handler, for handling cli outputs and
 * - component system, to modify the above
 */
interface ICLIHandler : IHandler {

    /**
     * Get the current instance of hte `CommandHandler`
     *
     * @return The current instance of hte `CommandHandler`
     *
     * @see ICommandHandler
     */
    val commandHandler: ICommandHandler

    /**
     * Set the component to be used for CLI handling
     *
     * If an [AbstractCLIComponent] is provided, the `defaultCLI` will be set
     *
     * @param cliComponent The component to be used
     *
     * @see ICLIComponent
     */
    fun setComponent(cliComponent: ICLIComponent)

    /**
     * Remove the current component from handling and set the system to handle everything
     */
    fun resetComponent()

    /**
     * Create a `LoadingBar` component
     *
     * @param name The name of the loading bar
     * @return The loading bar
     */
    fun createLoadingBar(name: String): ILoadingBar

    /**
     * Get the current instance of hte `LogHandler`
     *
     * @return The current instance of hte `LogHandler`
     *
     * @see ILogHandler
     */
    val logHandler: ILogHandler

    /**
     * Suggest an input
     *
     * @param suggestion The suggestion
     */
    fun suggest(suggestion: String?)
}
