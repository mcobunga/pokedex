package com.bonface.designsystem.components.progress

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Line progress indicator
 *
 * @param modifier
 * @param progressState
 * @param progressColor
 * @param filledColor
 * @sample com.bonface.designsystem.components.progress.LineProgressIndicatorPreview
 */
@Composable
fun LineProgressIndicator(
    modifier: Modifier = Modifier,
    progressState: LineProgressIndicatorState = rememberLineProgressState(),
    progressColor: Color = MaterialTheme.colorScheme.primary,
    filledColor: Color = MaterialTheme.colorScheme.secondary,
) {
    val progress = progressState.progress.coerceIn(0f, 1f) // normalize
    val lineColor by animateColorAsState(
        targetValue = if (progress < 1f) progressColor else filledColor,
        label = "lineColor",
    )

    LinearProgressIndicator(
        progress = { progress },
        modifier = modifier.fillMaxWidth()
            .clip(CircleShape),
        color = lineColor,
        trackColor = MaterialTheme.colorScheme.outline,
        strokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
    )
}

/** Line progress indicator preview */
@Composable
@PreviewLightDark
private fun LineProgressIndicatorPreview() {
    val progressState = remember { LineProgressIndicatorState() }

    PokedexTheme {
        Surface {
            LineProgressIndicator(
                progressState = progressState,
                modifier = Modifier.padding(16.dp),
            )
        }
    }

    LaunchedEffect(key1 = Unit) {
        progressState.updateProgress(0.75f)
    }
}
