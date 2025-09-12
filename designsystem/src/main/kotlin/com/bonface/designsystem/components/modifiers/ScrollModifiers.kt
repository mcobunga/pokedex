package com.bonface.designsystem.components.modifiers

import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.SoftwareKeyboardController
import com.bonface.designsystem.helpers.ZERO_FLOAT

/**
 * Hides the on-screen keyboard and clears focus when a downward scroll gesture is detected.
 *
 * This modifier listens for nested scroll events and, if the user scrolls down
 * (negative vertical offset), it automatically:
 * - Hides the software keyboard via [SoftwareKeyboardController].
 * - Clears focus from the currently focused component via [FocusManager].
 *
 * Useful for improving UX in scrollable screens where text fields may remain
 * focused after input, preventing layout shifts caused by the keyboard.
 *
 * @param keyboardController the [SoftwareKeyboardController] used to control the
 *        visibility of the soft keyboard.
 * @param focusManager the [FocusManager] responsible for clearing the current focus.
 *
 * @return a [Modifier] that adds this behavior to the scrollable component.
 *
 * @see androidx.compose.ui.input.nestedscroll.nestedScroll
 */
fun Modifier.hideKeyboardAndClearFocusOnScrollDown(
    keyboardController: SoftwareKeyboardController?,
    focusManager: FocusManager,
): Modifier = this.nestedScroll(object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        if (available.y < ZERO_FLOAT) {
            keyboardController?.hide()
            focusManager.clearFocus(force = true)
        }
        return Offset.Zero
    }
})


/**
 * A [Modifier] extension that hides the search input when the user scrolls down.
 *
 * This uses a [NestedScrollConnection] to intercept scroll gestures. Whenever a downward scroll
 * is detected (negative Y offset), the provided [onHideSearch] callback is invoked, allowing
 * the caller to collapse or hide the search UI.
 *
 * @param onHideSearch A callback that will be triggered when a downward scroll is detected.
 * Typically used to update state that controls the visibility of a search input.
 *
 * @return A [Modifier] that can be applied to scrollable composables to automatically hide
 * the search input on downward scrolling.
 */
fun Modifier.hideSearchOnScrollDown(
    onHideSearch: () -> Unit
): Modifier = this.nestedScroll(object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        if (available.y < 0) {
            onHideSearch()
        }
        return Offset.Zero
    }
})