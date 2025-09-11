package com.bonface.designsystem.components.scaffold

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.bonface.designsystem.R

/** Provides default values for the [LeftActionProperties] data class. */
object LeftActionPropertiesDefaults {

    /**
     * Returns the default [LeftActionProperties] configuration.
     *
     * @param iconResource The resource ID of the icon to display on the left.
     *   Defaults to [R.drawable.ic_action_back].
     * @param enable Whether the left action should be enabled by default.
     *    Defaults to `true`.
     * @param isVisible Whether the left action should be visible by default.
     *    Defaults to `true`.
     * @return The [LeftActionProperties] instance with the specified or
     *    default values.
     */
    @Composable
    fun default(
        @DrawableRes iconResource: Int = R.drawable.ic_action_back,
        enable: Boolean = true,
        isVisible: Boolean = true,
    ) = LeftActionProperties(
        iconResource = iconResource,
        enabled = enable,
        isVisible = isVisible,
    )
}
