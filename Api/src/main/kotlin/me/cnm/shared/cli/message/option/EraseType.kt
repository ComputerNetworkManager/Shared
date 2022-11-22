package me.cnm.shared.cli.message.option

import me.cnm.shared.cli.message.ICLIMessageBuilder

/**
 * `EraseTypes` tell the console, what to erase
 *
 * Used by [ICLIMessageBuilder.eraseScreen] and [ICLIMessageBuilder.eraseLine]
 */
enum class EraseType(
    /**
     * The code used to make this erase type
     */
    val code: Int
) {

    /**
     * Erase from the current position of the cursor to the end of the line or screen
     */
    TO_END(0),

    /**
     * Erase from the current position of the cursor to the start of the line or screen
     */
    TO_BEGIN(1),

    /**
     * Erase in both directions (to the start and to the end of the line/screen)
     */
    ALL(2);

}