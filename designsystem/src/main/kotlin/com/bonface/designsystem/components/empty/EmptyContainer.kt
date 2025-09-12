package com.bonface.designsystem.components.empty

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieConstants
import com.bonface.designsystem.R
import com.bonface.designsystem.components.buttons.SecondaryButton
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.avatars
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.helpers.EMPTY
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Empty container
 *
 * @param modifier
 * @param title
 * @param description
 * @param icon
 * @param iconSize
 * @param iconTint
 * @param buttonText
 * @param buttonOnClick
 * @receiver
 * @sample com.bonface.designsystem.components.empty.EmptyContainerPreview
 */
@Composable
fun EmptyContainer(
    modifier: Modifier = Modifier,
    title: String = EMPTY,
    annotatedTitle: AnnotatedString = buildAnnotatedString {},
    description: String = EMPTY,
    icon: Any? = null,
    iconSize: Dp = MaterialTheme.avatars.large,
    iconTint: Color = Color.Unspecified,
    buttonText: String = EMPTY,
    buttonOnClick: () -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(MaterialTheme.dimensions.medium),
    ) {
        if (icon != null) {
            when (icon) {
                is Painter -> Icon(
                    painter = icon,
                    contentDescription = title,
                    tint = iconTint,
                    modifier = Modifier.size(iconSize),
                )

                is Int -> Icon(
                    painter = painterResource(id = icon),
                    contentDescription = title,
                    tint = iconTint,
                    modifier = Modifier.size(iconSize),
                )

                is LottieComposition -> LottieAnimation(
                    composition = icon,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(iconSize),
                )
            }
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.small))
        }
        val displayTitle: AnnotatedString? = when {
            title.isNotEmpty() -> AnnotatedString(title)
            annotatedTitle.isNotEmpty() -> annotatedTitle
            else -> null
        }

        displayTitle?.let {
            BasicText(
                modifier = Modifier.padding(top = MaterialTheme.dimensions.small),
                text = it,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.small))
        }

        if (description.isNotEmpty()) {
            BasicText(
                modifier = Modifier.padding(top = MaterialTheme.dimensions.small),
                text = description,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 5,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.large))
        }
        if (buttonText.isNotEmpty()) {
            SecondaryButton(text = buttonText, onClick = buttonOnClick)
        }
    }
}

/** Empty container preview */
@Composable
@PreviewLightDark
private fun EmptyContainerPreview() {
    PokedexTheme {
        Surface {
            EmptyContainer(
                title = "No Pokemon",
                description = "No pokemons were found",
                icon = painterResource(R.drawable.ic_search_normal),
            )
        }
    }
}
