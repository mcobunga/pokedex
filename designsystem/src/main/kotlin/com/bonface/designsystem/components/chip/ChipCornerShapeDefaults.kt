package com.bonface.designsystem.components.chip

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.bonface.designsystem.components.chip.ChipCornerShape

object ChipCornerShapeDefaults {

    val default: ChipCornerShape
        @Composable @ReadOnlyComposable
        get() = ChipCornerShape(shape = MaterialTheme.shapes.medium)

    val rounded: ChipCornerShape
        @Composable @ReadOnlyComposable
        get() = ChipCornerShape(shape = CircleShape)
}
