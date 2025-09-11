package com.bonface.designsystem.theme.token.colors

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

internal object ColorDefaults {

    val LightColorSchemeV1
        @Composable @ReadOnlyComposable
        get() = lightColorScheme(
            primary = Color(0xFFE3350D),       // Poké Ball Red
            onPrimary = Color.White,
            primaryContainer = Color(0xFFFFAFA3),
            onPrimaryContainer = Color(0xFF410000),

            secondary = Color(0xFFFFCC00),     // Pikachu Yellow
            onSecondary = Color.Black,
            secondaryContainer = Color(0xFFFFF59D),
            onSecondaryContainer = Color(0xFF3B2F00),

            tertiary = Color(0xFF3B4CCA),      // Pokémon Blue
            onTertiary = Color.White,
            tertiaryContainer = Color(0xFFB3C6FF),
            onTertiaryContainer = Color(0xFF000D47),

            error = Color(0xFFFF2A58),         // Magenta Red
            onError = Color.White,
            errorContainer = Color(0xFFFFDAD4),
            onErrorContainer = Color(0xFF3A0905),

            background = Color(0xFFF8F9FA),    // Pokédex neutral
            onBackground = Color(0xFF1C1C1C),

            surface = Color.White,
            onSurface = Color(0xFF303030),
            surfaceVariant = Color(0xFFE6E8EB),
            onSurfaceVariant = Color(0xFF424242),

            outline = Color(0xFFB0BEC5),
            outlineVariant = Color(0xFF90A4AE),

            scrim = Color(0x99000000),

            inverseSurface = Color(0xFF2B3133),
            inverseOnSurface = Color(0xFFF1F1F1),
            inversePrimary = Color(0xFFB3280A),

            surfaceDim = Color(0xFFD5DBDC),
            surfaceBright = Color(0xFFFDFDFD),
            surfaceContainerLowest = Color.White,
            surfaceContainerLow = Color(0xFFF4F6F8),
            surfaceContainer = Color(0xFFEFF2F4),
            surfaceContainerHigh = Color(0xFFE3E7EA),
            surfaceContainerHighest = Color(0xFFDADFE2),
        )

    val DarkColorSchemeV1
        @Composable @ReadOnlyComposable
        get() = darkColorScheme(
            primary = Color(0xFFFF554D),       // Bright red for dark mode
            onPrimary = Color.Black,
            primaryContainer = Color(0xFF7A1E0D),
            onPrimaryContainer = Color(0xFFFFB4A6),

            secondary = Color(0xFFFFD95C),     // Bright yellow
            onSecondary = Color.Black,
            secondaryContainer = Color(0xFF7A6600),
            onSecondaryContainer = Color(0xFFFFF4B2),

            tertiary = Color(0xFF8097FF),      // Pokémon Blue lightened
            onTertiary = Color.Black,
            tertiaryContainer = Color(0xFF253080),
            onTertiaryContainer = Color(0xFFDEE0FF),

            error = Color(0xFFFF5C8D),         // Brighter magenta-red
            onError = Color.Black,
            errorContainer = Color(0xFF7A1E2A),
            onErrorContainer = Color(0xFFFFDAD4),

            background = Color(0xFF121212),    // Pokédex dark mode
            onBackground = Color(0xFFE0E0E0),

            surface = Color(0xFF1C1C1C),
            onSurface = Color(0xFFC1C3C7),
            surfaceVariant = Color(0xFF2C2C2C),
            onSurfaceVariant = Color(0xFFB3B3B3),

            outline = Color(0xFF616161),
            outlineVariant = Color(0xFF8A8A8A),

            scrim = Color(0xE6000000),

            inverseSurface = Color(0xFFE5E5E5),
            inverseOnSurface = Color(0xFF2C2C2C),
            inversePrimary = Color(0xFFD32F2F),

            surfaceDim = Color(0xFF0E0E0E),
            surfaceBright = Color(0xFF333333),
            surfaceContainerLowest = Color(0xFF090909),
            surfaceContainerLow = Color(0xFF171717),
            surfaceContainer = Color(0xFF1E1E1E),
            surfaceContainerHigh = Color(0xFF2A2A2A),
            surfaceContainerHighest = Color(0xFF303030),
        )

