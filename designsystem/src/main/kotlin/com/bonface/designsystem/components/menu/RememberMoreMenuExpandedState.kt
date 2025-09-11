package com.bonface.designsystem.components.menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable

/**
 * Remember more menu expanded state
 *
 * @return
 */
@Composable
fun rememberMoreMenuExpandedState(): MoreMenuExpandedState {
    return rememberSaveable(saver = MoreMenuExpandedState.Saver) { MoreMenuExpandedState() }
}
