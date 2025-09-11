package com.bonface.designsystem.components.progress

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember

/**
 * A state object that manages the progress and animation of a
 * [LineProgressIndicator].
 *
 * @param initialProgress The initial progress value (between 0 and 1).
 */
@Stable
class LineProgressIndicatorState(initialProgress: Float = 0f) {

    private val animatableProgress: Animatable<Float, AnimationVector1D> = Animatable(initialValue = initialProgress)

    val progress: Float
        get() = animatableProgress.value

    /**
     * Updates the progress value and triggers the animation.
     *
     * @param targetValue The target progress value (between 0 and 1).
     * @param animationSpec The animation spec to use for the transition.
     */
    suspend fun updateProgress(targetValue: Float, animationSpec: AnimationSpec<Float> = tween(3000)) {
        animatableProgress.animateTo(targetValue, animationSpec)
    }
}

/**
 * Creates and remembers a [LineProgressIndicatorState] instance.
 *
 * @param initialProgress The initial progress value (between 0 and 1).
 * @return A [LineProgressIndicatorState] instance.
 */
@Composable
fun rememberLineProgressState(initialProgress: Float = 0f): LineProgressIndicatorState {
    return remember { LineProgressIndicatorState(initialProgress) }
}
