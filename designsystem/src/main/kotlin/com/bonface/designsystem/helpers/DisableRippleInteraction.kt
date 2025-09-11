package com.bonface.designsystem.helpers

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/**
 * A custom [MutableInteractionSource] implementation that disables ripple or
 * interaction effects for composables.
 *
 * By providing an empty [interactions] flow and no-op [emit] behavior,
 * this interaction source ensures that components such as [Clickable],
 * [Button], or other interactive composables do not display ripple animations
 * or register pressed/hovered states.
 *
 * This is useful in cases where:
 * - Visual feedback is undesirable (e.g., icon-only buttons, decorative UI).
 * - You want to simplify the UI by removing ripple effects.
 * - You need a lightweight replacement for an interaction source.
 *
 * Example:
 * ```
 * Box(
 *     modifier = Modifier
 *         .clickable(
 *             interactionSource = DisableRippleInteraction,
 *             indication = null
 *         ) { /* Handle click */ }
 * )
 * ```
 */
object DisableRippleInteraction : MutableInteractionSource {
    override val interactions: Flow<Interaction> = emptyFlow()
    override suspend fun emit(interaction: Interaction) {}
    override fun tryEmit(interaction: Interaction) = true
}

