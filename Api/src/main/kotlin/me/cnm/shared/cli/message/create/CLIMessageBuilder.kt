package me.cnm.shared.cli.message.create

import me.cnm.shared.cli.message.ICLIMessageBuilder
import org.jetbrains.annotations.Contract

/**
 * Class to create an [ICLIMessageBuilder]
 */
object CLIMessageBuilder {

    /**
     * Create a message builder
     * @return The message builder
     *
     * @see ICLIMessageBuilder
     */
    @Contract(pure = true)
    fun create(): ICLIMessageBuilder {
        val clazz = Class.forName("me.cnm.impl.shared.cli.message.CLIMessageBuilder")
        val constructor = clazz.getConstructor()
        return constructor.newInstance() as ICLIMessageBuilder
    }

}

typealias CLIPrint = CLIMessageBuilder
typealias Colorizer = CLIMessageBuilder