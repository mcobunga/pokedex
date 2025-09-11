package com.bonface.designsystem.components.avatar

import android.util.TypedValue
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.R
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.avatars
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.toHslColor
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Avatar text
 *
 * @param text
 * @param modifier
 * @param size
 * @param textStyle
 * @sample com.bonface.designsystem.components.avatar.AvatarTextPreview
 */
@Composable
fun AvatarText(
    text: String,
    modifier: Modifier = Modifier,
    size: Dp = MaterialTheme.avatars.normal,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
) {
    val isLightTheme = !isSystemInDarkTheme()
    val backgroundColor = Color(text.toHslColor(adjustLightness = isLightTheme, lightness = 0.90f))

    val typedValue = TypedValue()
    LocalResources.current.getValue(R.dimen.alpha_darkest, typedValue, true)

    val textColor = when {
        isLightTheme -> Color(text.toHslColor(lightness = typedValue.float))
        else -> MaterialTheme.customColors.white
    }

    val initials = when {
        text.isNotBlank() -> {
            text.split(" ").mapNotNull { it.firstOrNull()?.toString() }.take(2).joinToString("")
        }

        else -> ""
    }

    val contentDescription = stringResource(R.string.content_description_avatar_text, text)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .background(backgroundColor, CircleShape)
            .semantics { this.contentDescription = contentDescription },
    ) {
        BasicText(
            text = initials,
            color = textColor,
            style = textStyle,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

/** Avatar text preview */
@Composable
@PreviewLightDark
private fun AvatarTextPreview() {
    PokedexTheme {
        Surface {
            AvatarText(
                text = "John Doe",
                size = 56.dp,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
