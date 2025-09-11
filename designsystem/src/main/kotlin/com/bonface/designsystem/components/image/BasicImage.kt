package com.bonface.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.R
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Basic image that supports painter resource
 *
 * @param imagePainter
 * @param modifier
 * @param imageConfiguration
 * @param contentDescription
 * @param clickable
 * @param onClick
 * @sample com.bonface.designsystem.components.image.BasicImageSquarePreview
 * @sample com.bonface.designsystem.components.image.BasicImageCircularPreview
 * @sample com.bonface.designsystem.components.image.BasicImageRoundedPreview
 */
@Composable
fun BasicImage(
    imagePainter: Painter,
    modifier: Modifier = Modifier,
    imageConfiguration: ImageConfiguration = ImageConfigurationDefaults.square(),
    contentDescription: String? = null,
    clickable: Boolean = false,
    onClick: (() -> Unit)? = null,
) {
    val aspectRatio = imagePainter.intrinsicSize.width / imagePainter.intrinsicSize.height

    Image(
        painter = imagePainter,
        contentScale = imageConfiguration.contentScale,
        contentDescription = contentDescription,
        modifier = modifier
            .clip(imageConfiguration.shape)
            .then(
                when {
                    imageConfiguration.aspectRatio != null -> Modifier.aspectRatio(imageConfiguration.aspectRatio)
                    else -> Modifier.aspectRatio(aspectRatio)
                },
            )
            .then(
                when {
                    clickable -> Modifier.clickable { onClick?.invoke() }
                    else -> Modifier
                },
            )
            .then(
                when {
                    imageConfiguration.backgroundColor != null -> Modifier.background(imageConfiguration.backgroundColor)
                    else -> Modifier
                },
            )
            .padding(imageConfiguration.contentPadding),
    )
}

/** Basic image square preview */
@Composable
@PreviewLightDark
private fun BasicImageSquarePreview() {
    PokedexTheme {
        Surface {
            BasicImage(
                imagePainter = painterResource(R.drawable.ic_search_normal),
                imageConfiguration = ImageConfigurationDefaults.square(
                    contentPadding = PaddingValues(8.dp),
                    backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .size(144.dp)
                    .padding(16.dp),
            )
        }
    }
}

/** Basic image circular preview */
@Composable
@PreviewLightDark
private fun BasicImageCircularPreview() {
    PokedexTheme {
        Surface {
            BasicImage(
                imagePainter = painterResource(R.drawable.ic_search_normal),
                imageConfiguration = ImageConfigurationDefaults.circular(
                    contentPadding = PaddingValues(16.dp),
                    backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .size(144.dp)
                    .padding(16.dp),
            )
        }
    }
}

/** Basic image rounded preview */
@Composable
@PreviewLightDark
private fun BasicImageRoundedPreview() {
    PokedexTheme {
        Surface {
            BasicImage(
                imagePainter = painterResource(R.drawable.ic_search_normal),
                imageConfiguration = ImageConfigurationDefaults.rounded(
                    backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
        }
    }
}
