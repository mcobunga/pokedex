package com.bonface.designsystem.extensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll

fun Modifier.hideSearchOnScrollDown(
    onHideSearch: () -> Unit
): Modifier = this.nestedScroll(object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        if (available.y < 0) {
            onHideSearch()
        }
        return Offset.Zero
    }
})
