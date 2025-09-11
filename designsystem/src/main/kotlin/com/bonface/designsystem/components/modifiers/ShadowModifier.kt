package com.bonface.designsystem.components.modifiers

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Shadow
 *
 * @param color
 * @param offsetX
 * @param offsetY
 * @param blurRadius
 *
 * @sample com.bonface.designsystem.components.modifiers.ShadowModifierPreview
 */
@Composable
fun Modifier.shadow(
    color: Color = MaterialTheme.colorScheme.scrim.copy(0.12f),
    offsetX: Dp = MaterialTheme.dimensions.none,
    offsetY: Dp = MaterialTheme.dimensions.none,
    blurRadius: Dp = MaterialTheme.dimensions.none,
) = then(
    Modifier.drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0f.toDp()) {
                frameworkPaint.maskFilter = (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }
            frameworkPaint.color = color.toArgb()

            val centerX = size.width / 2 + offsetX.toPx()
            val centerY = size.height / 2 + offsetY.toPx()
            val radius = size.width.coerceAtLeast(size.height) / 2

            canvas.drawCircle(Offset(centerX, centerY), radius, paint)
        }
    },
)

@Composable
@PreviewLightDark
private fun ShadowModifierPreview() {
    PokedexTheme {
        Surface {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .shadow(
                        offsetX = -MaterialTheme.dimensions.xSmall,
                        offsetY = MaterialTheme.dimensions.medium,
                        blurRadius = MaterialTheme.dimensions.xLarge,
                    ),
            ) {
                Text(
                    text = "Lorem Ipsum",
                    modifier = Modifier.padding(16.dp),
                )
            }
        }
    }
}
