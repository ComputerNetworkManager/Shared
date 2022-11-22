package me.cnm.shared.cli.message

import me.cnm.shared.cli.message.option.Color
import me.cnm.shared.cli.message.option.CursorDirection
import me.cnm.shared.cli.message.option.EraseType
import me.cnm.shared.cli.message.option.Format
import org.jetbrains.annotations.Contract

/**
 * The `ICLIPrint` can be used to modify cli messages
 * @see <a href="https://en.wikipedia.org/wiki/ANSI_escape_code#Description">Wikipedia ANSI</a>
 */
interface ICLIMessageBuilder {

    /**
     * Move the cursor in a direction
     *
     * @param amount    The amount of rows/columns to move in that direction
     * @param direction The direction in witch to move the cursor
     * @return This instance
     *
     * @see CursorDirection
     */
    @Contract("_, _ -> this", pure = true)
    fun cursor(amount: Int, direction: CursorDirection): ICLIMessageBuilder

    /**
     * Move the cursor to the next line
     *
     * @return This instance
     */
    @Contract("-> this", pure = true)
    fun cursorNextLine(): ICLIMessageBuilder

    /**
     * Move the cursor to the previous line
     *
     * @return This instance
     */
    @Contract("-> this", pure = true)
    fun cursorPreviousLine(): ICLIMessageBuilder

    /**
     * Set the position of the cursor in the current line
     *
     * @param position The new postion of the cursor
     * @return This instance
     */
    @Contract("_ -> this", pure = true)
    fun setCursorHorizontally(position: Int): ICLIMessageBuilder

    /**
     * Set the position of the cursor on the screen with x and y position
     *
     * @param x The x position
     * @param y The y position
     * @return This instance
     */
    @Contract("_, _ -> this", pure = true)
    fun moveCursor(x: Int, y: Int): ICLIMessageBuilder

    /**
     * Store the current position of the cursor, can later be restored with [.restoreCursorPosition]
     *
     * @return This instance
     */
    @Contract("-> this", pure = true)
    fun storeCursorPosition(): ICLIMessageBuilder

    /**
     * Restore the position of the cursor, previously store with [.storeCursorPosition]
     *
     * @return This instance
     */
    @Contract(pure = true)
    fun restoreCursorPosition(): ICLIMessageBuilder

    /**
     * Erase all content from the cursor to the end of the screen
     *
     * @return This instance
     *
     * @see ICLIMessageBuilder.eraseScreen
     * @see EraseType.TO_END
     */
    @Contract("-> this", pure = true)
    fun eraseScreen(): ICLIMessageBuilder

    /**
     * Erase part of the content or all of the screen
     *
     * @param eraseType The type
     * @return This instance
     *
     * @see EraseType
     */
    @Contract("_ -> this", pure = true)
    fun eraseScreen(eraseType: EraseType): ICLIMessageBuilder

    /**
     * Erase all content from the cursor to the end of the line
     *
     * @return This instance
     *
     * @see ICLIMessageBuilder.eraseLine
     * @see EraseType.TO_END
     */
    @Contract("-> this", pure = true)
    fun eraseLine(): ICLIMessageBuilder

    /**
     * Erase part of the content or all of the line
     *
     * @return This instance
     *
     * @see EraseType
     */
    @Contract("_ -> this", pure = true)
    fun eraseLine(eraseType: EraseType): ICLIMessageBuilder

    /**
     * Scroll one line up
     *
     * @return This instance
     */
    @Contract("-> this", pure = true)
    fun scrollUp(): ICLIMessageBuilder

    /**
     * Scroll one line down
     *
     * @return This instance
     */
    @Contract("-> this", pure = true)
    fun scrollDown(): ICLIMessageBuilder

    /**
     * Reset all formats (including colors)
     *
     * @return This instance
     */
    @Contract("-> this", pure = true)
    fun resetFormats(): ICLIMessageBuilder

    /**
     * Add a format in which to display text, added afterwards
     *
     * @param formats The format to add
     * @return This instance
     *
     * @see Format
     */
    @Contract("_ -> this", pure = true)
    fun addFormats(vararg formats: Format): ICLIMessageBuilder

    /**
     * Remove a format from the text added afterwards
     *
     * @param formats The format to remove
     * @return This instance
     *
     * @see Format
     */
    @Contract("_ -> this", pure = true)
    fun removeFormats(vararg formats: Format): ICLIMessageBuilder

