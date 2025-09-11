
package com.bonface.designsystem.components.modifiers

import androidx.compose.foundation.clickable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

/**
 * A modified version of `clickable` that debounces clicks to prevent rapid consecutive clicks.
 *
 * This modifier debounces clicks by introducing a delay specified by `debounceInterval`.
 * Only the first click within the `debounceInterval` will trigger the `onClick` lambda.
 *
 * @param debounceInterval The debounce interval in milliseconds. Default is 1000L (1 second).
 * @param onClick The callback to be invoked when a debounced click occurs.
 */
@OptIn(FlowPreview::class)
fun Modifier.debounceClickable(
    debounceInterval: Long = 1000L,
    onClick: () -> Unit,
) = composed {
    val coroutineScope = rememberCoroutineScope()
    val clickFlow = remember { MutableSharedFlow<Unit>() }
    LaunchedEffect(key1 = Unit) {
        clickFlow
            .debounce(debounceInterval)
            .collect { onClick() }
    }
    clickable {
        coroutineScope.launch {
            clickFlow.emit(Unit)
        }
    }
}
