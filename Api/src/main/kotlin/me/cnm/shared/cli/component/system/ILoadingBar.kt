package me.cnm.shared.cli.component.system

import me.cnm.shared.cli.component.ICLIComponent

/**
 * The `LoadingBar` is used for loading bars in the console
 */
interface ILoadingBar : ICLIComponent {

    /**
     * Set the current percentage (0.0 - 100.0) of the loading bar
     *
     * The value will be rounded to 1 decimal digit
     *
     * If the value is >= 100, [ILoadingBar.finish] is called
     *
     * @param percentage The percentage of the loading bar
     */
    fun setPercentage(percentage: Double)

    /**
     * Mark the `LoadingBar` as finished, [.setPercentage] won't have any effect any longer
     */
    fun finish()

    /**
     * Check if the `LoadingBar` has already finished loading
     *
     * @return Whether the `LoadingBar` is finished
     */
    val isFinished: Boolean
}