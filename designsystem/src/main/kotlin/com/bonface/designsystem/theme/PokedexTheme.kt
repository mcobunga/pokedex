package com.bonface.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.core.view.WindowCompat
import com.bonface.designsystem.theme.token.avatar.AvatarDefaults
import com.bonface.designsystem.theme.token.avatar.Avatars
import com.bonface.designsystem.theme.token.avatar.LocalAvatars
import com.bonface.designsystem.theme.token.colors.ColorDefaults.CustomDarkColorSchemeV1
import com.bonface.designsystem.theme.token.colors.ColorDefaults.CustomLightColorSchemeV1
import com.bonface.designsystem.theme.token.colors.ColorDefaults.DarkColorSchemeV1
import com.bonface.designsystem.theme.token.colors.ColorDefaults.LightColorSchemeV1
import com.bonface.designsystem.theme.token.colors.LocalColorScheme
import com.bonface.designsystem.theme.token.dimensions.DimensionDefaults
import com.bonface.designsystem.theme.token.dimensions.Dimensions
import com.bonface.designsystem.theme.token.dimensions.LocalDimensions
import com.bonface.designsystem.theme.token.elevations.ElevationDefaults
import com.bonface.designsystem.theme.token.elevations.Elevations
import com.bonface.designsystem.theme.token.elevations.LocalElevations
import com.bonface.designsystem.theme.token.shapes.LocalShapes
import com.bonface.designsystem.theme.token.shapes.ShapeDefaults
import com.bonface.designsystem.theme.token.typography.LocalTypography
import com.bonface.designsystem.theme.token.typography.TypographyDefaults
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * A custom theme composable for the Pokedex app that wraps Jetpack Compose's [MaterialTheme]
 * and provides additional design system configurations such as typography, dimensions,
 * elevations, avatars, and shapes.
 *
 * This theme determines whether to apply a light or dark color scheme, updates the system
 * status bar appearance accordingly, and injects custom design tokens into the composition
 * via [CompositionLocalProvider].
 *
 * @param isDarkTheme Whether to use the dark theme color scheme. Defaults to
 * [isSystemInDarkTheme].
 * @param typography The text styles used throughout the app. Defaults to [TypographyDefaults.V1].
 * @param dimensions The standardized spacing, padding, and sizing values used in layouts.
 * Defaults to [DimensionDefaults.V1].
 * @param elevations The set of elevation values used for surfaces and components.
 * Defaults to [ElevationDefaults.V1].
 * @param avatars The avatar style definitions (size, shape, etc.) used in the app.
 * Defaults to [AvatarDefaults.V1].
 * @param shapes The shape system used to style surfaces and components.
 * Defaults to [ShapeDefaults.V1].
 * @param content The composable content that will be wrapped by the theme.
 *
 * Example usage:
 * ```
 * PokedexTheme {
 *     // Your app UI here
 * }
 * ```
 *
 * This function ensures consistent theming across the app while allowing custom overrides
 * for specific design tokens when needed.
 */
@Composable
fun PokedexTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    typography: Typography = TypographyDefaults.V1,
    dimensions: Dimensions = DimensionDefaults.V1,
    elevations: Elevations = ElevationDefaults.V1,
    avatars: Avatars = AvatarDefaults.V1,
    shapes: Shapes = ShapeDefaults.V1,
    content: @Composable () -> Unit,
) {
    val rememberedTypography = remember { typography }
    val rememberedDimensions = remember { dimensions }
    val rememberedElevations = remember { elevations }
    val rememberedAvatars = remember { avatars }
    val rememberedShapes = remember { shapes }

    val defaultColorScheme = when {
        isDarkTheme -> DarkColorSchemeV1
        else -> LightColorSchemeV1
    }

    val customColorScheme = when {
        isDarkTheme -> CustomDarkColorSchemeV1
        else -> CustomLightColorSchemeV1
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Tell the system we will handle drawing behind status bars
            WindowCompat.setDecorFitsSystemWindows(window, false)
            // Control light/dark icons
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkTheme
        }
    }

    CompositionLocalProvider(
        LocalColorScheme provides customColorScheme,
        LocalTypography provides rememberedTypography,
        LocalShapes provides rememberedShapes,
        LocalDimensions provides rememberedDimensions,
        LocalElevations provides rememberedElevations,
        LocalAvatars provides rememberedAvatars,
        LocalFontFamilyResolver provides createFontFamilyResolver(LocalContext.current, CoroutineExceptionHandler { _, _ -> }),
    ) {
        MaterialTheme(
            colorScheme = defaultColorScheme,
            typography = typography,
            shapes = shapes,
            content = content,
        )
    }
}
