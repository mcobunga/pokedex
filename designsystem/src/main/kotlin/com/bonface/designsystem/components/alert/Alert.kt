package com.bonface.designsystem.components.alert

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Alert
 *
 * @param modifier
 * @param alertType
 * @param alertBorder
 * @param contentModifier
 * @param content
 * @receiver
 * @sample com.bonface.designsystem.components.alert.AlertInfoPreview
 * @sample com.bonface.designsystem.components.alert.AlertWarningPreview
 * @sample com.bonface.designsystem.components.alert.AlertDangerPreview
 */
@Composable
fun Alert(
    modifier: Modifier = Modifier,
    alertType: AlertType = AlertTypeDefaults.InfoAlert,
    alertBorder: AlertBorder = AlertBorderDefaults.None,
    contentModifier: Modifier = Modifier.padding(
        horizontal = MaterialTheme.dimensions.medium,
        vertical = MaterialTheme.dimensions.small,
    ),
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(alertBorder.cornerRadius))
            .background(alertType.background)
            .then(
                if (alertBorder.width > 0.dp) {
                    Modifier.drawBehind {
                        val strokeWidth = alertBorder.width.toPx()
                        val dashLength = alertBorder.dashLength.toPx()
                        val gapLength = alertBorder.gapLength.toPx()
                        val color = alertType.borderColor

                        val path = Path()
                        val rect = Rect(Offset.Zero, size)
                        path.addRoundRect(
                            roundRect = RoundRect(
                                rect,
                                CornerRadius(alertBorder.cornerRadius.toPx()),
                            ),
                        )

                        drawPath(
                            path = path,
                            color = color,
                            style = Stroke(
                                width = strokeWidth,
                                pathEffect = if (alertBorder.dashLength > 0.dp) {
                                    PathEffect.dashPathEffect(
                                        intervals = floatArrayOf(dashLength, gapLength),
                                        phase = 0f,
                                    )
                                } else {
                                    null
                                },
                            ),
                        )
                    }
                } else {
                    Modifier
                },
            ),
    ) {
        Box(modifier = contentModifier) {
            content()
        }
    }
}

/** Alert info preview */
@Composable
@PreviewLightDark
private fun AlertInfoPreview() {
    PokedexTheme {
        Surface {
            Alert(
                modifier = Modifier.padding(16.dp),
                alertType = AlertTypeDefaults.InfoAlert,
                alertBorder = AlertBorderDefaults.None,
            ) {
                BasicText(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ullamco stet quod ex id.",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                )
            }
        }
    }
}

/** Alert warning preview */
@Composable
@PreviewLightDark
private fun AlertWarningPreview() {
    PokedexTheme {
        Surface {
            Alert(
                modifier = Modifier.padding(16.dp),
                alertType = AlertTypeDefaults.WarningAlert,
                alertBorder = AlertBorderDefaults.Line,
            ) {
                BasicText(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ullamco stet quod ex id.",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                )
            }
        }
    }
}

/** Alert danger preview */
@Composable
@PreviewLightDark
private fun AlertDangerPreview() {
    PokedexTheme {
        Surface {
            Alert(
                modifier = Modifier.padding(16.dp),
                alertType = AlertTypeDefaults.DangerAlert,
                alertBorder = AlertBorderDefaults.Dashed,
            ) {
                BasicText(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ullamco stet quod ex id.",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                )
            }
        }
    }
}
