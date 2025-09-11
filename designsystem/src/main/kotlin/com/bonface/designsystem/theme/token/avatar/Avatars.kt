package com.bonface.designsystem.theme.token.avatar

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines standardized avatar sizes used throughout the application UI.
 *
 * This class centralizes avatar dimension values (in [Dp]) to ensure visual
 * consistency across components such as profile pictures, user icons,
 * or thumbnail images.
 *
 * Each property represents a predefined avatar size category, ranging from
 * [normal] to [xLarge]. These values can be customized at the theme level
 * and consumed via [LocalAvatars].
 *
 * @property normal Default or baseline avatar size.
 * @property small Compact avatar size, typically used in dense layouts
 * or secondary UI components.
 * @property medium Medium-sized avatar, often used for standard profile
 * pictures or list items.
 * @property large Large avatar size, useful in detail pages or hero sections.
 * @property xLarge Extra-large avatar size, generally reserved for prominent
 * display contexts.
 */
class Avatars(
    val normal: Dp = 0.dp,
    val small: Dp = 0.dp,
    val medium: Dp = 0.dp,
    val large: Dp = 0.dp,
    val xLarge: Dp = 0.dp,
)

/**
 * CompositionLocal that provides access to the current [Avatars] configuration.
 *
 * This allows composables to access standardized avatar sizes without requiring
 * direct parameter passing, enabling consistent theming and easy overrides.
 */
internal val LocalAvatars = staticCompositionLocalOf { Avatars() }

