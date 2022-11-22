package me.cnm.shared.cli.message.option

import me.cnm.shared.cli.message.ICLIMessageBuilder

/**
 * Formats that can be used to format text with the [ICLIMessageBuilder]
 */
enum class Format(
    /**
     * The code used to set the format
     */
    private val set: Int,

    /**
     * The code used to reset the format
     */
    private val reset: Int,
) {

    /**
     * Make text bold or increased intensity
     */
    BOLD(1, 22),

    /**
     * Make a text faint or decreased intensity
     */
    FAINT(2, 22),

    /**
     * Make a text italic<br></br>
     * Not widely supported
     */
    ITALIC(3, 23),

    /**
     * Make a text underlined
     */
    UNDERLINED(4, 24),

    /**
     * Make a text crossed out or strike, characters legible but marked as if for deletion
     *
     * Not supported in `Terminal.app`
     */
    CROSSED_OUT(9, 24),

    /**
     * Make a texted doubled underlined
     *
     * On some consoles this code is used as `not bold`
     */
    DOUBLE_UNDERLINED(21, 24);
}