    val CustomLightColorSchemeV1
        @Composable @ReadOnlyComposable
        get() = ColorScheme(
            primaryButton = Color(0xFFE3350D),      // Poké Ball Red
            secondaryButton = Color(0xFFFFCC00),    // Pikachu Yellow
            dangerButton = Color(0xFFFF2A58),       // Danger/Pink (fairy-like)
            tertiaryButton = Color(0xFF3B4CCA),     // Pokémon Blue

            disabledPrimaryButton = Color(0xFFEEEEEE),
            onDisabledPrimaryButton = Color(0xFF9E9E9E),
            disabledSecondaryButton = Color(0xFFEEEEEE),
            onDisabledSecondaryButton = Color(0xFF9E9E9E),

            disabled = Color(0xFFDDDDDD),
            onDisabled = Color(0xFF757575),

            icon = Color(0xFF616161),
            iconShadow = Color(0x122B2D33),
            cardShadow = Color(0x332B2D33),

            homeBackground = Color(0xFFF8F9FA),
            componentBackground = Color.White,
            unselectedChipsBackground = Color(0xFFE0E0E0),

            shimmerStart = Color(0xFFF1F3F6),
            shimmerCenter = Color(0xFFE5E7EA),
            shimmerEnd = Color(0xFFF1F3F6),

            gradientStart = Color(0xFFE3350D),      // Poké Ball gradient
            gradientEnd = Color(0xFF3B4CCA),        // Pokémon Blue
            gradientErrorStart = Color(0xFFFFCC15), // Warning Yellow
            gradientErrorEnd = Color(0XFFF40000),   // Error Red

            // Pokémon Type Accents (great for cards/details)
            tertiaryBlueDim = Color(0xFF56B3FF),    // Water
            tertiaryBlueBright = Color(0xFFADD8FF), // Ice
            tertiaryPearl = Color(0xFFAA00FF),      // Psychic
            tertiarySky = Color(0xFF00CFFF),        // Flying
            tertiaryOrange = Color(0xFFFF6D37),     // Fire/Fighting
            tertiaryLime = Color(0xFF77CC55),       // Grass/Bug

            statusBar = Color(0xFFFFFFFF),
        )

    val CustomDarkColorSchemeV1
        @Composable @ReadOnlyComposable
        get() = ColorScheme(
            primaryButton = Color(0xFFFF554D),      // Bright red in dark
            secondaryButton = Color(0xFFFFD95C),    // Pikachu Yellow
            dangerButton = Color(0xFFFF5C8D),       // Fairy/Danger
            tertiaryButton = Color(0xFF8097FF),     // Pokémon Blue Light

            disabledPrimaryButton = Color(0xFF333333),
            onDisabledPrimaryButton = Color(0xFFAAAAAA),
            disabledSecondaryButton = Color(0xFF333333),
            onDisabledSecondaryButton = Color(0xFFAAAAAA),

            icon = Color(0xFFB0BEC5),
            disabled = Color(0xFF2A2A2A),
            onDisabled = Color(0xFF888888),

            homeBackground = Color(0xFF121212),
            componentBackground = Color(0xFF1E1E1E),
            unselectedChipsBackground = Color(0xFF2A2A2A),

            shimmerStart = Color(0x1AF1F3F6),
            shimmerCenter = Color(0x33E5E7EA),
            shimmerEnd = Color(0x1AF1F3F6),

            gradientStart = Color(0xFFE3350D),      // Red
            gradientEnd = Color(0xFF3B4CCA),        // Blue
            gradientErrorStart = Color(0xFFFFCC15), // Warning
            gradientErrorEnd = Color(0XFFF40000),   // Error

            // Pokémon Type Accents (Dark mode)
            tertiaryBlueDim = Color(0xFF196895),    // Water
            tertiaryBlueBright = Color(0xFF1B3E51), // Ice
            tertiaryPearl = Color(0xFF9C27B0),      // Psychic
            tertiarySky = Color(0xFF00B8D4),        // Flying
            tertiaryOrange = Color(0xFFFF5722),     // Fire/Fighting
            tertiaryLime = Color(0xFF66BB6A),       // Grass/Bug

            statusBar = Color(0xFF121212),
        )
}
