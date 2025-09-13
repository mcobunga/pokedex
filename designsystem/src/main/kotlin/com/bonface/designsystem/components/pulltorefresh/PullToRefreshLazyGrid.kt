@file:OptIn(ExperimentalMaterial3Api::class)

package com.bonface.designsystem.components.pulltorefresh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
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
import com.bonface.designsystem.helpers.TWO
import com.bonface.designsystem.theme.PokedexTheme
import kotlinx.coroutines.delay

/**
 * Pull to refresh lazy grid
 *
 * @param isRefreshing
 * @param onRefresh
 * @param modifier
 * @param lazyGridState
 * @param pullToRefreshState
 * @param content
 * @receiver
 * @receiver
 *
 * @sample com.bonface.designsystem.components.pulltorefresh.PullToRefreshLazyGridPreview
 */
@Composable
fun PullToRefreshLazyGrid(
    modifier: Modifier = Modifier,
    columns: GridCells =  GridCells.Fixed(TWO),
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    refreshIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(MaterialTheme.dimensions.small),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(MaterialTheme.dimensions.small),
    lazyGridState: LazyGridState = rememberLazyGridState(),
    pullToRefreshState: PullToRefreshState = rememberPullToRefreshState(),
    content: LazyGridScope.() -> Unit,
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
        LazyVerticalGrid(
            columns = columns,
            state = lazyGridState,
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = horizontalArrangement,
            verticalArrangement = verticalArrangement,
        ) {
            content()
        }
    }
}

/** Pull to refresh lazy column preview */
@Composable
@PreviewLightDark
private fun PullToRefreshLazyGridPreview() {
    PokedexTheme {
        Surface {
            PullToRefreshLazyGrid(
                isRefreshing = true,
                onRefresh = {},
            ) {
                items(20) {
                    BasicText(text = "Testing 123", color = MaterialTheme.colorScheme.onBackground)
                }
            }
        }
    }
}
