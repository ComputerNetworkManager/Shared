package me.cnm.shared.cli.message.option

/**
 * Direction in witch to move the cursor
 */
enum class CursorDirection(
    /**
     * The code used to make this direction
     */
    val code: Char
) {

    /**
     * Move the cursor up
     */
    UP('A'),

    /**
     * Move the cursor down
     */
    DOWN('B'),

    /**
     * Move the cursor to the left
     */
    LEFT('C'),

    /**
     * Move the cursor to the right
     */
    RIGHT('D');
}