package com.bonface.designsystem.components.menu

import androidx.annotation.DrawableRes

/**
 * Menu item
 *
 * @property id
 * @property label
 * @property iconRes
 * @constructor Create empty Menu item
 */
data class MenuItem(
    val id: Int,
    val label: String,
    @DrawableRes val iconRes: Int? = null,
)
