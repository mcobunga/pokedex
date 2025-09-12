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
            primary = Color(0xFF35A839),
            onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFFBEF0B2),
            onPrimaryContainer = Color(0xFF002202),

            secondary = Color(0xFFFF2A58),
            onSecondary = Color(0xFFFFFFFF),
            secondaryContainer = Color(0xFFFFDADB),
            onSecondaryContainer = Color(0xFF3B0810),

            tertiary = Color(0xFF3D6838),
            onTertiary = Color(0xFFAAAAAA),
            tertiaryContainer = Color(0xFFBEF0B2),
            onTertiaryContainer = Color(0xFFAAAAAA),

            error = Color(0xFFF40000),
            onError = Color(0xFFFFFFFF),
            errorContainer = Color(0xFFFFDAD4),
            onErrorContainer = Color(0xFF3A0905),

            background = Color(0xFFFFFFFF),
            onBackground = Color(0xFF303030),

            surface = Color(0xFFFFFFFF),
            onSurface = Color(0xFF757575),
            surfaceVariant = Color(0xFFEAF6EE),
            onSurfaceVariant = Color(0xFF42493F),

            outline = Color(0xFFCBD5E1),
            outlineVariant = Color(0xFF999999),

            scrim = Color(0x99000000),

            inverseSurface = Color(0xFF2B3133),
            inverseOnSurface = Color(0xFFECF2F3),
            inversePrimary = Color(0xFFA2D398),

            surfaceDim = Color(0xFFD5DBDC),
            surfaceBright = Color(0xFFF5FAFB),
            surfaceContainerLowest = Color(0xFFFFFFFF),
            surfaceContainerLow = Color(0xFFEFF5F6),
            surfaceContainer = Color(0xFFE9EFF0),
            surfaceContainerHigh = Color(0xFFE3E9EA),
            surfaceContainerHighest = Color(0xFFDEE3E5),
        )

    val DarkColorSchemeV1
        @Composable @ReadOnlyComposable
        get() = darkColorScheme(
            primary = Color(0xFF2DA044),
            onPrimary = Color(0xFF121212),
            primaryContainer = Color(0xFF255023),
            onPrimaryContainer = Color(0xFFBEF0B2),

            secondary = Color(0xFFF14F72),
            onSecondary = Color(0xFF121212),
            secondaryContainer = Color(0xFF723339),
            onSecondaryContainer = Color(0xFFFFDADB),

            tertiary = Color(0xFF8AD6B7),
            onTertiary = Color(0xFFCBD5E1),
            tertiaryContainer = Color(0xFF00513C),
            onTertiaryContainer = Color(0xFFA6F2D2),

            error = Color(0XFFF40000),
            onError = Color(0xFF561E16),
            errorContainer = Color(0xFF73342A),
            onErrorContainer = Color(0xFFFFDAD4),

            background = Color(0xFF121212),
            onBackground = Color(0xFFDBDBDB),

            surface = Color(0xFF1E1E1E),
            onSurface = Color(0xFFC1C3C7),
            surfaceVariant = Color(0x1AFFFFFF),
            onSurfaceVariant = Color(0xFFC1C3C7),

            outline = Color(0xFF475569),
            outlineVariant = Color(0xFF999999),

            scrim = Color(0xE6000000),

            inverseSurface = Color(0xFFDEE3E5),
            inverseOnSurface = Color(0xFF2B3133),
            inversePrimary = Color(0xFF3D6838),

            surfaceDim = Color(0xFF0E1415),
            surfaceBright = Color(0xFF343A3B),
            surfaceContainerLowest = Color(0xFF090F10),
            surfaceContainerLow = Color(0xFF171D1E),
            surfaceContainer = Color(0xFF1B2122),
            surfaceContainerHigh = Color(0xFF252B2C),
            surfaceContainerHighest = Color(0xFF303637),
        )

    val CustomLightColorSchemeV1
        @Composable @ReadOnlyComposable
        get() = ColorScheme(
            primaryButton = Color(0xFF35A839),
            secondaryButton = Color(0xFF35A839),
            dangerButton = Color(0xFFFF2A58),
            tertiaryButton = Color(0xFF757575),

            disabledPrimaryButton = Color(0xFFDCDFED),
            onDisabledPrimaryButton = Color(0xFF757575),
            disabledSecondaryButton = Color(0xFFDCDFED),
            onDisabledSecondaryButton = Color(0xFFDCDFED),

            disabled = Color(0x4DE3E3E3),
            onDisabled = Color(0xFF757575),

            icon = Color(0xFFAAAAAA),
            iconShadow = Color(0x122B2D33),
            cardShadow = Color(0x332B2D33),

            homeBackground = Color(0xFFF2F3F6),
            componentBackground = Color(0xFFF7F7F7),
            unselectedChipsBackground = Color(0xFFE3E3E3),

            shimmerStart = Color(0xFFF1F3F6),
            shimmerCenter = Color(0xFFE5E7EA),
            shimmerEnd = Color(0xFFF1F3F6),

            gradientStart = Color(0xFF15ABFF),
            gradientEnd = Color(0xFF00F410),
            gradientErrorStart = Color(0xFFFFCC15),
            gradientErrorEnd = Color(0XFFF40000),

            tertiaryBlueDim = Color(0xFF94D6FB),
            tertiaryBlueBright = Color(0xFFE5F1F8),
            tertiaryPearl = Color(0xFF398FF3),
            tertiarySky = Color(0xFF39CEF3),
            tertiaryOrange = Color(0xFFFF6D37),
            tertiaryLime = Color(0xFF97D85E),
            statusBar = Color(0xFFFFFFFF),
        )

    val CustomDarkColorSchemeV1
        @Composable @ReadOnlyComposable
        get() = ColorScheme(
            primaryButton = Color(0xFF2DA044),
            secondaryButton = Color(0xFF2DA044),
            dangerButton = Color(0xFFFF2A58),
            tertiaryButton = Color(0xFFC1C3C7),

            disabledPrimaryButton = Color(0xFF333333),
            onDisabledPrimaryButton = Color(0xFFC1C3C7),
            disabledSecondaryButton = Color(0xFF333333),
            onDisabledSecondaryButton = Color(0xFFC1C3C7),

            icon = Color(0xFFCBD5E1),
            disabled = Color(0xFF2A2A2A),
            onDisabled = Color(0xFFC1C3C7),

            homeBackground = Color(0xFF121212),
            componentBackground = Color(0xFF333333),
            unselectedChipsBackground = Color(0xFF2A2A2A),

            shimmerStart = Color(0x1AF1F3F6),
            shimmerCenter = Color(0x33E5E7EA),
            shimmerEnd = Color(0x1AF1F3F6),

            gradientStart = Color(0xFF15ABFF),
            gradientEnd = Color(0xFF00F410),
            gradientErrorStart = Color(0xFFFFCC15),
            gradientErrorEnd = Color(0XFFF40000),

            tertiaryBlueDim = Color(0xFF196895),
            tertiaryBlueBright = Color(0xFF1B3E51),
            tertiaryPearl = Color(0xFF0C70E6),
            tertiarySky = Color(0xFF0FB4DD),
            tertiaryOrange = Color(0xFFFE591B),
            tertiaryLime = Color(0xFF75BA2D),
            statusBar = Color(0xFF121212),
        )
}
