package com.bonface.designsystem.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.R
import com.bonface.designsystem.components.modifiers.shadow
import com.bonface.designsystem.extensions.avatars
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.extensions.elevations
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Shadow icon button
 *
 * @param icon
 * @param iconTint
 * @param onClick
 * @param modifier
 * @param enabled
 * @param contentDescription
 * @param size
 * @param shadowOffsetX
 * @param shadowOffsetY
 * @param shadowBlurRadius
 * @receiver
 * @sample com.bonface.designsystem.components.buttons.ShadowIconButtonPreview
 */
@Composable
fun ShadowIconButton(
    icon: Painter,
    iconTint: Color,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentDescription: String? = null,
    size: Dp = MaterialTheme.avatars.normal,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    shadowOffsetX: Dp = MaterialTheme.dimensions.xxSmall,
    shadowOffsetY: Dp = -MaterialTheme.dimensions.xxSmall,
    shadowBlurRadius: Dp = MaterialTheme.dimensions.xLarge,
    onClick: () -> Unit = {},
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = MaterialTheme.elevations.none,
        ),
        shape = CircleShape,
        modifier = modifier.shadow(
            offsetX = shadowOffsetX,
            offsetY = shadowOffsetY,
            blurRadius = shadowBlurRadius,
        ),
    ) {
        IconButton(
            onClick = onClick,
            enabled = enabled,
            modifier = Modifier.size(size),
            content = {
                Icon(
                    painter = icon,
                    tint = iconTint,
                    contentDescription = contentDescription,
                )
            },
        )
    }
}

/** Shadow icon button preview */
@Composable
@PreviewLightDark
private fun ShadowIconButtonPreview() {
    PokedexTheme {
        Surface {
            ShadowIconButton(
                icon = painterResource(R.drawable.ic_action_back),
                iconTint = MaterialTheme.colorScheme.onBackground,
                onClick = {},
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
