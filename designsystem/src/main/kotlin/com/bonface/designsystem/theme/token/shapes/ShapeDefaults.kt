package com.bonface.designsystem.theme.token.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import com.bonface.designsystem.R

internal object ShapeDefaults {

    val V1
        @Composable @ReadOnlyComposable
        get() = Shapes(
            extraSmall = RoundedCornerShape(dimensionResource(R.dimen.radius_xsmall)),
            small = RoundedCornerShape(dimensionResource(R.dimen.radius_small)),
            medium = RoundedCornerShape(dimensionResource(R.dimen.radius_medium)),
            large = RoundedCornerShape(dimensionResource(R.dimen.radius_large)),
            extraLarge = RoundedCornerShape(dimensionResource(R.dimen.radius_xlarge)),
        )
}
