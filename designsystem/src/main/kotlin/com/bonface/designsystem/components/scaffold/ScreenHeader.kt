package com.bonface.designsystem.components.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.designsystem.R
import com.bonface.designsystem.components.buttons.ShadowIconButton
import com.bonface.designsystem.components.menu.MenuActionStyle
import com.bonface.designsystem.components.menu.MenuActionStyleDefaults
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Screen header
 *
 * @param onClose
 * @param modifier
 * @param title
 * @param titleColor
 * @param leftIconProperties
 * @param menuActionStyle
 * @param rightActions
 * @receiver
 * @sample com.bonface.designsystem.components.scaffold.ScreenHeaderPreview
 */
@Composable
fun ScreenHeader(
    modifier: Modifier = Modifier,
    title: String? = null,
    titleColor: Color = MaterialTheme.colorScheme.onBackground,
    leftIconProperties: LeftActionProperties = LeftActionPropertiesDefaults.default(),
    menuActionStyle: MenuActionStyle = MenuActionStyleDefaults.defaultStyle(iconTint = MaterialTheme.colorScheme.onBackground),
    rightActions: List<@Composable (MenuActionStyle) -> Unit> = emptyList(),
    onClose: () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(dimensionResource(R.dimen.header_height))
            .padding(MaterialTheme.dimensions.medium),
    ) {
        title?.let {
            BasicText(
                text = title,
                color = titleColor,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = MaterialTheme.dimensions.xxLarge,
                        end = MaterialTheme.dimensions.xxLarge,
                    ),
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            if (leftIconProperties.isVisible) {
                ShadowIconButton(
                    icon = painterResource(leftIconProperties.iconResource),
                    iconTint = menuActionStyle.iconTint,
                    containerColor = menuActionStyle.containerColor,
                    contentDescription = stringResource(R.string.content_description_action_close),
                    enabled = leftIconProperties.enabled,
                    onClick = onClose,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            rightActions.takeIf { it.isNotEmpty() }?.forEach { action ->
                action(menuActionStyle)
            }
        }
    }
}

/** Screen header preview */
@Composable
@PreviewLightDark
private fun ScreenHeaderPreview() {
    PokedexTheme {
        Surface {
            ScreenHeader(
                title = "Screen Title Screen Title Screen Title Screen Title",
                onClose = {},
                rightActions = listOf {
                    ShadowIconButton(
                        icon = painterResource(R.drawable.ic_search_normal),
                        iconTint = Color.Unspecified,
                        contentDescription = stringResource(R.string.content_description_action_close),
                    )
                },
            )
        }
    }
}