    /**
     * Set the foreground-color of the text
     *
     * @param color The new foreground-color
     * @return This instance
     *
     * @see Color
     */
    @Contract("_ -> this", pure = true)
    fun fg(color: Color): ICLIMessageBuilder

    /**
     * Set the foreground-color of the text with rgb
     *
     * @param r The red component of the color
     * @param g The green component of the color
     * @param b The blue component of the color
     * @return This instance
     */
    @Contract("_, _, _ -> this", pure = true)
    fun fg(r: Int, g: Int, b: Int): ICLIMessageBuilder

    /**
     * Set the background-color of the text
     *
     * @param color The new background-color
     * @return This instance
     *
     * @see Color
     */
    @Contract("_ -> this", pure = true)
    fun bg(color: Color): ICLIMessageBuilder

    /**
     * Set the background-color of the text with rgb
     *
     * @param r The red component of the color
     * @param g The green component of the color
     * @param b The blue component of the color
     * @return This instance
     */
    @Contract("_, _, _ -> this", pure = true)
    fun bg(r: Int, g: Int, b: Int): ICLIMessageBuilder

    /**
     * Append a text with formats, that only apply to the added text<br></br>
     * The text will have only the formats in the `formats` parameter<br></br>
     * The previously defined colors will be used<br></br>
     * All formats (except colors) are reset afterwards<br></br>
     *
     * @param text    The text
     * @param formats The formats
     * @return This instance
     *
     * @see Format
     */
    @Contract("_, _ -> this", pure = true)
    fun text(text: Any, vararg formats: Format?): ICLIMessageBuilder

    /**
     * Append a text with a foreground-color, that only apply to the added text<br>
     * Previously added formats will be used (except foreground-color)<br>
     * The foreground-color is reset afterwards
     *
     * @param text The text
     * @param fg   The foreground-color
     * @return This instance
     *
     * @see Color
     */
    @Contract("_, _ -> this", pure = true)
    fun textFg(text: Any, fg: Color): ICLIMessageBuilder

    /**
     * Append a text with a background-color, that only apply to the added text<br></br>
     * Previously added formats will be used (except background-color)<br></br>
     * The foreground-color is reset afterwards
     *
     * @param text The text
     * @param bg   The foreground-color
     * @return This instance
     *
     * @see Color
     */
    @Contract("_, _ -> this", pure = true)
    fun textBg(text: Any, bg: Color): ICLIMessageBuilder

    /**
     * Append a text with a fore- and background-color, that only apply to the added text<br></br>
     * Previously added formats will be used (except colors)<br></br>
     * The colors is reset afterwards
     *
     * @param text The text
     * @param fg   The foreground-color
     * @param bg   The background-color
     * @return This instance
     *
     * @see Color
     */
    @Contract("_, _, _ -> this", pure = true)
    fun text(text: Any, fg: Color, bg: Color): ICLIMessageBuilder

    /**
     * Append a text with a foreground-color, that only apply to the added text<br></br>
     * Previously added formats will be used (except foreground-color)<br></br>
     * The foreground-color is reset afterwards
     *
     * @param text The text
     * @param r    The red component of the color
     * @param g    The green component of the color
     * @param b    The blue component of the color
     * @return This instance
     *
     * @see Color
     */
    @Contract("_, _, _, _ -> this", pure = true)
    fun textFg(text: Any, r: Int, g: Int, b: Int): ICLIMessageBuilder

    /**
     * Append a text with a background-color, that only apply to the added text<br></br>
     * Previously added formats will be used (except background-color)<br></br>
     * The foreground-color is reset afterwards
     *
     * @param text The text
     * @param r    The red component of the color
     * @param g    The green component of the color
     * @param b    The blue component of the color
     * @return This instance
     *
     * @see Color
     */
    @Contract("_, _, _, _ -> this", pure = true)
    fun textBg(text: Any, r: Int, g: Int, b: Int): ICLIMessageBuilder

    /**
     * Append a text with a fore- and background-color, that only apply to the added text<br></br>
     * Previously added formats will be used (except colors)<br></br>
     * The colors is reset afterwards
     *
     * @param text The text
     * @param fgr  The red component of the foreground-color
     * @param fgg  The green component of the foreground-color
     * @param fgb  The blue component of the foreground-color
     * @param bgr  The red component of the background-color
     * @param bgg  The green component of the background-color
     * @param bgb  The blue component of the background-color
     * @return This instance
     *
     * @see Color
     */
    @Contract("_, _, _, _, _, _, _ -> this", pure = true)
    fun text(text: Any, fgr: Int, fgg: Int, fgb: Int, bgr: Int, bgg: Int, bgb: Int): ICLIMessageBuilder

