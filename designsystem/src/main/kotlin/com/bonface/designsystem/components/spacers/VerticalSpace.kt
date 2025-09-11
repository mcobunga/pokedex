package com.bonface.designsystem.components.spacers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Creates vertical space within the layout.
 *
 * @param space The size of the vertical space.
 * @param modifier The modifier to be applied to the space.
 */
@Composable
fun VerticalSpace(
    space: Dp,
    modifier: Modifier = Modifier,
) {
    Spacer(modifier = modifier.height(space))
}

@Preview(showBackground = true)
@Composable
private fun VerticalSpacePreview() {
    VerticalSpace(space = 16.dp, modifier = Modifier.fillMaxWidth())
}
