package com.bonface.designsystem.components.scaffold

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

/**
 * Data class that holds the properties for a left action in the screen header component.
 *
 * @property iconResource The resource ID of the icon to be displayed for the left action.
 * @property enabled Indicates whether the left action is enabled or disabled.
 * @property isVisible Indicates whether the left action is visible or hidden.
 */
@Immutable
data class LeftActionProperties(
    @DrawableRes val iconResource: Int,
    val enabled: Boolean,
    val isVisible: Boolean,
)
