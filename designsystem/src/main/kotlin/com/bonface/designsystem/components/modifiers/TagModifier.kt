package com.bonface.designsystem.components.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.R
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Tag
 *
 * @param tint
 * @param icon
 * @return Modifier
 *
 * @sample com.bonface.designsystem.components.modifiers.TagModifierPreview
 */
@Composable
fun Modifier.tag(
    tint: ColorFilter,
    icon: Painter,
): Modifier {
    val imageVector = ImageVector.Builder(
        name = "Tag",
        defaultWidth = 71.0.dp,
        defaultHeight = 19.0.dp,
        viewportWidth = 71.0f,
        viewportHeight = 19.0f,
    ).apply {
        path(
            fill = SolidColor(Color.White),
            stroke = null,
            strokeLineWidth = 0.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 4.0f,
            pathFillType = PathFillType.NonZero,
        ) {
            moveTo(0.0f, 4.0f)
            curveTo(0.0f, 1.7909f, 1.7909f, 0.0f, 4.0f, 0.0f)
            horizontalLineTo(66.3229f)
            curveTo(68.5321f, 0.0f, 70.3229f, 1.7909f, 70.3229f, 4.0f)
            verticalLineTo(18.9342f)
            horizontalLineTo(0.0f)
            verticalLineTo(4.0f)
            close()
        }
    }.build()

    val painter = rememberVectorPainter(imageVector)

    return then(
        Modifier.drawWithContent {
            drawContent()
            translate(left = 32f, top = 1f) {
                with(painter) {
                    draw(
                        size = painter.intrinsicSize,
                        colorFilter = tint,
                    )
                }
            }
            translate(left = 40f, top = 12f) {
                with(icon) {
                    draw(size = icon.intrinsicSize)
                }
            }
        },
    )
}

@Composable
@PreviewLightDark
private fun TagModifierPreview() {
    PokedexTheme {
        Surface {
            Column(modifier = Modifier.padding(16.dp)) {
                Box(
                    modifier = Modifier
                        .tag(
                            tint = ColorFilter.tint(MaterialTheme.customColors.homeBackground),
                            icon = painterResource(R.drawable.ic_search_normal),
                        )
                        .padding(top = 19.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(MaterialTheme.customColors.homeBackground),
                )
            }
        }
    }
}
