@file:OptIn(ExperimentalMaterial3Api::class)

package com.bonface.designsystem.components.pulltorefresh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme
import kotlinx.coroutines.delay

/**
 * Pull to refresh lazy column
 *
 * @param isRefreshing
 * @param onRefresh
 * @param modifier
 * @param lazyListState
 * @param pullToRefreshState
 * @param content
 * @receiver
 * @receiver
 *
 * @sample com.bonface.designsystem.components.pulltorefresh.PullToRefreshLazyColumnPreview
 */
@Composable
fun PullToRefreshLazyColumn(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    refreshIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    contentPadding: PaddingValues = PaddingValues(MaterialTheme.dimensions.small),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(MaterialTheme.dimensions.small),
    lazyListState: LazyListState = rememberLazyListState(),
    pullToRefreshState: PullToRefreshState = rememberPullToRefreshState(),
    content: LazyListScope.() -> Unit,
) {
    val hapticFeedback = LocalHapticFeedback.current
    LaunchedEffect(pullToRefreshState.isAnimating) {
        if (pullToRefreshState.isAnimating) {
            hapticFeedback.performHapticFeedback(HapticFeedbackType.TextHandleMove)
            delay(70)
            hapticFeedback.performHapticFeedback(HapticFeedbackType.TextHandleMove)
            delay(100)
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
        } else if (pullToRefreshState.distanceFraction > 0f) {
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    }

    PullToRefreshBox(
        modifier = modifier.background(backgroundColor),
        state = pullToRefreshState,
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing,
                state = pullToRefreshState,
                color = refreshIndicatorColor,
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
            )
        },
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement,
        ) {
            content()
        }
    }
}

/** Pull to refresh lazy column preview */
@Composable
@PreviewLightDark
private fun PullToRefreshLazyColumnPreview() {
    PokedexTheme {
        Surface {
            PullToRefreshLazyColumn(
                isRefreshing = true,
                onRefresh = { },
            ) {
                items(5) {
                    BasicText(text = "Testing 123", color = MaterialTheme.colorScheme.onBackground)
                }
            }
        }
    }
}
