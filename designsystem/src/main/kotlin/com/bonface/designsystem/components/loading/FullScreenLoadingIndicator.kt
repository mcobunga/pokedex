package com.bonface.designsystem.components.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.designsystem.R
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.helpers.EMPTY
import com.bonface.designsystem.theme.PokedexTheme

@Preview
@Composable
fun FullScreenLoadingIndicator(
    color: Color = MaterialTheme.colorScheme.primary,
    title: String? = stringResource(R.string.loading_placeholder),
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(MaterialTheme.dimensions.xxLarge),
            color = color
        )
        title?.let {
            BasicText(
                text = it,
                modifier = Modifier.padding(MaterialTheme.dimensions.medium),
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun LoadingPreview() {
    PokedexTheme {
        FullScreenLoadingIndicator()
    }
}