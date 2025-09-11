package com.bonface.designsystem.theme.token.dimensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import com.bonface.designsystem.R

internal object DimensionDefaults {

    val V1
        @Composable @ReadOnlyComposable
        get() = Dimensions(
            xxxSmall = dimensionResource(R.dimen.dimen_xxxsmall),
            xxSmall = dimensionResource(R.dimen.dimen_xxsmall),
            xSmall = dimensionResource(R.dimen.dimen_xsmall),
            small = dimensionResource(R.dimen.dimen_small),
            medium = dimensionResource(R.dimen.dimen_medium),
            large = dimensionResource(R.dimen.dimen_large),
            xLarge = dimensionResource(R.dimen.dimen_xlarge),
            xxLarge = dimensionResource(R.dimen.dimen_xxlarge),
        )
}
