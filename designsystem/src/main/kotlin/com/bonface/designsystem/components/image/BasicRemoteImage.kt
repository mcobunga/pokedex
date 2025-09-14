package com.bonface.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.bonface.designsystem.extensions.dimensions

@Composable
fun BasicImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    imageConfiguration: ImageConfiguration = ImageConfigurationDefaults.square(),
    imagePlaceholderPainter: Painter? = null,
    imageErrorPainter: Painter? = null,
    contentDescription: String? = null,
    clickable: Boolean = false,
    onClick: (() -> Unit)? = null,
) {
    val composedModifier = modifier
        .clip(imageConfiguration.shape)
        .then(if (imageConfiguration.aspectRatio != null) Modifier.aspectRatio(imageConfiguration.aspectRatio) else Modifier)
        .then(if (clickable) Modifier.clickable { onClick?.invoke() } else Modifier)
        .then(if (imageConfiguration.backgroundColor != null) Modifier.background(imageConfiguration.backgroundColor) else Modifier)
        .padding(imageConfiguration.contentPadding)

    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentScale = imageConfiguration.contentScale,
        contentDescription = contentDescription,
        modifier = composedModifier,
        loading = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (imagePlaceholderPainter != null) {
                    Image(
                        painter = imagePlaceholderPainter,
                        contentDescription = contentDescription,
                        contentScale = imageConfiguration.contentScale,
                        modifier = Modifier.size(MaterialTheme.dimensions.xLarge)
                    )
                } else {
                    CircularProgressIndicator(
                        modifier = Modifier.size(MaterialTheme.dimensions.xLarge)
                    )
                }
            }
        },
        error = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (imageErrorPainter != null) {
                    Image(
                        painter = imageErrorPainter,
                        contentDescription = contentDescription,
                        contentScale = imageConfiguration.contentScale,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    )
}