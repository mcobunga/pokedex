package com.bonface.pokedex.ui.homescreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.bonface.designsystem.components.buttons.ShadowIconButton
import com.bonface.designsystem.components.menu.MenuActionStyle
import com.bonface.designsystem.components.menu.MenuActionStyleDefaults
import com.bonface.designsystem.extensions.dimensions
import com.bonface.pokedex.R

@Composable
fun searchMenuIcon(
    showSearch: Boolean,
    onSearchClick: () -> Unit,
    onCloseClick: () -> Unit,
): List<@Composable (MenuActionStyle) -> Unit> {
    val menuActionStyle = MenuActionStyleDefaults.defaultStyle(iconTint = MaterialTheme.colorScheme.onBackground)
    return listOf {
        ShadowIconButton(
            icon = if (showSearch) {
                painterResource(com.bonface.designsystem.R.drawable.ic_close)
            } else {
                painterResource(com.bonface.designsystem.R.drawable.ic_search_normal)
            },
            iconTint = Color.Unspecified,
            containerColor = menuActionStyle.containerColor,
            contentDescription = if (showSearch) {
                stringResource(com.bonface.designsystem.R.string.content_description_action_close)
            } else {
                stringResource(R.string.search_pokemon)
            },
            enabled = true,
            onClick = if (showSearch) onCloseClick else onSearchClick,
            shadowOffsetX = MaterialTheme.dimensions.none,
            shadowOffsetY = -MaterialTheme.dimensions.none,
            shadowBlurRadius = MaterialTheme.dimensions.none,
        )
    }
}