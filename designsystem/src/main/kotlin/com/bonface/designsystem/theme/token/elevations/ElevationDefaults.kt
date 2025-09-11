package com.bonface.designsystem.theme.token.elevations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import com.bonface.designsystem.R

/**
 * Provides default elevation values sourced from dimension resources.
 *
 * This object centralizes elevation definitions to ensure consistent
 * shadow depth and visual hierarchy across the application.
 */
internal object ElevationDefaults {

    /**
     * Default set of [Elevations] (version 1), loaded from `R.dimen` resources.
     *
     * Use this to apply standardized elevation values throughout the UI instead
     * of hardcoding raw `Dp` values, ensuring maintainability and theme consistency.
     */
    val V1
        @Composable
        @ReadOnlyComposable
        get() = Elevations(
            none = dimensionResource(R.dimen.elevation_none),
            xSmall = dimensionResource(R.dimen.elevation_xsmall),
            small = dimensionResource(R.dimen.elevation_small),
            medium = dimensionResource(R.dimen.elevation_medium),
            large = dimensionResource(R.dimen.elevation_large),
            xLarge = dimensionResource(R.dimen.elevation_xlarge),
            max = dimensionResource(R.dimen.elevation_max),
        )
}