    /**
     * Append a text with a foreground-color and formats, that only apply to the added text<br></br>
     * The text will have only the formats in the `formats` parameter<br></br>
     * The previously defined background-color will be used<br></br>
     * All formats (except background-color) are reset afterwards<br></br>
     *
     * @param text    The text
     * @param fg      The color
     * @param formats The formats
     * @return This instance
     *
     * @see Color
     * @see Format
     */
    @Contract("_, _, _ -> this", pure = true)
    fun textFg(text: Any, fg: Color, vararg formats: Format): ICLIMessageBuilder

    /**
     * Append a text with a background-color and formats, that only apply to the added text<br></br>
     * The text will have only the formats in the `formats` parameter<br></br>
     * The previously defined foreground-color will be used<br></br>
     * All formats (except foreground-color) are reset afterwards<br></br>
     *
     * @param text    The text
     * @param bg      The color
     * @param formats The formats
     * @return This instance
     *
     * @see Color
     * @see Format
     */
    @Contract("_, _, _ -> this", pure = true)
    fun textBg(text: Any, bg: Color, vararg formats: Format): ICLIMessageBuilder

    /**
     * Append a text with colors and formats, that only apply to the added text<br></br>
     * All formats are reset afterwards<br></br>
     *
     * @param text    The text
     * @param fg      The foreground-color
     * @param bg      The background-color
     * @param formats The formats
     * @return This instance
     *
     * @see Color
     * @see Format
     */
    @Contract("_, _, _, _ -> this", pure = true)
    fun text(text: Any, fg: Color, bg: Color, vararg formats: Format): ICLIMessageBuilder

    /**
     * Append a text with a foreground-color and formats, that only apply to the added text<br></br>
     * The text will have only the formats in the `formats` parameter<br></br>
     * The previously defined background-color will be used<br></br>
     * All formats (except background-color) are reset afterwards<br></br>
     *
     * @param text    The text
     * @param r       The red component of the color
     * @param g       The green component of the color
     * @param b       The blue component of the color
     * @param formats The formats
     * @return This instance
     *
     * @see Color
     * @see Format
     */
    @Contract("_, _, _, _, _ -> this", pure = true)
    fun textFg(text: Any, r: Int, g: Int, b: Int, vararg formats: Format): ICLIMessageBuilder

    /**
     * Append a text with a background-color and formats, that only apply to the added text<br></br>
     * The text will have only the formats in the `formats` parameter<br></br>
     * The previously defined foreground-color will be used<br></br>
     * All formats (except foreground-color) are reset afterwards<br></br>
     *
     * @param text    The text
     * @param r       The red component of the color
     * @param g       The green component of the color
     * @param b       The blue component of the color
     * @param formats The formats
     * @return This instance
     *
     * @see Color
     * @see Format
     */
    @Contract("_, _, _, _, _ -> this", pure = true)
    fun textBg(text: Any, r: Int, g: Int, b: Int, vararg formats: Format): ICLIMessageBuilder

    /**
     * Append a text with colors and formats, that only apply to the added text<br></br>
     * All formats are reset afterwards<br></br>
     *
     * @param text    The text
     * @param fgr     The red component of the foreground-color
     * @param fgg     The green component of the foreground-color
     * @param fgb     The blue component of the foreground-color
     * @param bgr     The red component of the background-color
     * @param bgg     The green component of the background-color
     * @param bgb     The blue component of the background-color
     * @param formats The formats
     * @return This instance
     *
     * @see Color
     * @see Format
     */
    @Contract("_, _, _, _, _, _, _, _ -> this", pure = true)
    fun text(
        text: Any,
        fgr: Int,
        fgg: Int,
        fgb: Int,
        bgr: Int,
        bgg: Int,
        bgb: Int,
        vararg formats: Format
    ): ICLIMessageBuilder

    /**
     * Append a text that uses all previously defined formats and colors
     *
     * @param text The text
     * @return This instance
     */
    @Contract("_ -> this", pure = true)
    fun text(text: Any): ICLIMessageBuilder

    /**
     * Build all previously defined attributes to text
     * @return The build text
     */
    @Contract(pure = true)
    fun build(): String

}