package com.bonface.designsystem.components.menu

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue

/**
 * A state holder class for managing the expanded/collapsed state of a more menu (e.g., a dropdown menu).
 *
 * This class encapsulates the logic for tracking whether a more menu is currently expanded or not.
 * It also provides a convenient method for toggling the expanded state and a [Saver] for use with
 * [androidx.compose.runtime.saveable.rememberSaveable] to persist the state across configuration changes
 * and process death.
 */
class MoreMenuExpandedState {

    /**
     * Companion object for [MoreMenuExpandedState] that provides a [Saver] implementation.
     *
     * This [Saver] is used to save and restore the [expanded] state of a [MoreMenuExpandedState] instance
     * when using [androidx.compose.runtime.saveable.rememberSaveable].
     */
    companion object {
        /**
         * A [Saver] implementation for [MoreMenuExpandedState].
         *
         * This [Saver] saves the [expanded] state as a [Boolean] and restores it when needed.
         */
        val Saver: Saver<MoreMenuExpandedState, Boolean> = Saver(
            save = { it.expanded },
            restore = { MoreMenuExpandedState().apply { expanded = it } },
        )
    }

    /**
     * Indicates whether the more menu is currently expanded (true) or collapsed (false).
     *
     * This property is observable, meaning that any changes to its value will trigger recomposition
     * of composables that read it.
     */
    var expanded by mutableStateOf(false)
        private set

    /**
     * Toggles the expanded state of the more menu.
     *
     * If the menu is currently expanded, it will be collapsed. If it's collapsed, it will be expanded.
     */
    fun toggleExpanded() {
        expanded = !expanded
    }
}
